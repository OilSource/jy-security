package com.security.jy;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseControllerTest {

    @Autowired
    private WebApplicationContext wax;

    private MockMvc mockMvc;

    public MockMvc getMockMvc() {
        if(null==mockMvc){
            mockMvc = MockMvcBuilders.webAppContextSetup(wax).build();
        }
        return mockMvc;
    }
}
