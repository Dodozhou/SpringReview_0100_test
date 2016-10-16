package com.star.service;

import com.star.model.User;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by hp on 2016/10/2.
 */
public class UserManagerTest {
    @Test
    public void exists() throws Exception {
        UserManager um = new UserManager();
        User u = new User();
        u.setName("jack");
        Assert.assertEquals(true,um.exists(u));
    }

    @Test
    public void add() throws Exception {
        UserManager um = new UserManager();
        User u = new User();
        u.setName("susy");
        u.setPassword("susy");
        if (!um.exists(u)){
            um.add(u);
            Assert.assertEquals(true,um.exists(u));
        }

    }

}