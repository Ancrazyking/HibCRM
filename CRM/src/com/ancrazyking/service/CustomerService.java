package com.ancrazyking.service;

import com.ancrazyking.bean.Customer;

import java.util.List;

/**
 * @author Ancrazyking
 * @date 2018/4/17 11:22
 **/
public interface CustomerService
{
    //保存客户
    void save(Customer c);
    //获得所有客户
    List<Customer> queryAll();
    //通过id获取客户
    Customer getById(Long cust_id);

}
