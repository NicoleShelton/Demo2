package com.example.demo2.agent.impl;

import com.example.demo2.agent.ItemAgent;
import com.example.demo2.dao.ItemDao;
import com.example.demo2.model.internal.Item;
import com.example.demo2.model.internal.User;
import com.example.demo2.model.internal.request.CreateItemRequest;
import com.example.demo2.model.internal.request.GetItemRequest;
import com.example.demo2.model.internal.request.GetSerialItemRequest;
import com.example.demo2.model.internal.response.CreateItemResponse;
import com.example.demo2.model.internal.response.GetItemResponse;
import com.example.demo2.model.internal.response.GetSerialItemResponse;
import com.example.demo2.service.UserService;
import com.example.demo2.utility.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

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
                    final ForkJoinPool threadPool = new ForkJoinPool(2);

                    final Future<User> createUserFuture;
                    final Future<User> expireUserFuture;

                    if(createUserId != null){
                        createUserFuture = threadPool.submit(new Callable<User>() {
                            @Override
                            public User call() throws Exception {
                                return userService.getUserById(createUserId);
                            }
                        });
                    } else {
                        createUserFuture = null;
                    }

                    if(expireUserId != null){
                        expireUserFuture = threadPool.submit(new Callable<User>() {
                            @Override
                            public User call() throws Exception {
                                return userService.getUserById(expireUserId);
                            }
                        });
                    } else {
                        expireUserFuture = null;
                    }

                    final User createUser = createUserFuture != null ? createUserFuture.get() : null;
                    final User expireUser = expireUserFuture != null ? expireUserFuture.get() : null;
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

    @Override
    public GetSerialItemResponse getSerialItem(GetSerialItemRequest request) {
        final GetSerialItemResponse response = new GetSerialItemResponse();
        try{
            final String serialItemIdString = request.getSerialNumber();
            final Long serialItemId = StringUtils.getLong(serialItemIdString);
            if(serialItemId != null) {
                final Item serialItem = itemDao.getSerialItemById(serialItemId);
                if(serialItem != null) {
                    final Long createUserId = serialItem.getCreateUserId();
                    final Long expireUserId = serialItem.getExpireUserId();
                    final ForkJoinPool threadPool = new ForkJoinPool(2);

                    final Future<User> createUserFuture;
                    final Future<User> expireUserFuture;

                    if(createUserId != null){
                        createUserFuture = threadPool.submit(new Callable<User>() {
                            @Override
                            public User call() throws Exception {
                                return userService.getUserById(createUserId);
                            }
                        });
                    } else {
                        createUserFuture = null;
                    }

                    if(expireUserId != null){
                        expireUserFuture = threadPool.submit(new Callable<User>() {
                            @Override
                            public User call() throws Exception {
                                return userService.getUserById(expireUserId);
                            }
                        });
                    } else {
                        expireUserFuture = null;
                    }

                    final User createUser = createUserFuture != null ? createUserFuture.get() : null;
                    final User expireUser = expireUserFuture != null ? expireUserFuture.get() : null;
                    final GetSerialItemResponse.User responseCreateUser = createUser == null ? null : new GetSerialItemResponse.User()
                            .setId(createUser.getId())
                            .setFistName(createUser.getFirstName())
                            .setLastName(createUser.getLastName());

                    final GetSerialItemResponse.User responseExpireUser = expireUser == null ? null : new GetSerialItemResponse.User()
                            .setId(expireUser.getId())
                            .setFistName(expireUser.getFirstName())
                            .setLastName(expireUser.getLastName());

                    final GetSerialItemResponse.Item responseSerialItem = new GetSerialItemResponse.Item()
                            .setCsn(serialItem.getCsn())
                            .setItemId(serialItem.getId())
                            .setSerialItemId(serialItem.getSerialItemId())
                            .setSerialNumber(serialItem.getSerialNumber())
                            .setDescription(serialItem.getDescription())
                            .setCreateUser(responseCreateUser)
                            .setExpireUser(responseExpireUser);

                    response.setItem(responseSerialItem);
                }
            }
        } catch (Exception e) {
            LOG.error("Error getting serial item information", e);
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
