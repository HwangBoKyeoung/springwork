package co.micol.prj.ord.mapper;

import org.apache.ibatis.annotations.Insert;

public interface OrdDtlMapper {
	//등록
	@Insert("insert into ord_dtl values (#{data})")
	public int insert(String data);
}
