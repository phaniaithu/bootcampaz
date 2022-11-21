package com.example.demo.controller;

import com.example.demo.exception.UnknownDeveloperException;
import com.example.demo.model.Developer;
import com.example.demo.model.DeveloperPayload;
import com.example.demo.model.Feed;
import com.example.demo.model.Response;
import com.example.demo.repositories.DeveloperRepository;
import com.example.demo.repositories.FeedRepository;
import com.example.demo.repositories.ResponseRepository;
import com.example.demo.service.DeveloperService;
import java.util.List;

import com.example.demo.service.FeedService;
import com.example.demo.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ResponseRepository responseRepository;

    @Autowired
    ResponseService responseService;
    @Autowired
    DeveloperService developerService;

    @Autowired
    DeveloperRepository developerRepository;

    @Autowired
    FeedRepository feedRepository;

    @Autowired
    FeedService feedService;

    @GetMapping("/test")
    public String test() {
        return "Admin!!!!!";
    }

    @RequestMapping("/developerService/{devId}")
    public ResponseEntity <Developer> getDeveloperbyId(@PathVariable (value = "devId") Integer devId){
       Developer developer = developerRepository.getById(devId);
        if(developer!=null) {
            return new ResponseEntity<>(developer,HttpStatus.OK);
        }
        else {
            return	new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/developerService/newDeveloper")
    public ResponseEntity <Developer> save(@RequestBody Developer obj){
        developerService.saveDeveloper(obj);
        return new ResponseEntity<Developer>(obj, HttpStatus.OK);
    }

    @PutMapping("/developerService/Update")
    public ResponseEntity <Developer> update(@RequestBody Developer obj){
        developerService.updateDeveloper(obj, obj.getDevId());
        return new ResponseEntity<Developer>(obj, HttpStatus.OK);
    }

    @GetMapping("/developerService")
    public List<Developer> getAllDevelopers() {
        return developerService.fetchAllDevelopers();
    }

    @DeleteMapping("/deleteDeveloperService/{devId}")
    public String developerService(@PathVariable (value = "devId") Integer devId){
        developerService.deleteDeveloper(devId);
        return "Blocked";
    }

    @GetMapping("/developerService/verified/{devId}")
    public String userVerify( @PathVariable (value = "devId") Integer devId ){

        Developer obj = developerRepository.getById(devId);
        if (obj.getTotalFeeds() >= 100) {
            return"Verified User";

        }
        else {
            return"Not a Verified User";
        }
    }
    @GetMapping("/responseService")
    public List<Response> getAllResponse() {
        return responseService.fetchAllResponses();
    }

    @DeleteMapping("/deleteResponse/{respId}")
    public String deleteResponse(@PathVariable (value = "respId") Integer respId){
        responseService.removeResponse(respId);
        return "Removed Response!";
    }

    @RequestMapping("/responseByDevId/{devId}")
    public List<Response> getResponseByDeveloper(@PathVariable(value = "devId") Integer devId) {

        return responseService.getResponseByDeveloper(devId);
    }
    @RequestMapping("/responseByFeedId/{feedId}")
    public List<Response> getResponseByFeed(@PathVariable(value = "feedId") Integer feedId){

        return responseService.getResponseByFeed(feedId);
    }
    @GetMapping("/allUsers")
    public List<Feed> getAllFeed() {
        return feedService.fetchAll();
    }
    @RequestMapping("/getByFeedId/{feedId}")
    public ResponseEntity<Feed> findById(@PathVariable(value = "feedId") Integer feedId){
        Feed feed = feedRepository.getById(feedId);
        if(feed!=null) {
            return new ResponseEntity<>(feed, HttpStatus.OK);
        }
        else {
            return	new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/getFeed/dev/{devId}")
    public List<Feed> getFeedByDeveloper(@PathVariable(value = "devId") Integer devId) throws UnknownDeveloperException {

        return feedService.getFeedsByDeveloper(devId);
    }
}
