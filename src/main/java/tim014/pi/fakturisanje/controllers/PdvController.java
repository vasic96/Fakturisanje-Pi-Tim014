package tim014.pi.fakturisanje.controllers;

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

import net.bytebuddy.asm.Advice.Return;
import tim014.pi.fakturisanje.model.PDV;
import tim014.pi.fakturisanje.repositories.PdvRepository;

@RestController
@RequestMapping(value= "api/pdv")
public class PdvController {

	
	@Autowired
	private PdvRepository pdvRepository;
	
	@GetMapping(value="/all")
	public ResponseEntity<List<PDV>> PDV(){
		
		return new ResponseEntity<List<PDV>>(pdvRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(value="/add", consumes= "APPLICATION/JSON")
	public ResponseEntity<PDV> addPDV(@RequestBody PDV pdv){
		
		if (pdv != null){
			
			return new ResponseEntity<PDV>(pdvRepository.save(pdv), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/all/{id}")
	public ResponseEntity<PDV>searchID(@PathVariable Long id){
		
		if (pdvRepository.existsById(id)) {
			
			return new ResponseEntity<PDV>(pdvRepository.getOne(id), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<?>deletePDV(@PathVariable Long id)
	{
		if(pdvRepository.existsById(id)) {
			pdvRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
