package com.im.status.service.impl;

import com.im.status.mapper.ServiceMapper;
import com.im.status.model.TService;
import com.im.status.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhizhuang.yang on 2017/8/15.
 */
@Service("serviceService")
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceMapper serviceMapper;

    public List<TService> getService() {
        return serviceMapper.select();
    }
}
