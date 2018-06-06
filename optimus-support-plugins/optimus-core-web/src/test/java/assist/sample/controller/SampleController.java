package assist.sample.controller;

import optimus.TOOLKIT;
import com.github.ooknight.rubik.core.client.BusinessEventPublisher;

import org.springframework.data.domain.Pageable;
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
        return "parameter is " + TOOLKIT.DATE_TIME_FORMATTER.format(param);
    }

    @GetMapping(value = "/demo", params = {"key"})
    public String demo(String key) {
        //System.out.println(LocaleContextHolder.getLocale());
        //System.out.println(RequestContextUtils.getLocale(request));
        //
        @SuppressWarnings("ConstantConditions")
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        RequestContext requestContext = new RequestContext(request);
        return requestContext.getMessage(key);
    }

    @GetMapping("/page")
    public String page(Pageable pageable) {
        System.out.println(pageable);
        System.out.println(pageable.getOffset());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        return "ok";
    }
}
