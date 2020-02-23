package com.daling.controller;

import com.daling.platform.model.ResultVO;
import com.daling.util.XcHeadWrapper;
import com.daling.util.common.JsonHeaderWrapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BaseController {
    public Logger log = LoggerFactory.getLogger(this.getClass());

    protected final String authPrefix = "{funcID}/{pointCode}/";


    public <T> XcHeadWrapper<T> initJsonHeaderWrapper(String trackId) {
        XcHeadWrapper<T> jsonWrapper = new XcHeadWrapper<>();
        jsonWrapper.setStatus(XcHeadWrapper.StatusEnum.Success.getCode());
        jsonWrapper.setErrorMsg(XcHeadWrapper.StatusEnum.Success.getDesc());
        if (StringUtils.isNotBlank(trackId)) {
            jsonWrapper.setTrackId(trackId);
        }
        return jsonWrapper;
    }


    public <T> XcHeadWrapper<T> initJsonHeaderWrapper(String trackId, String defaultTrackId) {
        XcHeadWrapper<T> jsonWrapper = new XcHeadWrapper<>();
        jsonWrapper.setStatus(XcHeadWrapper.StatusEnum.Success.getCode());
        jsonWrapper.setErrorMsg(XcHeadWrapper.StatusEnum.Success.getDesc());
        if (StringUtils.isNotBlank(trackId)) {
            jsonWrapper.setTrackId(trackId);
        } else {
            jsonWrapper.setTrackId(defaultTrackId);
        }
        return jsonWrapper;
    }

    public <T> JsonHeaderWrapper dealResultVO(ResultVO<T> resultVO, JsonHeaderWrapper<T> jsonHeaderWrapper){
        if (!resultVO.isRetBool()){
            jsonHeaderWrapper.setStatus(resultVO.getCode());
            jsonHeaderWrapper.setErrmsg(resultVO.getMessage());
            jsonHeaderWrapper.setData(resultVO.getT());
        }else {
            jsonHeaderWrapper.setStatus(JsonHeaderWrapper.StatusEnum.Success.getCode());
            jsonHeaderWrapper.setErrmsg(JsonHeaderWrapper.StatusEnum.Success.getDesc());
            jsonHeaderWrapper.setData(resultVO.getT());
        }
        return jsonHeaderWrapper;
    }
}
