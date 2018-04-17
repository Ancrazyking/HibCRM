package com.ancrazyking.service.impl;

import com.ancrazyking.bean.Customer;
import com.ancrazyking.dao.CustomerDao;
import com.ancrazyking.dao.impl.CustomerDaoImpl;
import com.ancrazyking.service.CustomerService;
import com.ancrazyking.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @author Ancrazyking
 * @date 2018/4/17 11:23
 **/
public class CustomerServiceImpl implements CustomerService
{
    private CustomerDao customerDao=new CustomerDaoImpl();
    @Override
    public void save(Customer c)
    {
        Session session= HibernateUtils.getCurrentSession();
        Transaction tx=session.beginTransaction();
        try{
            customerDao.save(c);
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();

    }

    @Override
    public List<Customer> queryAll()
    {
       Session session=HibernateUtils.getCurrentSession();

       Transaction tx=session.beginTransaction();
       List<Customer> list=customerDao.queryAll();
       tx.commit();
       return list;
    }

    @Override
    public Customer getById(Long cust_id)
    {
        Session session=HibernateUtils.getCurrentSession();
        Transaction tx=session.beginTransaction();
        Customer c= customerDao.getById(cust_id);
        tx.commit();
        return c;
    }
}
