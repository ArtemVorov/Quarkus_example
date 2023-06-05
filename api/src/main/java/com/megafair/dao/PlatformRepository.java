package com.megafair.dao;

import com.megafair.entity.PlatformEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class PlatformRepository {

    @Inject
    EntityManager entityManager;

    public PlatformEntity getPlatformInfo(String platformName) {
        List<PlatformEntity> resultList = entityManager.createQuery("FROM PlatformEntity platform WHERE platform.name=:platformName")
                .setParameter("platformName", platformName)
                .getResultList();

        if(!resultList.isEmpty()){
            return resultList.get(0);
        }
        return null;
    }
}
