package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZaixianguahaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZaixianguahaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZaixianguahaoView;


/**
 * 在线挂号
 *
 * @author 
 * @email 
 * @date 2021-05-02 09:22:13
 */
public interface ZaixianguahaoService extends IService<ZaixianguahaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZaixianguahaoVO> selectListVO(Wrapper<ZaixianguahaoEntity> wrapper);
   	
   	ZaixianguahaoVO selectVO(@Param("ew") Wrapper<ZaixianguahaoEntity> wrapper);
   	
   	List<ZaixianguahaoView> selectListView(Wrapper<ZaixianguahaoEntity> wrapper);
   	
   	ZaixianguahaoView selectView(@Param("ew") Wrapper<ZaixianguahaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZaixianguahaoEntity> wrapper);
   	
}

