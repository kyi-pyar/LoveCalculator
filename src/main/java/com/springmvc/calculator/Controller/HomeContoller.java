package com.springmvc.calculator.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.calculator.api.Love;
import com.springmvc.calculator.api.LoverUser;

@Controller
@SessionAttributes("love")
public class HomeContoller {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home() {	
		ModelAndView mv=new ModelAndView();
		mv.setViewName("love_home");
		mv.addObject("love", new Love());		
		return mv;
	}
	
	@RequestMapping("/login")
	public String login_page(){
		return "login";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView register() {		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("register");
		mv.addObject("loveUser", new LoverUser());
		return mv;
	}

}
