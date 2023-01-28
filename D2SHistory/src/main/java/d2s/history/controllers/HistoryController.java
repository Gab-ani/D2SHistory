package d2s.history.controllers;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import d2s.history.data.History;
import d2s.history.domain.Match;

@SpringBootApplication  
@RestController  
public class HistoryController {
	
	@Autowired
	History history;
	
	@GetMapping("/")
	public String defaultAnswer() {
		return "hi, I am the microservice dedicated to manage a database of dota2 games played in the past";
	}
	
	@GetMapping("/unparsed")
	public ArrayList<Long> getUnparsedIDs() {
		return history.getUnparsedIDs();
	}
	
	@PutMapping(value = "/notice", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public void notice(@RequestBody long[] ids) {
		System.out.println("Noticing " + ids.length + " matches.");
		for(long id : ids) {
			Match match = history.findById(id);
			if(match == null) {
				System.out.println("noticed " + id);
				System.out.println("creating unparsed for " + id); 
				history.createUnparsed(id); 
			}
		}
	}
	
	@PutMapping(value = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public void save(@RequestBody Match match) {
		System.out.println(match.toString());
		history.add(match);
	}
	
}
