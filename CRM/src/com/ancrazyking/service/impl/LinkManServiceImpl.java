package com.ancrazyking.service.impl;

import com.ancrazyking.bean.Customer;
import com.ancrazyking.bean.LinkMan;
import com.ancrazyking.dao.CustomerDao;
import com.ancrazyking.dao.LinkManDao;
import com.ancrazyking.dao.impl.CustomerDaoImpl;
import com.ancrazyking.dao.impl.LinkManDaoImpl;
import com.ancrazyking.service.LinkManService;
import com.ancrazyking.utils.HibernateUtils;

/**
 * @author Ancrazyking
 * @date 2018/4/17 11:23
 **/
public class LinkManServiceImpl implements LinkManService
{
    private CustomerDao cd=new CustomerDaoImpl();
    private LinkManDao lmd=new LinkManDaoImpl();
    @Override
    public void save(LinkMan lm)
    {
        HibernateUtils.getCurrentSession().beginTransaction();
        try{
            //根据客户id获得客户对象
            Long cust_id=lm.getCust_id();
            Customer c=cd.getById(cust_id);
            lm.setCustomer(c);
            lmd.save(lm);
        }catch (Exception e){
            e.printStackTrace();//异常则回滚事务
            HibernateUtils.getCurrentSession().getTransaction().rollback();
        }
        HibernateUtils.getCurrentSession().getTransaction().commit();
    }
}
