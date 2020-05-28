package edu.ucsb.cs48.s20.demo.formbeans;

public class CountyFilter {

    private double minincome;
    private double maxincome;
    private double minhousecost;
    private double maxhousecost;

    public CountyFilter() {
    }

// getters
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

// setters
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

}