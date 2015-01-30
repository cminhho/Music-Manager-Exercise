package com.tma.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tma.model.User;
import com.tma.service.SongService;
import com.tma.service.UserService;

@Controller
@RequestMapping(value="/user", produces="application/json")
public class UserController {
	
		private static final Logger logger = Logger.getLogger(UserController.class);
	
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) context.getBean("userService");
		
//		@Autowired
//		UserService userService;
		
		@RequestMapping(method=RequestMethod.GET, produces="application/json")
		@ResponseBody public List<User> getAll(){
			
			//logs debug message
			if(logger.isDebugEnabled()){
				logger.debug("getAll is executed");
			}
			
			//logs exception
			logger.error("This is Error message", new Exception("Testing"));
			
			return userService.getAll();
		}
		
		@RequestMapping(method=RequestMethod.GET, value="/{id}",produces="application/json")
		@ResponseBody public User getWithId(@PathVariable String id){
			//logs debug message
			if(logger.isDebugEnabled()){
				logger.debug("getAll is executed");
			}
			
			//logs exception
			logger.error("This is Error message", new Exception("Testing"));
			return userService.getWithId(id);
		}
		
		@RequestMapping(method=RequestMethod.POST, produces="application/json")
		@ResponseBody public void addUser(@RequestBody User user){
			System.out.println("add User" + user);
			userService.addUser(user);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/{id}", produces="application/json")
		@ResponseBody public void delete(@PathVariable String id){
			userService.delete(id);
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/{id}",  produces="application/json")
		@ResponseBody public void update(@PathVariable String id, @RequestBody User user){
			userService.update(id, user);
		}
}
