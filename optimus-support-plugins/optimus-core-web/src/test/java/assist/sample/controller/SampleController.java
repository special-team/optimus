package assist.sample.controller;

import optimus.TOOLKIT;
import com.github.ooknight.rubik.core.client.BusinessEventPublisher;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class SampleController {

    @Resource
    private BusinessEventPublisher publisher;

    @GetMapping("/demo")
    public String demo() {
        Assert.notNull(publisher, "publisher must not null");
        return "ok";
    }

    @GetMapping(value = "/demo", params = "p")
    public String demo(@RequestParam("p") LocalDateTime param) {
        return "parameter is " + DateTimeFormatter.ofPattern(TOOLKIT.DATE_TIME_FORMAT).format(param);
    }

    @GetMapping(value = "/demo", params = {"key"})
    public String demo(String key) {
        //System.out.println(LocaleContextHolder.getLocale());
        //System.out.println(RequestContextUtils.getLocale(request));
        //
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        RequestContext requestContext = new RequestContext(request);
        return requestContext.getMessage(key);
    }
}
