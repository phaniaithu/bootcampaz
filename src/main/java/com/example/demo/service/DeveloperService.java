package com.example.demo.service;

import com.example.demo.model.Developer;
import com.example.demo.model.DeveloperPayload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeveloperService  {
    Developer saveDeveloper(Developer dev);

    Developer updateDeveloper(Developer obj, int devId );

    List<Developer> fetchAllDevelopers();

    void deleteDeveloper(Integer devId);


}
