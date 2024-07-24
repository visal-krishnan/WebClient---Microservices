package com.ust.StateServices.service;

import com.ust.StateServices.dto.Districtdto;
import com.ust.StateServices.dto.Responsedto;
import com.ust.StateServices.dto.Statedto;
import com.ust.StateServices.model.State;
import com.ust.StateServices.repo.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepo repo;

    @Autowired
    private WebClient webClient;

    public State addState(State state) {
        return repo.save(state);
    }

    public Responsedto getState(State state) {
        Responsedto responseDto = new Responsedto();
        //Airline airline = repo.findByAirlinecode(airlinecode).orElseThrow(() -> new RuntimeException("Airline not found"));
        State s = repo.findByStateId(state.getStateId()).orElseThrow(() -> new RuntimeException("State id not found"));

        Statedto statedto = mapToState(state);

        List<Districtdto> districtdtoList = webClient.get()
                .uri("http://localhost:9098/district/" + state.getStateId())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Districtdto>>() {}).block();

        responseDto.setState(statedto);
        responseDto.setDistrict(districtdtoList);

        return responseDto;
    }

    private Statedto mapToState(State state){
        Statedto dto=new Statedto();
        dto.setStateId(state.getStateId());
        dto.setStateName(state.getStateName());

        return dto;

    }



}
