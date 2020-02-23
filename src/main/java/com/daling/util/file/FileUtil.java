package com.daling.util.file;

import com.daling.platform.model.ResultVO;
import com.daling.platform.util.Jackson2Helper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @author tanhq
 * 文件上传下载
 */
public class FileUtil {

    static Logger log = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 文件下载
     * @param response
     * @param request
     * @param filePath
     */
    public static void downloadLocal(HttpServletResponse response, HttpServletRequest request, String filePath)  {
        try {
            // 下载本地文件
            String path = request.getSession().getServletContext().getRealPath(filePath);
            File file = new File(path);
            String fileName = file.getName();
            // 读到流中
            InputStream inStream = new FileInputStream(file);
            // 设置输出的格式
            response.reset();
            response.setContentType("bin");
            response.addHeader("Content-Type","application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(URLEncoder.encode(fileName,"UTF-8")));
            // 循环取出流中的数据
            byte[] b = new byte[100];
            int len;
            while ((len = inStream.read(b)) > 0){
                response.getOutputStream().write(b, 0, len);
            }
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传文件
     * @param request
     * @return
     */
    public static Map<String, Object> uploadFile(HttpServletRequest request) {
        Map<String, Object> result = Maps.newHashMap();
        ResultVO<String> resultVO = ResultVO.newResult();
        try {
            //创建解析器
            CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getServletContext());
            resolver.setDefaultEncoding("utf-8");
            resolver.setMaxUploadSize(5 * 1024 * 1024);
            MultipartHttpServletRequest multipart = resolver.resolveMultipart(request);
            MultipartFile contractFile = multipart.getFile("contractFile");
            if (contractFile == null) {
                result.put("success", false);
                result.put("message", "请选择要上传的文件");
                return result;
            }

            //上传图片
//            resultVO = ImgUploadUtils.uploadFile(contractFile);
            result.put("success", resultVO.isRetBool());
            result.put("message", resultVO.getMessage());
            result.put("data", resultVO.getT());
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "网络异常,请稍后再试");
        }
        log.info("uploadFile return={}",Jackson2Helper.toJsonString(result));
        return result;
    }

    /**
     * 将文件中的poiId用逗号拆分到一个list中
     * @param file
     * @return
     * @throws IOException
     */
    public static List<Long> fileUpload(MultipartFile file) throws IOException {

        InputStream inputStream = file.getInputStream();
        List<Long> poiList = Lists.newArrayList();
        BufferedReader reader = null;
        String str = null;
        try {
            //将字节流对象转换为字符流对象
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String[] strings = null;
            while ((str = reader.readLine()) != null){
                strings = str.split(",");
                for (String s : strings){
                    if (StringUtils.isNotEmpty(s) && StringUtils.isNotEmpty(s.trim())) {
                        Long poiId = Long.parseLong(s.trim());
                        poiList.add(poiId);
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        return poiList;
    }
}