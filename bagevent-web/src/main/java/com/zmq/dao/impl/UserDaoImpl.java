package com.zmq.dao.impl;

import com.zmq.dao.UserDao;
import com.zmq.pojo.Ccc;
import com.zmq.pojo.User;
import com.zmq.utils.MD5Util;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sun.security.provider.MD5;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    /***
     * 登录
     * @param user
     * @return
     */
    public User login(User user) {
        SQLQuery sqlQuery = getCurrentSession().createSQLQuery("select *From user where cellphone=?");
        sqlQuery.setParameter(0, user.getCellphone());
        sqlQuery.addEntity(User.class);
        User user1 = (User) sqlQuery.uniqueResult();
        //比较密码
        if (user1 != null) {

            String salt = user1.getSalt();
            String password = user.getPassword();
            String password2 = MD5Util.getStringMD5(password + salt);
            if (user1.getPassword().equals(password2)) {
                return user1;
            }
        }

        return null;
    }

    /***
     * 注册
     * @param user
     * @return
     */
    public int saveRegister(User user) {
        //设置注册时间
        user.setCreateTime(new Date());
        //设置盐
        String salt = UUID.randomUUID().toString();
        user.setSalt(salt);
        //加密密码
        String password = MD5Util.getStringMD5(user.getPassword() + salt);
        //设置密码
        user.setPassword(password);
        int i = (Integer) getCurrentSession().save(user);
        return i;
    }

    public List<User> findUsers() {
        Query query = getCurrentSession().createQuery("from User");
        List<User> list = query.list();
        return list;
    }

    public int saveUser(User entity) {
        int id = (Integer) getCurrentSession().save(entity);
        return id;
    }

    public List<Ccc> findCcc() {
        Query query = getCurrentSession().createQuery("from Ccc");
        List<Ccc> list = query.list();
        return list;
    }
}
