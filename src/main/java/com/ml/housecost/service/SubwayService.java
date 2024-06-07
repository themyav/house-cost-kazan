package com.ml.housecost.service;

import com.ml.housecost.entity.Subway;
import com.ml.housecost.repository.SubwayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class SubwayService extends ListObjectService<Subway>{
    private SubwayRepo subwayRepo;
    public SubwayService(SubwayRepo subwayRepo){
        this.repository = subwayRepo;
    }
}
