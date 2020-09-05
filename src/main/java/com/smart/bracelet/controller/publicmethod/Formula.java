package com.smart.bracelet.controller.publicmethod;

import com.smart.bracelet.model.vo.assets.FormulaVo;
import com.smart.bracelet.utils.BigDecimalUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

@RestController
@RequestMapping("/api/formula/")
@Validated
public class Formula {

    /**
     * 公式计算
     *
     * @param type  解债类型 (1.寄售2.一次性提走资产包计算)
     * @param years 解债年限
     * @param money 解债金额
     * @return
     */
    @RequestMapping("/Calculation")
    public FormulaVo Calculation(String type, int years, Float money) {
        FormulaVo formulaVo = new FormulaVo();
        //6
        String resolveNum;
        //7
        String totalCost;
        //8
        String totalMoney;
        //9
        String loan;
        //10
        String consultingMoney;
        //11
        String actualMoney;
        //12
        String average;
        //13
        String payBack;

        if (type.equals("1")) {

            switch (years) {
                //共12个月
                case 1:
                    String mul = BigDecimalUtil.div("0.5", "0.5", 4);
                    resolveNum = BigDecimalUtil.add(mul, "0.1", 4);
                    totalCost = BigDecimalUtil.mul(money.toString(), resolveNum, 2);
                    totalMoney = BigDecimalUtil.div(money.toString(), "0.5", 2);
                    loan = money.toString();
                    consultingMoney = BigDecimalUtil.mul(money.toString(), "0.1", 2);
                    actualMoney = BigDecimalUtil.sub(totalMoney, totalCost, 2);
                    average = BigDecimalUtil.div(totalMoney, "12", 2);
                    payBack = BigDecimalUtil.div(totalCost, average, 2);

                    formulaVo.setDeadline("12");
                    formulaVo.setMoney(money.toString());
                    formulaVo.setDebtScale("50%");
                    formulaVo.setDebtActual("50%");
                    formulaVo.setServiceChargeScale("10%");
                    formulaVo.setResolveNum(resolveNum);
                    formulaVo.setTotalCost(totalCost);
                    formulaVo.setTotalMoney(totalMoney);
                    formulaVo.setLoan(loan);
                    formulaVo.setConsultingMoney(consultingMoney);
                    formulaVo.setAverage(average);
                    formulaVo.setPayBack(payBack);
                    formulaVo.setActualMoney(actualMoney);
                    break;
                //共24个月
                case 2:
                    String mul1 = BigDecimalUtil.div("0.3", "0.7", 4);
                    resolveNum = BigDecimalUtil.add(mul1, "0.1", 4);

                    String mul11 = BigDecimalUtil.div("0.3", "0.7", 10);
                    String  resolveNum1 = BigDecimalUtil.add(mul11, "0.1", 10);
                    totalCost = BigDecimalUtil.mul(money.toString(), resolveNum1, 2);

                    totalMoney = BigDecimalUtil.div(money.toString(), "0.7", 2);
                    String mul2 = BigDecimalUtil.mul(money.toString(), "0.3", 2);

                    loan = BigDecimalUtil.div(mul2,"0.7",2);
                    consultingMoney = BigDecimalUtil.mul(money.toString(), "0.1", 2);
                    actualMoney = BigDecimalUtil.sub(totalMoney, totalCost, 2);
                    average = BigDecimalUtil.div(totalMoney, "24", 2);
                    payBack = BigDecimalUtil.div(totalCost, average, 2);

                    formulaVo.setDeadline("24");
                    formulaVo.setMoney(money.toString());
                    formulaVo.setDebtScale("30%");
                    formulaVo.setDebtActual("70%");
                    formulaVo.setServiceChargeScale("10%");
                    formulaVo.setResolveNum(resolveNum);
                    formulaVo.setTotalCost(totalCost);
                    formulaVo.setTotalMoney(totalMoney);
                    formulaVo.setLoan(loan);
                    formulaVo.setConsultingMoney(consultingMoney);
                    formulaVo.setAverage(average);
                    formulaVo.setPayBack(payBack);
                    formulaVo.setActualMoney(actualMoney);
                    break;
                //共36个月
                case 3:
                    String mul12 = BigDecimalUtil.div("0.2", "0.8", 4);
                    resolveNum = BigDecimalUtil.add(mul12, "0.1", 4);

                    String mul111 = BigDecimalUtil.div("0.2", "0.8", 10);
                    String  resolveNum11 = BigDecimalUtil.add(mul111, "0.1", 10);
                    totalCost = BigDecimalUtil.mul(money.toString(), resolveNum11, 2);

                    totalMoney = BigDecimalUtil.div(money.toString(), "0.8", 2);
                    String mul22 = BigDecimalUtil.mul(money.toString(), "0.2", 2);

                    loan = BigDecimalUtil.div(mul22,"0.8",2);
                    consultingMoney = BigDecimalUtil.mul(money.toString(), "0.1", 2);
                    actualMoney = BigDecimalUtil.sub(totalMoney, totalCost, 2);
                    average = BigDecimalUtil.div(totalMoney, "36", 2);
                    payBack = BigDecimalUtil.div(totalCost, average, 2);

                    formulaVo.setDeadline("36");
                    formulaVo.setMoney(money.toString());
                    formulaVo.setDebtScale("20%");
                    formulaVo.setDebtActual("80%");
                    formulaVo.setServiceChargeScale("10%");
                    formulaVo.setResolveNum(resolveNum);
                    formulaVo.setTotalCost(totalCost);
                    formulaVo.setTotalMoney(totalMoney);
                    formulaVo.setLoan(loan);
                    formulaVo.setConsultingMoney(consultingMoney);
                    formulaVo.setAverage(average);
                    formulaVo.setPayBack(payBack);
                    formulaVo.setActualMoney(actualMoney);
                    break;
            }

        }
        if(type.equals("2")){
            switch (years) {
                //共12个月
                case 1:
                    String mul = BigDecimalUtil.div("0.5", "1", 4);
                    resolveNum = BigDecimalUtil.add(mul, "0.1", 4);
                    totalCost = BigDecimalUtil.mul(money.toString(), resolveNum, 2);
                    totalMoney = BigDecimalUtil.div(money.toString(), "1", 2);
                    String mul3 = BigDecimalUtil.mul(money.toString(), "0.5", 2);
                    loan = BigDecimalUtil.div(mul3,"1",2);
                    consultingMoney = BigDecimalUtil.mul(money.toString(), "0.1", 2);
                    actualMoney = BigDecimalUtil.sub(totalMoney, totalCost, 2);
                    average = BigDecimalUtil.div(totalMoney, "12", 2);
                    payBack = BigDecimalUtil.div(totalCost, average, 2);

                    formulaVo.setDeadline("12");
                    formulaVo.setMoney(money.toString());
                    formulaVo.setDebtScale("50%");
                    formulaVo.setDebtActual("100%");
                    formulaVo.setServiceChargeScale("10%");
                    formulaVo.setResolveNum(resolveNum);
                    formulaVo.setTotalCost(totalCost);
                    formulaVo.setTotalMoney(totalMoney);
                    formulaVo.setLoan(loan);
                    formulaVo.setConsultingMoney(consultingMoney);
                    formulaVo.setAverage(average);
                    formulaVo.setPayBack(payBack);
                    formulaVo.setActualMoney(actualMoney);
                    break;
                //共24个月
                case 2:
                    String mul1 = BigDecimalUtil.div("0.3", "1", 4);
                    resolveNum = BigDecimalUtil.add(mul1, "0.1", 4);

                    String mul11 = BigDecimalUtil.div("0.3", "1", 10);
                    String  resolveNum1 = BigDecimalUtil.add(mul11, "0.1", 10);
                    totalCost = BigDecimalUtil.mul(money.toString(), resolveNum1, 2);

                    totalMoney = BigDecimalUtil.div(money.toString(), "1", 2);
                    String mul2 = BigDecimalUtil.mul(money.toString(), "0.3", 2);

                    loan = BigDecimalUtil.div(mul2,"1",2);
                    consultingMoney = BigDecimalUtil.mul(money.toString(), "0.1", 2);
                    actualMoney = BigDecimalUtil.sub(totalMoney, totalCost, 2);
                    average = BigDecimalUtil.div(totalMoney, "24", 2);
                    payBack = BigDecimalUtil.div(totalCost, average, 2);

                    formulaVo.setDeadline("24");
                    formulaVo.setMoney(money.toString());
                    formulaVo.setDebtScale("30%");
                    formulaVo.setDebtActual("100%");
                    formulaVo.setServiceChargeScale("10%");
                    formulaVo.setResolveNum(resolveNum);
                    formulaVo.setTotalCost(totalCost);
                    formulaVo.setTotalMoney(totalMoney);
                    formulaVo.setLoan(loan);
                    formulaVo.setConsultingMoney(consultingMoney);
                    formulaVo.setAverage(average);
                    formulaVo.setPayBack(payBack);
                    formulaVo.setActualMoney(actualMoney);
                    break;
                //共36个月
                case 3:
                    String mul12 = BigDecimalUtil.div("0.2", "1", 4);
                    resolveNum = BigDecimalUtil.add(mul12, "0.1", 4);

                    String mul111 = BigDecimalUtil.div("0.2", "1", 10);
                    String  resolveNum11 = BigDecimalUtil.add(mul111, "0.1", 10);
                    totalCost = BigDecimalUtil.mul(money.toString(), resolveNum11, 2);

                    totalMoney = BigDecimalUtil.div(money.toString(), "1", 2);
                    String mul22 = BigDecimalUtil.mul(money.toString(), "0.2", 2);

                    loan = BigDecimalUtil.div(mul22,"1",2);
                    consultingMoney = BigDecimalUtil.mul(money.toString(), "0.1", 2);
                    actualMoney = BigDecimalUtil.sub(totalMoney, totalCost, 2);
                    average = BigDecimalUtil.div(totalMoney, "36", 2);
                    payBack = BigDecimalUtil.div(totalCost, average, 2);

                    formulaVo.setDeadline("36");
                    formulaVo.setMoney(money.toString());
                    formulaVo.setDebtScale("20%");
                    formulaVo.setDebtActual("100%");
                    formulaVo.setServiceChargeScale("10%");
                    formulaVo.setResolveNum(resolveNum);
                    formulaVo.setTotalCost(totalCost);
                    formulaVo.setTotalMoney(totalMoney);
                    formulaVo.setLoan(loan);
                    formulaVo.setConsultingMoney(consultingMoney);
                    formulaVo.setAverage(average);
                    formulaVo.setPayBack(payBack);
                    formulaVo.setActualMoney(actualMoney);
                    break;
            }
        }
        return formulaVo;
    }
}
