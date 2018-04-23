/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

import com.util.NewHibernateUtil;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author l2pc214e
 */
public class StudentDAO{
    public boolean doInsert(Student stu){
        Session s=NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Serializable seri=s.save(stu);
        s.getTransaction().commit();
        s.close();
        if(seri!=null){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean loginA(String username,String password)throws SQLException{
        Session s=NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q=s.createQuery("from Student where username=:a and password=:b");
        q.setString("a", username);
        q.setString("b", password);
        List list=q.list();
        if(list.size()==1){
            return true;
        }else{
            return false;
        }
    }
}
