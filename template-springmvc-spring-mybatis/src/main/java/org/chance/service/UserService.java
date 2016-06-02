package org.chance.service;

import org.chance.domain.UserEntity;
import org.chance.mapper.UserEntityMapper;
import org.chance.utils.Base58;
import org.chance.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-12-15
 * <p>Version: 1.0
 */

@Service
public class UserService {

    @Autowired
    UserEntityMapper userEntityMapper;

    public String addUser(UserEntity userEntity){
        userEntity.setId(UUIDUtils.base58Uuid());
        userEntityMapper.insertSelective(userEntity);
        return userEntity.getId();
    }


}
