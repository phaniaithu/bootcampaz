package com.example.demo.service;

import com.example.demo.model.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResponseService {
    List<Response> fetchAllResponses();
    Response saveResponse(Response resp);

    Response updateResponse(Response obj, int respId);

    void removeResponse(int respId) ;

    public List<Response> getResponseByFeed(int feedId);
    public List<Response> getResponseByDeveloper(int devId);

}
