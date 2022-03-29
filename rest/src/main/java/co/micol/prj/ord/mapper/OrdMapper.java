package co.micol.prj.ord.mapper;

import org.apache.ibatis.annotations.Insert;

public interface OrdMapper {
	//등록
	@Insert("insert into ord values (#{data})")
	public int insert(String data);
}
