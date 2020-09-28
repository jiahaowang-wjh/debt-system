package com.smart.bracelet.controller.doc;

import com.smart.bracelet.enums.FailResultCode;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.doc.BusElectronSeal;
import com.smart.bracelet.model.po.doc.BusElectronUserno;
import com.smart.bracelet.model.po.doc.BusEletronUser;
import com.smart.bracelet.service.doc.BusElectronSealService;
import com.smart.bracelet.service.doc.BusElectronUserService;
import com.smart.bracelet.service.doc.BusElectronUsernoService;
import com.smart.bracelet.utils.DocUtils;
import com.smart.bracelet.utils.IdUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 电子章
 */
@RestController
@RequestMapping("/api/BusElectron/")
@Validated
public class BusElectronSealController {

    /**
     *
     *
     * 电子章对象
     */
    @Resource
    private BusElectronSealService busElectronSealService;

    /**
     * 电子章对象
     */
    @Resource
    private BusElectronUsernoService busElectronUsernoService;

    /**
     * 电子章对象
     */
    @Resource
    private BusElectronUserService busElectronUserService;

    /**
     * 电子章创建
     * @param busElectronSeal
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/addBusElectron")
    public Result addPubUser(@Valid BusElectronSeal busElectronSeal) throws CustomerException {
        //int insert = userInfoService.insertSelective(pubUser);
        try {
            String docType = busElectronSeal.getDocType();
            //身份证
            String partaCard = busElectronSeal.getPartaCard();

            BusEletronUser busEletronUser = null;
            if(StringUtils.isNotEmpty(partaCard)){
                busEletronUser = busElectronUserService.selectByPartaCard(partaCard);
                //判定人是否存储过
                if(busEletronUser==null){
                    busEletronUser = new BusEletronUser();
                    BusElectronUserno busElectronUserno = busElectronUsernoService.selectByPrimaryNotype("USER_NO");
                    int acctId = busElectronUserno.getIdno();
                    acctId +=1;
                    busElectronUserno.setIdno(acctId);
                    busElectronUsernoService.updateByPrimaryKey(busElectronUserno);
                    String acctIdStr = DocUtils.creatUser(DocUtils.creatUserId(acctId),busElectronSeal);
                    busEletronUser.setUserName(busElectronSeal.getParta());
                    busEletronUser.setUserCard(busElectronSeal.getPartaCard());
                    busEletronUser.setUserTel(busElectronSeal.getPartaTel());
                    //创建个人账号
                    busEletronUser.setAcctId(acctIdStr);
                    busElectronUserService.insert(busEletronUser);
                }
            }

            String acctId = "";
            if(busEletronUser!=null){
                acctId = busEletronUser.getAcctId();
            }
            //创建电子章及盖电子章
            String returnElectronCon = DocUtils.fileCrete(docType,busElectronSeal,acctId);
            String[] returnElectronConS = returnElectronCon.split(",");
            busElectronSeal.setElectronSealId(IdUtils.nextId());
            busElectronSeal.setFlowId(returnElectronConS[0]);
            busElectronSeal.setFileUrl(returnElectronConS[1]);
            //保证电子签单记录
            busElectronSealService.insert(busElectronSeal);
        } catch (Exception e) {
            return Result.fail(FailResultCode.CODE_13067_CODE_ERR);
        }
        return Result.success(0);
    }

    /**
     * 获取文件电子章
     * @param flowId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/getBusElectronDoc")
    public Result getBusElectronDoc(@Valid String flowId) throws Exception {
        //根据flowid 获取新地址
        String fileUrl  = DocUtils.getFile(flowId);
        return Result.success(fileUrl);
    }
}
