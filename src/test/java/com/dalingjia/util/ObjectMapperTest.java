package com.dalingjia.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.dalingjia.bean.ShipRule;
import com.dalingjia.bean.ShipRuleProdDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ObjectMapperTest {

    private static final Logger logger = LoggerFactory.getLogger(ObjectMapperTest.class);

    static {

    }

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        List<ShipRule> rules = new ArrayList<>();
        rules.add(new ShipRule(1000l, "alibaba", "[{\"id\":5146,\"sku\":\"X6BAN0OFBV001\",\"prodName\":\"苏宁121345073\"},{\"id\":3539,\"sku\":\"010602130A011\",\"prodName\":\"鲍勃新颖小丑人 椒盐罐(红色)\"}]"));
        rules.add(new ShipRule(1001l, "tengxun", "[{\"id\":3539,\"sku\":\"010602130A011\",\"prodName\":\"鲍勃新颖小丑人 椒盐罐(红色)\"}]"));
        rules.add(new ShipRule(1002l, "baidu", "[{\"id\":1229,\"sku\":\"CTAL9NFHBFXC1\",\"prodName\":\"闪耀派对耳环\"}]"));

//        List<ShipRule> rules2 = new ArrayList<>();
//        rules2.add(new ShipRule(1000l, "alibaba", "{\"id\":5146,\"sku\":\"X6BAN0OFBV001\",\"prodName\":\"苏宁121345073\"}"));
//        rules2.add(new ShipRule(1001l, "tengxun", "{\"id\":3539,\"sku\":\"010602130A011\",\"prodName\":\"鲍勃新颖小丑人 椒盐罐(红色)\"}"));
//        rules2.add(new ShipRule(1002l, "baidu", "{\"id\":1229,\"sku\":\"CTAL9NFHBFXC1\",\"prodName\":\"闪耀派对耳环\"}"));

        ShipRule shipRule = new ShipRule(1000l, "alibaba", "{\"id\":5146,\"sku\":\"X6BAN0OFBV001\",\"prodName\":\"苏宁121345073\"}");

        List<ShipRuleProdDTO> prods = null;

        for (ShipRule rule : rules) {

            try {
                //使用jackson的ObjectMapper json转object,rule.getProds()必须是一个数组
                prods = mapper.readValue(rule.getProds(), mapper.getTypeFactory().constructCollectionType(ArrayList.class, ShipRuleProdDTO.class));
            } catch (IOException e) {
                logger.error("数据库字段解析错误", e);
                break;
            }
        }
        prods.stream().forEach(shipRuleProdDTO -> System.out.println(shipRuleProdDTO));

        //json转object
        try {
            ShipRuleProdDTO shipRuleProdDTO =  mapper.readValue(shipRule.getProds(), ShipRuleProdDTO.class);
            System.out.println(shipRuleProdDTO);

            //Object转json
            System.out.println(mapper.writeValueAsString(shipRuleProdDTO));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
