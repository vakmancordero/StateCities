package com.upch.microservices.controller;

import com.upch.microservices.dto.StateDTO;
import com.upch.microservices.dto.StateWithCitiesDTO;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upch.microservices.model.State;
import com.upch.microservices.repository.StateRepository;
import com.upch.microservices.util.ConvertUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/states")
public class StateController {
    
    @Autowired
    private ConvertUtil convertUtil;
    
    @Autowired
    private StateRepository stateRepository;
    
    @GetMapping("/all")
    public List<StateDTO> getStates() {
        
        List<State> states = stateRepository.findAll();
        
        List<StateDTO> statesDTO = convertUtil.convert(states, StateDTO.class);
        
        return statesDTO;
    }
    
    //PathVariables
    @GetMapping("/{stateId}")
    public StateWithCitiesDTO getState(@PathVariable("stateId") Long stateId) {
        
        Optional<State> state = stateRepository.findById(stateId);
        
        if (state.isPresent()) {
            
            return convertUtil.convert(state.get(), StateWithCitiesDTO.class);
            
        } else {
            return null;
        }
        
    }
    
}
