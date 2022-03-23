package co.micol.prj;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.micol.prj.member.mapper.MemberMapper;
import co.micol.prj.member.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/config/*-context.xml")
public class MemberMapperClient {
	@Autowired
	MemberMapper mapper;
	
	/* @Test */
	public void listTest() {
		List<MemberVO> list = mapper.memberSelectList();
		System.out.println(list);
	}
	
	@Test
	public void selectTest() {
		MemberVO vo = new MemberVO();
		vo.setId("park");
		vo.setPassword("park");
		assertEquals(vo.getId(), "park");
	}
	
	@org.junit.Before
	public void deleteTest() {
		MemberVO vo = new MemberVO();
		vo.setId("good");
		mapper.memberDelete(vo);
	}
	
	@Test
	public void insertTest() {
		MemberVO vo = new MemberVO();
		vo.setId("good");
		vo.setAddress("add");
		vo.setName("hhh");
		vo.setPassword("hhh");
		vo.setTel("010");
		vo.setAuthor("user");
		int n = mapper.memberInsert(vo);
		System.out.println(n);
		assertEquals(n, 1);
	}
}
