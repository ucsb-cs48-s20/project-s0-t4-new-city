package edu.ucsb.cs48.s20.demo.formbeans;

public class CountyFilter {

private int minincome;
private int maxincome;
private int minhousecost;
private int maxhousecost;

public CountyFilter() {}

// getters
public int getMinincome() {
    return minincome;
}

public int getMaxincome() {
    return maxincome;
}

public int getMinhousecost() {
    return minhousecost;
}

public int getMaxhousecost() {
    return maxhousecost;
}

// setters
public void setMinincome(int minPay) {
    minincome = minPay;
}

public void setMaxincome(int maxPay) {
    maxincome = maxPay;
}

public void setMinhousecost(int minHome) {
    minhousecost = minHome;
}

public void setMaxhousecost(int maxHome) {
    maxhousecost = maxHome;
}

}