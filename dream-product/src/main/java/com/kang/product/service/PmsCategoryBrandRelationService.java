package com.kang.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kang.common.utils.PageUtils;
import com.kang.product.entity.PmsCategoryBrandRelationEntity;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author kang
 * @email 1468140258@qq.com
 * @date 2021-06-12 08:29:00
 */
public interface PmsCategoryBrandRelationService extends IService<PmsCategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

