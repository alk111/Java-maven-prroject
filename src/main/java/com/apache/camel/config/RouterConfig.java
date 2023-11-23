//package com.apache.camel.config;
//
//import com.apache.camel.serviceimpl.UserService;
//import org.apache.camel.builder.RouteBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RouterConfig extends RouteBuilder {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public void configure() throws Exception {
////        Exchange[ExchangePattern: InOnly, BodyType: null, Body: [Body is null]]
//        from("timer:initiateTime")
//                .transform()
////                .constant("First Message")
//                .constant("Users :: " + userService.getAllUsers())
//                .log("${body}")
//                .to("log:initiateTime");
//    }
//
//}
