package com.example.demo.service;

import com.example.demo.model.Response;
import com.example.demo.repositories.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service
public class ResponseServiceImpl implements ResponseService{

    @Autowired
    ResponseRepository responseRepository;

    @Override
    public List<Response> fetchAllResponses() {
        return responseRepository.findAll();
    }

    @Override
    public Response saveResponse(Response resp) {
        return responseRepository.save(resp);
    }

    @Override
    public Response updateResponse(Response obj, int respId) {
        Response response = new Response();
        response.setRespId(obj.getRespId());
        response.setAccuracy(obj.getAccuracy());
        response.setAnswer(obj.getAnswer());
        response.setRespDate(obj.getRespDate());
        responseRepository.save(response);
        return responseRepository.save(response);
    }

    @Override
    public void removeResponse(int respId) {
         responseRepository.deleteById(respId);
    }

    @Override
    public List<Response> getResponseByFeed(int feedId) {

        List<Response> responses = responseRepository.findAll();
        List<Response> result = new ArrayList<>();
        for(Response resp: responses) {
            if(resp.getFeedId() == feedId) {
                result.add(resp);
            }
        }
        return result;
    }
    @Override
    public List<Response> getResponseByDeveloper(int devId)  {
        List<Response> responses = responseRepository.findAll();
        List<Response> result = new ArrayList<>();
        for(Response resp: responses) {
            if(resp.getDevId() == devId) {
                result.add(resp);
            }
        }
        return result;
    }


}
