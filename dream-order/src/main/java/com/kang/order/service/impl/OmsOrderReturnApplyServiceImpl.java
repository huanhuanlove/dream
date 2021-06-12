package com.kang.order.${moduleName}.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kang.common.utils.PageUtils;
import com.kang.common.utils.Query;

import com.kang.order.${moduleName}.dao.OmsOrderReturnApplyDao;
import com.kang.order.${moduleName}.entity.OmsOrderReturnApplyEntity;
import com.kang.order.${moduleName}.service.OmsOrderReturnApplyService;


@Service("omsOrderReturnApplyService")
public class OmsOrderReturnApplyServiceImpl extends ServiceImpl<OmsOrderReturnApplyDao, OmsOrderReturnApplyEntity> implements OmsOrderReturnApplyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OmsOrderReturnApplyEntity> page = this.page(
                new Query<OmsOrderReturnApplyEntity>().getPage(params),
                new QueryWrapper<OmsOrderReturnApplyEntity>()
        );

        return new PageUtils(page);
    }

}