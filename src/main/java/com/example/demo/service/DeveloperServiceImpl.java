package com.example.demo.service;

import com.example.demo.model.Developer;
import com.example.demo.model.DeveloperPayload;
import com.example.demo.repositories.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService{

    @Autowired
    DeveloperRepository developerRepository;

    @Override
    public Developer saveDeveloper(Developer dev) {
        return developerRepository.save(dev);
    }

    @Override
    public Developer updateDeveloper(Developer obj, int devID) {
     Developer d = new Developer();
     d.setDevId(obj.getDevId());
     d.setDevname(obj.getDevname());
     d.setEmail(obj.getEmail());
     d.setSkillLevel(obj.getSkillLevel());
     d.setMemberSince(obj.getMemberSince());
     d.setTotalFeeds(obj.getTotalFeeds());
     d.setReputation(obj.getReputation());
     developerRepository.save(d);
        return developerRepository.save(d);
    }

    @Override
    public List<Developer> fetchAllDevelopers() {

        return developerRepository.findAll();
    }

    @Override
    public void deleteDeveloper(Integer devId) {
        developerRepository.deleteById(devId);
    }


}
