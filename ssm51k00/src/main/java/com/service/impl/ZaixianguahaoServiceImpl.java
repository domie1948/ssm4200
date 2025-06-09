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


import com.dao.ZaixianguahaoDao;
import com.entity.ZaixianguahaoEntity;
import com.service.ZaixianguahaoService;
import com.entity.vo.ZaixianguahaoVO;
import com.entity.view.ZaixianguahaoView;

@Service("zaixianguahaoService")
public class ZaixianguahaoServiceImpl extends ServiceImpl<ZaixianguahaoDao, ZaixianguahaoEntity> implements ZaixianguahaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZaixianguahaoEntity> page = this.selectPage(
                new Query<ZaixianguahaoEntity>(params).getPage(),
                new EntityWrapper<ZaixianguahaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZaixianguahaoEntity> wrapper) {
		  Page<ZaixianguahaoView> page =new Query<ZaixianguahaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZaixianguahaoVO> selectListVO(Wrapper<ZaixianguahaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZaixianguahaoVO selectVO(Wrapper<ZaixianguahaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZaixianguahaoView> selectListView(Wrapper<ZaixianguahaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZaixianguahaoView selectView(Wrapper<ZaixianguahaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
