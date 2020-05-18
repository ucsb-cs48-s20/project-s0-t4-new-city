package edu.ucsb.cs48.s20.demo.formbeans;

public class SurveyResult {

	int populationResult;
	
	int incomeResult;
	
	int housePriceResult;
	
	int temperatureResult;
	
	int crimeRateResult;
	
	int unemploymentResult;
	
	int studentResult;
	
	
	
	public int getIncomeResult() {
		return incomeResult;
	}

	public void setIncomeResult(int incomeResult) {
		this.incomeResult = incomeResult;
	}

	public int getHousePriceResult() {
		return housePriceResult;
	}

	public void setHousePriceResult(int housePriceResult) {
		this.housePriceResult = housePriceResult;
	}

	public int getTemperatureResult() {
		return temperatureResult;
	}

	public void setTemperatureResult(int temperatureResult) {
		this.temperatureResult = temperatureResult;
	}

	public int getCrimeRateResult() {
		return crimeRateResult;
	}

	public void setCrimeRateResult(int crimeRateResult) {
		this.crimeRateResult = crimeRateResult;
	}

	public int getUnemploymentResult() {
		return unemploymentResult;
	}

	public void setUnemploymentResult(int unemploymentResult) {
		this.unemploymentResult = unemploymentResult;
	}

	public int getStudentResult() {
		return studentResult;
	}

	public void setStudentResult(int studentResult) {
		this.studentResult = studentResult;
	}

	public SurveyResult() {}

	public int getPopulationResult() {
		return populationResult;
	}

	public void setPopulationResult(int populationResult) {
		this.populationResult = populationResult;
	}

	@Override
	public String toString() {
		return "SurveyResult [populationResult=" + populationResult + ", incomeResult=" + incomeResult
				+ ", housePriceResult=" + housePriceResult + ", temperatureResult=" + temperatureResult
				+ ", crimeRateResult=" + crimeRateResult + ", unemploymentResult=" + unemploymentResult
				+ ", studentResult=" + studentResult + "]";
	}

	
}
