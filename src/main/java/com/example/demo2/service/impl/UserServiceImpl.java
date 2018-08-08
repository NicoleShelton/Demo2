package com.example.demo2.service.impl;

import com.example.demo2.model.internal.User;
import com.example.demo2.model.internal.response.GetUserResponse;
import com.example.demo2.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public User getUserById(Long userId) {
        final String url = "http://localhost:9999/user/get-by-id";
        final com.example.demo2.model.external.request.GetUserRequest externalGetUserRequest =
                new com.example.demo2.model.external.request.GetUserRequest().setId(userId);

        final com.example.demo2.model.external.response.GetUserResponse externalGetUserResponse =
                restTemplate.postForObject(url, externalGetUserRequest, com.example.demo2.model.external.response.GetUserResponse.class);

        final User user;
        if(externalGetUserResponse != null) {
            final com.example.demo2.model.external.response.GetUserResponse.User externalUser =
                    externalGetUserResponse.getUser();
            if(externalUser != null) {
                user = new User()
                        .setFirstName(externalUser.getFirstName())
                        .setLastName(externalUser.getLastName())
                        .setId(externalUser.getId())
                        .setJobTitle(externalUser.getJobTitle())
                        .setLocationId(externalUser.getLocationId());
            } else {
                user = null;
            }
        } else {
            user = null;
        }
        return user;
    }
}
