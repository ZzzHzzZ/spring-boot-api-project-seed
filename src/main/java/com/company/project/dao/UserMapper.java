package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * descrition：
 *
 * @author: ZHZ
 * @create: 2017/12/20
 * @company: www.ideabinder.com
 */
public interface UserMapper extends Mapper<User> {
    List<String> listPermissionByUserId(@Param("id") Integer id);
}
