package com.zmy.demo.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zmy.demo.TimeUtil;
import com.zmy.demo.pojo.House;
import com.zmy.demo.pojo.Message;
import com.zmy.demo.service.HouseService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Key;
import java.time.Instant;
import java.util.*;

/**
 * @author Sam  Email:superdouble@yeah.net
 * @Description
 * @create 2022-04-28 20:19
 */
@RestController
public class HouseController {
    @Autowired
    private HouseService houseService;

    @GetMapping("/houses")
    @ResponseBody
    public Message getHouseList(@RequestParam(value = "page",defaultValue = "1")Integer page){
        // 传入查询的页码，以及每页战展示的条数
        PageHelper.startPage(page,1);
        // 查询
        List<House> houses = houseService.getAllHouse();
        // 使用pageInfo封装
        PageInfo pageInfo = new PageInfo(houses,5);
        return Message.success().add("pageInfo",pageInfo);
    }


    @PostMapping("/house")
    @ResponseBody
    public Message AddHouse(@RequestParam("file")MultipartFile file,HttpServletRequest request) throws IOException {
        // 上传文件返回文件最终路径
        String imagePath = upload(file, request.getSession());
        String houseInfo = request.getParameter("house");
        // 将houseInfo解析成
//        key = hdistrict,harea,hair,hdir,"haddress,hprice,hfurniture,hno,hroomnum,hdeco,hrentstatus,hfulladdress
//        value = 1,1,2,1,1,1,1,1,1,1,0,1"
        House house = parseHouseInfo(houseInfo, imagePath);
        houseService.addHouse(house);


        return Message.success();
    }

    /**
     * 解析收到的表单数据
     * @param houseInfo
     * @param img
     * @return
     */
    public House parseHouseInfo(String houseInfo,String img){
        Map<String,String> map = new HashMap();
        houseInfo = houseInfo.substring(1,houseInfo.length()-1);
        String[] strs = houseInfo.split("&");
        for (String str : strs) {
            String[] param = str.split("=");
            map.put(param[0],param[1]);
        }
        House house = new House();
        Set<String> set = map.keySet();
        for (String o : set) {
            house = dynamicSet(house, o, map.get(o));
        }
        dynamicSet(house,"himage",img.substring(img.lastIndexOf("\\")+1));
        System.out.println("house = " + house);
        return house;
    }
    /**
     * @description:根据属性名调用set方法
     * @param house 对象
     * @param propertyName 属性名
     * @param qtySum 要插入的值
     */
    private House dynamicSet(House house,String propertyName, String qtySum){
        try {
            Class<?> aClass = Class.forName(House.class.getName());
            String paramType = String.valueOf(aClass.getDeclaredField(propertyName));
            if (paramType.contains("Integer")){
                Integer num = Integer.parseInt(qtySum);
                Field field  = house.getClass().getDeclaredField(propertyName);
                field.setAccessible(true);
                field.set(house, num);
            }else if (paramType.contains("Double")){
                Double d = Double.parseDouble(qtySum);
                Field field  = house.getClass().getDeclaredField(propertyName);
                field.setAccessible(true);
                field.set(house, d);
            }else {
                Field field  = house.getClass().getDeclaredField(propertyName);
                field.setAccessible(true);
                field.set(house, qtySum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return house;
    }

    /**
     * 存储文件
     * @param file
     * @param session
     * @return  返回文件全路径
     */
    public String upload(MultipartFile file,HttpSession session) {
        if (file.isEmpty()){
            System.out.println("文件为空");
        }else {
            // 获取上传文件的文件名
            String filename = file.getOriginalFilename();
            // 解决文件的重名问题
            // 获取上传文件的后缀名
            String suffixName = filename.substring(filename.lastIndexOf("."));
            // 最终的文件名
            filename = UUID.randomUUID().toString().replaceAll("-","") + suffixName;
            ServletContext servletContext = session.getServletContext();
            // 通过servletContext获取服务器中photo目录的路径
            String path = servletContext.getRealPath("photo");
            File filePath = new File(path);
            // 判断路径是否存在
            if (!filePath.exists()){
                // 不存在创建文件目录
                filePath.mkdir();
            }
            // 最终路径
            String finalPath = path+File.separator+filename;
            // 处理文件重名问题
            try {
                file.transferTo(new File(finalPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            session.setAttribute("fileName",filename);
            return finalPath;
        }
        return null;
    }

    /**
     * 上传图片
     * @param file
     * @param model
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping("/house/upload/image")
    @ResponseBody
    public Message UploadImage(@RequestParam("himage") MultipartFile file, Model model, HttpSession session) throws IOException {
        if (file.isEmpty()){
            System.out.println("文件为空");
        }else {
            // 获取上传文件的文件名
            String filename = file.getOriginalFilename();
            // 解决文件的重名问题
            // 获取上传文件的后缀名
            String suffixName = filename.substring(filename.lastIndexOf("."));
            // 最终的文件名
            filename = UUID.randomUUID().toString().replaceAll("-","") + suffixName;
            ServletContext servletContext = session.getServletContext();
            // 通过servletContext获取服务器中photo目录的路径
            String path = servletContext.getRealPath("photo");
            File filePath = new File(path);
            // 判断路径是否存在
            if (!filePath.exists()){
                // 不存在创建文件目录
                filePath.mkdir();
            }
            // 最终路径
            String finalPath = path+File.separator+filename;
            // 处理文件重名问题
            file.transferTo(new File(finalPath));
            session.setAttribute("fileName",filename);
            return Message.success();
        }
        return Message.fail();
    }

    /**
     * 通过id查询房源
     * @param hid
     * @return
     */
    @GetMapping("/house/{hid}")
    @ResponseBody
    public Message getHouseById(@PathVariable("hid")Integer hid){
        House house = houseService.getHouseByid(hid);
        return Message.success().add("house",house);
    }

    /**
     * 修改房源
     * @param hid
     * @param house
     * @return
     */
    @PutMapping("/house/{hid}")
    @ResponseBody
    public Message updateHouseInfo(@PathVariable("hid")Integer hid,House house){
        house.setHid(hid);
        int num = houseService.updateHouse(house);
        if (num==1){
            return Message.success();
        }
        return Message.fail();
    }

    @GetMapping("/house")
    @ResponseBody
    public Message SerchHouseByparam(String serch){

        List<House> list = houseService.serchHouseByparam(serch);
        return Message.success().add("houses",list);
    }
    

}
