package com.star.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by hp on 2016/10/2.
 */
public class HibernateUtil {
    private static SessionFactory sf;
    static {
        sf = new Configuration().configure().buildSessionFactory();
    }

    public SessionFactory getSessionFactory(){
        return sf;
    }
}
