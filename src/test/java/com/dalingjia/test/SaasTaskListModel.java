package com.dalingjia.test;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author damon
 * @version 2019/7/23
 */
public class SaasTaskListModel {

    private List<SaasTaskQueryResultModel> saasTaskQueryResultModel;
    private Page page;

    public List<SaasTaskQueryResultModel> getSaasTaskQueryResultModel() {
        return saasTaskQueryResultModel;
    }

    public void setSaasTaskQueryResultModel(List<SaasTaskQueryResultModel> saasTaskQueryResultModel) {
        this.saasTaskQueryResultModel = saasTaskQueryResultModel;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }


    public static SaasTaskListModel buildEmptyModel(Integer pageNo, Integer pageSize){
        SaasTaskListModel model = new SaasTaskListModel();
        model.setSaasTaskQueryResultModel(Lists.newArrayList());
        //注意空指针异常
        model.setPage(new Page(pageNo,pageSize,0));
        return model;
    }
}
