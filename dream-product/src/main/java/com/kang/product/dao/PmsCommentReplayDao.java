package com.kang.product.dao;

import com.kang.product.entity.PmsCommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 * 
 * @author kang
 * @email 1468140258@qq.com
 * @date 2021-06-12 08:29:00
 */
@Mapper
public interface PmsCommentReplayDao extends BaseMapper<PmsCommentReplayEntity> {
	
}
