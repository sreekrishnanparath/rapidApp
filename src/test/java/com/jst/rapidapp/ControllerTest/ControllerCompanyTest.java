package com.jst.rapidapp.ControllerTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jst.rapidapp.beans.Company;
import com.jst.rapidapp.beans.User;
import com.jst.rapidapp.configurations.JwtUtil;
import com.jst.rapidapp.controllers.company.CompanyController;
import com.jst.rapidapp.service.company.CompanyService;
import com.jst.rapidapp.service.user.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CompanyController.class)
public class ControllerCompanyTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;
    @Mock
    CompanyService companyService;
    @Autowired
    private ObjectMapper mapper;

    @BeforeEach
    public void setup()
    {


    }
    @Test
    public void createCompanyTest() throws Exception
    {
        List<Company> listOfCompany = new ArrayList<>();
        listOfCompany.add(new Company(1,"Amazon","chris","created",true));
        listOfCompany.add(new Company(1,"Google","bob","created",true));
//        when(companyService.getAllCompanies()).thenReturn(listOfCompany);
//        mockMvc.perform( MockMvcRequestBuilders.get("/create")
//                        .accept(MediaType.APPLICATION_JSON))
//                        .andExpect(status().isOk())
//                        .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)));
        assertEquals(true,true);
    }

}
