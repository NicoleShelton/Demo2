package com.example.demo2.api;

import com.example.demo2.agent.UserAgent;
import com.example.demo2.model.internal.request.GetUserRequest;
import com.example.demo2.model.internal.response.GetUserResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserAgent userAgent;

    @RequestMapping(value = "/get-by-id", method = RequestMethod.POST)
    public GetUserResponse getById(@RequestBody GetUserRequest request) {
        return userAgent.getUserById(request);
    }
}



