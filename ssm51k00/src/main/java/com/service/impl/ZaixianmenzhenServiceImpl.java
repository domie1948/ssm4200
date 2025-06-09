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


import com.dao.ZaixianmenzhenDao;
import com.entity.ZaixianmenzhenEntity;
import com.service.ZaixianmenzhenService;
import com.entity.vo.ZaixianmenzhenVO;
import com.entity.view.ZaixianmenzhenView;

@Service("zaixianmenzhenService")
public class ZaixianmenzhenServiceImpl extends ServiceImpl<ZaixianmenzhenDao, ZaixianmenzhenEntity> implements ZaixianmenzhenService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZaixianmenzhenEntity> page = this.selectPage(
                new Query<ZaixianmenzhenEntity>(params).getPage(),
                new EntityWrapper<ZaixianmenzhenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZaixianmenzhenEntity> wrapper) {
		  Page<ZaixianmenzhenView> page =new Query<ZaixianmenzhenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZaixianmenzhenVO> selectListVO(Wrapper<ZaixianmenzhenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZaixianmenzhenVO selectVO(Wrapper<ZaixianmenzhenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZaixianmenzhenView> selectListView(Wrapper<ZaixianmenzhenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZaixianmenzhenView selectView(Wrapper<ZaixianmenzhenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
