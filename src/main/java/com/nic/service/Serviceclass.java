package com.nic.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nic.model.modelclass;
import com.nic.repository.Repositoryinterface;

@Service
public class Serviceclass {
	
	@Autowired
	public Repositoryinterface r;
	
	public List<modelclass> getform() {
		return r.findAll();
	}
	
	public modelclass saveform(modelclass m)
	{
		return r.save(m);
	}

	public List<modelclass> findbyfirstname(String name)
	{
		List<modelclass> demolist = r.findByFirstname(name);
		return demolist;
	}
	
	public List<modelclass> findbyage(Integer age)
	{
		List<modelclass> demolist = r.findByAgeGreaterThan(age);
		return demolist;
	} 
	
	
}
