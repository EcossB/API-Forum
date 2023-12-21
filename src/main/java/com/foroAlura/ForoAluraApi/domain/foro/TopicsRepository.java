package com.foroAlura.ForoAluraApi.domain.foro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicsRepository extends JpaRepository<Topics, Long> {

     Page<Topics> findByActiveTrue(Pageable pageable);
}
