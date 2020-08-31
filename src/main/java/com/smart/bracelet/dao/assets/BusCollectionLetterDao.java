package com.smart.bracelet.dao.assets;

import com.smart.bracelet.model.po.assets.BusCollectionLetter;
import com.smart.bracelet.model.vo.assets.BusCollectionLetterShow;
import com.smart.bracelet.model.vo.assets.BusCollectionLetterVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusCollectionLetterDao {

    int deleteByPrimaryKey(Long collectionLettertId);

    int insertSelective(BusCollectionLetter record);

    BusCollectionLetter selectByPrimaryKey(Long collectionLettertId);

    int updateByPrimaryKeySelective(BusCollectionLetterVo record);

    List<BusCollectionLetter> queryList();

    /**
     * 查询最后一条编号
     */
    String selectNo();

    /**
     * 催款函页面初始化
     * @param relativePerId
     * @return
     */
    BusCollectionLetterShow initialize(Long relativePerId);
}