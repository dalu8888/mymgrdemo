package io.renren.controller;

import io.renren.entity.SysRealNameEntity;
import io.renren.service.SysRealNameService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月31日 上午10:40:10
 */
@RestController
@RequestMapping("/sys/realnamemgr")
public class SysRealNameController{
	@Autowired
	private SysRealNameService sysRealNameService;

	/**
	 * 所有用户列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:realname:list")
	public R list(@RequestParam Map<String, Object> params){
//		System.out.println("map"+params);
//		try {
//			request.setCharacterEncoding("GBK");
//			System.out.println(request.getParameter("name"));
//			request.setCharacterEncoding("ISO8859-1");
//			System.out.println(request.getParameter("name"));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}

		//查询列表数据
		Query query = new Query(params);
		List<SysRealNameEntity> userList = sysRealNameService.queryList(query);
		int total = sysRealNameService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}
	/**
	 * 用户信息
	 */
	@RequestMapping("/info/{userid}")
//	@GetMapping("/info/{userid}")
	@RequiresPermissions("sys:user:info")
	public R info(@PathVariable("userid") String userid){
		SysRealNameEntity rn = sysRealNameService.queryObject(userid);
		
		return R.ok().put("realnameinfo", rn);
	}

	
//	/**
//	 * 删除用户
//	 */
//	@SysLog("删除用户")
//	@RequestMapping("/delete")
//	@RequiresPermissions("sys:user:delete")
//	public R delete(@RequestBody Long[] userIds){
//		if(ArrayUtils.contains(userIds, 1L)){
//			return R.error("系统管理员不能删除");
//		}
//
//		if(ArrayUtils.contains(userIds, getUserId())){
//			return R.error("当前用户不能删除");
//		}
//
//		sysUserService.deleteBatch(userIds);
//
//		return R.ok();
//	}
}
