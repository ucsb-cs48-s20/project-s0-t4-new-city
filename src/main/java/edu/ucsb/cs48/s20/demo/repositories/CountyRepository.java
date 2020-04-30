package edu.ucsb.cs48.s20.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.ucsb.cs48.s20.demo.entities.County;

public interface CountyRepository extends CrudRepository<County, Long>{
	public List<County> findByName(String name);
}
