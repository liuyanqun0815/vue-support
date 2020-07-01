package com.example.vuesupport.user.mapper;

import com.example.vuesupport.user.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lyq
 * @since 2020-04-19
 */
public interface TUserMapper extends BaseMapper<TUser> {
    public TUser login(@Param("username")String username,@Param("password")String password);

    public TUser getUserByToken(@Param("token")String token);
}
