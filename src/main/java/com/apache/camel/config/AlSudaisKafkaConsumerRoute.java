//package com.apache.camel.config;
//
//import org.apache.camel.builder.RouteBuilder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AlSudaisKafkaConsumerRoute extends RouteBuilder {
//
//    @Override
//    public void configure() throws Exception {
//        from("kafka:myKafkaTopic")
//                .log("Kafka Message :: ${body}");
//    }
//}
