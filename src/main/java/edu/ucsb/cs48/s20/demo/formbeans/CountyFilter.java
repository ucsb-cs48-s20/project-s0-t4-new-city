package edu.ucsb.cs48.s20.demo.formbeans;

public class CountyFilter {

    // 1
    private double minpopulation;
    private double maxpopulation;

    // 2
    private double minincome;
    private double maxincome;
    
    // 3
    private double minhousecost;
    private double maxhousecost;
    
    // 4
    private double mintemperature;
    private double maxtemperature;

    // 5
    private double mincrimerate;
    private double maxcrimerate;

    // 6
    private double minunemploymentrate;
    private double maxunemploymentrate;

    // 7
    private double minstudentenrollment;
    private double maxstudentenrollment;

    public CountyFilter() {
    }

// getters
    public double getMinpopulation() {
        return minpopulation;
    }

    public double getMaxpopulation() {
        return maxpopulation;
    }

    public double getMinincome() {
        return minincome;
    }

    public double getMaxincome() {
        return maxincome;
    }

    public double getMinhousecost() {
        return minhousecost;
    }

    public double getMaxhousecost() {
        return maxhousecost;
    }

    public double getMintemperature() {
        return mintemperature;
    }

    public double getMaxtemperature() {
        return maxtemperature;
    }

    public double getMincrimerate() {
        return mincrimerate;
    }

    public double getMaxcrimerate() {
        return maxcrimerate;
    }

    public double getMinunemploymentrate() {
        return minunemploymentrate;
    }

    public double getMaxunemploymentrate() {
        return maxunemploymentrate;
    }

    public double getMinstudentenrollment() {
        return minstudentenrollment;
    }

    public double getMaxstudentenrollment() {
        return maxstudentenrollment;
    }


// setters

    public void setMinpopulation(double minPop) {
        minpopulation = minPop;
    }

    public void setMaxpopulation(double maxPop) {
        maxpopulation = maxPop;
    }

    public void setMinincome(double minPay) {
        minincome = minPay;
    }

    public void setMaxincome(double maxPay) {
        maxincome = maxPay;
    }

    public void setMinhousecost(double minHome) {
        minhousecost = minHome;
    }

    public void setMaxhousecost(double maxHome) {
        maxhousecost = maxHome;
    }

    public void setMintemperature(double minTemp) {
        mintemperature = minTemp;
    }

    public void setMaxtemperature(double maxTemp) {
        maxtemperature = maxTemp;
    }

    public void setMincrimerate(double minCrime) {
        mincrimerate = minCrime;
    }

    public void setMaxcrimerate(double maxCrime) {
        maxcrimerate = maxCrime;
    }

    public void setMinunemploymentrate(double minUnemploy) {
        minunemploymentrate = minUnemploy;
    }

    public void setMaxunemploymentrate(double maxUnemploy) {
        maxunemploymentrate = maxUnemploy;
    }

    public void setMinstudentenrollment(double minStudent) {
        minstudentenrollment = minStudent;
    }

    public void setMaxstudentenrollment(double maxStudent) {
        maxstudentenrollment = maxStudent;
    }

}