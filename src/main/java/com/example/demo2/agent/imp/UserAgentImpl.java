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
                final GetUserResponse.User responseUser = new GetUserResponse.User()
                        .setFirstName(user.getFirstName())
                        .setLastName(user.getLastName())
                        .setId(user.getId())
                        .setJobTitle(user.getJobTitle())
                        .setLocationId(user.getLocationId());
                response.setUser(responseUser);
            }
        } catch (Exception e) {
            LOG.error("Error getting user data.", e);
        }

        return response;
    }
}
