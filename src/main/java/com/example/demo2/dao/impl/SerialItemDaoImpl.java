package com.example.demo2.dao.impl;

import org.springframework.stereotype.Repository;
import javax.annotation.Resource;

import com.example.demo2.dao.SerialItemDao;
import com.example.demo2.model.internal.SerialItem;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class SerialItemDaoImpl implements SerialItemDao{

    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public SerialItem getSerialItemBySerialNum(Long serialNumber){
            final String sql = "" +
                " SELECT  serial_number, serial_item_id, item_id, csn, description, create_user_id, create_date " +
                " FROM serial_item " +
                " WHERE serial_number = :serial_number";

            final MapSqlParameterSource parameterSource = new MapSqlParameterSource()
            .addValue("serial_number", serialNumber);

            return namedParameterJdbcTemplate.query(sql, parameterSource, new ResultSetExtractor<SerialItem>(){
                @Override
                public SerialItem extractData(ResultSet rs)throws SQLException, DataAccessException{
                    final SerialItem serialItem;
                    if(rs.next()){
                        //finalStringexpireUserIdString=rs.getString("expire_user_id");
                        serialItem = new SerialItem()
                        .setSerialItemId(rs.getLong("serial_item_id"))
                        .setId(rs.getLong("item_id"))
                        .setSerialNumber(rs.getString("serial_number"))
                        .setCsn(rs.getString("csn"))
                        .setDescription(rs.getString("description"))
                        .setCreateUserId(rs.getLong("create_user_id"));
                        //.setExpireUserId(StringUtils.getLong(expireUserIdString));
                    }else{
                        serialItem = null;
                    }
                return serialItem;
            }
            });
            }
}