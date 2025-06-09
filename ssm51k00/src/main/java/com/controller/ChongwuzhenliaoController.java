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

import com.entity.ChongwuzhenliaoEntity;
import com.entity.view.ChongwuzhenliaoView;

import com.service.ChongwuzhenliaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 宠物诊疗
 * 后端接口
 * @author 
 * @email 
 * @date 2021-05-02 09:22:13
 */
@RestController
@RequestMapping("/chongwuzhenliao")
public class ChongwuzhenliaoController {
    @Autowired
    private ChongwuzhenliaoService chongwuzhenliaoService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChongwuzhenliaoEntity chongwuzhenliao, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			chongwuzhenliao.setYishenggonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			chongwuzhenliao.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChongwuzhenliaoEntity> ew = new EntityWrapper<ChongwuzhenliaoEntity>();
		PageUtils page = chongwuzhenliaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongwuzhenliao), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChongwuzhenliaoEntity chongwuzhenliao, 
		HttpServletRequest request){
        EntityWrapper<ChongwuzhenliaoEntity> ew = new EntityWrapper<ChongwuzhenliaoEntity>();
		PageUtils page = chongwuzhenliaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongwuzhenliao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChongwuzhenliaoEntity chongwuzhenliao){
       	EntityWrapper<ChongwuzhenliaoEntity> ew = new EntityWrapper<ChongwuzhenliaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chongwuzhenliao, "chongwuzhenliao")); 
        return R.ok().put("data", chongwuzhenliaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChongwuzhenliaoEntity chongwuzhenliao){
        EntityWrapper< ChongwuzhenliaoEntity> ew = new EntityWrapper< ChongwuzhenliaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chongwuzhenliao, "chongwuzhenliao")); 
		ChongwuzhenliaoView chongwuzhenliaoView =  chongwuzhenliaoService.selectView(ew);
		return R.ok("查询宠物诊疗成功").put("data", chongwuzhenliaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChongwuzhenliaoEntity chongwuzhenliao = chongwuzhenliaoService.selectById(id);
        return R.ok().put("data", chongwuzhenliao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChongwuzhenliaoEntity chongwuzhenliao = chongwuzhenliaoService.selectById(id);
        return R.ok().put("data", chongwuzhenliao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChongwuzhenliaoEntity chongwuzhenliao, HttpServletRequest request){
    	chongwuzhenliao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chongwuzhenliao);

        chongwuzhenliaoService.insert(chongwuzhenliao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChongwuzhenliaoEntity chongwuzhenliao, HttpServletRequest request){
    	chongwuzhenliao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chongwuzhenliao);

        chongwuzhenliaoService.insert(chongwuzhenliao);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ChongwuzhenliaoEntity chongwuzhenliao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chongwuzhenliao);
        chongwuzhenliaoService.updateById(chongwuzhenliao);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chongwuzhenliaoService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ChongwuzhenliaoEntity> wrapper = new EntityWrapper<ChongwuzhenliaoEntity>();
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
		if(tableName.equals("yonghu")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = chongwuzhenliaoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
