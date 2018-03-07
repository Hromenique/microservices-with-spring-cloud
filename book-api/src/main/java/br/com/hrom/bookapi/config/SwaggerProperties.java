package br.com.hrom.bookapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "swagger")
@Data
public class SwaggerProperties {

    private String baseUrl;
    private String title;
    private String description;
    private String termsOfService;
    private String license;
    private String licenseUrl;
    private String applicationVersion;
    private String[] endpoints;
}
