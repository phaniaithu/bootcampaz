package com.example.demo.controller;

import com.example.demo.model.Developer;
import com.example.demo.model.Response;
import com.example.demo.repositories.ResponseRepository;
import com.example.demo.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/response")
public class ResponseController {
    @Autowired
    ResponseRepository responseRepository;
    @Autowired
    ResponseService responseService;

    @GetMapping("/test")
    public String test() {
        return "Response!";
    }

    @RequestMapping("/responseService/{respId}")
    public ResponseEntity <Response> getResponseByFeedId(@PathVariable (value = "respId") Integer respId){
        Response response = responseRepository.getById(respId);
        if(response!=null) {
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        else {
            return	new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

        }
    }
    /*@RequestMapping("/responseByDevId/{devId}")
    public ResponseEntity <Response> getResponseByDevId(@PathVariable (value = "devId") Integer devId){
        Response response = responseRepository.getById(devId);
        if(response!=null) {
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        else {
            return	new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

        }
    }
    @RequestMapping("/responseByFeedId/{feedId}")
    public ResponseEntity <Response> getResponseById(@PathVariable (value = "feedId") Integer feedId){
        Response response = responseRepository.getById(feedId);
        if(response!=null) {
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        else {
            return	new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

        }
    }*/

    @PutMapping("/responseService/Update")
    public ResponseEntity<Response> update(@RequestBody Response obj){
        responseService.updateResponse(obj, obj.getRespId());
        return new ResponseEntity<Response>(obj, HttpStatus.OK);
    }
    @PostMapping("/responseService/newResponse")
    public ResponseEntity <Response> save(@RequestBody Response obj){
        responseService.saveResponse(obj);
        return new ResponseEntity<Response>(obj, HttpStatus.OK);
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

}
