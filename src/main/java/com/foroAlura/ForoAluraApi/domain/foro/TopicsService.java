package com.foroAlura.ForoAluraApi.domain.foro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class TopicsService {

    /*
    implementing Solid Principles.
     */

    @Autowired
    private TopicsRepository topicsRepository;


    public ResponseEntity<?> saveTopic(TopicsData data, UriComponentsBuilder builder){

        Topics topic = topicsRepository.save(new Topics(data));

        TopicsResponseDto topicsResponseDto = new TopicsResponseDto(topic.getId(), topic.getTitle(), topic.getMessage(),
                topic.getCreation_date(), topic.isActive() ,topic.getAuthor());

        URI url = builder.path("/topic/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(url).body(topicsResponseDto);

    }


    public ResponseEntity<?> getTopics(Pageable pageable){

        return ResponseEntity.ok(topicsRepository.findByActiveTrue(pageable).map(TopicsResponseDto::new));
    }


}
