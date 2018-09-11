package com.example.demo2.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import com.example.demo2.agent.SerialItemAgent;
import com.example.demo2.model.internal.request.GetSerialItemRequest;
import com.example.demo2.model.internal.response.GetSerialItemResponse;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value="/serial-item")
public class SerialItemController{

    @Resource
    private SerialItemAgent serialItemAgent;

    @RequestMapping(value="/get-serial-item",method= RequestMethod.POST)
    public GetSerialItemResponse getSerialItem(@RequestBody GetSerialItemRequest request){
            return serialItemAgent.getSerialItem(request);
            }
}