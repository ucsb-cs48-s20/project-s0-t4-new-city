package edu.ucsb.cs48.s20.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import edu.ucsb.cs48.s20.demo.formbeans.CompareCounty;
import edu.ucsb.cs48.s20.demo.repositories.CountyRepository;


@Controller
public class CompareController {

    private Logger logger = LoggerFactory.getLogger(CompareController.class);

    private CountyRepository countyRepository = null;

    @Autowired
    public void applicationController(CountyRepository countyRepository) {
        this.countyRepository = countyRepository;
    }

    @GetMapping("/county/compare-select")

    public String getCountiesComparison(Model model, CompareCounty compareCounty) {
        model.addAttribute("counties", countyRepository.findAll());
        return "counties/compare-select";
    }

    @GetMapping("/county/compare-results")

    public String getComparisonResults(@RequestParam String county1, @RequestParam String county2,
                                        Model model, CompareCounty compareCounty) {
        model.addAttribute("counties", countyRepository.findAll());
        model.addAttribute("county1", county1);
        model.addAttribute("county2", county2);
        model.addAttribute("County1", countyRepository.findByName(county1));
        model.addAttribute("County2", countyRepository.findByName(county2));
        model.addAttribute("compareCounty", compareCounty);
        return "counties/compare-results";
    }

}
