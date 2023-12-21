package com.foroAlura.ForoAluraApi.controller;


import com.foroAlura.ForoAluraApi.domain.foro.TopicsData;
import com.foroAlura.ForoAluraApi.domain.foro.TopicsService;
import com.foroAlura.ForoAluraApi.domain.foro.UpadteData;
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

    @PutMapping
    public ResponseEntity<?> updateTopics(@RequestBody UpadteData data){

        return topicsService.updateTopic(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deactivateTopic(@PathVariable Long id){
        return topicsService.deactivateTopic(id);
    }

}
