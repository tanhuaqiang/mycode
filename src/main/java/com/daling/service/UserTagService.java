package com.daling.service;

import java.util.List;

public interface UserTagService {

    List<String> getUserTagsById(Long userId, String[] tags);


 }
