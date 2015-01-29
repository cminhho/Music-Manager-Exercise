package com.tma.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tma.model.Music;
import com.tma.model.User;
import com.tma.service.MusicService;
import com.tma.service.UserService;

@Controller
@RequestMapping(value="/music", produces="application/json")
public class MusicController {
	private static final Logger logger = Logger.getLogger(MusicController.class);
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	MusicService musicService = (MusicService) context.getBean("musicService");
//	MusicService musicService = (MusicService) SpringApplicationContext.getBean("musicService");
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	@ResponseBody public List<Music> getAll(){
		//logs debug message
		if(logger.isDebugEnabled()){
			logger.debug("getAll is executed");
		}
		
		//logs exception
		logger.error("This is Error message", new Exception("Testing"));
		return musicService.getAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}", produces="application/json")
	@ResponseBody public Music getId(@PathVariable String id){
		
		return musicService.getId(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, produces="application/json")
	@ResponseBody public void addMusic(@RequestBody Music music){
		musicService.addMusic(music);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="{id}", produces="application/json")
	@ResponseBody public void updateMusic(@PathVariable String id, @RequestBody Music music){
		musicService.updateMusic(id, music);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="{id}", produces="applicatino/json")
	@ResponseBody public void deleteMusic(@PathVariable String id){
		musicService.deleteMusic(id);
	}
}
	