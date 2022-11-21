package com.example.demo.controller;


import com.example.demo.model.Developer;
import com.example.demo.repositories.DeveloperRepository;
import com.example.demo.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/developer")
public class DeveloperController {
    @Autowired
    DeveloperService developerService;

    @Autowired
    DeveloperRepository developerRepository;


    @GetMapping("/test")
    public String test() {
        return "Developer!";
    }

    @RequestMapping("/getById/{devId}")
    public ResponseEntity<Developer> findById(@PathVariable(value = "devId") Integer devId){
        Developer developer = developerRepository.getById(devId);
        if(developer!=null) {
            return new ResponseEntity<>(developer, HttpStatus.OK);
        }
        else {
            return	new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

        }
    }
    @PutMapping("/editProfile")
    public ResponseEntity <Developer> update(@RequestBody Developer obj){
        developerService.updateDeveloper(obj, obj.getDevId());
        return new ResponseEntity<Developer>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProfile/{devId}")
    public String developerService(@PathVariable (value = "devId") Integer devId){
        developerService.deleteDeveloper(devId);
        return "Blocked";
    }

    @GetMapping("/viewDeveloperStatus/{devId}")
    public String userVerify( @PathVariable (value = "devId") Integer devId ){

        Developer obj = developerRepository.getById(devId);
        if (obj.getTotalFeeds() >= 100) {
            return"Verified User";

        }
        else {
            return"Not a Verified User";
        }
    }

}
