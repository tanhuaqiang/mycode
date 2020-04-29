package com.daling.util.common;

public interface CommonConstant {

    int MAX_SIZE = 1000;

    //电话邀约数量
    String INTENTION = "intention";
    //电话意向数量
    String INVITATION = "invitation";

    int EXCEL_QUEUE_SIZE = 100;
    int EXCEL_CORE_POOL_SIZE = 5;
    int EXCEL_MAX_POOL_SIZE = 100;
    int EXCEL_KEEP_ALIVE_TIME = 60;
    String EXCEL_THREAD_POOL_NAME = "import.thread.pool";
    int EXCEL_ROW_MAX_SIZE = 500;

}
