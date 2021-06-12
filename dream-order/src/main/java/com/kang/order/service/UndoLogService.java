package com.kang.order.${moduleName}.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kang.common.utils.PageUtils;
import com.kang.order.${moduleName}.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author kang
 * @email 1468140258@qq.com
 * @date 2021-06-12 08:34:34
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

