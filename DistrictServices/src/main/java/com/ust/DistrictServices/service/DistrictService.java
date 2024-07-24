package com.ust.DistrictServices.service;

import com.ust.DistrictServices.model.District;
import com.ust.DistrictServices.repo.DistrictRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {
    @Autowired
    DistrictRepo    districtRepo;

    public District addDistrict( District district ) {

        return districtRepo.save( district );
    }

    public District getDistrictById( Long id ) {

        return districtRepo.findById( id ).orElse( null );
    }
    public List<District> getDistricts(String stateName) {
        return districtRepo.findByStateName(stateName);
    }
}
