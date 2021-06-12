package com.kang.order.${moduleName}.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kang.order.${moduleName}.entity.OmsOrderOperateHistoryEntity;
import com.kang.order.${moduleName}.service.OmsOrderOperateHistoryService;
import com.kang.common.utils.PageUtils;
import com.kang.common.utils.R;



/**
 * 订单操作历史记录
 *
 * @author kang
 * @email 1468140258@qq.com
 * @date 2021-06-12 08:34:34
 */
@RestController
@RequestMapping("${moduleName}/omsorderoperatehistory")
public class OmsOrderOperateHistoryController {
    @Autowired
    private OmsOrderOperateHistoryService omsOrderOperateHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("${moduleName}:omsorderoperatehistory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = omsOrderOperateHistoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("${moduleName}:omsorderoperatehistory:info")
    public R info(@PathVariable("id") Long id){
		OmsOrderOperateHistoryEntity omsOrderOperateHistory = omsOrderOperateHistoryService.getById(id);

        return R.ok().put("omsOrderOperateHistory", omsOrderOperateHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("${moduleName}:omsorderoperatehistory:save")
    public R save(@RequestBody OmsOrderOperateHistoryEntity omsOrderOperateHistory){
		omsOrderOperateHistoryService.save(omsOrderOperateHistory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("${moduleName}:omsorderoperatehistory:update")
    public R update(@RequestBody OmsOrderOperateHistoryEntity omsOrderOperateHistory){
		omsOrderOperateHistoryService.updateById(omsOrderOperateHistory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("${moduleName}:omsorderoperatehistory:delete")
    public R delete(@RequestBody Long[] ids){
		omsOrderOperateHistoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
