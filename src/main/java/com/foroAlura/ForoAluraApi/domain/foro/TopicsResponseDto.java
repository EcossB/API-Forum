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
}
