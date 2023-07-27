package top.gzk.wy.config.mvc;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.gzk.wy.config.security.JwtAuthenticationTokenFilter;

import javax.servlet.Filter;

@Configuration
public class WebConfig{
    @Bean
    public FilterRegistrationBean filterRegistrationBean(JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>(jwtAuthenticationTokenFilter);
        filterFilterRegistrationBean.setEnabled(false);
        return filterFilterRegistrationBean;
    }
}