package com.nk.springjpa.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nk.springjpa.dao.CitizenDAO;
import com.nk.springjpa.model.Citizen;

@RestController
@RequestMapping("/village")
public class CitizenController {

	@Autowired
	CitizenDAO citizenDao;

	@PostMapping("/citizens")
	public Citizen createCitizen(@Valid @RequestBody Citizen ctz) {
		return citizenDao.save(ctz);
	}

	@GetMapping("/citizens")
	public List<Citizen> getAllCitizens() {
		return citizenDao.findAll();
	}

	@GetMapping("/notes/{id}")
	public ResponseEntity<Citizen> getCitizenById(@PathVariable(value = "id") Long citizenId) {

		Optional<Citizen> ctz = citizenDao.findOne(citizenId);

		Citizen citizen = null;
		if (!ctz.isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			citizen = ctz.get();
		}
		return ResponseEntity.ok().body(citizen);

	}

	
	  @PutMapping("/citizens/{id}") 
	  public ResponseEntity<Citizen> updateEmployee(@PathVariable(value="id") Long ctzid,@Valid @RequestBody Citizen ctz){
	  
	  Optional<Citizen> citizenOp=citizenDao.findOne(ctzid); 
	  
	  if(!citizenOp.isPresent()) {
		  return ResponseEntity.notFound().build(); 
	  }
	  
	  Citizen citizen = citizenOp.get();
	  
	  citizen.setName(ctz.getName()); citizen.setDesignation(ctz.getDesignation());
	  citizen.setProfession(ctz.getProfession());
	  
	  Citizen updateCtz=citizenDao.save(citizen); return
	  ResponseEntity.ok().body(updateCtz);
	  
	  }
	 

	@DeleteMapping("/citizens/{id}")
	public ResponseEntity<Citizen> deleteEmployee(@PathVariable(value = "id") Long ctzid) {

		Optional<Citizen> citizen = citizenDao.findOne(ctzid);

		if (!citizen.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		citizenDao.delete(citizen.get());
		return ResponseEntity.ok().build();

	}

}
