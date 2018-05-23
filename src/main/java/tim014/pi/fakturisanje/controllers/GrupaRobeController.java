package tim014.pi.fakturisanje.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim014.pi.fakturisanje.dto.GrupaRobeDTO;
import tim014.pi.fakturisanje.model.GrupaRobe;
import tim014.pi.fakturisanje.repositories.GrupaRobeRepository;



@RequestMapping(value= "api/grupa_robe")
@RestController
public class GrupaRobeController {

	@Autowired
	private GrupaRobeRepository grupaRobeRepository;
	
	
	@GetMapping(value="all")
	public ResponseEntity<List<GrupaRobeDTO>> allgrupaRobe(){
		
		List<GrupaRobeDTO> grupaRobeDTOs= new ArrayList<>();
		for (GrupaRobe gr: grupaRobeRepository.findAll()) {
			
			grupaRobeDTOs.add(new GrupaRobeDTO(gr));
		}
		return new ResponseEntity<List<GrupaRobeDTO>>(grupaRobeDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value="all/{id}")
	public ResponseEntity<GrupaRobeDTO>searchGrupaRobeId(@PathVariable Long id){
		
		if(grupaRobeRepository.existsById(id)) {
		
		return new ResponseEntity<GrupaRobeDTO>(new GrupaRobeDTO(grupaRobeRepository.getOne(id)),HttpStatus.OK);
			
		}		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	
	
	@DeleteMapping(value ="delete/{id}")
		
		public ResponseEntity<?> deleteGrupaRobe(@PathVariable Long id){
			if(grupaRobeRepository.existsById(id)) {
				grupaRobeRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
				
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping(value="pdv/{id}")
	public ResponseEntity<List<GrupaRobeDTO>> allPDVuGrupiRobe(@PathVariable Long id){
		
		List<GrupaRobeDTO> grupaRobeDTO = new ArrayList<>();
		for(GrupaRobe grupaRobe: grupaRobeRepository.findAllByPdvId(id)) {
			grupaRobeDTO.add(new GrupaRobeDTO(grupaRobe));
		}
		return new ResponseEntity<List<GrupaRobeDTO>>(grupaRobeDTO, HttpStatus.OK);
	}
}
