package io.renren.service;

import io.renren.entity.SysRealNameEntity;

import java.util.List;
import java.util.Map;


/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:43:39
 */
public interface SysRealNameService {
	
	/**
	 * 根据用户ID，查询用户
	 * @param userid
	 * @return
	 */
	SysRealNameEntity queryObject(String userid);
	
	/**
	 * 查询用户列表
	 */
	List<SysRealNameEntity> queryList(Map<String, Object> map);
	
	/**
	 * 查询总数
	 */
	int queryTotal(Map<String, Object> map);

}
