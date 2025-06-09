package com.entity.view;

import com.entity.ZaixianguahaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 在线挂号
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-02 09:22:13
 */
@TableName("zaixianguahao")
public class ZaixianguahaoView  extends ZaixianguahaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZaixianguahaoView(){
	}
 
 	public ZaixianguahaoView(ZaixianguahaoEntity zaixianguahaoEntity){
 	try {
			BeanUtils.copyProperties(this, zaixianguahaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
