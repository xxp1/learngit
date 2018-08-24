package com.jianpu.realm;

import java.util.Arrays;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * 自定义realm
 * 
 * @author Administrator
 * 
 */
public class MyRealm extends AuthorizingRealm {

	/**
	 * 调用service
	 */
/*	@Resource
	private  AdminService as;
	*/
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		// 1. 获得用户名
		String username = (String) principals.getPrimaryPrincipal();
		// 2. 根据用户名获得角色 数据库
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(Arrays.asList("super"));
		// 3. 获得资源 数据库
		info.addStringPermissions(Arrays.asList("super:create", "super:update"));
		return info;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		// 1 获得用户名
		String username = (String) token.getPrincipal();
		// 2.根据用户名查询数据中正确的秘密
		String password = "de579425ecdc26a855ef934981530f0a";
		String salt = "ASDF";

		// 交给shiro
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password,
				ByteSource.Util.bytes(salt), getName());

		return info;
	}
}
