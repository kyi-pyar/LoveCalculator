package com.springmvc.calculator.Controller;

import java.util.Arrays;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.calculator.Dao.LoveUserDao;
import com.springmvc.calculator.ServiceImpl.EmailService;
import com.springmvc.calculator.api.Love;
import com.springmvc.calculator.api.LoverUser;

@Controller

public class UserController {	
	
	@Autowired
	LoveUserDao loverUserDao;
	
	@Autowired
	EmailService emailService;
	
	@RequestMapping("registered")
	public String registered(@Valid @ModelAttribute("loveUser") LoverUser loveUser,BindingResult result, @SessionAttribute("love") Love love, HttpSession session) {
		//Love love=(Love) session.getAttribute("love");
		if(result.hasErrors()) {
			System.out.println(result);
			return "register";
		}
		loveUser.setLove(love);		
		loverUserDao.save(loveUser);
		loveUser=loverUserDao.get(loveUser.getEmail());
		System.out.println(loveUser);		
		session.setAttribute("loveUser", loveUser);
		return "register_success";
		
	}
	
	@RequestMapping(value="/login_check", method = RequestMethod.POST)
	public String loginCheck(@RequestParam("uname") String name, @RequestParam("pwd") String pwd, HttpSession session) {
		LoverUser user=loverUserDao.loginCheck(name, pwd);
		System.out.println(user);
		if(user!=null) {
			session.setAttribute("loveUser", user);
			return "register_success";
			
		}
		return "";
	}
	
	@RequestMapping(value="/send_mail", params = "try_again")
	public ModelAndView try_again(HttpSession session) {
		System.out.println("you click try_again button");
		return new HomeContoller().home();
	}
	
	@RequestMapping(value="/send_mail", params = "submit")
	public ModelAndView sendMail(HttpSession session) {
		System.out.println("you click submit button from sent mail");
		LoverUser user=(LoverUser) session.getAttribute("loveUser");
		emailService.sendMail(user.getEmail(), "love_calculator", user.toString());
		System.out.println("mail sent.");
		return new HomeContoller().home();
	}

}
