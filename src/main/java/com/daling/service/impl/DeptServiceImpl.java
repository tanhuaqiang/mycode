package com.daling.service.impl;

import com.daling.bean.Dept;
import com.daling.dao.DeptMapper;
import com.daling.platform.model.ResultVO;
import com.daling.service.DeptService;
import com.daling.util.common.JsonHeaderWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * DeptServiceImpl bean 交由Spring来统一管理业务对象，这样该对象上面的事务才会生效
 */
@Service
public class DeptServiceImpl implements DeptService {

    private static final Logger logger = LoggerFactory.getLogger(DeptServiceImpl.class);

    @Autowired
    private DeptMapper deptMapper;

    /**
     * Spring中事务回滚是有触发机制的，其触发机制就是抛出unchecked异常，即RuntimeException及其子类异常
     * 交由Spring来统一管理业务对象，这样该对象上面的事务才会生效
     *
     * 需要指定具体的事物管理器, txManager为定义好的事务管理器
     * @param dept
     * @return
     */
    @Transactional("txManager")
    @Override
    public ResultVO<String> saveDept(Dept dept) {
        ResultVO<String> resultVO = new ResultVO<>();
        deptMapper.saveDept(dept);
//        try {
//            int i = 1/0;
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//            throw new RuntimeException("除零异常，回滚");
//        }
        resultVO.format(true, JsonHeaderWrapper.StatusEnum.Success.getDesc(), JsonHeaderWrapper.StatusEnum.Success.getCode());
        return resultVO;
    }

    @Transactional
    @Override
    public ResultVO delDept(Integer did) {
        ResultVO<String> resultVO = new ResultVO<>();
        deptMapper.delDept(did);
        try {
            int i = 1/0;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("除零异常，回滚");
        }
        resultVO.format(true, JsonHeaderWrapper.StatusEnum.Success.getDesc(), JsonHeaderWrapper.StatusEnum.Success.getCode());
        return resultVO;
    }

    @Transactional
    @Override
    public ResultVO updateDept(Dept dept) {

        ResultVO<String> resultVO = new ResultVO<>();
        deptMapper.updateDept(dept);
        resultVO.format(true, JsonHeaderWrapper.StatusEnum.Success.getDesc(), JsonHeaderWrapper.StatusEnum.Success.getCode());
        return resultVO;
    }

    @Override
    public Dept selDept(Integer did) {
        return deptMapper.selDept(did);
    }

    @Override
    public List<Dept> selAllDept() {
        return deptMapper.selAllDept();
    }

    @Override
    public Long selectCount() {
        return deptMapper.selectCount();
    }
}
