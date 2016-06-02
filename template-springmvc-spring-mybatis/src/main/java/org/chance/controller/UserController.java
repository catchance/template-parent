package org.chance.controller;

import org.apache.commons.lang.StringUtils;
import org.chance.domain.User;
import org.chance.domain.UserEntity;
import org.chance.service.UserService;
import org.chance.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>User: chance
 * <p>Date: 13-12-13
 * <p>Version: 1.0
 */
@Controller
//@RequestMapping("/")   //表示要访问这个action的时候都要加上这个/路径
public class UserController {

    private static Map<String,String> registMap=new HashMap<String,String>();

    @Autowired
    private UserService userService;

    @RequestMapping(value="/regist",method= RequestMethod.POST)
    public ModelAndView regist(HttpServletRequest request,User user,Model model) {

        String uuid= UUIDUtils.base58Uuid();
        registMap.put(request.getSession().getId(),uuid);
        model.addAttribute("uuid",uuid);
        return new ModelAndView("regist");
    }

    // 获得前台参数的方式：
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public ModelAndView login(String username,@RequestParam(value="password") String password){
        if(this.checkParams(new String[]{username,password})){
            ModelAndView mav=new ModelAndView("success");
            mav.addObject("username",username);
            mav.addObject("password",password);
            return mav;
        }
        return new ModelAndView("login");
    }

    /**
     * RESTful 风格 配置
     * @param id
     * @return
     */

    @RequestMapping(value = "/user/{id}",method =RequestMethod.GET)
    public String get(@PathVariable("id") String id){
        System.out.println("get"+id);
        return "success";
    }

    @RequestMapping(value="/user/{id}",method=RequestMethod.POST)
    public String post(@PathVariable("id") String id){
        System.out.println("post"+id);
        return "success";
    }

    @RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
    public String put(HttpServletRequest request,@PathVariable("id") String id,String user,String passwd){
        if(registMap.get(request.getSession().getId()).equals(id)){
            System.out.println("put"+id);
            /*向用户表中插入数据*/
            UserEntity userEntity=new UserEntity();
            userEntity.setName(user);
            userEntity.setPassword(passwd);
            userService.addUser(userEntity);
            return "success";
        }else{
            System.out.println("session Id 不正确");
            return "index";
        }

    }

    @RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") String id){
        System.out.println("delete"+id);
        return "success";
    }

    /**
     * 验证参数是否为null
     * @param params
     * @return
     */
    private boolean checkParams(String[] params){
        for(String param:params){
            if(StringUtils.isBlank(param)){
                return false;
            }
        }
        return true;
    }
}
