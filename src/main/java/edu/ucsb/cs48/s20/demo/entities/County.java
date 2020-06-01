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

    @CsvBindByPosition(position = 6)
    @CsvBindByName
    private double unEmploymentRate;



    @CsvBindByPosition(position = 7)
    @CsvBindByName
    private double studentEnrollment;

    @CsvBindByPosition(position = 8)
    @CsvBindByName
    private int populationRank;

    @CsvBindByPosition(position = 9)
    @CsvBindByName
    private int incomeRank;

    @CsvBindByPosition(position = 10)
    @CsvBindByName
    private int houseRank;

    @CsvBindByPosition(position = 11)
    @CsvBindByName
    private int temperatureRank;

    @CsvBindByPosition(position = 12)
    @CsvBindByName
    private int crimeRank;

    @CsvBindByPosition(position = 13)
    @CsvBindByName
    private int unemploymentRank;

    @CsvBindByPosition(position = 14)
    @CsvBindByName
    private int studentRank;


    public County () {

    }

    public County(String name, double income, double houseprice) {
        this.name = name;
        this.averageIncome = income;
        this.housePrice = houseprice;
    }
    
    public County (String name, int populationRank, int incomeRank,
                   int houseRank, int temperatureRank, int crimeRank,
                   int unemploymentRank, int studentRank) {
       
        this.name = name;
        this.populationRank = populationRank;
        this.incomeRank = incomeRank;
        this.houseRank = houseRank;
        this.temperatureRank = temperatureRank;
        this.crimeRank = crimeRank;
        this.unemploymentRank = unemploymentRank;
        this.studentRank = studentRank;

    } 
    
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

    //newly added
    public double getUnEmploymentRate() {
        return unEmploymentRate;
    }
    public void setUnEmploymentRate(double unEmploymentRate) {
        this.unEmploymentRate = unEmploymentRate;
    }

    public double getStudentEnrollment() {
        return studentEnrollment;
    }
    public void setStudentEnrollment(double studentEnrollment) {
        this.studentEnrollment = studentEnrollment;
    }

    public int getPopulationRank() {
        return populationRank;
    }
    public void setPopulationRank(int populationRank) {
        this.populationRank = populationRank;
    }
    public int getIncomeRank() {
        return incomeRank;
    }
    public void setIncomeRank(int incomeRank) {
        this.incomeRank = incomeRank;
    }
    public int getHouseRank() {
        return houseRank;
    }
    public void setHouseRank(int houseRank) {
        this.houseRank = houseRank;
    }
    public int getTemperatureRank() {
        return temperatureRank;
    }
    public void setTemperatureRank(int temperatureRank) {
        this.temperatureRank = temperatureRank;
    }
    public int getCrimeRank() {
        return crimeRank;
    }
    public void setCrimeRank(int crimeRank) {
        this.crimeRank = crimeRank;
    }
    public int getUnemploymentRank() {
        return unemploymentRank;
    }
    public void setUnemploymentRank(int unemploymentRank) {
        this.unemploymentRank = unemploymentRank;
    }
    public int getStudentRank() {
        return studentRank;
    }
    public void setStudentRank(int studentRank) {
        this.studentRank = studentRank;
    }



    @Override
    public String toString() {
        return "County [id=" + id + ", population=" + population + ", name=" + name +
               ", averageIncome=" + averageIncome
               + ", temperature=" + temperature
               + ", housePrice=" + housePrice
               + ", crimeRate=" + crimeRate
               + ", unEmploymentRate=" + unEmploymentRate
               + ", studentEnrollment=" + studentEnrollment
               + ", populationRank=" + populationRank
               + ", incomeRank=" + incomeRank
               + ", houseRank=" + houseRank
               + ", temperatureRank=" + temperatureRank
               + ", crimeRank=" + crimeRank
               + ", unemploymentRank=" + unemploymentRank
               + ", studentRank=" + studentRank + "]";
    }



}
