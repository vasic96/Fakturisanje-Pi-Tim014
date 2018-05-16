package tim014.pi.fakturisanje.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.fabric.Response;

import tim014.pi.fakturisanje.dto.RobaDTO;
import tim014.pi.fakturisanje.model.Roba;
import tim014.pi.fakturisanje.repositories.RobaRepository;

@RestController
@RequestMapping(value= "api/roba")
public class RobaController {
	
	
	@Autowired
	private RobaRepository robaRepository;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<RobaDTO>>allRoba(){
		List<RobaDTO> robaDTOs= new ArrayList<>();
		
		for(Roba ro: robaRepository.findAll()) {
			robaDTOs.add(new RobaDTO(ro));
		}
		
		return new ResponseEntity<List<RobaDTO>>(robaDTOs, HttpStatus.OK);
	}
	
	
	
	
}
