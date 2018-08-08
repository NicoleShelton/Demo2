package com.example.demo2.agent.impl;

import com.example.demo2.agent.ItemAgent;
import com.example.demo2.dao.ItemDao;
import com.example.demo2.model.internal.Item;
import com.example.demo2.model.internal.User;
import com.example.demo2.model.internal.request.CreateItemRequest;
import com.example.demo2.model.internal.request.GetItemRequest;
import com.example.demo2.model.internal.response.CreateItemResponse;
import com.example.demo2.model.internal.response.GetItemResponse;
import com.example.demo2.service.UserService;
import com.example.demo2.utility.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public CreateItemResponse createItem(CreateItemRequest request) {
        final CreateItemResponse response = new CreateItemResponse();
        final List<String> errors = response.getErrors();
        try{
            final String csn = request.getCsn();
            final String description = request.getDescription();
            final Long userId = request.getUserId();

            validatecreateItemRequest(csn, description, userId, errors);

            if(errors.isEmpty()) {
                final Long itemId = itemDao.getItemIdNextValue();
                final boolean insertSuccess =  itemDao.createItem(itemId, csn, description, userId);
                if(insertSuccess) {
                    final Item item = itemDao.getItemById(itemId);
                    final CreateItemResponse.Item responseItem = new CreateItemResponse.Item()
                            .setCsn(item.getCsn())
                            .setDescription(item.getDescription())
                            .setId(item.getId());

                    response.setItem(responseItem);
                }
            }

        } catch (Exception e){
            errors.add("Error adding item: " + e.getMessage());
            LOG.error("Error creating item.", e);
        } finally {
            response.setSuccess(errors.isEmpty());
        }

        return response;
    }

    private void validatecreateItemRequest(String csn, String description, Long userId, List<String> errors) {
        if(StringUtils.isEmpty(csn)) {
            errors.add("CSN is required and cannot be empty.");
        }
        if(StringUtils.isEmpty(description)) {
            errors.add("Description is required and cannot be empty.");
        }
        if(userId == null) {
            errors.add("UserId is required and must be a number.");
        } else {
            final User user = userService.getUserById(userId);
            if(user == null || user.getId() == null) {
                errors.add("userId " + userId + " was not found. Please provide a valid user Id");
            }
        }
    }
}
