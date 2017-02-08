package com.ggktech.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ggktech.dao.AuthenticationDao;
import com.ggktech.dao.SignUpDao;
import com.ggktech.model.SignUpModel;

@Controller
public class CommonService {

	@Autowired
	private AuthenticationDao authenticationDao;
	@Autowired
	private SignUpDao signUpDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
		System.out.println("aa");
		//return new String("LoginPage");
		return new String("ProductFeatureOption");
	}

	@RequestMapping(value = "/log", method = RequestMethod.POST)
	public String log(@RequestParam("email") String email,
			@RequestParam("password") String password, HttpSession session) {
		
		if (authenticationDao.login(email, password)) {
			session.setAttribute("email", email);

			int roleId = authenticationDao.roleId(email, password);
			int userId = authenticationDao.userId(email, password);
			session.setAttribute("userIdSession", userId);

			if (roleId == 1) {
				session.setAttribute("loogedIn", "loogedIn");
				return "Admin";
			} else if (roleId == 2) {
				session.setAttribute("loogedIn", "loogedIn");
				return "Seller";
			} else if (roleId == 3) {
				session.setAttribute("loogedIn", "loogedIn");
				return "CustomerPayment";
			} else {
				System.out.println("Try Again");
				return "LoginPage";
			}

		}
		System.out.println("Not User");
		return "LoginPage";
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUpppp() {
		System.out.println("ssss");
		//return new String("LoginPage");
		return new String("SignUp");
	}
	
	@RequestMapping(value="/signUpService", method=RequestMethod.POST)
	@ResponseBody
	public String signUp(@ModelAttribute SignUpModel signUpModel, Model model){
		Integer userRole=3;
		System.out.println(signUpModel.getEmail());
		signUpDao.signUp(signUpModel,userRole);
		return "Complited";
	}
	 @RequestMapping(value = "logOut")
	  public String logout(HttpSession session) {
	  if (session.getAttribute("userIdSession") != null) {
		  System.out.println("logout");
		  session.invalidate();
		  return
	  "ProductFeatureOption";
		  } 
	  else { 
		  return "xyz"; 
		  } 
	  }


}
