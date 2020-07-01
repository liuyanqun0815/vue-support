package com.example.vuesupport.user.service;

import com.example.vuesupport.user.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyq
 * @since 2020-04-19
 */
public interface ITUserService extends IService<TUser> {

    public TUser login(String username,String password);

    public TUser getUserByToken(String token);
}
