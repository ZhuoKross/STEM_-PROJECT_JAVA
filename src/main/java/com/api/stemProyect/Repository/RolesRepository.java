package com.api.stemProyect.Repository;

import com.api.stemProyect.Entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity , Long> {
}
