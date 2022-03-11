package org.mauro.templateapp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.PropertyNamingStrategies.LOWER_CAMEL_CASE;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

@Configuration
class MapperConfig {

    @Bean
    public ObjectMapper getMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(LOWER_CAMEL_CASE);
        mapper.setSerializationInclusion(NON_NULL);
        mapper.disable(FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.disable(WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerModule(new JavaTimeModule());
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"));
        mapper.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        return mapper;
    }
}
