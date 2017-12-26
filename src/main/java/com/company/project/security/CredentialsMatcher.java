package com.company.project.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * descrition：
 *
 * @author: ZHZ
 * @create: 2017/12/26
 * @company: www.ideabinder.com
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;
        String inPassword = new String(utoken.getPassword());
        String dbPassword = (String) info.getCredentials();
        return this.equals(inPassword, dbPassword);
    }
}
