package com.example.demo2.agent.impl;

import com.example.demo2.service.UserService;
import com.example.demo2.utility.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

import com.example.demo2.agent.SerialItemAgent;
import com.example.demo2.dao.SerialItemDao;
import com.example.demo2.model.internal.SerialItem;
import com.example.demo2.model.internal.User;
import com.example.demo2.model.internal.request.GetSerialItemRequest;
import com.example.demo2.model.internal.response.GetSerialItemResponse;


@Service
public class SerialItemAgentImpl implements SerialItemAgent{
    private static final Logger LOG=LoggerFactory.getLogger(SerialItemAgentImpl.class);

    @Resource
    private SerialItemDao serialItemDao;

    @Resource
    private UserService userService;

    @Override
    public GetSerialItemResponse getSerialItem(GetSerialItemRequest request){
        final GetSerialItemResponse response = new GetSerialItemResponse();
        try{
            final String serialNumString = request.getSerialNumber();
            final Long serialItemNum = StringUtils.getLong(serialNumString);
            if(serialItemNum!=null){
                final SerialItem serialItem = serialItemDao.getSerialItemBySerialNum(serialItemNum);
                if(serialItem!=null){
                    final Long createUserId = serialItem.getCreateUserId();
                    //finalLongexpireUserId=serialItem.getExpireUserId();
                    final ForkJoinPool threadPool = new ForkJoinPool(2);

                    final Future<User> createUserFuture;
                    //finalFuture<User>expireUserFuture;

                    if(createUserId!=null){
                        createUserFuture = threadPool.submit(new Callable<User>() {
                            @Override
                            public User call() throws Exception {
                                return userService.getUserById(createUserId);
                            }
                        });
                    }else{
                        createUserFuture = null;
                    }

                    //if(expireUserId!=null){
                    //expireUserFuture=threadPool.submit(newCallable<User>(){
                    //@Override
                    //publicUsercall()throwsException{
                    //returnuserService.getUserById(expireUserId);
                    //}
                    //});
                    //}else{
                    //expireUserFuture=null;
                    //}

                    final User createUser = createUserFuture!=null?createUserFuture.get():null;
                    //finalUserexpireUser=expireUserFuture!=null?expireUserFuture.get():null;
                    final GetSerialItemResponse.User responseCreateUser = createUser == null ? null: new GetSerialItemResponse.User()
                            .setId(createUser.getId())
                            .setFistName(createUser.getFirstName())
                            .setLastName(createUser.getLastName());

                    //finalGetSerialItemResponse.UserresponseExpireUser=expireUser==null?null:newGetSerialItemResponse.User()
                    //.setId(expireUser.getId())
                    //.setFistName(expireUser.getFirstName())
                    //.setLastName(expireUser.getLastName());

                    final GetSerialItemResponse.SerialItem responseSerialItem =new GetSerialItemResponse.SerialItem()
                            .setCsn(serialItem.getCsn())
                            .setItemId(serialItem.getId())
                            .setSerialItemId(serialItem.getSerialItemId())
                            .setSerialNumber(serialItem.getSerialNumber())
                            .setDescription(serialItem.getDescription())
                            .setCreateUser(responseCreateUser);
                    //.setExpireUser(responseExpireUser);

                    response.setSerialItem(responseSerialItem);
                }
            }
        }catch(Exception e){
            LOG.error("Error getting serial item information",e);
        }

        return response;
    }
}