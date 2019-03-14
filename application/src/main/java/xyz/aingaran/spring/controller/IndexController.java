package xyz.aingaran.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping
    public String sayHello() {
        logger.info("Requested to say welcome .");
        return "Hello and Welcome to the DevOps application V3. \nYou can view users by making a GET request to /api/uses endpoint.";
    }
}
