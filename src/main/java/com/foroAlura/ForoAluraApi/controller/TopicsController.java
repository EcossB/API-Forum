package com.foroAlura.ForoAluraApi.controller;


import com.foroAlura.ForoAluraApi.domain.foro.TopicsData;
import com.foroAlura.ForoAluraApi.domain.foro.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topic")
public class TopicsController {


    @Autowired
    private TopicsService topicsService;


    @PostMapping
    public ResponseEntity<?> saveTopic(@RequestBody TopicsData data, UriComponentsBuilder builder){

       return topicsService.saveTopic(data, builder);
    }


    @GetMapping
    public ResponseEntity<?> getTopics(@PageableDefault(size=10) Pageable pageable){
        return topicsService.getTopics(pageable);
    }

}
