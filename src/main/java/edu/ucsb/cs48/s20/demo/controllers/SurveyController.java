package edu.ucsb.cs48.s20.demo.controllers;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ucsb.cs48.s20.demo.entities.County;
import edu.ucsb.cs48.s20.demo.formbeans.CountyFilter;
import edu.ucsb.cs48.s20.demo.formbeans.SurveyResult;
import edu.ucsb.cs48.s20.demo.repositories.CountyRepository;
import edu.ucsb.cs48.s20.demo.services.CountyService;
import edu.ucsb.cs48.s20.demo.util.DynamicCountyComparator;


@Controller
public class SurveyController {

    private final CountyRepository countyRepository;

    @Autowired
    private CountyService countyService;

    @Autowired
    public SurveyController(CountyRepository countyRepository, CountyService countyService) {
        this.countyRepository = countyRepository;
        this.countyService = countyService;
    }





    @GetMapping("/survey")
    public String getSurveyResult(SurveyResult surveryResult) {
        return "survey/index";
    }

    @GetMapping("/survey/result")
    public String getSurveyResults(Model model, SurveyResult surveyResult) {
        model.addAttribute("surveyResult", surveyResult);
        Iterable<County> counties = countyRepository.findAll();

        ArrayList<County> countyList = new ArrayList<>();
        counties.forEach(countyList::add);



        DynamicCountyComparator s1 = new DynamicCountyComparator(surveyResult);

        countyList.sort(s1);

        ArrayList<County> result = new ArrayList<>();
        result.add(countyList.get(0));
        result.add(countyList.get(1));
        result.add(countyList.get(2));


        model.addAttribute("counties", result);


        return "survey/result";

    }
}