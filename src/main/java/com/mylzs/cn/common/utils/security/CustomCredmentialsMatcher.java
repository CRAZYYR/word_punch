package com.mylzs.cn.common.utils.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by Administrator on 17/11/7.
 */
public class CustomCredmentialsMatcher extends SimpleCredentialsMatcher {
    @Override
    protected Object getCredentials(AuthenticationToken token) {
        return super.getCredentials(token);
    }

    @Override
    protected Object getCredentials(AuthenticationInfo info) {
        return super.getCredentials(info);
    }

    @Override
    protected boolean equals(Object tokenCredentials, Object accountCredentials) {
        return super.equals(tokenCredentials, accountCredentials);
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        return super.doCredentialsMatch(token, info);
    }
}
