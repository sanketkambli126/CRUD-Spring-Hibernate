/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intel;

import com.bean.Book;
import com.bean.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sanke
 */
public class hibernateimpl implements IDAO{
    Session sc;
    @Override
    public List<Book> select_all() {
        sc=NewHibernateUtil.getSessionFactory().openSession();
        Criteria c=sc.createCriteria(Book.class);
        ArrayList<Book> b=(ArrayList<Book>) c.list();
        sc.flush();
        sc.close();
        return b;
    }

    @Override
    public void insert(Book b) {
       sc=NewHibernateUtil.getSessionFactory().openSession();
       sc.save(b);
       sc.beginTransaction().commit();
       sc.flush();
       sc.close();
       
    }

    @Override
    public void delete(int id) {
    sc=NewHibernateUtil.getSessionFactory().openSession();
        Query q=sc.createQuery("delete from Book WHERE id=:id");
        q.setParameter("id", id);
        q.executeUpdate();
        sc.beginTransaction().commit();
        sc.flush();
        sc.close();
    }

    @Override
    public void update(Book b) {
        sc=NewHibernateUtil.getSessionFactory().openSession();
        Query q=sc.createQuery("update Book set title=:title,price=:price WHERE id=:id");
        q.setParameter("id", b.getId());
        q.setParameter("title", b.getTitle());
        q.setParameter("price", b.getPrice());
        q.executeUpdate();
        sc.beginTransaction().commit();
        sc.flush();
        sc.close();
    }

    @Override
    public Book read(int id) {
        sc=NewHibernateUtil.getSessionFactory().openSession();
        Criteria c=sc.createCriteria(Book.class);
        Criterion ct=Restrictions.eq("id", id);
        c.add(ct);
        return (Book)c.uniqueResult();
    }
    
}
