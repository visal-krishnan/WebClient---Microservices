package com.ust.DistrictServices.repo;

import com.ust.DistrictServices.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepo extends JpaRepository<District,Long> {
    List<District> findByStateName(String stateName);
}
