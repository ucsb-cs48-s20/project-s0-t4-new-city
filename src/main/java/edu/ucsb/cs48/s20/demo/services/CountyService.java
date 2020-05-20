package edu.ucsb.cs48.s20.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ucsb.cs48.s20.demo.entities.County;
import edu.ucsb.cs48.s20.demo.repositories.CountyRepository;

@Service
public class CountyService {

    @Autowired
    private CountyRepository countyRepository;

    
    public List<County> findAll() {

        var it = countyRepository.findAll();

        var counties = new ArrayList<County>();
        it.forEach(e -> counties.add(e));

        return counties;
    }
    
    
    
}