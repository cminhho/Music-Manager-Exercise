package com.tma.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tma.service.SongService;
import com.tma.service.UserService;
import com.tma.model.Song;
import com.tma.model.User;
import com.wordnik.swagger.annotations.*;

@Controller
@RequestMapping(value="/song", produces="application/json")
@Api(value = "/song", description = "Manage songs")
public class SongController {
	private static final Logger logger = Logger.getLogger(SongController.class);
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	SongService songService = (SongService) context.getBean("songService");
	
//	@Autowired SongService songService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation(value = "List all songs", 
			notes = "List all people using paging", 
			response = Song.class, 
			responseContainer = "List")
	@ResponseBody public Page<Song> getAll(@RequestParam String page, @RequestParam String size){
		return songService.findAll(new PageRequest(Integer.parseInt(page), Integer.parseInt(size), Direction.ASC, "name"));
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	@ResponseBody public Page<Song> getByName(@RequestParam String name, @RequestParam String page, @RequestParam String size){
		return songService.findByName(name, new PageRequest(Integer.parseInt(page), Integer.parseInt(size), Direction.ASC, "name"));
	}
	
	@ApiOperation(value = "Find song by ID", notes = "More notes about this method", response = Song.class)
	@ApiResponses(value = {
	  @ApiResponse(code = 400, message = "Invalid ID supplied"),
	  @ApiResponse(code = 404, message = "Pet not found") 
	})
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody public Song getWithId(@ApiParam(value = "ID of song to fetch", required = true) @PathVariable String id){
		return songService.findOne(id);
	}

	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody public void addSong(@RequestBody Song song){
		songService.addSong(song);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ResponseBody public void updateSong(@PathVariable String id, @RequestBody Song song){
		songService.updateSong(id, song);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseBody public void deleteSong(@PathVariable String id){
		songService.delete(id);
	}
}
