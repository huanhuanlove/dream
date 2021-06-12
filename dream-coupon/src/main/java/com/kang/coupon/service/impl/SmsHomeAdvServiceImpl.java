package com.kang.coupon.coupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kang.common.utils.PageUtils;
import com.kang.common.utils.Query;

import com.kang.coupon.coupon.dao.SmsHomeAdvDao;
import com.kang.coupon.coupon.entity.SmsHomeAdvEntity;
import com.kang.coupon.coupon.service.SmsHomeAdvService;


@Service("smsHomeAdvService")
public class SmsHomeAdvServiceImpl extends ServiceImpl<SmsHomeAdvDao, SmsHomeAdvEntity> implements SmsHomeAdvService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsHomeAdvEntity> page = this.page(
                new Query<SmsHomeAdvEntity>().getPage(params),
                new QueryWrapper<SmsHomeAdvEntity>()
        );

        return new PageUtils(page);
    }

}