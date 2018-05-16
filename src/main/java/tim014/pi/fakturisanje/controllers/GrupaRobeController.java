package tim014.pi.fakturisanje.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim014.pi.fakturisanje.dto.GrupaRobeDTO;
import tim014.pi.fakturisanje.model.GrupaRobe;
import tim014.pi.fakturisanje.repositories.GrupaRobeRepository;

@RestController
@RequestMapping(value= "api/grupa_robe")
public class GrupaRobeController {

	@Autowired
	private GrupaRobeRepository grupaRobeRepository;
	
	@GetMapping(value="/all")
	public ResponseEntity<List<GrupaRobeDTO>> allgrupaRobe(){
		
		List<GrupaRobeDTO> grupaRobeDTOs= new ArrayList<>();
		for (GrupaRobe gr: grupaRobeRepository.findAll()) {
			
			grupaRobeDTOs.add(new GrupaRobeDTO(gr));
		}
		
		
		
		return new ResponseEntity<List<GrupaRobeDTO>>(grupaRobeDTOs, HttpStatus.OK);
	}
	
}
