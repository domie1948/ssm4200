package com.entity.view;

import com.entity.ZaixianmenzhenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 在线门诊
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-02 09:22:13
 */
@TableName("zaixianmenzhen")
public class ZaixianmenzhenView  extends ZaixianmenzhenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZaixianmenzhenView(){
	}
 
 	public ZaixianmenzhenView(ZaixianmenzhenEntity zaixianmenzhenEntity){
 	try {
			BeanUtils.copyProperties(this, zaixianmenzhenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
