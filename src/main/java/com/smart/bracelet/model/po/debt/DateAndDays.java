package com.smart.bracelet.model.po.debt;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DateAndDays implements Serializable {

    private static final long serialVersionUID = -6459456744870017121L;


    /**
     * 当日报备分组
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date days;

    /**
     * 每日创建数量
     */
    private int count;

}
