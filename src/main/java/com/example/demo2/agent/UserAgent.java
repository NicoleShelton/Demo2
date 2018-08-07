package com.example.demo2.agent;

import com.example.demo2.model.internal.request.GetUserRequest;
import com.example.demo2.model.internal.response.GetUserResponse;

public interface UserAgent {
    GetUserResponse getUserById(GetUserRequest request);
}
