package tim014.pi.fakturisanje.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim014.pi.fakturisanje.model.JedinicaMere;
import tim014.pi.fakturisanje.repositories.JedinicaMereRepository;

@RestController
@RequestMapping(value= "api/jedinicaMere")
public class JedinicaMereController {
	
	
	@Autowired 
	private JedinicaMereRepository jedinicaMereRepository;
	
	
	@GetMapping(value= "all")
	public ResponseEntity<List<JedinicaMere>> allJedinicaMere(){
		
		
		return new ResponseEntity<List<JedinicaMere>>(jedinicaMereRepository.findAll(), HttpStatus.OK);
	}
	
	
	

}
