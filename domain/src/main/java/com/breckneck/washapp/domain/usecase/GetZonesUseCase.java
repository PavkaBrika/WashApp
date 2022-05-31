package com.breckneck.washapp.domain.usecase;

import com.breckneck.washapp.domain.model.Zone;
import com.breckneck.washapp.domain.repository.ZoneRepository;

import java.util.List;

public class GetZonesUseCase {

    ZoneRepository zoneRepository;


    public GetZonesUseCase(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    public List<Zone> execute() {
        return zoneRepository.getAllZones();
    }
}
