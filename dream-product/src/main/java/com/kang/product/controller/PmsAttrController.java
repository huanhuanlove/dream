package com.kang.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kang.product.entity.PmsAttrEntity;
import com.kang.product.service.PmsAttrService;
import com.kang.common.utils.PageUtils;
import com.kang.common.utils.R;



/**
 * 商品属性
 *
 * @author kang
 * @email 1468140258@qq.com
 * @date 2021-06-12 08:29:00
 */
@RestController
@RequestMapping("product/pmsattr")
public class PmsAttrController {
    @Autowired
    private PmsAttrService pmsAttrService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("product:pmsattr:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsAttrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    @RequiresPermissions("product:pmsattr:info")
    public R info(@PathVariable("attrId") Long attrId){
		PmsAttrEntity pmsAttr = pmsAttrService.getById(attrId);

        return R.ok().put("pmsAttr", pmsAttr);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("product:pmsattr:save")
    public R save(@RequestBody PmsAttrEntity pmsAttr){
		pmsAttrService.save(pmsAttr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("product:pmsattr:update")
    public R update(@RequestBody PmsAttrEntity pmsAttr){
		pmsAttrService.updateById(pmsAttr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("product:pmsattr:delete")
    public R delete(@RequestBody Long[] attrIds){
		pmsAttrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
