package com.smart.bracelet.service.doc.impl;

import com.smart.bracelet.enums.DocReplaceEnum;
import com.smart.bracelet.enums.DocumentPath;
import com.smart.bracelet.service.doc.BusWordConversionService;
import com.smart.bracelet.utils.IdUtils;

import com.smart.bracelet.utils.PdfUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzq
 * @version 1.0
 * @date 2020/9/20
 **/
@Service
@Slf4j
public class BusWordConversionServiceImpl implements BusWordConversionService {

    /**
     * 填充Word并保存为指定格式
     *
     * @author liuzq
     * @date 2020/9/20
     */
    @Override
    public void fillInWordAndSaveAsSpecifyFormat() {
        //设置模板读取路径
        String readPath = DocumentPath.WORD_TEMPLATE.getPath() + DocumentPath.WORD_TEMPLATE.getFileName();
        //设置pdf文件保存路径
        String savePath = DocumentPath.PDF_SAVE.getPath() + DocumentPath.PDF_SAVE.getName() + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        map.put(DocReplaceEnum.DEBT_NAME.getName(), "张三");
        map.put(DocReplaceEnum.DEBT_ID_CARD.getName(), "510364198712021816");
        map.put(DocReplaceEnum.ID_CARD_ADDRESS.getName(), "重庆市渝中区xxxx");
        map.put(DocReplaceEnum.PHONE_NUMBER.getName(), "18765453643");
        map.put(DocReplaceEnum.SITUATION.getName(), "1");
        map.put(DocReplaceEnum.AMOUNT.getName(), "100");
        map.put(DocReplaceEnum.AMOUNT_IN_WORDS.getName(), "壹佰");
        map.put(DocReplaceEnum.PRINCIPAL.getName(), "10000");
        map.put(DocReplaceEnum.INTEREST.getName(), "100");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 0.信息分析暨尽调协议（天泽系统）
     */
    public void informationAnalysis() {
        //设置模板读取路径
        String readPath = "D:/doc/0.信息分析暨尽调协议（天泽系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/0.信息分析暨尽调协议（天泽系统）" + IdUtils.nextId() + ".pdf";
        LocalDate date = LocalDate.now();
        Map<String, String> map = new HashMap<>(20);
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("reporter", "张三");
        map.put("reporterIDCard", "" + IdUtils.nextId());
        map.put("partyA", "张三");
        map.put("partyB", "李四");
        map.put("yyy1", date.getYear() + "");
        map.put("M1", date.getMonthValue() + "");
        map.put("d1", date.getDayOfMonth() + "");
        map.put("yyy2", date.getYear() + "");
        map.put("M2", date.getMonthValue() + "");
        map.put("d2", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 1.策划方案服务协议(天泽系统）
     */
    public void planningScheme() {
        //设置模板读取路径
        String readPath = "D:/doc/1.策划方案服务协议(天泽系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/1.策划方案服务协议(天泽系统）" + IdUtils.nextId() + ".pdf";
        LocalDate date = LocalDate.now();
        Map<String, String> map = new HashMap<>(20);
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("debtName", "张三");
        map.put("debtIdCard", "510364198712021816");
        map.put("idCardAddress", "重庆市渝中区xxxx");
        map.put("phoneNumber", "18765453643");
        map.put("situation", "1");
        map.put("amount", "11000");
        map.put("amountInWords", "壹万壹仟");
        map.put("principal", "10000");
        map.put("interest", "1000");
        map.put("serviceFee", "1100");
        map.put("serviceFeeInWords", "壹仟壹佰");
        map.put("yyy1", date.getYear() + "");
        map.put("M1", date.getMonthValue() + "");
        map.put("d1", date.getDayOfMonth() + "");
        map.put("yyy2", date.getYear() + "");
        map.put("M2", date.getMonthValue() + "");
        map.put("d2", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 2.债权转让协议1（资产系统）
     */
    public void debtAssignmentAgreement() {
        //设置模板读取路径
        String readPath = "D:/doc/2.债权转让协议1（资产系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/2.债权转让协议1（资产系统）" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("debtName", "张三");
        map.put("idCard", "510265197612271644");
        map.put("idCardAddress", "重庆市渝中区xxxx");
        map.put("phoneNumber", "17578655634");
        map.put("personName", "李四");
        map.put("yyy1 ", "2020");
        map.put("M1", "5");
        map.put("d1", "26");
        map.put("yyy2", date.getYear() + "");
        map.put("M2", date.getMonthValue() + "");
        map.put("d2", date.getDayOfMonth() + "");
        map.put("amount", "11000");
        map.put("principal", "10000");
        map.put("interest", "1000");
        map.put("amount2", "11000");
        map.put("partyA", "张三");
        map.put("partyB", "李四");
        map.put("yyy3", date.getYear() + "");
        map.put("M3", date.getMonthValue() + "");
        map.put("d3", date.getDayOfMonth() + "");
        map.put("yyy4", date.getYear() + "");
        map.put("M4", date.getMonthValue() + "");
        map.put("d4", date.getDayOfMonth() + "");
        //这里设置需要填充的表格行数
        int length = 6;
        //表格行数默认最多10行
        for (int i = 1; i < 11; i++) {
            if (i > length) {
                map.put("productName" + i, "");
                map.put("model" + i, "");
                map.put("unit" + i, "");
                map.put("unitPrice" + i, "");
                map.put("amount" + i, "");
                map.put("total" + i, "");
                map.put("remarks" + i, "");
            } else {
                map.put("productName" + i, "商品" + i);
                map.put("model" + i, "SPR-138");
                map.put("unit" + i, "个");
                map.put("unitPrice" + i, "1");
                map.put("amount" + i, "10");
                map.put("total" + i, "10");
                map.put("remarks" + i, "");
            }
        }
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }


    /**
     * 3.债权转让确认书 （资产系统）
     */
    public void confirmation() {
        //设置模板读取路径
        String readPath = "D:/doc/3.债权转让确认书 （资产系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/3.债权转让确认书 （资产系统）" + IdUtils.nextId() + ".pdf";
        LocalDate date = LocalDate.now();
        Map<String, String> map = new HashMap<>(20);
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("agreementNumber2", IdUtils.nextId() + "");
        map.put("agreementNumber3", IdUtils.nextId() + "");
        map.put("debtName", "张三");
        map.put("personName", "李四");
        map.put("guarantee", "王五");
        map.put("amount", "11000");
        map.put("yyy1", date.getYear() + "");
        map.put("M1", date.getMonthValue() + "");
        map.put("d1", date.getDayOfMonth() + "");
        map.put("yyy2", date.getYear() + "");
        map.put("M2", date.getMonthValue() + "");
        map.put("d2", date.getDayOfMonth() + "");
        map.put("yyy3", date.getYear() + "");
        map.put("M3", date.getMonthValue() + "");
        map.put("d3", date.getDayOfMonth() + "");
        map.put("yyy4", date.getYear() + "");
        map.put("M4", date.getMonthValue() + "");
        map.put("d4", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 4.债权转让通知书 （资产系统）
     */
    public void notice() {
        //设置模板读取路径
        String readPath = "D:/doc/4.债权转让通知书 （资产系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/4.债权转让通知书 （资产系统）" + IdUtils.nextId() + ".pdf";
        LocalDate date = LocalDate.now();
        Map<String, String> map = new HashMap<>(20);
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("debtName", "张三");
        map.put("personName", "李四");
        map.put("personReason", "因xxx，造成了巨大的损失，所以需要在这里完成他们的事物");
        map.put("idCard", "510364198712021816");
        map.put("amount", "11000");
        map.put("yyyy", date.getYear() + "");
        map.put("MM", date.getMonthValue() + "");
        map.put("dd", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);

    }

    /**
     * 5.债权确认书 （资产系统）
     */
    public void confirmationOfCreditorRights() {
        //设置模板读取路径
        String readPath = "D:/doc/5.债权确认书 （资产系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/5.债权确认书 （资产系统）" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("personName", "李四");
        map.put("debtName", "张三");
        map.put("agreementNumber2", IdUtils.nextId() + "");
        map.put("yyy1", date.getYear() + "");
        map.put("M1", date.getMonthValue() + "");
        map.put("d1", date.getDayOfMonth() + "");
        map.put("principal", "11000");
        map.put("interest", "1000");
        map.put("yyy2", date.getYear() + "");
        map.put("M2", date.getMonthValue() + "");
        map.put("d2", date.getDayOfMonth() + "");
        map.put("yyy3", date.getYear() + "");
        map.put("M3", date.getMonthValue() + "");
        map.put("d3", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 6.催款函 （资产系统）
     */
    public void dunningLetter() {
        //设置模板读取路径
        String readPath = "D:/doc/6.催款函 （资产系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/6.催款函 （资产系统）" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("debtName", "张三");
        map.put("personName", "李四");
        map.put("agreementNumber2", IdUtils.nextId() + "");
        map.put("amount", "11000");
        map.put("amountInWords", "壹万壹仟");
        map.put("yyyy", date.getYear() + "");
        map.put("MM", date.getMonthValue() + "");
        map.put("dd", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 7.委托代理销售合同1 （资产系统）
     */
    public void salesContract() {
        //设置模板读取路径
        String readPath = "D:/doc/7.委托代理销售合同1 （资产系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/7.委托代理销售合同1 （资产系统）" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("debtName", "张三");
        map.put("idCard", "510453197607161416");
        map.put("idCardAddress", "重庆市渝中区xxxx");
        map.put("phoneNumber", "13656467865");
        map.put("yyy1", "2020");
        map.put("M1", "6");
        map.put("d1", "21");
        map.put("yyy2", date.getYear() + "");
        map.put("M2", date.getMonthValue() + "");
        map.put("d2", date.getDayOfMonth() + "");
        map.put("amount", "11000");
        map.put("amountInWords", "壹万壹仟");
        map.put("bankCard", "5642245785546532");
        map.put("bank", "中国银行");
        map.put("partyA", "张三");
        map.put("partyB", "李四");
        map.put("yyy3", date.getYear() + "");
        map.put("M3", date.getMonthValue() + "");
        map.put("d3", date.getDayOfMonth() + "");
        map.put("yyy4", date.getYear() + "");
        map.put("M4", date.getMonthValue() + "");
        map.put("d4", date.getDayOfMonth() + "");
        //这里设置需要填充的表格行数
        int length = 6;
        //表格行数默认最多10行
        for (int i = 1; i < 11; i++) {
            if (i > length) {
                map.put("productName" + i, "");
                map.put("model" + i, "");
                map.put("unit" + i, "");
                map.put("unitPrice" + i, "");
                map.put("amount" + i, "");
                map.put("total" + i, "");
                map.put("remarks" + i, "");
            } else {
                map.put("productName" + i, "商品" + i);
                map.put("model" + i, "SPR-138");
                map.put("unit" + i, "个");
                map.put("unitPrice" + i, "1");
                map.put("amount" + i, "10");
                map.put("total" + i, "10");
                map.put("remarks" + i, "");
            }
        }
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 8.委托代理销售合同补充协议 （资产系统）
     */
    public void supplementalAgreement() {
        //设置模板读取路径
        String readPath = "D:/doc/8.委托代理销售合同补充协议 （资产系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/8.委托代理销售合同补充协议 （资产系统）" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("agreementNumber2", IdUtils.nextId() + "");
        map.put("debtName", "张三");
        map.put("partyA", "张三");
        map.put("partyB", "李四");
        map.put("yyy1", date.getYear() + "");
        map.put("M1", date.getMonthValue() + "");
        map.put("d1", date.getDayOfMonth() + "");
        map.put("yyy2", date.getYear() + "");
        map.put("M2", date.getMonthValue() + "");
        map.put("d2", date.getDayOfMonth() + "");
        map.put("yyy3", date.getYear() + "");
        map.put("M3", date.getMonthValue() + "");
        map.put("d3", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 9.和解协议 （资产系统）
     */
    public void settlementAgreement() {
        //设置模板读取路径
        String readPath = "D:/doc/9.和解协议 （资产系统）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/9.和解协议 （资产系统）" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("personName", "李四");
        map.put("debtName", "张三");
        map.put("amount", "11000");
        String situation = "三";
        map.put("situation", situation);
        //根据不同的选项替换内容
        if ("一".equals(situation)) {
            map.put("amount2", "10000");
            map.put("average", "");
            map.put("days", "");
        }
        if ("二".equals(situation)) {
            map.put("amount2", "");
            map.put("average", "2000");
            map.put("days", "15");
        }
        if ("三".equals(situation)) {
            map.put("amount2", "");
            map.put("average", "");
            map.put("days", "");
        }
        map.put("partyA", "张三");
        map.put("partyB", "李四");
        map.put("yyy1", date.getYear() + "");
        map.put("M1", date.getMonthValue() + "");
        map.put("d1", date.getDayOfMonth() + "");
        map.put("yyy2", date.getYear() + "");
        map.put("M2", date.getMonthValue() + "");
        map.put("d2", date.getDayOfMonth() + "");
        map.put("yyy3", date.getYear() + "");
        map.put("M3", date.getMonthValue() + "");
        map.put("d3", date.getDayOfMonth() + "");

        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 14委托线上代理销售合同
     */
    public void onlineAgent() {
        //设置模板读取路径
        String readPath = "D:/doc/14委托线上代理销售合同.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/14委托线上代理销售合同" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("agreementNumber", IdUtils.nextId() + "");
        map.put("client", "张三");
        map.put("idCard", "510265197612271644");
        map.put("idCardAddress", "重庆市渝中区xxxx");
        map.put("phoneNumber", "13876353678");
        map.put("yyy1", "2020");
        map.put("M1", "5");
        map.put("d1", "12");
        map.put("yyy2", "2020");
        map.put("M2", "6");
        map.put("d2", "18");
        map.put("amount", "11000");
        map.put("amountInWords", "壹万壹仟");
        map.put("fraction", "123");
        map.put("accountNumber", "67338267272");
        map.put("phoneNumber2", "17865253568");
        map.put("idCard2", "501286198702214698");
        map.put("partyA", "张三");
        map.put("partyB", "李四");
        map.put("yyy3", date.getYear() + "");
        map.put("M3", date.getMonthValue() + "");
        map.put("d3", date.getDayOfMonth() + "");
        map.put("yyy4", date.getYear() + "");
        map.put("M4", date.getMonthValue() + "");
        map.put("d4", date.getDayOfMonth() + "");
        //这里设置需要填充的表格行数
        int length = 6;
        //表格行数默认最多10行
        for (int i = 1; i < 11; i++) {
            if (i > length) {
                map.put("productName" + i, "");
                map.put("model" + i, "");
                map.put("unit" + i, "");
                map.put("unitPrice" + i, "");
                map.put("amount" + i, "");
                map.put("total" + i, "");
                map.put("remarks" + i, "");
            } else {
                map.put("productName" + i, "商品" + i);
                map.put("model" + i, "SPR-138");
                map.put("unit" + i, "个");
                map.put("unitPrice" + i, "1");
                map.put("amount" + i, "10");
                map.put("total" + i, "10");
                map.put("remarks" + i, "");
            }
        }
        map.put("total", "60");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 收据（报备费）
     */
    public void filingFeeReceipt() {
        //设置模板读取路径
        String readPath = "D:/doc/收据（报备费）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/收据（报备费）" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("office1", "重庆市办事处");
        map.put("office2", "重庆市办事处");
        map.put("debtName", "张三");
        map.put("personName", "李四");
        map.put("number1", "TZFWF00002");
        map.put("number2", "TZFWF00002");
        map.put("bbCost1", "11000");
        map.put("bbCostInWords1", "壹万壹仟元整");
        map.put("bbCost2", "11000");
        map.put("bbCostInWords2", "壹万壹仟元整");
        map.put("yyy1", date.getYear() + "");
        map.put("M1", date.getMonthValue() + "");
        map.put("d1", date.getDayOfMonth() + "");
        map.put("yyy2", date.getYear() + "");
        map.put("M2", date.getMonthValue() + "");
        map.put("d2", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 收据（预付款）
     */
    public void prepaymentReceipt() {
        //设置模板读取路径
        String readPath = "D:/doc/收据（预付款）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/收据（预付款）" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("office1", "重庆市办事处");
        map.put("debtName", "张三");
        map.put("number1", "JRYFK00002");
        map.put("moneyWay", "11000");
        map.put("moneyWayInWords", "壹万壹仟元整");
        map.put("yyy1", date.getYear() + "");
        map.put("M1", date.getMonthValue() + "");
        map.put("d1", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

    /**
     * 收据（咨询服务费）
     */
    public void consultingServiceFeeReceipt() {
        //设置模板读取路径
        String readPath = "D:/doc/收据（咨询服务费）.docx";
        //设置pdf文件保存路径
        String savePath = "D:/doc/收据（咨询服务费）" + IdUtils.nextId() + ".pdf";
        Map<String, String> map = new HashMap<>(20);
        LocalDate date = LocalDate.now();
        map.put("office1", "重庆市办事处");
        map.put("payer", "张素芳");
        map.put("number1", "TZFWF00002");
        map.put("consultingMoney", "11000");
        map.put("consultingMoneyInWords", "壹万壹仟元整");
        map.put("yyy1", date.getYear() + "");
        map.put("M1", date.getMonthValue() + "");
        map.put("d1", date.getDayOfMonth() + "");
        //替换模板并保存为PDF
        PdfUtil.fillInWordAndSaveAsPdf(readPath, savePath, map);
    }

}
