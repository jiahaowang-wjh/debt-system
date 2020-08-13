package com.smart.bracelet.utils;

import cn.hutool.core.util.StrUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Calendar;
@Component
public class RepNoUtils {

    /**
     * 编号生成方法
     * @param stutas 编号类型
     * @param aLong 数据库中最后一条编号
     * @return
     */
    public String createRepNo(String type,String aLong){
        String repNo;
        int intXuhao;
        String stringXuhao;
        boolean ok=true;
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);//获取年份
        String xuHao=null;
        if(StrUtil.isBlank(aLong)) {
            xuHao = aLong.substring(aLong.toString().indexOf("F") + 1);
            intXuhao = Integer.parseInt(xuHao);
            intXuhao = intXuhao+1;
            stringXuhao = intXuhao+"";
            while (ok){
                if(stringXuhao.length()<6){
                    stringXuhao = 0+stringXuhao;
                }else{
                    ok = false;
                }
            }
            repNo = "TZ" + year + type+stringXuhao;
            return repNo;
        }else {
            repNo = "TZ" + year + type+"000001";
            return repNo;
        }
    }


}
