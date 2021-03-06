package co.micol.prj.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.user.service.UserService;
import co.micol.prj.user.service.UserVO;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping("getUser.do")
	public String getUser(UserVO vo, Model model) {
		model.addAttribute("user",  userService.getUser(vo));
		return "users/getUser"; //íŽėë
	}
	
	@RequestMapping("getUserList.do")
	public String getUserList(Model model, UserVO vo) {
		model.addAttribute("userList", 
				             userService.getUserList(vo));
		return "users/getUserList";
	}
	
	@RequestMapping("getUserListMap.do")
	public String getUserListMap(Model model, UserVO vo) {
		model.addAttribute("userList", 
				             userService.getUserListMap(vo));
		return "users/getUserList";
	}	
}
