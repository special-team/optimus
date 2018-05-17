package com.github.ooknight.rubik.support.thymeleaf.expression;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.springframework.context.i18n.LocaleContextHolder;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class UserInterfaceExpression {

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
        if (context instanceof IWebContext) {
            Map<String, String> params = Maps.newHashMap();
            HttpServletRequest request = ((IWebContext) context).getRequest();
            String u1 = request.getRequestURI();
            String u2 = request.getQueryString();
            if (!Strings.isNullOrEmpty(u2)) {
                params.putAll(Splitter.on('&').withKeyValueSeparator('=').split(u2));
            }
            params.put("locale", locale);
            ///return u1 + "?" + "locale=" + locale + (u2 == null ? "" : ("&" + PARAMETER_LOCALE_PATTERN.matcher(u2).replaceAll("")));
            return u1 + "?" + Joiner.on('&').withKeyValueSeparator('=').join(params);
        }
        return "";
    }
}
