/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intel;

import com.bean.Book;
import java.util.List;

/**
 *
 * @author sanke
 */
public interface IDAO {
    List<Book> select_all();
    void insert(Book b);
    void delete(int id);
    void update(Book b);
    Book read(int id);
}
