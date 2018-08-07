package com.example.demo2.api;

import com.example.demo2.agent.ItemAgent;
import com.example.demo2.model.internal.request.GetItemRequest;
import com.example.demo2.model.internal.response.GetItemResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/item")
public class ItemController {
    @Resource
    private ItemAgent itemAgent;

    @RequestMapping(value = "/get-item", method = RequestMethod.POST)
    public GetItemResponse getItem(@RequestBody GetItemRequest request) {
        return itemAgent.getItem(request);
    }
}
