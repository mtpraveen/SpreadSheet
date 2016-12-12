package com.ipl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ipl.dao.UserDao;
import com.ipl.model.User;
import com.ipl.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/indexPage")
	 public String index() {
	        /*model.addAttribute("msg", "Please Enter Your Login Details");*/
	        return "index";
	    }
	
	 @RequestMapping(value="/loginPage",method=RequestMethod.GET)
	 public String init() {
	        /*model.addAttribute("msg", "Please Enter Your Login Details");*/
	        return "login";
	    }
	 @RequestMapping(value="/login", method=RequestMethod.POST)
	  public String login(@Valid @RequestParam("Email") String email,@RequestParam("Password") String password,Model model,HttpServletRequest request) {
		 User user = userService.authUser(email, password);
		 // authenticate session
		 
		 if (user == null) 
		 {
	          return "login";
	     }
		 else 
		 {
	        
			 	HttpSession sess=request.getSession();
			 	sess.invalidate();
			 	
			 	sess=request.getSession();
			 	sess.setAttribute("user", user);
	        return "teamdetails";
	        
	     }

	  }
	 @RequestMapping(value="/logout", method=RequestMethod.GET)
	 public String logout() {
	        /*model.addAttribute("msg", "Please Enter Your Login Details");*/
	        return "login";
	    }
}
