package com.example.demo2.agent.imp;

import com.example.demo2.agent.UserAgent;
import com.example.demo2.api.UserController;
import com.example.demo2.model.internal.User;
import com.example.demo2.model.internal.request.GetUserRequest;
import com.example.demo2.model.internal.response.GetUserResponse;
import com.example.demo2.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class UserAgentImpl implements UserAgent{
    private static final Logger LOG = LoggerFactory.getLogger(UserAgentImpl.class);

    @Resource
    private UserService userService;

    @Override
    public GetUserResponse getUserById(GetUserRequest request) {
        final GetUserResponse response = new GetUserResponse();

        try {
            final User user = userService.getUserById(request.getId());
            if(user != null){
                final GetUserResponse.User user = new GetUserResponse.User()
                        .setFirstName(externalUser.getFirstName())
                        .setLastName(externalUser.getLastName())
                        .setId(externalUser.getId())
                        .setJobTitle(externalUser.getJobTitle())
                        .setLocationId(externalUser.getLocationId());
                response.setUser(user);
            }



            final RestTemplate restTemplate = new RestTemplate();
            final String url = "http://localhost:9999/user/get-by-id";
            final com.example.demo2.model.external.request.GetUserRequest externalGetUserRequest =
                    new com.example.demo2.model.external.request.GetUserRequest().setId(request.getId());

            final com.example.demo2.model.external.response.GetUserResponse externalGetUserResponse =
                    restTemplate.postForObject(url, externalGetUserRequest, com.example.demo2.model.external.response.GetUserResponse.class);

            if(externalGetUserResponse != null){
                final com.example.demo2.model.external.response.GetUserResponse.User externalUser =
                        externalGetUserResponse.getUser();

                final GetUserResponse.User user = new GetUserResponse.User()
                        .setFirstName(externalUser.getFirstName())
                        .setLastName(externalUser.getLastName())
                        .setId(externalUser.getId())
                        .setJobTitle(externalUser.getJobTitle())
                        .setLocationId(externalUser.getLocationId());
                response.setUser(user);
            }
        } catch (Exception e) {
            LOG.error("Error getting user data.", e);
        }

        return response;
    }
}
