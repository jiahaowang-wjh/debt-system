package com.smart.bracelet.utils;

import cn.hutool.core.util.StrUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Calendar;
public class RepNoUtils {

    /**
     * 编号生成方法
     * @param headName
     * @param type
     * @param aLong
     * @return
     */
    public static String createRepNo(String headName,String type,String aLong){
        String repNo;
        int intXuhao;
        String stringXuhao;
        String xuHao;
        boolean ok=true;
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);//获取年份
        if(!StrUtil.isBlank(aLong)) {
            int indexOf = aLong.indexOf(type);
            xuHao = aLong.substring(indexOf + type.length());
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
            repNo = headName + year + type+stringXuhao;
            return repNo;
        }else {
            repNo = headName + year + type+"000001";
            return repNo;
        }
    }


}
