package com.example.vuesupport.home.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.vuesupport.home.entity.THome;
import com.example.vuesupport.home.mapper.THomeMapper;
import com.example.vuesupport.home.service.ITHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cglib.core.internal.LoadingCache;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lyq
 * @since 2020-01-27
 */
@Service("tHomeService")
public class THomeServiceImpl extends ServiceImpl<THomeMapper, THome> implements ITHomeService {

    @Autowired
    THomeMapper tHomeMapper;

//    private LoadingCache<String, String> allHome;


    @Override
    public List<THome> queryHomeList() {
        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("address","曲周县");
        List<THome> list = this.list(queryWrapper);
        return list;
    }


    @Override
    public List<THome> selectAll() {

        return tHomeMapper.selectAll();
    }

    @Override
//    @DS("slave")
    public List<THome> queryByCondition(JSONObject jsonObject) {
        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("address","曲周县");

        List<THome> list = this.list(queryWrapper);
        return list;
    }

    @Cacheable(value = "tHome", key = "#id")
    @Override
    public THome queryById(Integer id) {
        System.out.println("queryId:" + id);
        return tHomeMapper.selectById(id);
    }

//    @Override
//    public LoadingCache<String, String> queryAllFromCach() {
//        System.out.println("service----");
////        LoadingCache<String, String> build = CacheBuilder.newBuilder().maximumSize(1000).refreshAfterWrite(10, TimeUnit.SECONDS).build(
////                new CacheLoader<String, String>() {
////                    @Override
////                    public String load(String s) throws Exception {
////                        System.out.println("--------------------");
////                        return JSON.toJSONString(tHomeMapper.selectAll());
////                    }
////                });
//
//        if (allHome == null) {
//            allHome = CacheBuilder.newBuilder()
//                    .maximumSize(10000).refreshAfterWrite(10, TimeUnit.SECONDS)
//                    .build(new CacheLoader<String, String>() {
//                        @Override
//                        public String load(String id) {
//                            System.out.println("----load---------");
//                            return JSON.toJSONString(tHomeMapper.selectAll());
//                        }
//
//                    });
//        }
//        return allHome;
//    }


}
