package com.example.demo2.agent.impl;

import com.example.demo2.agent.ItemAgent;
import com.example.demo2.dao.ItemDao;
import com.example.demo2.model.internal.Item;
import com.example.demo2.model.internal.User;
import com.example.demo2.model.internal.request.GetItemRequest;
import com.example.demo2.model.internal.response.GetItemResponse;
import com.example.demo2.service.UserService;
import com.example.demo2.utility.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Service
public class ItemAgentImpl implements ItemAgent{
    private static final Logger LOG = LoggerFactory.getLogger(ItemAgentImpl.class);

    @Resource
    private ItemDao itemDao;

    @Resource
    private UserService userService;

    @Override
    public GetItemResponse getItem(GetItemRequest request) {
        final GetItemResponse response = new GetItemResponse();
        try{
            final String itemIdString = request.getItemId();
            final Long itemId = StringUtils.getLong(itemIdString);
            if(itemId != null) {
                final Item item = itemDao.getItemById(itemId);
                if(item != null) {
                    final Long createUserId = item.getCreateUserId();
                    final Long expireUserId = item.getExpireUserId();
                    final User createUser = createUserId != null ? userService.getUserById(createUserId) : null;
                    final User expireUser = expireUserId != null ? userService.getUserById(expireUserId) : null;

                    final GetItemResponse.User responseCreateUser = createUser == null ? null : new GetItemResponse.User()
                            .setId(createUser.getId())
                            .setFistName(createUser.getFirstName())
                            .setLastName(createUser.getLastName());

                    final GetItemResponse.User responseExpireUser = expireUser == null ? null : new GetItemResponse.User()
                            .setId(expireUser.getId())
                            .setFistName(expireUser.getFirstName())
                            .setLastName(expireUser.getLastName());

                    final GetItemResponse.Item responseItem = new GetItemResponse.Item()
                            .setCsn(item.getCsn())
                            .setId(item.getId())
                            .setDescription(item.getDescription())
                            .setCreateUser(responseCreateUser)
                            .setExpireUser(responseExpireUser);

                    response.setItem(responseItem);
                }
            }
        } catch (Exception e) {
            LOG.error("Error getting item information", e);
        }

        return response;
    }
}
