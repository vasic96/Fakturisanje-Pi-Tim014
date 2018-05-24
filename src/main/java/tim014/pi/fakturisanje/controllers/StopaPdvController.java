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

import tim014.pi.fakturisanje.dto.StopaPdvDTO;
import tim014.pi.fakturisanje.model.StopaPDV;
import tim014.pi.fakturisanje.repositories.PdvRepository;
import tim014.pi.fakturisanje.repositories.StopaPdvRepository;

@RestController
@RequestMapping(value= "api/stopa_pdv")
public class StopaPdvController {

	@Autowired
	private StopaPdvRepository stopaPdvRepository;
	
	@Autowired
	private PdvRepository pdvRepository;
	
	
	@GetMapping(value="/all")
	public ResponseEntity<List<StopaPdvDTO>> allPdv(){
	      List<StopaPdvDTO> stopaPdva = new ArrayList<>();
	        for (StopaPDV st : stopaPdvRepository.findAll()) {
	        	stopaPdva.add(new StopaPdvDTO(st));
	        }
	        return new ResponseEntity<List<StopaPdvDTO>>(stopaPdva, HttpStatus.OK);
	}
	
	@GetMapping(value="all/{id}")
	public ResponseEntity<StopaPdvDTO>searchStopaID(@PathVariable long id){
		
		if(stopaPdvRepository.existsById(id)) {
			return new ResponseEntity<StopaPdvDTO>(new StopaPdvDTO(stopaPdvRepository.getOne(id)), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	@PostMapping(value="/add")
	public ResponseEntity<StopaPdvDTO> addStopaPdv(@RequestBody StopaPdvDTO stopaPdvDTO){
		
		if(stopaPdvDTO!= null) {
				StopaPDV stopaPDV= new StopaPDV();
				stopaPDV.setProcenat(stopaPdvDTO.getProcenat());
				stopaPDV.setDatumVazenja(stopaPdvDTO.getDatumVazenja());
				stopaPDV.setPdv(pdvRepository.getOne(stopaPdvDTO.getPdvId()));
				stopaPdvRepository.save(stopaPDV);
				
				return new ResponseEntity<StopaPdvDTO>(new StopaPdvDTO(stopaPDV),HttpStatus.CREATED);
				
			
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "delete/{id}")
	
	public ResponseEntity<?>deleteStopaPdv(@PathVariable Long id){
		if(stopaPdvRepository.existsById(id)) {
			stopaPdvRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);	
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

}
