package com.dragon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest requst, HttpServletResponse response)
	{
		//System.out.println("Adding");
		int i = Integer.parseInt(requst.getParameter("a1"));
		int j = Integer.parseInt(requst.getParameter("a2"));
		int k = i + j;
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		mv.addObject("result", k);
		return mv;
	}
}
