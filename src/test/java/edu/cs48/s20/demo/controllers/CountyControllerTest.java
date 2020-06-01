package edu.ucsb.cs48.s20.demo.controllers;

import edu.ucsb.cs48.s20.demo.entities.County;
import edu.ucsb.cs48.s20.demo.repositories.CountyRepository;
import org.junit.Before;
import org.junit.Test;
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
public class CountyControllerTest {

    
    @Autowired
    private CountyController cc;

    @MockBean
    private CountyRepository cr;

    @Test
    public void testCountyModel() throws Exception {
        // Begin by creating a new Model that we can pass to the controller to populate
        Model model = new ExtendedModelMap();

        // Mock the database response
        List<County> someCounties = Arrays.asList(new County(), new County(), new County());
        when(cr.findAll()).thenReturn(someCounties);

        // Call the controller
        cc.showUpdateForm(model);

        // Make sure model has correct attribute
        assert(model.getAttribute("counties").equals(someCounties));
    }

    @Test
    public void testEmptyCountyModel() throws Exception {
        // Begin by creating a new Model that we can pass to the controller to populate
        Model model = new ExtendedModelMap();

        // Mock the database response
        List<County> someCounties = Arrays.asList();
        when(cr.findAll()).thenReturn(someCounties);

        // Call the controller
        cc.showUpdateForm(model);

        // Make sure model has correct attribute
        assert(model.getAttribute("counties").equals(someCounties));
    }

}