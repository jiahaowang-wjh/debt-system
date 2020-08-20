package com.smart.bracelet.dao.debt;

import com.smart.bracelet.model.po.user.PubRolemenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PubRolemenuDao {

    int addListRolemenu(List<PubRolemenu> pubRolemenuDaos);

}
