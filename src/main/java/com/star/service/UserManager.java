package com.star.service;

import com.star.model.User;
import com.star.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by hp on 2016/10/2.
 */
public class UserManager {

    public boolean exists(User u) throws Exception{
        HibernateUtil hu = new HibernateUtil();
       SessionFactory sf = hu.getSessionFactory();
        Session s = sf.getCurrentSession();
        s.beginTransaction();
        String sql = "select count(*) from User u where u.name= :name";
        long count=(Long)s.createQuery(sql).setString("name",u.getName()).uniqueResult();
        if(count>0){
            return true;
        }
        s.getTransaction().commit();
        return false;
    }

    public void add(User u) throws Exception {
        HibernateUtil hu = new HibernateUtil();
        SessionFactory sf = hu.getSessionFactory();
        Session s = sf.getCurrentSession();
        s.beginTransaction();
        s.save(u);
        s.getTransaction().commit();
    }

}
