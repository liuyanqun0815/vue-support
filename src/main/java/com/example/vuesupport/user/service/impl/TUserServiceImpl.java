package com.example.vuesupport.user.service.impl;

import com.example.vuesupport.user.entity.TUser;
import com.example.vuesupport.user.mapper.TUserMapper;
import com.example.vuesupport.user.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lyq
 * @since 2020-04-19
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

    @Autowired
    TUserMapper tUserMapper;

    @Override
    public TUser login(String username,String password) {
        TUser user = tUserMapper.login(username,password);
        return user;
    }

    @Override
    public TUser getUserByToken(String token) {

        return tUserMapper.getUserByToken(token);
    }
}
