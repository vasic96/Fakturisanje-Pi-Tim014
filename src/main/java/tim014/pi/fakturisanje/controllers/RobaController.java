package tim014.pi.fakturisanje.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tim014.pi.fakturisanje.dto.RobaDTO;
import tim014.pi.fakturisanje.model.Roba;
import tim014.pi.fakturisanje.repositories.GrupaRobeRepository;
import tim014.pi.fakturisanje.repositories.JedinicaMereRepository;
import tim014.pi.fakturisanje.repositories.RobaRepository;

@RestController
@RequestMapping(value= "api/roba")
public class RobaController {
	
	
	@Autowired
	private RobaRepository robaRepository;
	
	@Autowired
	private GrupaRobeRepository grupaRobeRepository;
	
	@Autowired
	private JedinicaMereRepository jedinicaMereRepository;
	
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<RobaDTO>>allRoba(){
		List<RobaDTO> robaDTOs= new ArrayList<>();
		
		for(Roba ro: robaRepository.findAll()) {
			robaDTOs.add(new RobaDTO(ro));
		}
		
		return new ResponseEntity<List<RobaDTO>>(robaDTOs, HttpStatus.OK);
	}
	
	
	@PostMapping(value= "add")
	public ResponseEntity<RobaDTO> addRoba(@RequestBody RobaDTO robaDTO){
		if (robaDTO != null) {
			
			Roba roba = new Roba();
			roba.setNaziv(robaDTO.getNaziv());
			roba.setGrupaRobe(grupaRobeRepository.getOne(robaDTO.getGrupaRobeID()));
			roba.setJedinicaMere(jedinicaMereRepository.getOne(robaDTO.getJedinicaMereID()));
			robaRepository.save(roba);
			
			return new ResponseEntity<RobaDTO>(new RobaDTO(roba), HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "delete/{id}")
		public ResponseEntity<?> deleteRoba(@PathVariable Long id){
			if(robaRepository.existsById(id)) {
				
				robaRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
}
