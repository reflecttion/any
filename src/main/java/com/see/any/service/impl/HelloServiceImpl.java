package com.see.any.service.impl;

import com.see.any.dao.mapper.HelloMapper;
import com.see.any.dao.pojo.Hello;
import com.see.any.dao.pojo.HelloExample;
import com.see.any.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private  HelloMapper helloMapper;

    public boolean insert(Hello model) {
        return helloMapper.insert(model) > 0;
    }

    public Hello select(int id) {
        return helloMapper.selectByPrimaryKey(id);
    }

    public List<Hello> selectAll() {
        return helloMapper.selectByExample(new HelloExample());
    }

    public boolean updateValue(Hello model) {
        return helloMapper.updateByPrimaryKeySelective(model) > 0;
    }

    public boolean delete(Integer id) {
        return helloMapper.deleteByPrimaryKey(id) > 0;
    }
}
