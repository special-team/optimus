package com.github.ooknight.rubik.support.thymeleaf.expression;

import org.springframework.context.i18n.LocaleContextHolder;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.regex.Pattern;

public class UserInterfaceExpression {

    private static Pattern PARAMETER_LOCALE_PATTERN = Pattern.compile("^locale=.*");
    //
    private IExpressionContext context;
    private String defaultLanguage;

    public UserInterfaceExpression(IExpressionContext context) {
        this.context = context;
        this.defaultLanguage = "en";
    }

    public String text(Map<String, String> map) {
        String result = null;
        if (map != null) {
            String language = LocaleContextHolder.getLocale().getLanguage();
            result = map.get(language);
            if (StringUtils.isEmptyOrWhitespace(result)) {
                result = map.get(defaultLanguage);
            }
        }
        return result;
    }

    public String uri(String locale) {
        //String[] strs = {"x=1", "y=1", "locale=111", "xlocale=1111"};
        //List<String> x = Lists.newArrayList(strs);
        //boolean f = x.removeIf(PARAMETER_LOCALE_PATTERN.asPredicate());
        //System.out.println(f);
        //String r = StringUtils.join(x, "&");
        //System.out.println(r);
        if (context instanceof IWebContext) {
            final HttpServletRequest request = ((IWebContext) context).getRequest();
            String u1 = request.getRequestURI();
            String u2 = request.getQueryString();
            return u1 + "?" + "locale=" + locale + (u2 == null ? "" : ("&" + PARAMETER_LOCALE_PATTERN.matcher(u2).replaceAll("")));
        }
        return "";
    }
}
