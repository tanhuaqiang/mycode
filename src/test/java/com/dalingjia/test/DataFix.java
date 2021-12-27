package com.dalingjia.test;

import com.daling.util.HttpUtils;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataFix {

    @Test
    public void test() throws IOException {
        List<String> ids = Lists.newArrayList((new String(Files.readAllBytes(Paths.get("/Users/tanhq/Desktop/yuejie000")))).split("\n"));
        for (String id : ids) {
            String output = HttpUtils.post("http://10.54.129.2:8418/test/fixOrderLineId/2658183/#{}", id);
            System.out.println(id + "\t" + output);
            break;
        }
    }

    public static void main(String[] args) {
        String ids = "5313419,5756224,5774299,5777749,5777841,5778943,5784985,5785015,5785363,5785905,5785919,5786671,5787075,5787325,5790288,5794736,5822112";
        for (String id : ids.split(",")) {
            System.out.println(id);
        }
    }
}
