package edu.ucsb.cs48.s20.demo.controllers;

import edu.ucsb.cs48.s20.demo.advice.AuthControllerAdvice;
import edu.ucsb.cs48.s20.demo.services.GoogleMembershipService;
import edu.ucsb.cs48.s20.demo.services.MembershipService;
import edu.ucsb.cs48.s20.demo.Application;
import edu.ucsb.cs48.s20.demo.controllers.FilterController;
import edu.ucsb.cs48.s20.demo.formbeans.CountyFilter;
import edu.ucsb.cs48.s20.demo.entities.County;
import edu.ucsb.cs48.s20.demo.repositories.AppUserRepository;
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





@SpringBootTest(classes= {Application.class})
@AutoConfigureMockMvc
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class FilterControllerTest {


    @Autowired
    private FilterController fc;

    @MockBean
    private CountyRepository cr;

    static {
        System.setProperty("newCity.googleMapKey","1");
    }
    @MockBean
    private AppUserRepository aur;
    @MockBean
    private ClientRegistrationRepository crr;
    @MockBean
    private MembershipService ms;
    @MockBean
    private AuthControllerAdvice aca;

    @Test
    public void testFilter() {

        // Begin by creating a new Model that we can pass to the controller to populate
        Model model = new ExtendedModelMap();

        CountyFilter cf = new CountyFilter();

        cf.setMinincome(10);
        cf.setMaxincome(100);
        cf.setMaxhousecost(100);
        cf.setMinhousecost(10);

        County c1 = new County("one", 50, 50);
        County c2 = new County("two", 90, 90);

        // Mock the database response
        List<County> someCounties = Arrays.asList(c1,c2);
        when(cr.findByAverageIncomeBetweenAndHousePriceBetween(10,100,10,100)).thenReturn(someCounties);

        // Call the controller
        fc.getCountiesResults(model, cf);


        // Make sure model has correct attribute
        assert(model.getAttribute("counties").equals(someCounties));

    }
}
