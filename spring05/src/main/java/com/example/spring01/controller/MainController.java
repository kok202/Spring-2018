package com.example.spring01.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.dto.ProductDTO;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("message", " 홈페이지 방문을 환영합니다.");
		return "main";
	}
	
	@RequestMapping(value="/gugu.do", method=RequestMethod.GET)
	public String gugu(@RequestParam int dan, Model model) {
		String result="";
		for(int i =1; i<=9; i++) {
			result += dan + " * " + i + " = " + dan * i + "<br>";
		}
		model.addAttribute("result", result);
		return "test/gugu";
	}
	
	@RequestMapping(value="/test.do")
	public void test(Model model) {
	}
	
	@RequestMapping(value="/test/doA")
	public String doA(Model model) {
		logger.info("dpA called...");
		model.addAttribute("message", "do A");
		return "test/doB";
	}
	
	@RequestMapping(value="/test/doB")
	public void doB(Model model) {
		logger.info("dpB called...");
	}
	
	@RequestMapping(value="/test/doC")
	public ModelAndView doC() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product", new ProductDTO("샤프", 1000));
		return new ModelAndView("test/doC", "map", map);
	}
	
	@RequestMapping(value="/test/doD")
	public String doD(Model model) {
		return "redirect:/test/doE";
	}
	
	@RequestMapping(value="/test/doE")
	public void doE(Model model) {
		logger.info("dpE called...");
	}
}
