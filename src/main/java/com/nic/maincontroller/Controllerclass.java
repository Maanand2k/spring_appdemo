package com.nic.maincontroller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nic.model.modelclass;
import com.nic.service.Serviceclass;

@RestController
public class Controllerclass {
	
	@Autowired
	private Serviceclass s;
	
	@GetMapping("/get")
	public ResponseEntity<List<modelclass>> getdetails()
	{
		List<modelclass> getusers = s.getform();
		return ResponseEntity.ok(getusers);
	}
	
	@PostMapping("/set")
	public ResponseEntity<modelclass> setdetails(modelclass m) throws URISyntaxException
	{
		modelclass newuser = (modelclass) s.saveform(m);
		return ResponseEntity.created(new URI("/set"+ newuser.getId())).body(newuser);
	}
	
	@GetMapping("/getbyfirstname")
	public ResponseEntity<List<modelclass>> getbyfirstname(@RequestParam String name)
	{
		List<modelclass> userfirstname = s.findbyfirstname(name);
		return ResponseEntity.ok(userfirstname);
	}
	
	@GetMapping("/getbyage")
	public ResponseEntity<List<modelclass>> getbyage(@RequestParam int age)
	{
		List<modelclass> userage = s.findbyage(age);
		return ResponseEntity.ok(userage);
	}
	
//	@PutMapping("/updatetable")
//	public ResponseEntity<modelclass> updation(modelclass m) throws URISyntaxException
//	{
//		modelclass updateuser = (modelclass) s.saveform(m);
//		return ResponseEntity.ok(new URI("/updatetable"+ updateuser.getId())).body(updateuser);
//	}
	
}
