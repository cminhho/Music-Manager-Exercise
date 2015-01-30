package com.tma.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tma.service.SongService;
import com.tma.service.UserService;
import com.tma.model.Song;
import com.tma.model.User;

@Controller
@RequestMapping(value="/song", produces="application/json")
public class SongController {
	private static final Logger logger = Logger.getLogger(SongController.class);
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	SongService songService = (SongService) context.getBean("songService");
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody public Page<Song> getQueryPagging(@RequestBody String start, @RequestBody String max, @RequestBody String direction, @RequestBody String properties){
		return songService.getAllPagging(new PageRequest(Integer.parseInt("0"), Integer.parseInt("5"), Direction.ASC, "name"));
	}

	@RequestMapping(value="/all", method=RequestMethod.GET)
	@ResponseBody public List<Song> getAll(){
		return songService.getAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody public Song getWithId(@PathVariable String id){
		return songService.findOne(id);
	}

	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody public void addSong(@RequestBody Song song){
		songService.save(song);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseBody public void updateSong(@PathVariable String id, @RequestBody Song song){
		songService.updateSong(id, song);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseBody public void deleteSong(@PathVariable String id){
		songService.delete(id);
	}
}
