package com.ml.housecost.repository;

import com.ml.housecost.entity.ResidentialComplex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResComplexRepo extends JpaRepository<ResidentialComplex, Integer> {
}
