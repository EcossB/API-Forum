package com.foroAlura.ForoAluraApi.domain.foro;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "topics")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Topics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDate creation_date;
    private boolean topic_status;
    private String author;

    public Topics(TopicsData data) {
        this.title = data.title();
        this.message = data.message();
        this.creation_date = LocalDate.now();
        this.topic_status = true;
        this.author = data.author();
    }


    private void deactivateTopic(){
        this.topic_status = false;
    }

}
