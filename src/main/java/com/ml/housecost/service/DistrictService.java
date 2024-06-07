package com.ml.housecost.service;

import com.ml.housecost.entity.District;
import com.ml.housecost.repository.DistrictRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService extends ListObjectService<District> {
    private DistrictRepo districtRepo;
    public DistrictService(DistrictRepo districtRepo){
        this.repository = districtRepo;
    }

}
