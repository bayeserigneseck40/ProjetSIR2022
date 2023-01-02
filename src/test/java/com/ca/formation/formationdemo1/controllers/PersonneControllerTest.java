package com.ca.formation.formationdemo1.controllers;

import com.ca.formation.formationdemo1.models.Utilisateur;
import com.ca.formation.formationdemo1.models.Personne;

import com.ca.formation.formationdemo1.models.Role;
import com.ca.formation.formationdemo1.models.UtilisateurDTO;
import com.ca.formation.formationdemo1.services.PersonneService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Set;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PersonneControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PersonneService personneService;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port + "/api/v2";
    }

    private String tokenRequest;



    @Test
    @WithMockUser(username = "michel@formation.sn", password = "Passer@123", authorities = { "READ" })
    public void getPersonnes() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v2/personnes")
                .header(HttpHeaders.AUTHORIZATION, "Bearer token")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void getPersonnesPasAutoriser() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v2/personnes")
                .header(HttpHeaders.AUTHORIZATION, "Bearer token")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isUnauthorized());

    }
    @Test
    @WithMockUser(username = "clara@formation.ca", password = "Passer@123", authorities = {"READ"})
    public void nouveauPersonne() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/nouveau")
                .header(HttpHeaders.AUTHORIZATION, "Bearer token")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
          String response = mvcResult.getResponse().getContentAsString();
          System.out.println(response);
        assertEquals("nouveau",response);
    }

    @Test
    @WithMockUser(username = "michel@formation.sn", password = "Passer@123", authorities = { "READ" })
    public void getPersonnesVrai() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + tokenRequest);
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + "/api/v2/personnes",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response);

    }

  
}
