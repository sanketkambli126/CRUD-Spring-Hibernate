/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intel;

import com.bean.Book;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sanke
 */
public class Inmemoryimpl implements IDAO{
static List<Book> b1=new ArrayList<>();
 static
{
   b1.add(new Book(1, "c programming", 340));
   b1.add(new Book(2, "java fundamentals", 200));
}

    @Override
    public List<Book> select_all() {
        
      return b1;
        
    }

    @Override
    public void insert(Book b) {
        b.setId(getNextid());
        b1.add(b);
        
    }

    @Override
    public void delete(int id) {
        if(id>0)
        {
            b1.remove(id-1);
        }
        
    }

    @Override
    public void update(Book b) {
        for(Book book:b1)
        {
            if(book.getId()==b.getId())
            {
            b1.set(b.getId()-1, b);
            }
        }
    }

    @Override
    public Book read(int id) {
        return b1.get(id-1);
    }

    static int getNextid() {
       int max=0;
       for(Book b:b1)
       {
           if(b.getId()>max)
           {
           max=b.getId();}
       }
       return ++max;
    }
    
}
