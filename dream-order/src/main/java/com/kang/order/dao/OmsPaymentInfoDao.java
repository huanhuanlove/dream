package com.kang.order.${moduleName}.dao;

import com.kang.order.${moduleName}.entity.OmsPaymentInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 * 
 * @author kang
 * @email 1468140258@qq.com
 * @date 2021-06-12 08:34:34
 */
@Mapper
public interface OmsPaymentInfoDao extends BaseMapper<OmsPaymentInfoEntity> {
	
}
