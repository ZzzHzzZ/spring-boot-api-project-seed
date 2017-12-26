package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.model.User;
import com.company.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * descrition：
 *
 * @author: ZHZ
 * @create: 2017/12/20
 * @company: www.ideabinder.com
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userServiceImpl;

    @GetMapping("/getUser")
    public Result getUser(@RequestParam("id") Integer id) {
        try {
            User user = this.userServiceImpl.getUser(id);
            return Result.ok(user);
        } catch (Exception e) {
            logger.error("获取人员信息失败", e);
            return Result.error("获取人员信息失败");
        }
    }

    @PostMapping("insertUser")
    public Result insertUser(@RequestBody User user) {
        try {
            this.userServiceImpl.insertUser(user);
            return Result.ok();
        } catch (Exception e) {
            logger.error("插入人员信息失败", e);
            return Result.error("插入人员信息失败");
        }
    }
}
