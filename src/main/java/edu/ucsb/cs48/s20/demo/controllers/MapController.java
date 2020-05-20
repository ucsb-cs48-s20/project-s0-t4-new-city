package edu.ucsb.cs48.s20.demo.controllers;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ucsb.cs48.s20.demo.repositories.CountyRepository;


@Controller
public class MapController {
	 
	private Logger logger = LoggerFactory.getLogger(MapController.class);
	
	private final CountyRepository countyRepository;
	
	@Value("${newCity.googleMapKey}")
	private String key;
	
	@Autowired
	public MapController(CountyRepository countyRepository) {
        this.countyRepository = countyRepository;
 }

    @GetMapping("/map")
    public String showSurveyForm(Model model) {
    	logger.info("key={}",key);
    	String googleMapUrl = String.format("https://maps.googleapis.com/maps/api/js?key=%s&callback=initMap", key);
    	model.addAttribute("googleMapsUrl", googleMapUrl);
        return "map/index";
    }
}



