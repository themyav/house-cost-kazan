package com.ml.housecost.repository;

import com.ml.housecost.entity.Subway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubwayRepo extends JpaRepository<Subway, Integer> {
}
