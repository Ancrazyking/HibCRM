package com.ancrazyking.dao;

import com.ancrazyking.bean.Customer;

import java.util.List;

/**
 * @author Ancrazyking
 * @date 2018/4/17 11:21
 **/
public interface CustomerDao
{
    //保存客户
    void save(Customer c);
    //查询所有客户
    List<Customer> queryAll();
    //根据id获得客户
    Customer getById(Long cust_id);
}
