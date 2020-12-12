package com.smart.bracelet.controller.doc;

import com.smart.bracelet.enums.FailResultCode;
import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.doc.BusElectronSeal;
import com.smart.bracelet.model.po.doc.BusElectronUserno;
import com.smart.bracelet.model.po.doc.BusEletronUser;
import com.smart.bracelet.model.po.user.PubDoc;
import com.smart.bracelet.service.doc.BusElectronSealService;
import com.smart.bracelet.service.doc.BusElectronUserService;
import com.smart.bracelet.service.doc.BusElectronUsernoService;
import com.smart.bracelet.service.user.PubDocService;
import com.smart.bracelet.utils.DocUtils;
import com.smart.bracelet.utils.IdUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 电子章
 */
@RestController
@RequestMapping("api/BusElectron/")
@Validated
public class BusElectronSealController {

    /**
     * 电子章对象
     */
    @Resource
    private BusElectronSealService busElectronSealService;

    /**
     * 电子章对象
     */
    @Resource
    private BusElectronUsernoService busElectronUsernoService;

    @Resource
    private PubDocService pubDocService;

    /**
     * 电子章对象
     */
    @Resource
    private BusElectronUserService busElectronUserService;

    /**
     * 电子章创建
     *
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
            String acctIdStr = "";
            String acctIdStr2 = "";
            if (StringUtils.isNotEmpty(partaCard)) {
                String [] partaCards = partaCard.split(",");
                String [] partas = busElectronSeal.getParta().split(",");
                String [] partaTels = busElectronSeal.getPartaTel().split(",");

                for (int i = 0; i < partaCards.length; i++) {
                    busEletronUser = null;
                    busEletronUser = busElectronUserService.selectByPartaCard(partaCards[i]);
                    //判定人是否存储过
                    if (busEletronUser == null) {
                        busEletronUser = new BusEletronUser();
                        BusElectronUserno busElectronUserno = busElectronUsernoService.selectByPrimaryNotype("USER_NO");
                        int acctId = busElectronUserno.getIdno();
                        acctId += 1;
                        busElectronUserno.setIdno(acctId);
                        busElectronUsernoService.updateByPrimaryKey(busElectronUserno);
                        busEletronUser.setUserName(partas[i]);
                        busEletronUser.setUserCard(partaCards[i]);
                        busEletronUser.setUserTel(partaTels[i]);
                        String acctIdStra = DocUtils.creatUser(DocUtils.creatUserId(acctId), busEletronUser);
                        //创建个人账号
                        busEletronUser.setAcctId(acctIdStra);
                        busElectronUserService.insert(busEletronUser);
                    }
                    if(i==0){
                        if (busEletronUser != null) {
                            acctIdStr = busEletronUser.getAcctId()+"";
                        }
                    }else{
                        if (busEletronUser != null) {
                            acctIdStr2 = busEletronUser.getAcctId()+"";
                        }
                    }
                }
            }
            //创建电子章及盖电子章
            String returnElectronCon = DocUtils.fileCrete(docType, busElectronSeal, acctIdStr,acctIdStr2);
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
     *
     * @param docId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/getBusElectronDoc")
    public Result getBusElectronDoc(@NotNull(message = "文档ID不能为空") Long docId) throws Exception {
        //根据flowid 获取新地址
        BusElectronSeal busElectronSeal = busElectronSealService.selectByDocId(docId);
        if(busElectronSeal!=null){
            String fileUrl = DocUtils.getFile(busElectronSeal.getFlowId());
            return Result.success(fileUrl);
        }
        PubDoc pubDoc = pubDocService.selectByPrimaryKey(docId);
        return Result.success(pubDoc.getDocPath());
    }
}
