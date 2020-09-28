package com.smart.bracelet.model.po.assets;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * bus_collection_letter
 *
 * @author
 */
@Data
public class BusCollectionLetter implements Serializable {

    /**
     * 催款函ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long collectionLettertId;


    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空")
    private String collectionLettertNo;
    /**
     * 资产ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "资产ID不能为空")
    private Long propertId;

    /**
     * 合同日期
     */
    @NotNull(message = "合同日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date contractDate;


    /**
     * 甲方确认送达地址
     */
    private String partyaAddr;

    /**
     * 甲方确认送达联系人
     */
    private String partyaPerson;

    /**
     * 甲方确认送达电话
     */
    private String partyaTel;

    /**
     * 乙方确认送达地址
     */
    private String partybAddr;

    /**
     * 乙方确认送达联系人
     */
    private String partybPerson;

    /**
     * 乙方确认送达电话
     */
    private String partybTel;

    /**
     * 电子章
     */
    String chapter;

}