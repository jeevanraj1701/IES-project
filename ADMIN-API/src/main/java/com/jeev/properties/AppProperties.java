package com.jeev.properties;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@EnableConfigurationProperties
public class AppProperties {

	private Map<String, String> messages = new HashMap<>();
}
