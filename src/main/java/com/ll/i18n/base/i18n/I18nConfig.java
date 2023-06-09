package com.ll.i18n.base.i18n;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
@RequiredArgsConstructor
public class I18nConfig {

    private final CustomResourceBundleMessageSource customResourceBundleMessageSource;

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = customResourceBundleMessageSource;
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    // 브라우저의 요청에 들어있는 언어정보로 언어를 결정
    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
        acceptHeaderLocaleResolver.setDefaultLocale(Locale.US);

        return acceptHeaderLocaleResolver;
    }
}