package edu.ucsb.cs48.s20.demo.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

@Entity
public class County {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	 
	@CsvBindByPosition(position = 1)
    @CsvBindByName
     
	private double population;
	
	@CsvBindByPosition(position = 0)
    @CsvBindByName
    
	private String name;
	
	@CsvBindByPosition(position = 2)
    @CsvBindByName
    
	private double averageIncome;
	
	@CsvBindByPosition(position = 4)
    @CsvBindByName
    
	private double temperature;
	
	@CsvBindByPosition(position = 3)
    @CsvBindByName
    
	private double housePrice;
	
	@CsvBindByPosition(position = 5)
    @CsvBindByName
	private double crimeRate;
		
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPopulation() {
		return population;
	}
	public void setPopulation(double population) {
		this.population = population;
	}
	public double getAverageIncome() {
		return averageIncome;
	}
	public void setAverageIncome(double averageIncome) {
		this.averageIncome = averageIncome;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getHousePrice() {
		return housePrice;
	}
	public void setHousePrice(double housePrice) {	
		this.housePrice = housePrice;
	}
	public double getCrimeRate() {
		return crimeRate;
	}
	public void setCrimeRate(double crimeRate) {
		this.crimeRate = crimeRate;
	}
	
	@Override
	public String toString() {
		return "County [id=" + id + ", population=" + population + ", name=" + name + ", averageIncome=" + averageIncome
				+ ", temperature=" + temperature + ", housePrice=" + housePrice + ", crimeRate=" + crimeRate + "]";
	}
	
	
		
}
