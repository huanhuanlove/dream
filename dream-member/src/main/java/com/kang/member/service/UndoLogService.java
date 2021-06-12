package com.kang.coupon.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kang.common.utils.PageUtils;
import com.kang.coupon.member.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author kang
 * @email 1468140258@qq.com
 * @date 2021-06-12 08:39:47
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

