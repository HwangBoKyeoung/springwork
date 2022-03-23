package co.micol.prj.member.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import co.micol.prj.member.mapper.MemberMapper;
import co.micol.prj.member.vo.MemberVO;

//	rest uri 형태로 생성
@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5500"})	//이 서버에서 들어온 요청은 허락해라{},{} 로 여러개 넣을수있음
public class MemberRestController {
	@Autowired
	MemberMapper mapper;
	
//	외부연동 로그인 구현할 때 활용할 것.
	@GetMapping("/movie")
	public Map movie() {
		RestTemplate template = new RestTemplate();
		String url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220320";
		Map map = template.getForObject(url, Map.class); 		// (uri, vo type etc..)
		System.out.println(map);
		return map;
	}
	
	/*
	 * @GetMapping(value="/test", produces = "text/plain") 
	 * public String test(){
	 * 	return "Plain Text"; 
	 * }
	 */
	
	@GetMapping(value="/test", produces = "text/plain")
	public ResponseEntity<String> test(@RequestParam int num){
		if(num<10) {
//			상태값 405로 넘기기(에러로 간주)
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("error");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("success");
		}
	}
	
	@GetMapping("/member")
//	@ResponseBody	//jackson : java Object -> json string 변환 (RestController로 할 경우, 이 것을 하나씩 넣어줄 필요없음)
	public List<MemberVO> list(){
		return mapper.memberSelectList();
	}
	
	@PostMapping("/member")
	public MemberVO insert(MemberVO vo){
		mapper.memberInsert(vo);
		return vo;
	}
	
	@PutMapping("/member")
	@ResponseBody	//응답값을 json으로 <-> json을 vo에 담기 : RequestBody
	public MemberVO update(@RequestBody MemberVO vo) {
		mapper.memberUpdate(vo);
		return vo;
	}
	
	@GetMapping("/member/{id}")
	public MemberVO select(@PathVariable String id){
		MemberVO vo = new MemberVO();
		vo.setId(id);
		return mapper.memberSelect(vo);
	}
	
	@DeleteMapping("/member/{id}")
	public MemberVO delete(@PathVariable String id){
		MemberVO vo = new MemberVO();
		vo.setId(id);
		mapper.memberDelete(vo);
		return vo;
	}
}
