/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

/**
 *
 * @author sanke
 */
public class Book {
    private int id;
    private String title;
    private double Price;

    public Book() {
    }

    public Book(int id,String title, double Price) {
       this.id=id;
        this.title = title;
        this.Price = Price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", Price=" + Price + '}';
    }
    
}
