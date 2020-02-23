package com.daling.controller;

import com.alibaba.fastjson.JSON;
import com.daling.bean.Student;
import com.daling.bean.User;
import com.daling.util.DataSecureUtil;
import com.daling.util.DeadLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.*;

/**
 * @RestController = @Controller + @ResponseBody
 */
@RestController
@RequestMapping(path = "/index")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    /**
     * 先去resources下的application.yaml找，然后去resources下的config下的application.yaml找
     */
    @Value(value = "${roncoo.secret}")
    private String secret;

    @Value(value = "${roncoo.number}")
    private Integer number;

    /**
     * 冒号后面是默认值，从配置文件中取不到值就取默认值，取到了就不用默认值
     */
    @Value(value = "${roncoo.name:rick,libai}")
    private String name;

    @Value(value = "${roncoo.desc: tanhq is a hero}")
    private String desc;

    /**
     * http://localhost:8080/index/hello
     * @return
     */
    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello world!";
    }

    /**
     * http://localhost:8080/index/jvm-info
     * @return
     */
    @RequestMapping(value = "/jvm-info")
    public String info(){
        List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();
        StringBuilder sb = new StringBuilder();
        for (GarbageCollectorMXBean bean : list) {
            sb.append(bean.getName() + "\n");
        }
        return sb.toString();
    }

    /**
     * http://localhost:8080/index/param
     * @return
     */
    @RequestMapping(value = "/param")
    public String param(){
        int i = 0;
        while (true) {
            i++;
            System.out.println(i);
        }
    }

    /**
     * http://localhost:8080/index/safe
     */
    @RequestMapping(value = "/safe")
    public String safe(){
        for (int i = 0; i < 10000; i++) {
            Student student = new Student();
            student.setName("tanhq" + i);
            System.out.println(System.currentTimeMillis() + "---------------------" + i);
        }
        return "safe";
    }

    /**
     * http://localhost:8080/index/object
     */
    @RequestMapping(value = "/object")
    public String object(){
        List<Student> list = new ArrayList<>();
        while (true) {
            list.add(new Student());
        }
    }

    /**
     * http://localhost:8080/index/deadLock
     */
    @RequestMapping(value = "/deadLock")
    public String deadLock(){
        DeadLock.deadLock();
        return "deadLock";
    }


    /**
     * http://localhost:8080/index/decrypt
     */
    @RequestMapping(value = "/decrypt")
    public String decrypt(){
        String s = null;
        try {
            for (int i = 0; i < 100; i++) {
                s = DataSecureUtil.decrypt("a");
                System.out.println(System.currentTimeMillis() + "---------------------" + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * http://localhost:8080/index/get?age=26
     * @param age
     * @return
     */
    @RequestMapping(value="/get")
    public Map<String, Object> get(@RequestParam Integer age){
        Long start = System.currentTimeMillis();
        Map<String, Object> map = new HashMap<>();
        map.put("age", age);
        map.put("value", "hello mycode");
        map.put("secret", secret);
        map.put("number", number);
        map.put("name", name);
        map.put("desc", desc);
        System.out.println("接口耗时：" + (System.currentTimeMillis()-start));
        return map;
    }

    /**
     * http://localhost:8080/index/find/123456/tanhuaqiang
     * @param id
     * @param name
     * @return
     */
    @RequestMapping(value="/find/{id}/{name}")
    public User find(@PathVariable Integer id, @PathVariable String name){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setDate(new Date());
        System.out.println(user.getDate());
        return user;
    }


    /**
     * http://localhost:8080/index/printWriter?name=tanhq
     * 返回值可以用输出流来返回
     * @param name
     * @param response
     */
    @RequestMapping(value="/printWriter")
    public void get(@RequestParam String name, HttpServletResponse response, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("value", "hello mycode");
        map.put("secret", secret);
        map.put("number", number);
        map.put("desc", desc);
        map.put("URI", request.getRequestURI());// index/printWriter
        map.put("URL", request.getRequestURL());/*http://localhost:8080/index/printWriter*/
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");
            pw.write(JSON.toJSONString(map));
        } catch (IOException e) {
            logger.error("printWriter", e);
        }
    }

    /**
     * http://localhost:8080/index/getUser?name=tanhq
     * 参数name会封装到对象User中去
     * @param user
     * @param response
     */
    @RequestMapping(value="/getUser")
    public void getUser(User user, HttpServletResponse response){
        //传入对象，在方法中给对象赋值，获取新的对象
        prepareUser(user);
        System.out.println(user);

    }

    private void prepareUser(User user){
        user.setId(1001);
        user.setDate(new Date());
    }

}
