package com.ancrazyking.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Ancrazyking
 * @date 2018/4/17 11:23
 **/
public class HibernateUtils
{
    private static SessionFactory sf;
    static {
        Configuration conf=new Configuration().configure();
        sf=conf.buildSessionFactory();

    }

    public static Session openSession(){
        Session session=sf.openSession();
        return session;
    }

    public static Session getCurrentSession(){
        Session session=sf.getCurrentSession();
        return session;
    }

    public static void main(String[] args){
        System.out.println(HibernateUtils.openSession());
    }

}
