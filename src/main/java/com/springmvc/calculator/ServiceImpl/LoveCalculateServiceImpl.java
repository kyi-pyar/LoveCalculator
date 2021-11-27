package com.springmvc.calculator.ServiceImpl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.springmvc.calculator.Service.LoveCalculateService;

@Service
public class LoveCalculateServiceImpl implements LoveCalculateService{
	

	@Override
	public String calcuateResult() {
		Random  r=new Random();		
		return results[r.nextInt(results.length)];
	}

}
