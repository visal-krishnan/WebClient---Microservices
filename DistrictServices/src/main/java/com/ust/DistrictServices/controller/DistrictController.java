package com.ust.DistrictServices.controller;

import com.netflix.discovery.converters.Auto;
import com.ust.DistrictServices.model.District;
import com.ust.DistrictServices.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/districts")
public class DistrictController {
    @Autowired
    DistrictService districtService;

    @PostMapping("/addDistrict")
    public District addDistrict(District district) {
        return districtService.addDistrict(district);
    }

    @GetMapping("/getDistrict/{stateName}")
    public ResponseEntity<List<District>> addState(@PathVariable String stateName){
        return ResponseEntity.ok(districtService.getDistricts(stateName));

    }
}
