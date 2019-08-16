package com.qianfeng.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qianfeng.baiduapi.AdvancedGeneral;
import com.qianfeng.vo.GarbageInfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("fileupload")
public class FileUpAndDown {

    @RequestMapping("upload")
    @ResponseBody
    public Object fileUpload(MultipartFile dropzFile, HttpServletRequest request){
        System.out.println("upload..........");
        HashMap<String, String> stringObjectHashMap = new HashMap<String, String>();
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
         if(!file.exists()) {
             file.mkdirs();
         }
        // 获取到上传文件的名称
         String filename = dropzFile.getOriginalFilename();
         String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        // 把文件的名称唯一化
         filename = uuid+"_"+filename;
        // 上传文件
        File file1 = new File(file, filename);
        try {
            dropzFile.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("filename",file1.toString());
        return  hashMap;
    }

    @RequestMapping("garbageDiscernController")
    @ResponseBody
    public Map<String, Object> garbageDiscernController(MultipartFile dropzFile, HttpServletRequest request) throws IOException {
        System.out.println("inner upload");
        Map<String, Object> result = new HashMap<String, Object>();

        //创建文件需要存储的路径
        String destPathName = request.getSession().getServletContext().getRealPath("/uploads");
        File destPath = new File(destPathName);
        //获取文件的后缀名
        String fileSuffix = dropzFile.getOriginalFilename().substring(dropzFile.getOriginalFilename().lastIndexOf("."));
        String destFileName = UUID.randomUUID()+fileSuffix;
        File destFile = new File(destPath,destFileName);
        if(!destFile.exists()){
            destFile.createNewFile();
        }
        dropzFile.transferTo(destFile);
        String resultStr = AdvancedGeneral.advancedGeneral(destFile.getAbsolutePath());
        result.put("status",200);
        //将json字符串转对象
        Gson gson = new Gson();
        Object o = gson.fromJson(resultStr, new TypeToken<GarbageInfoVO>() {
        }.getType());
        result.put("resultObj",o);
        result.put("filePath",destFile);
        return result;
    }

    //版本1
}
