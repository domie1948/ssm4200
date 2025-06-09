package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ChongwuzhenliaoDao;
import com.entity.ChongwuzhenliaoEntity;
import com.service.ChongwuzhenliaoService;
import com.entity.vo.ChongwuzhenliaoVO;
import com.entity.view.ChongwuzhenliaoView;

@Service("chongwuzhenliaoService")
public class ChongwuzhenliaoServiceImpl extends ServiceImpl<ChongwuzhenliaoDao, ChongwuzhenliaoEntity> implements ChongwuzhenliaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChongwuzhenliaoEntity> page = this.selectPage(
                new Query<ChongwuzhenliaoEntity>(params).getPage(),
                new EntityWrapper<ChongwuzhenliaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChongwuzhenliaoEntity> wrapper) {
		  Page<ChongwuzhenliaoView> page =new Query<ChongwuzhenliaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChongwuzhenliaoVO> selectListVO(Wrapper<ChongwuzhenliaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChongwuzhenliaoVO selectVO(Wrapper<ChongwuzhenliaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChongwuzhenliaoView> selectListView(Wrapper<ChongwuzhenliaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChongwuzhenliaoView selectView(Wrapper<ChongwuzhenliaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
