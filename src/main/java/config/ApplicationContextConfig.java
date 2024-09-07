package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({
        @PropertySource(value = "classpath:cfg.properties")}
)
@ComponentScan(basePackages = {"component", "pages", "utils"})
public class ApplicationContextConfig {
    @Autowired
    Environment env;
}
