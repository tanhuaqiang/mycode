package com.daling.util.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.joda.time.DateTime;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JsonHeaderWrapper<T> {

    @JsonIgnore
    private static final ObjectMapper mapper = new ObjectMapper();
    @JsonIgnore
    private static final String DAT_FMT_STR = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    @JsonIgnore
    private static final SimpleDateFormat DAT_FMT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    private String version = "1.0";
    private String clientFrom = "";
    private String timestamp = DateTime.now().toString("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    private String get_url = "";
    private int status;
    private String errmsg;
    private long elapsed;
    private String acc_point;
    private String track_id;
    private int secur_type;
    private T data;
    @JsonIgnore
    private long stopWatch = System.currentTimeMillis();

    public JsonHeaderWrapper() {
        this.status = JsonHeaderWrapper.StatusEnum.UnknownOther.getCode();
        this.errmsg = "";
        this.elapsed = 0L;
        this.acc_point = getLocalIP_D();
        this.track_id = UUID.randomUUID().toString();
        this.secur_type = JsonHeaderWrapper.SecurTypeEnum.UnknownOther.getCode();
        this.data = null;
    }

    public static JsonHeaderWrapper<?> parsingObject(String jsonString) throws JsonParseException, JsonMappingException, IOException {
        return null == jsonString ? null : (JsonHeaderWrapper)mapper.readValue(jsonString, JsonHeaderWrapper.class);
    }

    public String toJsonString() throws JsonProcessingException {
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setDateFormat(DAT_FMT);
        return mapper.writeValueAsString(this);
    }

    public String toJson4MString() throws JsonProcessingException {
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setDateFormat(DAT_FMT);
        Map<String, Object> tmpMap = new HashMap();
        tmpMap.put("version", this.version);
        tmpMap.put("clientFrom", this.clientFrom);
        tmpMap.put("timestamp", this.timestamp);
        tmpMap.put("get_url", this.get_url);
        tmpMap.put("status", this.status);
        tmpMap.put("err_detail", this.errmsg);
        tmpMap.put("elapsed", this.elapsed);
        tmpMap.put("acc_point", this.acc_point);
        tmpMap.put("track_id", this.track_id);
        tmpMap.put("secur_type", this.secur_type);
        tmpMap.put("data", this.data);
        return mapper.writeValueAsString(tmpMap);
    }

    public long timeWatchStop() {
        this.elapsed = System.currentTimeMillis() - this.stopWatch;
        return this.elapsed;
    }

    public String getVersion() {
        return this.version;
    }

    public String getClientFrom() {
        return this.clientFrom;
    }

    public void setClientFrom(String clientFrom) {
        this.clientFrom = clientFrom;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getGet_url() {
        return this.get_url;
    }

    public void setGet_url(String get_url) {
        this.get_url = get_url;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public long getElapsed() {
        return this.elapsed;
    }

    public String getAcc_point() {
        return this.acc_point;
    }

    public String getTrack_id() {
        return this.track_id;
    }

    public void setTrack_id(String track_id) {
        this.track_id = track_id;
    }

    public int getSecur_type() {
        return this.secur_type;
    }

    public void setSecur_type(int secur_type) {
        this.secur_type = secur_type;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private static String getLocalIP_D() {
        return getLocalIP_Seg(3);
    }

    private static String getLocalIP_Seg(int seg) {
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            String[] d = ip.split("\\.");
            return d != null && d.length == 4 && seg < 4 ? d[seg] : "";
        } catch (UnknownHostException var3) {
            return "";
        }
    }

    public static enum StatusEnum {
        Success(0, "全部成功"),
        Success4M(200, "全部成功"),
        PartialSuccess(202, "库存数不足"),
        Timeout(405, "接口超时返回"),
        OverFlowCtrl(406, "客户流量超量"),
        Failed(500, "全部失败"),
        ParamError(505, "传入参数错误"),
        UnknownOther(599, "未知错误,系统错误");

        private int code;
        private String desc;

        public int getCode() {
            return this.code;
        }

        public void setCode(int value) {
            this.code = value;
        }

        public String getDesc() {
            return this.desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        private StatusEnum(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

    public static enum SecurTypeEnum {
        InnerAcc(1, "内网"),
        InnerAuthAcc(2, "内网认证"),
        PublicAcc(3, "公网"),
        PublicAuthAcc(4, "公网认证"),
        IPAuthAcc(5, "IP限制"),
        UnknownOther(599, "未知类型");

        private int code;
        private String desc;

        public int getCode() {
            return this.code;
        }

        public void setCodee(int code) {
            this.code = code;
        }

        public String getDesc() {
            return this.desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        private SecurTypeEnum(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

}
