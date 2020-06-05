package edu.ucsb.cs48.s20.demo.formbeans;

public class CompareCounty {

    private String countyone;
    private String countytwo;

    public CompareCounty() {}

    @Override
    public String toString() {
        return "{" +
               " countyone='" + countyone + "'" +
               ", countytwo='" + countytwo + "'" +
               "}";
    }

    // getters
    public String getCountyone() {
        return countyone;
    }

    public String getCountytwo() {
        return countytwo;
    }

    // setters
    public void setCountyone(String one) {
        countyone = one;
    }

    public void setCountytwo(String two) {
        countytwo = two;
    }

}