package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChongwuzhenliaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChongwuzhenliaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChongwuzhenliaoView;


/**
 * 宠物诊疗
 *
 * @author 
 * @email 
 * @date 2021-05-02 09:22:13
 */
public interface ChongwuzhenliaoService extends IService<ChongwuzhenliaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChongwuzhenliaoVO> selectListVO(Wrapper<ChongwuzhenliaoEntity> wrapper);
   	
   	ChongwuzhenliaoVO selectVO(@Param("ew") Wrapper<ChongwuzhenliaoEntity> wrapper);
   	
   	List<ChongwuzhenliaoView> selectListView(Wrapper<ChongwuzhenliaoEntity> wrapper);
   	
   	ChongwuzhenliaoView selectView(@Param("ew") Wrapper<ChongwuzhenliaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChongwuzhenliaoEntity> wrapper);
   	
}

