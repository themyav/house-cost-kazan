package com.ml.housecost.service;

import com.ml.housecost.entity.ListObject;
import com.ml.housecost.entity.Subway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class ListObjectService<T extends ListObject> {

    private ArrayList<T>allObjects;
    public JpaRepository<T, Integer>repository;

    public void fillAll(){
       this.allObjects = repository.findAll()
                .stream()
                .sorted(Comparator.comparing(T::getName)).collect(Collectors.toCollection(ArrayList::new));

    }

    public ArrayList<T> getAll(){
        return this.allObjects;
    }
}
