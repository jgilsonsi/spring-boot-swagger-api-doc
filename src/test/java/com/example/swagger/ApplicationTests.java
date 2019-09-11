package com.example.swagger;

import com.google.common.io.Files;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    WebApplicationContext context;

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationTests.class);

    @Test
    public void swaggerTests() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
                .andDo(result -> {
                    String swaggerDoc = result.getResponse().getContentAsString();
                    if (StringUtils.hasText(swaggerDoc)) {
                        LOG.debug("Generating Swagger documentation");
                        Files.write(result.getResponse().getContentAsString().getBytes(),
                                //*** Set the project name in the json file
                                new File("doc/swagger-api-doc.json"));
                    } else {
                        Assert.fail("Can't generate Swagger documentation. Check the environment configuration.");
                    }
                });
    }
}
