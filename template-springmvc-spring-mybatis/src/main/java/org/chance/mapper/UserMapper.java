package org.chance.mapper;

import org.apache.ibatis.annotations.Param;
import org.chance.domain.User;

import java.util.List;

/**
 * Created by wqg on 2015/12/10.
 */
public interface UserMapper {

    User find(@Param("id") long id);

    List<User> all();

    void save(@Param("user") User user);

}
