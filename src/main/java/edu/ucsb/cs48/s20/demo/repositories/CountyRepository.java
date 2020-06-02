package edu.ucsb.cs48.s20.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.ucsb.cs48.s20.demo.entities.County;

public interface CountyRepository extends CrudRepository<County, Long> {

    public List<County> findByName(String name);

    public List<County> findByPopulationBetweenAndAverageIncomeBetweenAndHousePriceBetweenAndTemperatureBetweenAndCrimeRateBetweenAndUnEmploymentRateBetweenAndStudentEnrollmentBetween(
        double popLower, double popUpper,
        double incomeLower, double incomeUpper,
        double priceLower, double priceUpper,
        double tempLower, double tempUpper,
        double crimeLower, double crimeUpper,
        double unEmployLower, double unEmployUpper,
        double studentLower, double studentUpper
    );
}
