package test.com.github.ooknight.rubik.optimus.client.web.controller;

import optimus.TOOLKIT;
import com.github.ooknight.rubik.core.client.BusinessEventPublisher;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Maps;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class DemoController {

    @Resource
    private BusinessEventPublisher publisher;

    @GetMapping("/demo")
    public Map demo() {
        System.out.println(publisher);
        Map<String, Object> x = Maps.newHashMap();
        x.put("x", LocalDate.now());
        x.put("y", LocalDateTime.now());
        x.put("z", new A());
        return x;
    }

    @GetMapping(value = "/demo", params = "p")
    public LocalDateTime demo(@RequestParam("p") LocalDateTime param) {
        return param;
    }

    @Data
    class A {

        @JsonFormat(pattern = TOOLKIT.DATE_FROMAT)
        private LocalDate x = LocalDate.now();
        @JsonFormat(pattern = TOOLKIT.DATE_TIME_FROMAT)
        private LocalDateTime y = LocalDateTime.now();
    }
}
