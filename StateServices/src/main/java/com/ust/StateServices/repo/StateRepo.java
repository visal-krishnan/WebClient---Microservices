package com.ust.StateServices.repo;

import com.ust.StateServices.dto.Districtdto;
import com.ust.StateServices.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StateRepo extends JpaRepository<State,Long> {
    Optional<State> findByStateId(String stateId);


}
