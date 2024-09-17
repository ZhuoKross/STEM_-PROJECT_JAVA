package com.api.stemProyect.Repository;

import com.api.stemProyect.Entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContenRepository extends JpaRepository<ContentEntity, Long> {
}
