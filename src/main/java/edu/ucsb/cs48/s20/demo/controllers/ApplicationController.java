package edu.ucsb.cs48.s20.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import edu.ucsb.cs48.s20.demo.repositories.CountyRepository;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.ui.Model;

@Controller
public class ApplicationController {

    private Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;


    private CountyRepository countyRepository = null;

    @Autowired
    public ApplicationController(CountyRepository countyRepository) {
        this.countyRepository = countyRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        logger.info("model={} countyRepository={}", model,
                    countyRepository); // prints to console information
        model.addAttribute("counties", countyRepository.findAll());
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model,
                               OAuth2AuthenticationToken oAuth2AuthenticationToken) {

        Map<String, String> urls = new HashMap<>();

        // get around an unfortunate limitation of the API
        // that requires an unchecked cast to Iterable<ClientRegistration>

        @SuppressWarnings("unchecked") Iterable<ClientRegistration> iterable = ((
                    Iterable<ClientRegistration>) clientRegistrationRepository);
        iterable.forEach(clientRegistration -> urls.put(clientRegistration.getClientName(),
                         "/oauth2/authorization/" + clientRegistration.getRegistrationId()));

        model.addAttribute("urls", urls);
        return "login";
    }
}

