package com.ipl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.ipl.dao.UserDao;
import com.ipl.model.Mail;
import com.ipl.model.User;
import com.ipl.service.UserService;


@Controller
public class SignupController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private Mail mail;
	
	@RequestMapping(value="/signupPage", method=RequestMethod.GET)
	public String signup(Model model) {
	      User user = new User();  
	      return "signup";
	  }
	@RequestMapping(value="/saveUser", method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, BindingResult result)
			{       
	          userService.addUser(user);
	          String source = "pravmt9@gmail.com";
	          String dest=user.getEmail();
	          String msg="please verify ur email by clicking this link http://localhost:8080/IPL2016/loginPage";
	          mail.sendMail(source, dest, msg);
	          return "login";
	      }
	  }