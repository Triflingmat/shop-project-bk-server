package com.project.shop.controller;

import com.project.shop.common.Result;
import com.project.shop.entity.pojo.Page;
import com.project.shop.entity.pojo.Goods;
import com.project.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    //查找商品数据
    @GetMapping("/goods/list")
    public Result<Page<Goods>> findGoodsData(
            @RequestParam(defaultValue = "1")Integer pageNum,
            @RequestParam(defaultValue = "15")Integer pageSize,
            @RequestParam(defaultValue = "0") Integer mode){
        try{
            Page<Goods> page = goodsService.findGoodsData(pageNum,pageSize,mode);
            return Result.success(page);
        }catch (RuntimeException e){
            return Result.fail(e.getMessage());
        }
    }
    //更改商品数据
    @PutMapping("/goods/update")
    public Result<Goods> updateGoodsData(@RequestBody Goods goods){
        int updateGoods = goodsService.updateGoodsData(goods);
        if (updateGoods==0){
            return Result.fail("发生错误");
        }
        return Result.success(goods);
    }
    //增加商品数据
    @PostMapping("/goods/add")
    public  Result<Goods> addGoodsData(@RequestBody Goods goods){
        int addGoods = goodsService.addGoodsData(goods);
        if (addGoods==0){
            return Result.fail("发生错误");
        }
        return Result.success(goods);
    }

    //删除商品数据
    @DeleteMapping("/goods/del/{id}")
    public  Result<Goods> delGoodsData(@PathVariable Integer id){
        int delGoods = goodsService.delGoodsData(id);
        if (delGoods==0){
            return Result.fail("发生错误");
        }
        return Result.success(null);
    }

    /** 获取单个商品详情 */
    @GetMapping("/goods/detail/{id}")
    public Result<Goods> getGoodsDetail(@PathVariable Integer id){
        try {
            Goods goods = goodsService.getGoodsById(id);
            if (goods == null) {
                return Result.fail("商品不存在");
            }
            return Result.success(goods);
        } catch (RuntimeException e) {
            return Result.fail(e.getMessage());
        }
    }
}
