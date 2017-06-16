package com.target.demo.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * Created by rohit on 6/16/17.
 */
@Component
public class TargetApiClient {

    private static final Logger logger = LoggerFactory.getLogger(TargetApiClient.class);
    private final RestTemplate webClient = new RestTemplateBuilder().build();

    @Cacheable
    public JsonNode getPriceData(long id) {
        logger.info("invoking target's rest api");
        JsonNode node = webClient
                .getForObject("https://api.target.com/products/v3/{id}?fields=descriptions&id_type=TCIN&key=43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz",
                        JsonNode.class, Collections.singletonMap("id", id));
        logger.info("finished getting response from target's rest api");
        return node;
    }
}
