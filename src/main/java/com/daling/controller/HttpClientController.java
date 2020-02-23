package com.daling.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController = @Controller + @ResponseBody
@RestController
@RequestMapping(path = "/http")
public class HttpClientController {

    private static final Logger log = LoggerFactory.getLogger(HttpClientController.class);

    private final int userTagApiPort = 8084;

    private final String userTagApiHost = "10.36.13.31";

    private final String checkUrl = "/xc_usertag/api/utags/busi/checkAnyTags.do";

    //http://localhost:8080/http/get?name=tanhq
//    @RequestMapping(value="/get")
//    public ResultVO<Map<String, Object>> get(@RequestParam String name){
//        ResultVO<Map<String, Object>> result = ResultVO.newResult();
//        try {
//            Map<String, String> paramMap = Maps.newHashMap();
//            paramMap.put("track_id", vo.getTrackId());
//            paramMap.put("srNo", vo.getSrNo());
//            paramMap.put("buyerId", buyerId + "");
//            paramMap.put("optName", StringUtils.isBlank(user.getRealName()) ? user.getNickName() : user.getRealName());
//            JsonHeaderWrapper<Object> wrapper = DataSyncUtil.getDataByOneMinit(CommonConstant.return_view_url, paramMap);
//            if (JsonHeaderWrapper.StatusEnum.Success.getCode() == wrapper.getStatus()) {
//                result.format(true, "success", (Map<String, Object>) wrapper.getData());
//            } else {
//                result.format(false, wrapper.getErrmsg());
//            }
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            result.format(false, "网络繁忙,请稍后再试!");
//        }
//        return result;
//    }


    private String getUrl(String url){

        return "http://" + userTagApiHost + ":" + userTagApiPort + url;
    }
}
