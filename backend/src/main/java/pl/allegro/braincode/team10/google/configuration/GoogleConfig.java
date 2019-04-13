package pl.allegro.braincode.team10.google.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource(value = "google.properties")
@ConfigurationProperties(prefix = "google")
public class GoogleConfig {
    private String tokenValue;

    private String tokenKey;

    private String addressParam;

    private String endpointGeocode;

    private String origins;

    private String destinations;

    private String endpointDistance;
}