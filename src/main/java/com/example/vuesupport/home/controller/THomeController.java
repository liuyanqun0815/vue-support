package com.example.vuesupport.home.controller;

import com.example.vuesupport.config.ResultData;
import com.example.vuesupport.home.entity.THome;
import com.example.vuesupport.home.service.impl.THomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lyq
 * @since 2020-01-27
 */
@RestController
@RequestMapping("/home")
public class THomeController {


    @Autowired
    THomeServiceImpl tHomeService;

    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public ResultData queryHomeList(){
//        List<THome> tHomes = tHomeService.queryHomeList();
        List<THome> tHomes = tHomeService.selectAll();

        return ResultData.success(tHomes);
    }

    @RequestMapping(value = "/queryByCondition",method = RequestMethod.POST)
    public List<THome> queryByCondition(@RequestBody THome json){
//        ValidatorUtils.validateEntity(json.toString(),THome.class);
        System.out.println((json));
        caculation(json);
       return tHomeService.queryByCondition(null);
    }
    private String caculation( THome home){
//        ValidatorUtils.validateEntity(home);

        return null;
    }

    @RequestMapping("/cachQueryById")
    public ResultData queryById(@RequestParam(name = "id")Integer id){
        System.out.println("-----queryId:"+id);
        return ResultData.success(tHomeService.queryById(id));
    }
//    @GetMapping("/cachQueryAll")
//    public Object queryFromCache(){
//        System.out.println("queryFromCache---");
//        return tHomeService.queryAllFromCach();
//    }
    @GetMapping("/updateById")
    @Transactional
    public Object updateById(@RequestParam Integer id){
        System.out.println("queryFromCache---");
        THome tHome = new THome();
        tHome.setId(id+1);
        tHome.setTel(101);
        tHomeService.updateById(tHome);
        tHome.setId(id);
        return tHomeService.updateById(tHome);
    }


}
