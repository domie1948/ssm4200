package com.dao;

import com.entity.ZaixianmenzhenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZaixianmenzhenVO;
import com.entity.view.ZaixianmenzhenView;


/**
 * 在线门诊
 * 
 * @author 
 * @email 
 * @date 2021-05-02 09:22:13
 */
public interface ZaixianmenzhenDao extends BaseMapper<ZaixianmenzhenEntity> {
	
	List<ZaixianmenzhenVO> selectListVO(@Param("ew") Wrapper<ZaixianmenzhenEntity> wrapper);
	
	ZaixianmenzhenVO selectVO(@Param("ew") Wrapper<ZaixianmenzhenEntity> wrapper);
	
	List<ZaixianmenzhenView> selectListView(@Param("ew") Wrapper<ZaixianmenzhenEntity> wrapper);

	List<ZaixianmenzhenView> selectListView(Pagination page,@Param("ew") Wrapper<ZaixianmenzhenEntity> wrapper);
	
	ZaixianmenzhenView selectView(@Param("ew") Wrapper<ZaixianmenzhenEntity> wrapper);
	
}
