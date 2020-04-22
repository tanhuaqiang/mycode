package com.dalingjia.LambdaStream;

import com.daling.util.JsonUtil.JacksonHelper;
import com.dalingjia.bean.CallTargetUnReached;
import com.dalingjia.bean.UnFinishedInfo;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author : tanhq
 * @version :
 * @date : Created in 2020/3/15 下午1:54
 * @description:
 */
public class DistinctListTest {


    public static Integer distinctUnReachedEmpCount(List<CallTargetUnReached> unreachedList) {
        List<UnFinishedInfo> list = Lists.newArrayList();
        unreachedList.forEach(callTargetUnReached -> {
            list.addAll(JacksonHelper.jsonToList(callTargetUnReached.getUnFinishedInfo(), UnFinishedInfo.class));
        });
        List<UnFinishedInfo> list1 = list.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(UnFinishedInfo::getEmpId))),
                        ArrayList::new)
        );
        return list1.size();
    }


    public static void main(String[] args) {
        List<CallTargetUnReached> unreachedList = Lists.newArrayList();
        CallTargetUnReached unReached1 = new CallTargetUnReached(1L, "[\n" +
                "{\"empName\":\"张三\",\"empId\":1,\"count\":4}\n" +
                ",{\"empName\":\"李四\",\"empId\":2,\"count\":5}\n" +
                ",{\"empName\":\"王五\",\"empId\":3,\"count\":6}\n" +
                "]");
        CallTargetUnReached unReached2 = new CallTargetUnReached(2L, "[\n" +
                "{\"empName\":\"张三\",\"empId\":1,\"count\":4}\n" +
                ",{\"empName\":\"李四\",\"empId\":342,\"count\":5}\n" +
                ",{\"empName\":\"王五\",\"empId\":3,\"count\":6}\n" +
                "]");
        CallTargetUnReached unReached3 = new CallTargetUnReached(3L, "[\n" +
                "{\"empName\":\"张三\",\"empId\":134,\"count\":4}\n" +
                ",{\"empName\":\"李四\",\"empId\":2,\"count\":5}\n" +
                ",{\"empName\":\"王五\",\"empId\":3,\"count\":6}\n" +
                "]");
        unreachedList.add(unReached1);
        unreachedList.add(unReached2);
        unreachedList.add(unReached3);

        System.out.println(distinctUnReachedEmpCount(unreachedList));
    }

}
