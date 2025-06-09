package com.entity.view;

import com.entity.ChongwuzhenliaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 宠物诊疗
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-02 09:22:13
 */
@TableName("chongwuzhenliao")
public class ChongwuzhenliaoView  extends ChongwuzhenliaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChongwuzhenliaoView(){
	}
 
 	public ChongwuzhenliaoView(ChongwuzhenliaoEntity chongwuzhenliaoEntity){
 	try {
			BeanUtils.copyProperties(this, chongwuzhenliaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
