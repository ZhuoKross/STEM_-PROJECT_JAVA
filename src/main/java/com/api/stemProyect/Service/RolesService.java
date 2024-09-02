package com.api.stemProyect.Service;

import com.api.stemProyect.Entity.RolesEntity;
import com.api.stemProyect.Repository.RolesRepository;
import com.api.stemProyect.Service.Dao.Idao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService implements Idao<RolesEntity , Long> {

    @Autowired
    RolesRepository rolesRepository;

    @Override
    public List<RolesEntity> findAll() {
        return rolesRepository.findAll();
    }

    @Override
    public RolesEntity getById(Long id) {
        Optional<RolesEntity>optionalRolesEntity = rolesRepository.findById(id);
        return optionalRolesEntity.orElse(null);
    }

    @Override
    public void update(RolesEntity entity) {
        this.rolesRepository.save(entity);
    }

    @Override
    public void save(RolesEntity entity) {
        this.rolesRepository.save(entity);
    }

    @Override
    public void delete(RolesEntity entity) {
        this.rolesRepository.delete(entity);
    }

    @Override
    public void create(RolesEntity entity) {
        this.rolesRepository.save(entity);
    }
}
