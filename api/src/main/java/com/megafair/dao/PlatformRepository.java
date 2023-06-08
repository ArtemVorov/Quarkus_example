package com.megafair.dao;

import com.megafair.entity.PlatformEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlatformRepository implements PanacheRepository<PlatformEntity> {

    public PlatformEntity findByName(String name) {
        return find("name", name).firstResult();
    }
}
