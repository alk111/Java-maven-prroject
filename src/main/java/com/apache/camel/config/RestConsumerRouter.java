package com.apache.camel.config;

import com.apache.camel.enitities.User;
import com.apache.camel.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;

@Component
public class RestConsumerRouter extends RouteBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${time-window}")
    private String timeWindow;

    @Autowired
    private UserRepository userRepository;


//    @Override
//    public void configure() throws Exception {
//        from("timer://test-rest-api?period=".concat(this.timeWindow))
//                .log("API Hitting :: ")
//                .setHeader(Exchange.HTTP_METHOD, simple("GET"))
//                .autoStartup(Boolean.FALSE)
////                .to("http://localhost:8086/user/")
////                .to("http://localhost:8086/user/")
//                .to("https://fakerapi.it/api/v1/images?_width=380")
//                .process(exchange -> {
//                    String user = exchange.getIn().getBody(String.class);
//                    JsonNode jsonNode = this.objectMapper.readTree(user);
//                    System.out.println("User :: " + jsonNode);
//                });
////                .process(exchange -> {
////                    String user = exchange.getIn().getBody(String.class);
////                    JsonNode jsonNode = this.objectMapper.readTree(user);
////                    System.out.println("User :: " + jsonNode);
////                });
//    }


    //    INSERT ROUTE
    @Override
    public void configure() throws Exception {
        from("direct:insert").log("Processing message: ")
                .setHeader("message", body())
                .process(exchange -> {
                    User userBody = exchange.getIn().getBody(User.class);
                    LOGGER.info("User :: {}", userBody);
                    this.userRepository.save(userBody).subscribe();
                });
    }
}