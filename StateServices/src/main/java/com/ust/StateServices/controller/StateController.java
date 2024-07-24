package com.ust.StateServices.controller;

import com.ust.StateServices.dto.Districtdto;
import com.ust.StateServices.dto.Responsedto;
import com.ust.StateServices.model.State;
import com.ust.StateServices.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    StateService stateService;

    @PostMapping("/addstate")
    public ResponseEntity<State> addState(@RequestBody State state){
        return ResponseEntity.ok(stateService.addState(state));

    }
//    @GetMapping("{stateId}")
//    public ResponseEntity<Responsedto> getUser(@PathVariable("stateId") String stateId){
//        Responsedto responseDto = stateService.getState(stateId);
//        return ResponseEntity.ok(responseDto);
//    }



}
