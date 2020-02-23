package com.daling.controller.mybatis;

import com.daling.bean.Dept;
import com.daling.controller.BaseController;
import com.daling.platform.model.ResultVO;
import com.daling.service.DeptService;
import com.daling.util.common.JsonHeaderWrapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("dept")
public class DeptController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;


    @RequestMapping(value = "saveDept.do", method = RequestMethod.POST)
    public JsonHeaderWrapper saveDept(Dept dept, HttpServletResponse response, HttpServletRequest request) {
        JsonHeaderWrapper result = new JsonHeaderWrapper<>();
        String trackId = StringUtils.isBlank(request.getParameter("trackId")) ? UUID.randomUUID().toString() : request.getParameter("trackId");
        result.setTrack_id(trackId);
        result.setStatus(JsonHeaderWrapper.StatusEnum.Success.getCode());
        result.setErrmsg(JsonHeaderWrapper.StatusEnum.Success.getDesc());
        try {
            ResultVO resultVO = deptService.saveDept(dept);
            result.setStatus(resultVO.getCode());
            result.setErrmsg(resultVO.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.setStatus(JsonHeaderWrapper.StatusEnum.UnknownOther.getCode());
            result.setErrmsg(JsonHeaderWrapper.StatusEnum.UnknownOther.getDesc());
        } finally {
            result.timeWatchStop();
        }
        return result;
    }

    @RequestMapping("/delDept")
    public JsonHeaderWrapper delDept(Integer did, HttpServletResponse response, HttpServletRequest request) {
        JsonHeaderWrapper result = new JsonHeaderWrapper<>();
        String trackId = StringUtils.isBlank(request.getParameter("trackId")) ? UUID.randomUUID().toString() : request.getParameter("trackId");
        result.setTrack_id(trackId);
        result.setStatus(JsonHeaderWrapper.StatusEnum.Success.getCode());
        result.setErrmsg(JsonHeaderWrapper.StatusEnum.Success.getDesc());
        try {
            ResultVO resultVO = deptService.delDept(did);
            result.setStatus(resultVO.getCode());
            result.setErrmsg(resultVO.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.setStatus(JsonHeaderWrapper.StatusEnum.UnknownOther.getCode());
            result.setErrmsg(JsonHeaderWrapper.StatusEnum.UnknownOther.getDesc());
        } finally {
            result.timeWatchStop();
        }
        return result;
    }

    @RequestMapping("/updateDept")
    public JsonHeaderWrapper updateDept(Dept dept, HttpServletResponse response, HttpServletRequest request) {
        JsonHeaderWrapper result = new JsonHeaderWrapper<>();
        String trackId = StringUtils.isBlank(request.getParameter("trackId")) ? UUID.randomUUID().toString() : request.getParameter("trackId");
        result.setTrack_id(trackId);
        result.setStatus(JsonHeaderWrapper.StatusEnum.Success.getCode());
        result.setErrmsg(JsonHeaderWrapper.StatusEnum.Success.getDesc());
        try {
            ResultVO resultVO = deptService.updateDept(dept);
            result.setStatus(resultVO.getCode());
            result.setErrmsg(resultVO.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.setStatus(JsonHeaderWrapper.StatusEnum.UnknownOther.getCode());
            result.setErrmsg(JsonHeaderWrapper.StatusEnum.UnknownOther.getDesc());
        } finally {
            result.timeWatchStop();
        }
        return result;
    }

    @RequestMapping("/selDept")
    public JsonHeaderWrapper selDept(Integer did, HttpServletResponse response, HttpServletRequest request) {
        JsonHeaderWrapper result = new JsonHeaderWrapper<>();
        String trackId = StringUtils.isBlank(request.getParameter("trackId")) ? UUID.randomUUID().toString() : request.getParameter("trackId");
        result.setTrack_id(trackId);
        result.setStatus(JsonHeaderWrapper.StatusEnum.Success.getCode());
        result.setErrmsg(JsonHeaderWrapper.StatusEnum.Success.getDesc());
        try {
            Dept dept = deptService.selDept(did);
            result.setData(dept);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.setStatus(JsonHeaderWrapper.StatusEnum.UnknownOther.getCode());
            result.setErrmsg(JsonHeaderWrapper.StatusEnum.UnknownOther.getDesc());
        } finally {
            result.timeWatchStop();
        }
        return result;
    }

    @RequestMapping("/selAllDept")
    public JsonHeaderWrapper selAllDept(HttpServletResponse response, HttpServletRequest request) {
        JsonHeaderWrapper result = new JsonHeaderWrapper<>();
        String trackId = StringUtils.isBlank(request.getParameter("trackId")) ? UUID.randomUUID().toString() : request.getParameter("trackId");
        result.setTrack_id(trackId);
        result.setStatus(JsonHeaderWrapper.StatusEnum.Success.getCode());
        result.setErrmsg(JsonHeaderWrapper.StatusEnum.Success.getDesc());
        try {
            List<Dept> list = deptService.selAllDept();
            result.setData(list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.setStatus(JsonHeaderWrapper.StatusEnum.UnknownOther.getCode());
            result.setErrmsg(JsonHeaderWrapper.StatusEnum.UnknownOther.getDesc());
        } finally {
            result.timeWatchStop();
        }
        return result;
    }

    @RequestMapping("/selectCount")
    public JsonHeaderWrapper selectCount(HttpServletResponse response, HttpServletRequest request) {
        JsonHeaderWrapper result = new JsonHeaderWrapper<>();
        String trackId = StringUtils.isBlank(request.getParameter("trackId")) ? UUID.randomUUID().toString() : request.getParameter("trackId");
        result.setTrack_id(trackId);
        result.setStatus(JsonHeaderWrapper.StatusEnum.Success.getCode());
        result.setErrmsg(JsonHeaderWrapper.StatusEnum.Success.getDesc());
        try {
            Map<String, Object> map = new HashMap<>();
            Long count = deptService.selectCount();
            result.setData(count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.setStatus(JsonHeaderWrapper.StatusEnum.UnknownOther.getCode());
            result.setErrmsg(JsonHeaderWrapper.StatusEnum.UnknownOther.getDesc());
        } finally {
            result.timeWatchStop();
        }
        return result;

    }

}
