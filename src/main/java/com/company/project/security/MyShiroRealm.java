package com.company.project.security;

import com.company.project.dao.UserMapper;
import com.company.project.dao.UserRoleMapper;
import com.company.project.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * descrition：
 *
 * @author: ZHZ
 * @create: 2017/12/26
 * @company: www.ideabinder.com
 */
public class MyShiroRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleMapper userRoleMapper;


    //登录认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = new User();
        user.setUsername(token.getUsername());
        user = this.userMapper.selectOne(user);
        if (user != null) {
            logger.info("用户名:{} 正在尝试登录", user.getUsername());
            return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        }
        return null;
    }

    //授权认证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("##################执行shiro认证#################");
        //获取当前登录输入的用户名，等价于(String) principalCollection.fromRealm(getName()).iterator().next();
        User user = (User) super.getAvailablePrincipal(principalCollection);
        // 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        user = this.userMapper.selectOne(user);
        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            List<String> permission = this.userMapper.listPermissionByUserId(user.getId());
            info.addStringPermissions(permission);
            return info;
        }
        return null;
    }


}
