package com.dao;

import com.entity.ChongwuzhenliaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChongwuzhenliaoVO;
import com.entity.view.ChongwuzhenliaoView;


/**
 * 宠物诊疗
 * 
 * @author 
 * @email 
 * @date 2021-05-02 09:22:13
 */
public interface ChongwuzhenliaoDao extends BaseMapper<ChongwuzhenliaoEntity> {
	
	List<ChongwuzhenliaoVO> selectListVO(@Param("ew") Wrapper<ChongwuzhenliaoEntity> wrapper);
	
	ChongwuzhenliaoVO selectVO(@Param("ew") Wrapper<ChongwuzhenliaoEntity> wrapper);
	
	List<ChongwuzhenliaoView> selectListView(@Param("ew") Wrapper<ChongwuzhenliaoEntity> wrapper);

	List<ChongwuzhenliaoView> selectListView(Pagination page,@Param("ew") Wrapper<ChongwuzhenliaoEntity> wrapper);
	
	ChongwuzhenliaoView selectView(@Param("ew") Wrapper<ChongwuzhenliaoEntity> wrapper);
	
}
