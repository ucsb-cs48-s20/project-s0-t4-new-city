package edu.ucsb.cs48.s20.demo.util;

import java.util.Comparator;

import edu.ucsb.cs48.s20.demo.entities.County;
import edu.ucsb.cs48.s20.demo.formbeans.SurveyResult;

public class DynamicCountyComparator implements Comparator<County> {

    private SurveyResult surveyResult;

    public DynamicCountyComparator(SurveyResult surveyResult) {
        this.surveyResult = surveyResult;

    }

    //double score = surveyResult.getPopulationResult() * 1 / countyList[0].getPopulationRank + ;


    public int compare(County o1, County o2) {




        double score1 = (double) surveyResult.getPopulationResult()
                        / (double) (o1.getPopulationRank())
                        + (double) surveyResult.getIncomeResult() / (double) (o1.getIncomeRank())
                        + (double) urveyResult.getHousePriceResult() / (double) (o1.getHouseRank())
                        + (double) surveyResult.getTemperatureResult()
                          / (double) (o1.getTemperatureRank())
                        + (double) surveyResult.getCrimeRateResult() / (double) (o1.getCrimeRank())
                        + (double) surveyResult.getUnemploymentResult()
                          / (double) (o1.getUnemploymentRank())
                        + (double) surveyResult.getStudentResult() / (double) (o1.getStudentRank());

        double score2 = (double) surveyResult.getPopulationResult()
                        /  (double) (o2.getPopulationRank())
                        + (double) surveyResult.getIncomeResult() / (double) (o2.getIncomeRank())
                        + (double) surveyResult.getHousePriceResult() / (double) (o2.getHouseRank())
                        + (double) surveyResult.getTemperatureResult()
                          / (double) (o2.getTemperatureRank())
                        + (double) surveyResult.getCrimeRateResult() / (double) (o2.getCrimeRank())
                        + (double) surveyResult.getUnemploymentResult()
                          / (double) (o2.getUnemploymentRank())
                        + (double) surveyResult.getStudentResult() / (double) (o2.getStudentRank());


        if (score1 == score2) {
            return 0;
        } else if (score1 > score2) {
            return -1;
        } else {
            return 1;
        }

    }

}
