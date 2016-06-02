package org.chance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by wqg on 2015/12/30.
 */
@Controller
//@RequestMapping(value = "/hello")//表示要访问这个action的时候都要加上这个/hello路径
public class HelloController {
/* 接收参数getParameter()的时候:
 * 如果地址栏/springmvc/hello.htm上面没有传递参数,那么当id为int型的时候会报错,当id为Integer的时候值为null
 * 当地址栏为/springmvc/hello.htm?id=10的时候,action中有三种接收方式
 * 1、String hello(@RequestParam(value = "userid") int id),这样会把地址栏参数名为userid的值赋给参数id,如果用地址栏上的参数名为id,则接收不到
 * 2、String hello(@RequestParam int id),这种情况下默认会把id作为参数名来进行接收赋值
 * 3、String hello(int id),这种情况下也会默认把id作为参数名来进行接收赋值
 * 注:如果参数前面加上@RequestParam注解,如果地址栏上面没有加上该注解的参数,例如:id,那么会报404错误,找不到该路径
 */
@RequestMapping(value = "/hello.html")
public String hello(Integer id){//getParameter()的方式
    System.out.println("hello action:"+id);
//      return "hello";
    return "redirect:/index.jsp";//不能重定向web-info里面的文件,而且需要写上绝对路径
}

    //返回页面参数的第一种方式,在形参中放入一个map
    @RequestMapping(value = "/hello1.html")
    public String hello(Integer id,Map<String,Object> map){
        System.out.println("hello1 action:"+id);
        map.put("name", "huangjie");
        return "hello";
    }

    //返回页面参数的第二种方式,在形参中放入一个Model
    @RequestMapping(value = "/hello2.html")
    public String hello2(Integer id,Model model){
        System.out.println("hello2 action:"+id);
        model.addAttribute("name", "huangjie");
        //这个只有值没有键的情况下,使用Object的类型作为key,String-->string
        model.addAttribute("ok");
        return "hello";
    }

    //得到request,response,session等,只要在方法形参中声明参数即可
    @RequestMapping(value = "/hello3.html")
    public String hello3(HttpServletRequest request){

        Integer userId= ServletRequestUtils.getIntParameter(request,"id",-1);

        String id = request.getParameter("id");
        System.out.println("userId:"+userId);
        System.out.println("hello3 action:"+id);
        return "hello";
    }

}
