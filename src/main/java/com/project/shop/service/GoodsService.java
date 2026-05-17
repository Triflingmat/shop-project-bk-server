package com.project.shop.service;

import com.project.shop.entity.pojo.Page;
import com.project.shop.entity.pojo.Goods;

public interface GoodsService {

    Page findGoodsData(Integer pageNum, Integer pageSize, Integer mode, String name);

    int updateGoodsData(Goods goods);

    int addGoodsData(Goods goods);

    int delGoodsData(Integer id);

    Goods getGoodsById(Integer id);
}
