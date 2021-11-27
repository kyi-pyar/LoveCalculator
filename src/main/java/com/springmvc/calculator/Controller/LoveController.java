package com.springmvc.calculator.Controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.calculator.Service.LoveCalculateService;
import com.springmvc.calculator.api.Love;

@Controller
@SessionAttributes("love")
public class LoveController {	
	@Autowired
	LoveCalculateService lovecalculate;
	
	@RequestMapping("/calculate")
	public ModelAndView loveCalculate(@Valid @ModelAttribute("love") Love love, BindingResult result) {
		ModelAndView mv=new ModelAndView();
		if(result.hasErrors()) {
			for(ObjectError error:result.getAllErrors())
			System.out.print(error);
			mv.setViewName("love_home");
		}
		else {
		love.setResult(lovecalculate.calcuateResult());		
		mv.setViewName("love_result");
		mv.addObject("love", love);
		}
		return mv;
		
	}

}
