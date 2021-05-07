package com.bingo.controller;

import com.bingo.dao.TMockTextDao;
import com.bingo.entity.ResultInfo;
import com.bingo.entity.TMockText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author:yaobin
 * @date:2021/4/26,12:04
 */

@RequestMapping("/mock")
@RestController
public class TestController {

    @Autowired
    private TMockTextDao mockTextDao;
    
    
    
    @GetMapping("/getTrack")
    public String getTrack(){
        String str = getString();
        return str;
    }

    private String getString() {
        String str = "aaa";
        return str;
    }


    @GetMapping("/get/{id}")
    public TMockText get(@PathVariable("id") Integer id){
        TMockText tMockText = mockTextDao.selectByPrimaryKey(id);
        return tMockText;
    }
    
    @GetMapping("/getAll")
    public List<TMockText> getAll(){
        List<TMockText> all = mockTextDao.getAll();
        return all;
    }

    @RequestMapping("/getJson/{id}")
    public String getJson(@PathVariable("id") Integer id){
        TMockText tMockText = mockTextDao.selectByPrimaryKey(id);
        return tMockText.getJsonData();
    }
    
    @PostMapping("/delete/{id}")
    public ResultInfo delete(@PathVariable("id") Integer id){
        ResultInfo resultInfo = new ResultInfo(true);
        try {
            int num = mockTextDao.deleteByPrimaryKey(id);
            if(num == 0){
                resultInfo.setState(false);
                resultInfo.setMessage("保存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo.setState(false);
            resultInfo.setMessage(e.getMessage());
        }
        return resultInfo;
    }
    
    @PostMapping("/insert")
    public ResultInfo insert(TMockText mockText){
        ResultInfo resultInfo = new ResultInfo(true);
        int insert = 0;
        try {
            insert = mockTextDao.insert(mockText);
            if(insert == 0){
                resultInfo.setState(false);
                resultInfo.setMessage("保存失败");
            }else {
                resultInfo.setMethodResult(mockText.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo.setState(false);
            resultInfo.setMessage(e.getMessage());
        }
        return resultInfo;
    }
    
    @PutMapping("/update")
    public ResultInfo update(TMockText mockText){
        ResultInfo resultInfo = new ResultInfo(true);
        try {
            int update = mockTextDao.updateByPrimaryKeySelective(mockText);
            if(update == 0){
                resultInfo.setState(false);
                resultInfo.setMessage("保存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo.setState(false);
            resultInfo.setMessage(e.getMessage());
        }
        return resultInfo;
    }
    
    @GetMapping("/getServer")
    public String getServer(HttpServletRequest request){
        String requestURI = request.getRequestURI();
        StringBuffer url = request.getRequestURL();
        return "uri:" + requestURI + "\n" +
                "url:" + url;
    }
}
