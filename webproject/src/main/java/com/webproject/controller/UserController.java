package com.webproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.webproject.domain.User;
import com.webproject.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/user")
public class UserController{

    private static final Logger logger=LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserService servie;
    @GetMapping("/signup")
    public void getSignup()throws Exception {
        logger.info("get signup!");

    }
    
    @PostMapping("/signup")
    public String postSignup(User user,RedirectAttributes rttr)throws Exception {
        logger.info("get signup!");

        servie.signup(user);
        
        rttr.addFlashAttribute("msg","SUCCESS");
        return "redirect:/";
    }
    
    @GetMapping("/signin")
     public void getSignin()throws Exception{
         logger.info("get signin");
     }

     @PostMapping("/signin")
     public String postSignin(User user,HttpServletRequest req,RedirectAttributes rttr)throws Exception{
         logger.info("post signin");
         
         User login=servie.signin(user);
         HttpSession session=req.getSession();
        
         if(login !=null&& user.getUserPass().compareTo(login.getUserPass())==0){
             session.setAttribute("user", login);
         }else{
             session.setAttribute("user", null);
             rttr.addFlashAttribute("msg",false);
             return "redirect:/user/signin";
         }
         return "redirect:/";
     }

     @GetMapping("/logout")
     public String getSignOut(HttpSession session)throws Exception{
         logger.info("sign out!");

         servie.signout(session);

         return "redirect:/";

     }



}