package com.daling.service.impl;

import com.daling.service.UserTagService;

import java.util.List;

public class UserTagServiceImpl implements UserTagService {

    private final int userTagApiPort = 8084;

    private final String userTagApiHost = "10.36.13.31";

    private final String checkUrl = "/xc_usertag/api/utags/busi/checkAnyTags.do";



    private String getUrl(String url){

        return "http://" + userTagApiHost + ":" + userTagApiPort + url;
    }

    @Override
    public List<String> getUserTagsById(Long userId, String[] tags) {
        return null;
    }
}
