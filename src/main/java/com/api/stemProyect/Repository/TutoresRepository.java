package com.api.stemProyect.Repository;

import com.api.stemProyect.Entity.TutoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TutoresRepository extends JpaRepository<TutoresEntity, Long>{
}
