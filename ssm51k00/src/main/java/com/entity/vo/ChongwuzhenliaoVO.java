package com.entity.vo;

import com.entity.ChongwuzhenliaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 宠物诊疗
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-05-02 09:22:13
 */
public class ChongwuzhenliaoVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 医生工号
	 */
	
	private String yishenggonghao;
		
	/**
	 * 医生姓名
	 */
	
	private String yishengxingming;
		
	/**
	 * 账号
	 */
	
	private String zhanghao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 宠物名称
	 */
	
	private String chongwumingcheng;
		
	/**
	 * 宠物分类
	 */
	
	private String chongwufenlei;
		
	/**
	 * 症状描述
	 */
	
	private String zhengzhuangmiaoshu;
		
	/**
	 * 初步诊断
	 */
	
	private String chubuzhenduan;
		
	/**
	 * 药方
	 */
	
	private String yaofang;
		
	/**
	 * 诊治时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date zhenzhishijian;
				
	
	/**
	 * 设置：医生工号
	 */
	 
	public void setYishenggonghao(String yishenggonghao) {
		this.yishenggonghao = yishenggonghao;
	}
	
	/**
	 * 获取：医生工号
	 */
	public String getYishenggonghao() {
		return yishenggonghao;
	}
				
	
	/**
	 * 设置：医生姓名
	 */
	 
	public void setYishengxingming(String yishengxingming) {
		this.yishengxingming = yishengxingming;
	}
	
	/**
	 * 获取：医生姓名
	 */
	public String getYishengxingming() {
		return yishengxingming;
	}
				
	
	/**
	 * 设置：账号
	 */
	 
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：宠物名称
	 */
	 
	public void setChongwumingcheng(String chongwumingcheng) {
		this.chongwumingcheng = chongwumingcheng;
	}
	
	/**
	 * 获取：宠物名称
	 */
	public String getChongwumingcheng() {
		return chongwumingcheng;
	}
				
	
	/**
	 * 设置：宠物分类
	 */
	 
	public void setChongwufenlei(String chongwufenlei) {
		this.chongwufenlei = chongwufenlei;
	}
	
	/**
	 * 获取：宠物分类
	 */
	public String getChongwufenlei() {
		return chongwufenlei;
	}
				
	
	/**
	 * 设置：症状描述
	 */
	 
	public void setZhengzhuangmiaoshu(String zhengzhuangmiaoshu) {
		this.zhengzhuangmiaoshu = zhengzhuangmiaoshu;
	}
	
	/**
	 * 获取：症状描述
	 */
	public String getZhengzhuangmiaoshu() {
		return zhengzhuangmiaoshu;
	}
				
	
	/**
	 * 设置：初步诊断
	 */
	 
	public void setChubuzhenduan(String chubuzhenduan) {
		this.chubuzhenduan = chubuzhenduan;
	}
	
	/**
	 * 获取：初步诊断
	 */
	public String getChubuzhenduan() {
		return chubuzhenduan;
	}
				
	
	/**
	 * 设置：药方
	 */
	 
	public void setYaofang(String yaofang) {
		this.yaofang = yaofang;
	}
	
	/**
	 * 获取：药方
	 */
	public String getYaofang() {
		return yaofang;
	}
				
	
	/**
	 * 设置：诊治时间
	 */
	 
	public void setZhenzhishijian(Date zhenzhishijian) {
		this.zhenzhishijian = zhenzhishijian;
	}
	
	/**
	 * 获取：诊治时间
	 */
	public Date getZhenzhishijian() {
		return zhenzhishijian;
	}
			
}
