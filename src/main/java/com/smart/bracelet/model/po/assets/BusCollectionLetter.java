package com.smart.bracelet.model.po.assets;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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
    private Long collectionLettertId;

    /**
     * 编号
     */
    private String collectionLettertNo;
    /**
     * 资产ID
     */
    @NotNull(message = "资产ID不能为空")
    private Long propertId;

    /**
     * 甲方确认送达地址
     */
    @NotBlank(message = "甲方确认送达地址不能为空")
    private String partyaAddr;

    /**
     * 甲方确认送达联系人
     */
    @NotBlank(message = "甲方确认送达联系人不能为空")
    private String partyaPerson;

    /**
     * 甲方确认送达电话
     */
    @NotBlank(message = "甲方确认送达电话不能为空")
    private String partyaTel;

    /**
     * 乙方确认送达地址
     */
    @NotBlank(message = "乙方确认送达地址不能为空")
    private String partybAddr;

    /**
     * 乙方确认送达联系人
     */
    @NotBlank(message = "乙方确认送达联系人不能为空")
    private String partybPerson;

    /**
     * 乙方确认送达电话
     */
    @NotBlank(message = "乙方确认送达电话不能为空")
    private String partybTel;

}