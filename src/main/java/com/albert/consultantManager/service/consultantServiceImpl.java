package com.albert.consultantManager.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albert.consultantManager.model.Consultant;
import com.albert.consultantManager.repository.consultantRepository;

@Service
public class consultantServiceImpl implements consultantService {
	@Autowired
	private consultantRepository consultantrepository;

	@Override
	public List< Consultant > getAllConsultants() {
		// get list of all consultants
		return consultantrepository.findAll();

	}
	
	@Override
	public void saveConsultant(Consultant consultant) {
		this.consultantrepository.save(consultant);
	}
	@Override
	public void deleteConsultantById(long id) {
		this.consultantrepository.deleteById(id);
	}

	@Override
	public Consultant getConsultantById(long id) {
		Optional<Consultant> optional =consultantrepository.findById(id);
		Consultant consultant =null;
		if(optional.isPresent()) {
			consultant =optional.get();
		}
		else {
			throw new RuntimeErrorException(null, "Consultant not Found with id: "+id);
		}
		return consultant;
	}

}
