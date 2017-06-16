package com.target.demo.configuration;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;

/**
 * Created by rohit on 6/16/17.
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public DynamoDBMapper dbMapper() {
        return new DynamoDBMapper(AmazonDynamoDBClient.builder()
                .withCredentials(new ProfileCredentialsProvider())
                .withRegion(Regions.US_EAST_1)
                .build());
    }
}
