package com.kang.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kang.common.utils.PageUtils;
import com.kang.product.entity.PmsBrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author kang
 * @email 1468140258@qq.com
 * @date 2021-06-12 08:29:00
 */
public interface PmsBrandService extends IService<PmsBrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

