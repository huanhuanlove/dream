package com.kang.order.${moduleName}.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kang.common.utils.PageUtils;
import com.kang.common.utils.Query;

import com.kang.order.${moduleName}.dao.OmsPaymentInfoDao;
import com.kang.order.${moduleName}.entity.OmsPaymentInfoEntity;
import com.kang.order.${moduleName}.service.OmsPaymentInfoService;


@Service("omsPaymentInfoService")
public class OmsPaymentInfoServiceImpl extends ServiceImpl<OmsPaymentInfoDao, OmsPaymentInfoEntity> implements OmsPaymentInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OmsPaymentInfoEntity> page = this.page(
                new Query<OmsPaymentInfoEntity>().getPage(params),
                new QueryWrapper<OmsPaymentInfoEntity>()
        );

        return new PageUtils(page);
    }

}