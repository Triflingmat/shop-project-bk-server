package com.project.shop.service.impl;

import com.project.shop.entity.pojo.Goods;
import com.project.shop.entity.pojo.Page;
import com.project.shop.mapper.GoodsMapper;
import com.project.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Page findGoodsData(Integer pageNum, Integer pageSize, Integer mode, String name){
        int offset = (pageNum - 1) * pageSize;
        List<Goods> list = goodsMapper.findGoodsData(offset, pageSize, mode, name);
        long total = goodsMapper.getGoodsCount(mode, name);
        Page<Goods> page = new Page<>();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        page.setList(list);
        page.setTotal(total);
        return page;
    }

    @Override
    public int updateGoodsData(Goods goods){return goodsMapper.updateGoodsData(goods);}

    @Override
    public int addGoodsData(Goods goods){return goodsMapper.addGoodsData(goods);}

    @Override
    public int delGoodsData(Integer id){return goodsMapper.delGoodsData(id);}

    @Override
    public Goods getGoodsById(Integer id){return goodsMapper.getGoodsById(id);}


}
