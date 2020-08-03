package com.smart.bracelet.model.po.debt;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * bus_mediate_person
 *
 * @author
 */
@Data
public class BusMediatePerson implements Serializable {

    /**
     * 担保人ID
     */
    private Long mediatePersonId;

    /**
     * 民事调解ID
     */
    @NotNull(message = "民事调解ID不能为空")
    private Long civilId;

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空")
    private Long userId;


}