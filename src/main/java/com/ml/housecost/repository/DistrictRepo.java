package com.ml.housecost.repository;

import com.ml.housecost.entity.District;
import com.ml.housecost.entity.ListObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepo extends JpaRepository<District, Integer> {
}
