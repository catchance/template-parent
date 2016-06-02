//package org.chance.repository;
//
//import com.google.inject.Inject;
//import org.chance.domain.User;
//import org.chance.mapper.UserMapper;
//import org.mybatis.guice.transactional.Transactional;
//
//import java.util.List;
//
///**
// * Created by wqg on 2015/12/10.
// */
//public class UserRepository {
//    @Inject
//    UserMapper userMapper;
//
//    @Transactional
//    public User find(long id) {
//        return userMapper.find(id);
//    }
//
//    @Transactional
//    public List<User> all() {
//        return userMapper.all();
//    }
//
//    @Transactional
//    public User createUser(User user) {
//        userMapper.save(user);
//        return user;
//    }
//}
