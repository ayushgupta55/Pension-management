package com.pm.ProcessPensionModule.Controller;


import com.pm.ProcessPensionModule.Entity.Pensioner;
import com.pm.ProcessPensionModule.Service.ProcessPensionService;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.Before;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;

@AutoConfigureMockMvc
@SpringBootTest
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProcessPensionService processPensionService;

    @Before
	public void initMocks() {
	       MockitoAnnotations.initMocks(this);
	   }
    
    @Test
    public void test12() throws Exception {
        Pensioner pensioner = new Pensioner();
        Mockito.when(processPensionService.getPensionDetail(any())).thenReturn(pensioner);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/Process/ProcessPension/10"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}
