package com.smart.bracelet.controller.debt;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.po.debt.BusReport;
import com.smart.bracelet.model.po.debt.DateAndDays;
import com.smart.bracelet.model.vo.debt.*;
import com.smart.bracelet.service.debt.BusReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 报备信息表现层
 */
@RestController
@RequestMapping("/api/busReportController/")
@Validated
public class BusReportController {

    @Autowired
    private BusReportService busReportService;

    /**
     * 非空验证
     * @param busReportListVo
     * @return
     */
    public StringBuffer PackageRep(BusReportListVo busReportListVo){
        StringBuffer stringBuffer = new StringBuffer();
        if (busReportListVo.getReportPropert().equals("1")) {
            if (busReportListVo.getPersonalName().equals("")) {
                stringBuffer.append("姓名不能为空,");
            } if (busReportListVo.getPhone().equals("")){
                stringBuffer.append("手机号码不能为空,");
            } if (busReportListVo.getIdCard().equals("")){
                stringBuffer.append("身份证号码不能为空,");
            } if (busReportListVo.getArea().equals("")){
                stringBuffer.append("所在地区不能为空,");
            } if (busReportListVo.getEmail().equals("")){
                stringBuffer.append("电子邮箱不能为空,");
            } if (busReportListVo.getAssets().equals("")){
                stringBuffer.append("资产总价值不能为空,");
            } if (busReportListVo.getSex().equals("")){
                stringBuffer.append("性别不能为空,");
            } if (busReportListVo.getAssetsNumber().equals("")){
                stringBuffer.append("资产项数不能为空,");
            } if (busReportListVo.getCirculationAssets().equals("")){
                stringBuffer.append("可流通资产价值不能为空");
            }
            if(stringBuffer.length()>0) {
                return stringBuffer;
            }
        }else if(busReportListVo.getReportPropert().equals("2")){
            if (busReportListVo.getCompanyName().equals("")) {
                stringBuffer.append("企业名称不能为空,");
            } if (busReportListVo.getCreditCode().equals("")){
                stringBuffer.append("社会统一信用代码不能为空,");
            } if (busReportListVo.getIndustryAttributes().equals("")){
                stringBuffer.append("行业属性不能为空,");
            } if (busReportListVo.getLegalName().equals("")){
                stringBuffer.append("法定代表人名称不能为空,");
            } if (busReportListVo.getLegalPhone().equals("")){
                stringBuffer.append("法定代表人联系电话不能为空");
            } if (busReportListVo.getLegalIdCard().equals("")){
                stringBuffer.append("法定代表人身份证号不能为空");
            } if (busReportListVo.getAddress().equals("")){
                stringBuffer.append("注册地址不能为空");
            } if (busReportListVo.getContactPerson().equals("")){
                stringBuffer.append("企业联系人不能为空");
            } if (busReportListVo.getContactPhone().equals("")){
                stringBuffer.append("联系电话不能为空");
            }
            if(stringBuffer.length()>0){
                return stringBuffer;
            }
        }
        return stringBuffer;
    }


    /**
     * 新增私人报备信息
     *
     * @param
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/insertPrivateSelective")
    public Result insertPrivateSelective(@Valid BusPrivateReport busPrivateReport) throws CustomerException {
        int insertPrivateSelective = busReportService.insertPrivateSelective(busPrivateReport);
        return Result.success(insertPrivateSelective);
    }

    /**
     * 新增企业报备信息
     *
     * @param
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/insertEterpriseSelective")
    public Result insertEterpriseSelective(@Valid BusEterpriseReport busEterpriseReport) throws CustomerException {
        int insertEterpriseSelective = busReportService.insertEterpriseSelective(busEterpriseReport);
        return Result.success(insertEterpriseSelective);
    }

    /**
     * 新增银行报备信息
     *
     * @param
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/insertBankSelective")
    public Result insertBankSelective(@Valid BusBankReport busBankReport) throws CustomerException {
        int insertBankSelective = busReportService.insertBankSelective(busBankReport);
        return Result.success(insertBankSelective);
    }

    /**
     * 通过Id删除报备信息
     *
     * @param reportId
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@NotNull(message = "报备信息Id不能为空") Long reportId) throws CustomerException {
        int deleteByPrimaryKey = busReportService.deleteByPrimaryKey(reportId);
        return Result.success(deleteByPrimaryKey);
    }

    /**
     * 更新个人报备信息
     * @param busPrivateReportVo
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updatePrivateSelective")
    public Result updatePrivateSelective(@Valid BusPrivateReportVo busPrivateReportVo) throws CustomerException {
        int updatePrivateSelective = busReportService.updatePrivateSelective(busPrivateReportVo);
        return Result.success(updatePrivateSelective);
    }


    /**
     * 更新个人报备信息
     * @param busPrivateReportVo
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateEterpriseSelective")
    public Result updateEterpriseSelective(@Valid BusEterpriseReportVo busPrivateReportVo) throws CustomerException {
        int updatePrivateSelective = busReportService.updateEterpriseSelective(busPrivateReportVo);
        return Result.success(updatePrivateSelective);
    }

    /**
     * 更新个人报备信息
     * @param busPrivateReportVo
     * @return
     * @throws CustomerException
     */
    @RequestMapping("/updateBankSelective")
    public Result updateBankSelective(@Valid BusBankReportVo busPrivateReportVo) throws CustomerException {
        int updatePrivateSelective = busReportService.updateBankSelective(busPrivateReportVo);
        return Result.success(updatePrivateSelective);
    }


    /**
     * 通过Id查询报备信息
     *
     * @param reportId
     * @return
     */
    @RequestMapping("/selectByPrimaryKey")
    public Result<BusReportListVo> selectByPrimaryKey(@NotNull(message = "报备信息Id不能为空") Long reportId) throws CustomerException {
        BusReportListVo busReportListVo = busReportService.selectByPrimaryKey(reportId);
        return Result.success(busReportListVo);
    }

    /**
     * 查询所有报备信息
     *
     * @return
     */
    @RequestMapping("/queryBusReport")
    public Result<List<BusReportListVo>> queryBusReport() throws CustomerException {
        List<BusReportListVo> busReports = busReportService.queryBusReport();
        return Result.success(busReports);
    }

    /**
     * 按照日期查询每日报备数量
     *
     * @return
     */
    @RequestMapping("/selectDaysCount")
    public Result<List<DateAndDays>> selectDaysCount() {
        List<DateAndDays> busReports = busReportService.selectDaysCount();
        return Result.success(busReports);
    }
}
