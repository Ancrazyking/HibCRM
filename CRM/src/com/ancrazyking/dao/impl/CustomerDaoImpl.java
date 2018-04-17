package com.ancrazyking.dao.impl;

import com.ancrazyking.bean.Customer;
import com.ancrazyking.dao.CustomerDao;
import com.ancrazyking.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

/**
 * @author Ancrazyking
 * @date 2018/4/17 11:21
 **/
public class CustomerDaoImpl implements CustomerDao
{
    @Override
    public void save(Customer c)
    {
        Session session= HibernateUtils.getCurrentSession();
        session.save(c);
    }

    /**
     * Criteria查询,单表查询方便
     * @return
     */
    @Override
    public List<Customer> queryAll()
    {
        Session session=HibernateUtils.getCurrentSession();
        Criteria c=session.createCriteria(Customer.class);
        return c.list();
    }


    @Override
    public Customer getById(Long cust_id)
    {
        Session session=HibernateUtils.getCurrentSession();
        return session.get(Customer.class,cust_id);
    }
}
