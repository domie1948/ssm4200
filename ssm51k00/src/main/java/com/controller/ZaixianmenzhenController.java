package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZaixianmenzhenEntity;
import com.entity.view.ZaixianmenzhenView;

import com.service.ZaixianmenzhenService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 在线门诊
 * 后端接口
 * @author 
 * @email 
 * @date 2021-05-02 09:22:13
 */
@RestController
@RequestMapping("/zaixianmenzhen")
public class ZaixianmenzhenController {
    @Autowired
    private ZaixianmenzhenService zaixianmenzhenService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZaixianmenzhenEntity zaixianmenzhen, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			zaixianmenzhen.setYishenggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZaixianmenzhenEntity> ew = new EntityWrapper<ZaixianmenzhenEntity>();
		PageUtils page = zaixianmenzhenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianmenzhen), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZaixianmenzhenEntity zaixianmenzhen, 
		HttpServletRequest request){
        EntityWrapper<ZaixianmenzhenEntity> ew = new EntityWrapper<ZaixianmenzhenEntity>();
		PageUtils page = zaixianmenzhenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianmenzhen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZaixianmenzhenEntity zaixianmenzhen){
       	EntityWrapper<ZaixianmenzhenEntity> ew = new EntityWrapper<ZaixianmenzhenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zaixianmenzhen, "zaixianmenzhen")); 
        return R.ok().put("data", zaixianmenzhenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZaixianmenzhenEntity zaixianmenzhen){
        EntityWrapper< ZaixianmenzhenEntity> ew = new EntityWrapper< ZaixianmenzhenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zaixianmenzhen, "zaixianmenzhen")); 
		ZaixianmenzhenView zaixianmenzhenView =  zaixianmenzhenService.selectView(ew);
		return R.ok("查询在线门诊成功").put("data", zaixianmenzhenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZaixianmenzhenEntity zaixianmenzhen = zaixianmenzhenService.selectById(id);
        return R.ok().put("data", zaixianmenzhen);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZaixianmenzhenEntity zaixianmenzhen = zaixianmenzhenService.selectById(id);
        return R.ok().put("data", zaixianmenzhen);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZaixianmenzhenEntity zaixianmenzhen, HttpServletRequest request){
    	zaixianmenzhen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zaixianmenzhen);

        zaixianmenzhenService.insert(zaixianmenzhen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZaixianmenzhenEntity zaixianmenzhen, HttpServletRequest request){
    	zaixianmenzhen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zaixianmenzhen);

        zaixianmenzhenService.insert(zaixianmenzhen);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZaixianmenzhenEntity zaixianmenzhen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zaixianmenzhen);
        zaixianmenzhenService.updateById(zaixianmenzhen);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zaixianmenzhenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ZaixianmenzhenEntity> wrapper = new EntityWrapper<ZaixianmenzhenEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			wrapper.eq("yishenggonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = zaixianmenzhenService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
