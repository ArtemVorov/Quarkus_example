package com.megafair.service;

import com.megafair.dao.PlatformRepository;
import com.megafair.entity.GameResourceEntity;
import com.megafair.entity.PlatformEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GameService {

    @Inject
    PlatformRepository repository;

    public String getResourceUrl(String platformName, String requestedResource) {
        PlatformEntity platformEntity = repository.getPlatformInfo(platformName);
        if(platformEntity == null){
            return null;
        }

        List<GameResourceEntity> allowedResources = platformEntity.getAllowedResources();
        if(isAllowedForPlatform(allowedResources, requestedResource)){
            return allowedResources.stream()
                    .filter(gameResourceEntity -> gameResourceEntity.getName().equals(requestedResource))
                    .map(GameResourceEntity::getUrl)
                    .findFirst().orElse(null); //todo Custom exception can be thrown here
        }
        return null;
    }

    private boolean isAllowedForPlatform(List<GameResourceEntity> allowedResources, String requestedResource) {
        return allowedResources.stream()
                .map(GameResourceEntity::getName)
                .anyMatch(s -> s.equals(requestedResource));
    }
}
