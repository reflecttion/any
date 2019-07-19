package com.see.any.service;

import com.see.any.dao.mapper.HelloMapper;
import com.see.any.dao.pojo.Hello;
import com.see.any.dao.pojo.HelloExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HelloService {

    public boolean insert(Hello model);

    public Hello select(int id);

    public List<Hello> selectAll();

    public boolean updateValue(Hello model);

    public boolean delete(Integer id);
}
