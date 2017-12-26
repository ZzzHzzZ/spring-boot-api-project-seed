package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * descrition：
 *
 * @author: ZHZ
 * @create: 2017/12/26
 * @company: www.ideabinder.com
 */
public interface UserRoleMapper extends Mapper<UserRole> {
    Set<String> listRoleByUser(@Param("id") Integer userId);
}
