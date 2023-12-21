package com.foroAlura.ForoAluraApi.controller;


import com.foroAlura.ForoAluraApi.domain.foro.TopicsData;
import com.foroAlura.ForoAluraApi.domain.foro.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topic")
public class TopicsController {


    @Autowired
    private TopicsService topicsService;


    @PostMapping
    public ResponseEntity<?> SaveTopic(@RequestBody TopicsData data, UriComponentsBuilder builder){

       return topicsService.saveTopic(data, builder);
    }

}
