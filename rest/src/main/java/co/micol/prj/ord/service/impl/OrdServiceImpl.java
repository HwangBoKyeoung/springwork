package co.micol.prj.ord.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.micol.prj.ord.mapper.OrdDtlMapper;
import co.micol.prj.ord.mapper.OrdMapper;
import co.micol.prj.ord.service.OrdService;

@Service
public class OrdServiceImpl implements OrdService {

	@Autowired OrdDtlMapper ordDtlMapper;
	@Autowired OrdMapper ordMapper;
	
	@Override
	@Transactional
	public int insert(String data) {		
		int r = ordMapper.insert(data);
		ordDtlMapper.insert(data);
		return r;
	}
}
