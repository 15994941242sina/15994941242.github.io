package com.example.config;

import com.example.pojo.User;
import com.example.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author LinJie
 * @create 2020-12-17 8:16
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("执行了=>授权doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //拿到当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();
        if(currentUser.getUser_type()==1){      //管理员
            info.addStringPermission("user:administrator");
        }

        if(currentUser.getUser_type()==0){      //销售员
            info.addStringPermission("user:salesman");
        }

        if(currentUser.getUser_type()==2){      //超级管理员
            info.addStringPermission("user:salesman");
            info.addStringPermission("user:administrator");
        }

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        System.out.println("执行了=>认证doGetAuthenticationInfo");

//        String name = "root";
//        String password = "123456";
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        if(!token.getUsername().equals(name)){
//            return null;
//        }
        UsernamePasswordToken usernamePasswordToken =(UsernamePasswordToken) authenticationToken;
        User user = userService.queryUser(usernamePasswordToken.getUsername());
        if(user == null){
            return null;
        }

        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("",user);

        return new SimpleAuthenticationInfo(user,user.getUser_pwd(),"");
    }
}
