package edu.ucsb.cs48.s20.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.ucsb.cs48.s20.demo.formbeans.CountyFilter;

@Controller
public class FilterController {

    @GetMapping("/county/search")

    public String getEarthquakesSearch(CountyFilter countyFilter) {
        return "counties/filter";
    }

    @GetMapping("/county/results")

    public String getEarthquakesResults(Model model, CountyFilter countyFilter) {
        model.addAttribute("countyFilter", countyFilter);
        return "counties/results";
    }

}
