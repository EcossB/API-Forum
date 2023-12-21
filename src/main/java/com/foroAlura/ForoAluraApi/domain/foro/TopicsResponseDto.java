package com.foroAlura.ForoAluraApi.domain.foro;

import java.time.LocalDate;

public record TopicsResponseDto(

        Long id,
        String title,
        String message,

        LocalDate creation_date,

        boolean topic_status,
        String author
) {

    public TopicsResponseDto(Topics topics){
        this(topics.getId(), topics.getTitle(), topics.getMessage(), topics.getCreation_date(), topics.isActive(), topics.getAuthor());
    }

}
