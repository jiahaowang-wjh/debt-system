package com.smart.bracelet.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.smart.bracelet.model.po.user.PubMenuShow;

import java.util.List;
import java.util.Map;

public class TreeToolUtils {

    //根节点对象存放到这里
    private List<PubMenuShow> rootList;

    //其他节点存放到这里，可以包含根节点
    private List<PubMenuShow> bodyList;

    public TreeToolUtils(List<PubMenuShow> rootList, List<PubMenuShow> bodyList) {
        this.rootList = rootList;
        this.bodyList = bodyList;
    }

    public List<PubMenuShow> getTree(){   //调用的方法入口
        if(bodyList != null && !bodyList.isEmpty()){
            //声明一个map，用来过滤已操作过的数据
            Map<String,String> map = Maps.newHashMapWithExpectedSize(bodyList.size());
            rootList.forEach(beanTree -> getChild(beanTree,map));
            return rootList;
        }
        return null;
    }

    public void getChild(PubMenuShow treeDto,Map<String,String> map){
        List<PubMenuShow> childList = Lists.newArrayList();
        bodyList.stream()
                .filter(c -> !map.containsKey(c.getMenuId()))
                .filter(c ->c.getPrantId().equals(treeDto.getMenuId()))
                .forEach(c ->{
                    map.put(c.getMenuId().toString(),c.getPrantId().toString());
                    getChild(c,map);
                    childList.add(c);
                });
        treeDto.setChildTreeDto(childList);
    }
}
