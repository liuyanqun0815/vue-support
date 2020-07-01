package com.example.vuesupport.home.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vuesupport.home.entity.THome;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lyq
 * @since 2020-04-11
 */
public interface THomeMapper extends BaseMapper<THome> {

    List<THome> selectAll();


}
