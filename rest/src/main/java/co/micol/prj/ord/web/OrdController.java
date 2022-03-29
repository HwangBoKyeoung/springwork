package co.micol.prj.ord.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.micol.prj.ord.service.OrdService;

@Controller
public class OrdController {

	@Autowired OrdService ordService;
	
	@GetMapping("/ord")
	public void ord (String data) {
		ordService.insert(data);
	}
	
}
