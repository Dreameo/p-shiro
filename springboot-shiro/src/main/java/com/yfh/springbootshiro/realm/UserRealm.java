package com.yfh.springbootshiro.realm;

import com.yfh.springbootshiro.pojo.User;
import com.yfh.springbootshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

///自定义的UserRealm
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //拿到当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();//拿到user对象


        //设置当前用户的权限
        if (currentUser.getPerms() != null) {
            String[] perms = currentUser.getPerms().split(",");

//        info.addStringPermission(currentUser.getPerms());
            for (String perm : perms) {
                info.addStringPermission(perm);
            }
        }

        return  info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了=>认证doGetAuthorizationInfo");

        // 用户名、密码， 数据中取
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        User user = userService.queryUserByName(userToken.getUsername());
        if (user == null) {
            return null;//抛出异常 UnknownAccountException, 不存这个名字
        }

        // 密码认证，shiro做
        return new SimpleAuthenticationInfo(user, user.getPwd(), "");
    }
}
