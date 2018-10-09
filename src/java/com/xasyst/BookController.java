
package com.xasyst;

import com.bean.Book;
import com.intel.IDAO;
import com.intel.Inmemoryimpl;
import com.intel.hibernateimpl;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/a")
public class BookController {
    @RequestMapping("/b")
    public ModelAndView p()
    {
        IDAO i=new hibernateimpl();
        ArrayList<Book> b=(ArrayList<Book>)i.select_all();
        
    return new ModelAndView("index","name",b);
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id)
    {
        IDAO i1=new hibernateimpl();
        i1.delete(id);
       return new ModelAndView("redirect:/a/b");
    }
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public ModelAndView update_page(@PathVariable int id)
    {
       IDAO i1=new hibernateimpl();
       Book b=i1.read(id);
    return new ModelAndView("update","command",b);}
    
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public ModelAndView update_book(@ModelAttribute("book")Book book)
    { IDAO i1=new hibernateimpl();
    i1.update(book);
       
    return new ModelAndView("redirect:/a/b");}
    
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView ADD_page()
    {
    return new ModelAndView("update","command",new Book());}
    
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView ADD(@ModelAttribute("book")Book book)
    {
        IDAO i1=new hibernateimpl();
    i1.insert(book);
    return new ModelAndView("redirect:/a/b");
    }
    }

