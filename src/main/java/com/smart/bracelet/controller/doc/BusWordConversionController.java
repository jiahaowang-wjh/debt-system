package com.smart.bracelet.controller.doc;

import com.smart.bracelet.exception.CustomerException;
import com.smart.bracelet.message.Result;
import com.smart.bracelet.model.vo.debt.AuxiliaryDownload;
import com.smart.bracelet.model.vo.debt.DowLod;
import com.smart.bracelet.service.debt.BusRelativePersonService;
import com.smart.bracelet.service.doc.BusWordConversionService;
import com.smart.bracelet.utils.ExportHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.util.List;

/**
 * TODO:
 *
 * @author liuzq
 * @version 1.0
 * @date 2020/9/20
 **/
@RestController
@RequestMapping("/wordConversion")
@Validated
public class BusWordConversionController {

    @Autowired
    private BusWordConversionService busWordConversionService;

    @Autowired
    private BusRelativePersonService busRelativePersonService;

    /**
     * 暨尽协议下载
     *
     * @param reportId
     * @param comId
     * @return
     * @throws CustomerException
     * @throws ParseException
     */
    @RequestMapping("/fillInWordAndSaveAsSpecifyFormatCumOut")
    public Result fillInWordAndSaveAsSpecifyFormatCumOut(@NotNull(message = "报备ID不能为空") Long reportId, @NotNull(message = "公司ID不能为空") Long comId
                                                         ) throws CustomerException, ParseException {
        Long aLong = busWordConversionService.fillInWordAndSaveAsSpecifyFormatCumOut(reportId, comId);
        return Result.success(aLong + "");
    }


    /**
     * 填充word并保存为指定格式(策划方案)
     */
    @RequestMapping("/fillInWordAndSaveAsSpecifyFormat")
    public Result fillInWordAndSaveAsSpecifyFormat(@NotNull(message = "解债ID不能为空") Long debtId, @NotNull(message = "公司Id不能为空") Long comId) throws CustomerException {
        busWordConversionService.fillInWordAndSaveAsSpecifyFormatPlan(debtId, comId);
        return Result.success();
    }

    /**
     * 填充Word并保存为指定格式（债权转让协议）
     */
    @RequestMapping("/fillInWordAndSaveAsSpecifyFormatTransfer")
    public Result fillInWordAndSaveAsSpecifyFormatTransfer(@NotNull(message = "资产ID不能为空") Long propertId, @NotNull(message = "公司ID不能为空") Long comId) throws CustomerException, ParseException {
        busWordConversionService.fillInWordAndSaveAsSpecifyFormatTransfer(propertId, comId);
        return Result.success();
    }

    /**
     * 填充Word并保存为指定格式（资产债权转让确认）
     */
    @RequestMapping("/fillInWordAndSaveAsSpecifyFormatConfrim")
    public Result fillInWordAndSaveAsSpecifyFormatConfrim(@NotNull(message = "资产ID不能为空") Long propertId) throws CustomerException, ParseException {
        busWordConversionService.fillInWordAndSaveAsSpecifyFormatConfrim(propertId);
        return Result.success();
    }

    /**
     * 填充Word并保存为指定格式（资产债权通知书）
     */
    @RequestMapping("/fillInWordAndSaveAsSpecifyFormatNotice")
    public Result fillInWordAndSaveAsSpecifyFormatNotice(@NotNull(message = "资产ID不能为空") Long propertId) throws CustomerException, ParseException {
        busWordConversionService.fillInWordAndSaveAsSpecifyFormatNotice(propertId);
        return Result.success();
    }

    /**
     * 填充Word并保存为指定格式（债权确认书）
     */
    @RequestMapping("/fillInWordAndSaveAsSpecifyFormatProve")
    public Result fillInWordAndSaveAsSpecifyFormatProve(@NotNull(message = "资产Id不能为空") Long propertId) throws CustomerException, ParseException {
        busWordConversionService.fillInWordAndSaveAsSpecifyFormatProve(propertId);
        return Result.success();
    }


    /**
     * 填充Word并保存为指定格式（催款函）
     */
    @RequestMapping("/fillInWordAndSaveAsSpecifyFormatLetter")
    public Result fillInWordAndSaveAsSpecifyFormatLetter(@NotNull(message = "资产ID不能为空") Long propertId, @NotNull(message = "公司Id不能为空") Long comId) throws CustomerException, ParseException {
        busWordConversionService.fillInWordAndSaveAsSpecifyFormatLetter(propertId, comId);
        return Result.success();
    }

    /**
     * 填充Word并保存为指定格式（委托代理销售合同）
     */
    @RequestMapping("/fillInWordAndSaveAsSpecifyFormatConsignment")
    public Result fillInWordAndSaveAsSpecifyFormatConsignment(@NotNull(message = "资产ID") Long propertId, @NotNull(message = "公司ID") Long comId) throws CustomerException, ParseException {
        busWordConversionService.fillInWordAndSaveAsSpecifyFormatConsignment(propertId, comId);
        return Result.success();
    }

    /**
     * 填充Word并保存为指定格式（和解协议）
     */
    @RequestMapping("/fillInWordAndSaveAsSpecifyFormatReconciliation")
    public Result fillInWordAndSaveAsSpecifyFormatReconciliation(@NotNull(message = "资产ID") Long propertId, @NotNull(message = "公司ID") Long comId) throws CustomerException, ParseException {
        busWordConversionService.fillInWordAndSaveAsSpecifyFormatReconciliation(propertId, comId);
        return Result.success();
    }

    /**
     * 填充Word并保存为指定格式（委托线上代理销售合同）
     */
    @RequestMapping("/fillInWordAndSaveAsSpecifyFormatOnlineCons")
    public Result fillInWordAndSaveAsSpecifyFormatOnlineCons(@NotNull(message = "资产ID") Long propertId, @NotNull(message = "公司ID") Long comId) throws CustomerException, ParseException {
        busWordConversionService.fillInWordAndSaveAsSpecifyFormatOnlineCons(propertId, comId);
        return Result.success();
    }


    /**
     * 填充Word并保存为指定格式（报备费发票）
     */
    @RequestMapping("/fillInWordAndSaveAsSpecifyFormatReportFee")
    public Result fillInWordAndSaveAsSpecifyFormatReportFee(@NotNull(message = "报备ID") Long reportId, @NotBlank(message = "人员姓名不能为空") String parta, @NotBlank(message = "人员身份证不能为空") String partaCard,
                                                            @NotBlank(message = "人员电话不能为空") String partaTel,Long debtId,Long propertId) throws CustomerException, ParseException {
        busWordConversionService.fillInWordAndSaveAsSpecifyFormatReportFee(reportId, parta, partaCard, partaTel,debtId,propertId);
        return Result.success();
    }

    /**
     * 填充Word并保存为指定格式（咨询服务费发票）
     */
    @RequestMapping("/fillInWordAndSaveAsSpecifyFormatdvisory")
    public Result fillInWordAndSaveAsSpecifyFormatdvisory(@NotNull(message = "报备ID") Long reportId, @NotBlank(message = "人员姓名不能为空") String parta, @NotBlank(message = "人员身份证不能为空") String partaCard,
                                                          @NotBlank(message = "人员电话不能为空") String partaTel,Long debtId,Long propertId) throws CustomerException, ParseException {
        busWordConversionService.fillInWordAndSaveAsSpecifyFormatdvisory(reportId, parta, partaCard, partaTel,debtId,propertId);
        return Result.success();
    }

    /**
     * 填充Word并保存为指定格式（货款务费发票）
     */
    @RequestMapping("/fillInWordAndSaveAsSpecifyPayment")
    public Result fillInWordAndSaveAsSpecifyPayment(@NotNull(message = "报备ID") Long reportId, @NotBlank(message = "人员姓名不能为空") String parta, @NotBlank(message = "人员身份证不能为空") String partaCard,
                                                    @NotBlank(message = "人员电话不能为空") String partaTel,Long debtId,Long propertId) throws CustomerException, ParseException{
        busWordConversionService.fillInWordAndSaveAsSpecifyPayment(reportId,parta,partaCard,partaTel,debtId,propertId);
        return Result.success();
    }


    /**
     * 下载财务
     */
    @RequestMapping("/downSelectDow")
    public void downSelectDow(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String debtName = request.getParameter("debtName");
        String time = request.getParameter("time");
        List<AuxiliaryDownload> auxiliaryDownloads = busRelativePersonService.selectDow(debtName, time);
        try {
            ExportHelper exportHelper = new ExportHelper();
            exportHelper.WriteResponse("财务信息", exportHelper.ExportExcel2(auxiliaryDownloads),
                    request, response);
        } catch (Exception e) {
            e.printStackTrace();
            //Result.fail(FailResultCode.FAIL);
        }
        //return Result.success();
    }
    /**
     * 下载债务
     */
    @RequestMapping("/downSelectDebtDow")
    public void downSelectDebtDow(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        try{
            String debtName = request.getParameter("debtName");
            String time = request.getParameter("time");
            List<DowLod> dowLods = busRelativePersonService.selectDebtDow(debtName, time);
            ExportHelper exportHelper=new ExportHelper();
            exportHelper.WriteResponse("债务信息", exportHelper.ExportExcel1(dowLods),
                    request,response);
        }catch (Exception e){
            e.printStackTrace();
            //Result.fail(FailResultCode.FAIL);
        }
        //return Result.success();
    }

}
