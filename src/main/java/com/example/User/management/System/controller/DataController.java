package com.example.User.management.System.controller;

import com.example.User.management.System.Entity.Data;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class DataController {
    private List<Data> myData;

    public DataController() {

        myData = new ArrayList<>();
    }

    @GetMapping("datas")
    public List<Data> getAllData(){

        return myData;
    }

    @PostMapping("data")
    public String addData(@RequestBody Data data){
        myData.add(data);
        return "Data added successful";
    }
    @PutMapping("data/{userId}")
    public String markData(@PathVariable Integer userId,@RequestBody Data data){
        for (Data myDatas : myData){
            if(myDatas.getUserId().equals(userId)){
                myDatas.setName(data.getName());
                myDatas.setUserName(data.getUserName());
                myDatas.setAddress(data.getAddress());
                myDatas.setNumber(data.getNumber());
                return "User information is updated";
            }
        }
        return "UserId is not found" + userId;
    }
    @DeleteMapping("data")
    public String removeData(@RequestParam Integer userId){
        for(Data myDatas : myData){
            if(myDatas.getUserId().equals(userId)){
                myData.remove(myDatas);
                return "Data removed for UserId" + userId;
            }
        }
        return "Userid :" + userId + "is not found";
    }

}
