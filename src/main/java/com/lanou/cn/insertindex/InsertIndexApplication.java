package com.lanou.cn.insertindex;

import com.lanou.cn.Entity.person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@Controller
@RequestMapping("/")
public class InsertIndexApplication {
	List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
	public static void main(String[] args) {
		SpringApplication.run(InsertIndexApplication.class, args);
	}

//	@ResponseBody
//	public ModelAndView insert(){
//		ModelAndView modelAndView=new ModelAndView();
//
//		return
//	}
	@RequestMapping("/")
	public String registe(){
		return "index";
	}

	@RequestMapping("hello")
	public String insert(String name,String pwd){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("username",name);
		map.put("password",pwd);
		list.add(map);
		return "success";
	}
	@RequestMapping("helloworld")
	public ModelAndView index(String username,String pwd){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("registe");
		if(username!=null){
			modelAndView.addObject("lp",list);
		}else{
			modelAndView.addObject("username",username);
			modelAndView.addObject("password",pwd);
		}
		return modelAndView;

	}

}
