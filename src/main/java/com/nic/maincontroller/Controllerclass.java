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

	private Serviceclass serviceclass;

	@Autowired
	public void Controllerclass(Serviceclass serviceclass) {
		this.serviceclass = serviceclass;
	}

	@GetMapping("/get")
	public ResponseEntity<List<modelclass>> getdetails() {
		List<modelclass> getusers = serviceclass.getform();
		return ResponseEntity.ok(getusers);
	}

	@PostMapping("/set")
	public ResponseEntity<modelclass> setdetails(modelclass m) throws URISyntaxException {
		modelclass newuser = (modelclass) serviceclass.saveform(m);
		return ResponseEntity.created(new URI("/set" + newuser.getId())).body(newuser);
	}

	@GetMapping("/getbyfirstname")
	public ResponseEntity<List<modelclass>> getbyfirstname(@RequestParam String name) {
		List<modelclass> userfirstname = serviceclass.findbyfirstname(name);
		return ResponseEntity.ok(userfirstname);
	}

	@GetMapping("/getbyage")
	public ResponseEntity<List<modelclass>> getbyage(@RequestParam int age) {
		List<modelclass> userage = serviceclass.findbyage(age);
		return ResponseEntity.ok(userage);
	}

	@PutMapping("/update")
	public void updateuser(modelclass m) {
		serviceclass.updateuser(m);
	}

	// @PostMapping("/getjwt")
	// public List<Map<String,Object>> jwttoken(@RequestParam String
	// subject,@RequestParam String role)
	// {
	// List<Map<String,Object>> listvalue = new ArrayList<>();
	// String jwtString;
	// Map<String,Object> mapvalue = new HashMap<>();
	// jwtString = serviceclass.createJWTToken(subject, role);
	// mapvalue.put("JwtToken", jwtString);
	// listvalue.add(mapvalue);

	// return listvalue;

	// }

	// @PutMapping("/updatetable")
	// public ResponseEntity<modelclass> updation(modelclass m) throws
	// URISyntaxException
	// {
	// modelclass updateuser = (modelclass) s.saveform(m);
	// return ResponseEntity.ok(new URI("/updatetable"+
	// updateuser.getId())).body(updateuser);
	// }

}
