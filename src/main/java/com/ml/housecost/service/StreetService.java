package com.ml.housecost.service;

import com.ml.housecost.entity.Street;
import com.ml.housecost.repository.StreetRepo;
import com.ml.housecost.repository.SubwayRepo;
import org.springframework.stereotype.Service;

@Service
public class StreetService extends ListObjectService<Street>{
    private StreetRepo streetRepo;
    public StreetService(StreetRepo streetRepo){
        this.repository = streetRepo;
    }
}
