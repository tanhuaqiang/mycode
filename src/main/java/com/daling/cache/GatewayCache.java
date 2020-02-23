package com.daling.cache;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.CacheGetResult;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.daling.bean.Student;
import com.daling.util.lock.LockUtils;
import com.daling.util.lock.jedisLock.RdLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GatewayCache {

    private Logger logger = LoggerFactory.getLogger(GatewayCache.class);

    private final String GATEWAY_PREFIX = "gateway_";

    /**
     * 通过@CreateCache注解创建一个二级（内存 + 远程）缓存实例，默认超时时间是60秒，内存中的元素个数限制在50个
     */
    @CreateCache(name = GATEWAY_PREFIX, expire = 60, cacheType = CacheType.BOTH, localLimit = 50)
    private Cache<String, Student> studentCache;



    public Student getStudent() {
        Student student = new Student();
        CacheGetResult<Student> result = studentCache.GET("10000");
        if(result.isSuccess()){
            student = result.getValue();
            return student;
        }
        // 先获取锁，串行操作
        // RdLock实现了Closeable接口，try代码块结束后会执行close方法
        try(RdLock rdLock = LockUtils.getRLock(GATEWAY_PREFIX + "getStudent")){
            boolean lock = rdLock.tryLock();
            if (!lock) {
                System.out.println("获取锁过于频繁");
                return null;
            }else {
                student = new Student(100, "tanhq", 1);
                studentCache.put("10000", student);
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return student;
    }


}
