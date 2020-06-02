package edu.ucsb.cs48.s20.demo.controllers;

import static org.junit.Assert.assertEquals;

import edu.ucsb.cs48.s20.demo.controllers.SurveyController;
import org.junit.Test;
import org.junit.Before;
import edu.ucsb.cs48.s20.demo.entities.County;
import edu.ucsb.cs48.s20.demo.util.DynamicCountyComparator;
import edu.ucsb.cs48.s20.demo.formbeans.SurveyResult;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import edu.ucsb.cs48.s20.demo.entities.County;
import edu.ucsb.cs48.s20.demo.repositories.CountyRepository;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;


import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class SurveyControllerTest {


    @Autowired
    private SurveyController sc;

    @MockBean
    private CountyRepository cr;

    @Test
    public void test_correct_sorting() {
        
        ArrayList<County> countyList = new ArrayList<>();
        County one = new County("One", 1, 1, 1, 1, 1, 3, 3);
        County two = new County("Two", 2, 2, 2, 2, 2, 2, 2);
        County three = new County("Three", 3, 3, 3, 3, 3, 1, 1);

        countyList.add(one);
        countyList.add(two);
        countyList.add(three);

        SurveyResult survey = new SurveyResult(2,2,2,2,2,-2,-2);

        DynamicCountyComparator s1 = new DynamicCountyComparator(survey);
        countyList.sort(s1);

        assertEquals(countyList.get(0), one);
        
    }

    @Test
    public void testSurveyModel() throws Exception {
        // Begin by creating a new Model that we can pass to the controller to populate
        Model model = new ExtendedModelMap();

        // Mock the database response
        List<County> someCounties = Arrays.asList(new County(), new County(), new County());
        when(cr.findAll()).thenReturn(someCounties);


        SurveyResult survey = new SurveyResult(2,2,2,2,2,-2,-2);
        // Call the controller
        sc.getSurveyResults(model, survey);

        // Make sure model has correct attribute
        assert(model.getAttribute("counties").equals(someCounties));
    }

}