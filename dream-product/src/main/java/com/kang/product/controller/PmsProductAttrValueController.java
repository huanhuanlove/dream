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

import com.kang.product.entity.PmsProductAttrValueEntity;
import com.kang.product.service.PmsProductAttrValueService;
import com.kang.common.utils.PageUtils;
import com.kang.common.utils.R;



/**
 * spu属性值
 *
 * @author kang
 * @email 1468140258@qq.com
 * @date 2021-06-12 08:29:00
 */
@RestController
@RequestMapping("product/pmsproductattrvalue")
public class PmsProductAttrValueController {
    @Autowired
    private PmsProductAttrValueService pmsProductAttrValueService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("product:pmsproductattrvalue:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmsProductAttrValueService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("product:pmsproductattrvalue:info")
    public R info(@PathVariable("id") Long id){
		PmsProductAttrValueEntity pmsProductAttrValue = pmsProductAttrValueService.getById(id);

        return R.ok().put("pmsProductAttrValue", pmsProductAttrValue);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("product:pmsproductattrvalue:save")
    public R save(@RequestBody PmsProductAttrValueEntity pmsProductAttrValue){
		pmsProductAttrValueService.save(pmsProductAttrValue);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("product:pmsproductattrvalue:update")
    public R update(@RequestBody PmsProductAttrValueEntity pmsProductAttrValue){
		pmsProductAttrValueService.updateById(pmsProductAttrValue);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("product:pmsproductattrvalue:delete")
    public R delete(@RequestBody Long[] ids){
		pmsProductAttrValueService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
