package com.smart.bracelet.model.vo.debt;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * bus_mediate_person
 *
 * @author
 */
@Data
public class BusMediatePersonVo implements Serializable {

    /**
     * 担保人ID
     */
    @NotNull(message = "担保人ID不能为空")
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