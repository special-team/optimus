package test.com.github.ooknight.rubik.optimus.client.web;

import assist.sample.controller.SampleController;

import optimus.JUNIT;
import com.github.ooknight.rubik.optimus.client.web.WebAutoConfiguration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WebAutoConfiguration.class)
@WebMvcTest(controllers = SampleController.class, secure = false)
@ComponentScan(value = "assist.sample", excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class))
@ActiveProfiles(JUNIT.SPRING_PROFILE)
public class Run {

    @Resource
    private MockMvc mvc;

    @Test
    public void test1() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/demo"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("ok"))
            .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void test2() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/demo").param("p", "2018-01-02 03:04:05"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("parameter is 2018-01-02 03:04:05"))
            .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testWithI18n() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/demo").param("locale", "en").param("key", "demo"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("demo"))
            .andDo(MockMvcResultHandlers.print());
        mvc.perform(MockMvcRequestBuilders.get("/demo").param("locale", "zh").param("key", "demo"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("演示"))
            .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testPage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/page")
            //.param("page", "9")
            //.param("size", "90")
        )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("ok"))
            .andDo(MockMvcResultHandlers.print());
    }
}
