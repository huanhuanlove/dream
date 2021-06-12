package com.kang.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kang.common.utils.PageUtils;
import com.kang.product.entity.PmsSpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author kang
 * @email 1468140258@qq.com
 * @date 2021-06-12 08:29:00
 */
public interface PmsSpuInfoDescService extends IService<PmsSpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

