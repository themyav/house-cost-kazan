package com.ml.housecost.service;

import com.ml.housecost.entity.ResidentialComplex;
import com.ml.housecost.repository.ResComplexRepo;
import com.ml.housecost.repository.SubwayRepo;
import org.springframework.stereotype.Service;

@Service
public class ResComplexService extends ListObjectService<ResidentialComplex> {
    private ResComplexRepo resComplexRepo;
    public ResComplexService(ResComplexRepo resComplexRepo){
        this.repository = resComplexRepo;
    }
}
