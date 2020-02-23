package com.daling.controller;

import com.alibaba.fastjson.JSONObject;
import com.daling.util.common.CommonConstant;
import com.daling.util.file.FileUtil;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/job/temp")
public class ReadFileController {

    @RequestMapping(value = "/message")
    public void readFile(){
        //读取文件流对象InputStream
        InputStream in = ReadFileController.class.getResourceAsStream("/info/BuFaMessage.txt");
        BufferedReader reader = null;
        BufferedWriter writer = null;
        String str = null;
        try {
            //将字节流对象转换为字符流对象
            reader = new BufferedReader(new InputStreamReader(in));
            writer = new BufferedWriter(new FileWriter("userInfo.txt"));

            String[] strings = null;
            while ((str = reader.readLine()) != null){
                System.out.println(str);
                strings = str.split(",");
                writer.newLine();
                writer.write(str);
            }
            for (String s : strings){
                System.out.println(s.trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将文件中的poiId用逗号拆分到一个list中
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/fileUpload.do")
    public String fileUpload(MultipartFile file) throws IOException {

        //拆分到list中
        List<Long> poiList = FileUtil.fileUpload(file);
        if (!CollectionUtils.isEmpty(poiList)) {
            //然后进行具体的业务操作
            List<List<Long>> poiIdPartation = Lists.partition(poiList, CommonConstant.MAX_SIZE);
//            poiIdPartation.forEach(batchPoiIds -> poiService.deleteByIds(batchPoiIds));
            return "success";
        }
        return "false";
    }

    @RequestMapping(value = "/jsonString.do")
    public int jsonString(@RequestBody String jsonStr) throws IOException {

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        String poiListStr = (String) jsonObject.get("poiList");
        String[] strings = StringUtils.split(poiListStr, ",");
        List<Long> list = new ArrayList<>();
        for (String poi : strings) {
            if (StringUtils.isNotEmpty(poi) && StringUtils.isNotEmpty(poi.trim())) {
                list.add(Long.parseLong(poi.trim()));
            }
        }
        return list.size();
    }
}
