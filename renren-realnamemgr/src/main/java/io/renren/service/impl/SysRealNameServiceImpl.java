package io.renren.service.impl;

import io.renren.dao.SysRealNameDao;
import io.renren.entity.SysRealNameEntity;
import io.renren.service.SysRealNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * 实名认证
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:46:09
 */
@Service("sysRealNameService")
public class SysRealNameServiceImpl implements SysRealNameService {
	@Autowired
	private SysRealNameDao sysRealNameDao;

	@Override
	public SysRealNameEntity queryObject(String userid) {
		return sysRealNameDao.queryObject(userid);
	}

	@Override
	public List<SysRealNameEntity> queryList(Map<String, Object> map){
		return sysRealNameDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysRealNameDao.queryTotal(map);
	}


}
