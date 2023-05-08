package com.ll.i18n.base.i18n;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class CustomResourceBundleMessageSource extends ResourceBundleMessageSource {
    @Override
    protected String resolveCodeWithoutArguments(String code, Locale locale) {
        if (code.equals("hello")) return "메롱";

        return super.resolveCodeWithoutArguments(code, locale);
    }
}