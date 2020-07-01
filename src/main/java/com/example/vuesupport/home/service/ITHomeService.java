package com.example.vuesupport.home.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vuesupport.home.entity.THome;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.cglib.core.internal.LoadingCache;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyq
 * @since 2020-01-27
 */
public interface ITHomeService extends IService<THome> {
    /**
     * 查询列表
     * @return
     */
    public List<THome> queryHomeList();


    public List<THome> selectAll();

    public List<THome> queryByCondition(JSONObject jsonObject);

    public THome queryById(Integer id);

//    public LoadingCache<String, String> queryAllFromCach();
}
