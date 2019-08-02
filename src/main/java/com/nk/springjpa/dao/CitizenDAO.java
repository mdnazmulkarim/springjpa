package com.nk.springjpa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nk.springjpa.model.Citizen;
import com.nk.springjpa.repository.CitizenRepository;

@Service
public class CitizenDAO {
	
	@Autowired
	CitizenRepository citizenRepository;
	
	
	/**
	 * @param citizen
	 * @return save the given object and return after saving
	 */
	public Citizen save(Citizen citizen) {		
		return citizenRepository.save(citizen);
	}
	
	/**
	 * @return list of all citizens
	 */
	public List<Citizen> findAll(){		
		return citizenRepository.findAll();
	}
	
	/**
	 * @param citizenId
	 * @return citizen with the matched id
	 */
	public Optional<Citizen> findOne(Long citizenId) {		
		return citizenRepository.findById(citizenId);
	}
	
	
	/**
	 * @param ctz
	 * deletes a citizen
	 */
	public void delete(Citizen ctz) {
		citizenRepository.delete(ctz);
	}

}
