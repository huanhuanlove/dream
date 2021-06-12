package com.kang.coupon.coupon.dao;

import com.kang.coupon.coupon.entity.SmsCouponHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 * 
 * @author kang
 * @email 1468140258@qq.com
 * @date 2021-06-12 08:37:26
 */
@Mapper
public interface SmsCouponHistoryDao extends BaseMapper<SmsCouponHistoryEntity> {
	
}
