package com.nic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nic.model.modelclass;

@Repository
public interface Repositoryinterface extends JpaRepository<modelclass,Integer>{
	
	
	@Query(value="select * from demo where firstname=:name",nativeQuery=true)
	public List<modelclass> findByFirstname(String name);
	
	@Query(value="select * from demo where age>=:age",nativeQuery=true)
	public List<modelclass> findByAgeGreaterThan(Integer age);
	
}
