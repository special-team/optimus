package test.com.github.ooknight.rubik.optimus.client.web;

import com.github.ooknight.rubik.optimus.client.web.WebConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebConfiguration.class)
//@AutoConfigureMockMvc
@ComponentScan
//@EnableWebMvc
@EnableAutoConfiguration
@ActiveProfiles("develop")
public class Run {

    private MockMvc mvc;
    //
    @Resource
    private WebApplicationContext context;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void test1() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/demo"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            //.andExpect(MockMvcResultMatchers.content().string("demo"))
            .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void test2() throws Exception {
        System.out.println(context.getBean(ObjectMapper.class));
        mvc.perform(MockMvcRequestBuilders.get("/demo?p=2018-01-01 00:00:00"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("\"2018-01-01 00:00:00\""))
            .andDo(MockMvcResultHandlers.print())
        ;
    }
}
