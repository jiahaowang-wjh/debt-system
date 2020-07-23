package com.smart.bracelet.dao.user;

import com.smart.bracelet.model.po.user.PubExp;
import com.smart.bracelet.model.vo.user.PubExpVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PubExpDao {

    int deleteByPrimaryKey(Long expId);

    int insertSelective(PubExp record);

    PubExp selectByPrimaryKey(Long expId);

    int updateByPrimaryKeySelective(PubExpVo record);

    /**
     * 查询所有公式
     * @return
     */
    List<PubExp> queryExpList();

    /**
     * 批量删除公式
     * @param expIds
     * @return
     */
    int delExpList(Long[] expIds);

}