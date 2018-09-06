package com.example.demo2.dao.impl;

import com.example.demo2.dao.ItemDao;
import com.example.demo2.model.internal.Item;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ItemDaoImpl implements ItemDao {

    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Item getItemById(Long id) {
        final String sql = "" +
                " SELECT  item_id, csn, description, create_user_id, create_date, expire_user_id, expire_date " +
                " FROM item " +
                " WHERE item_id = :item_id";

        final MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("item_id", id);

        return namedParameterJdbcTemplate.query(sql, parameterSource, new ResultSetExtractor<Item>() {
            @Override
            public Item extractData(ResultSet rs) throws SQLException, DataAccessException {
                final Item item;
                if(rs.next()) {
                    final String expireUserIdString = rs.getString("expire_user_id");
                    final Long expireUserId = expireUserIdString != null ? Long.valueOf(expireUserIdString) : null;
                    item = new Item()
                            .setId(rs.getLong("item_id"))
                            .setCsn(rs.getString("csn"))
                            .setDescription(rs.getString("description"))
                            .setCreateUserId(rs.getLong("create_user_id"))
                            .setCreateDate(rs.getTimestamp("create_date"))
                            .setExpireUserId(expireUserId)
                            .setExpireDate(rs.getTimestamp("expire_date"));
                } else {
                    item = null;
                }
                return item;
            }
        });
    }

    @Override
    public Long getItemIdNextValue() {
        final String sql ="SELECT item_id_seq.NEXTVAL As nextvalue FROM dual";
        
        
        return namedParameterJdbcTemplate.query(sql, EmptySqlParameterSource.INSTANCE, new ResultSetExtractor<Long>() {
            @Override
            public Long extractData(ResultSet rs) throws SQLException, DataAccessException {
                return rs.next() ? rs.getLong("nextvalue") : null;
            }
        });
    }

    @Override
    public boolean createItem(Long itemId, String csn, String description, Long createUserId) {
        final String sql = "" +
                "INSERT INTO item ( " +
                "  item_id, " +
                "  csn, " +
                "  description, " +
                "  create_user_id " +
                ") VALUES ( " +
                "  :itemId, " +
                "  :csn, " +
                "  :description, " +
                "  :createUserId " +
                ");";

        final MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("itemId", itemId)
                .addValue("csn", csn)
                .addValue("description", description)
                .addValue("createUserId", createUserId);

        return namedParameterJdbcTemplate.update(sql, parameterSource) == 1;
    }
}
