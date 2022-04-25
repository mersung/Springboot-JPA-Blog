package com.cos.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.blog.service.BoardService;

@Controller
public class BoardController {

	
		@Autowired
		private BoardService boardService;
		
	
		//컨트롤러에서 세션을 어떻게 찾는지?
		//@AuthenticationPrincipal PrincipalDetail principal
		@GetMapping({"","/"}) // 아무것도 안 적었을 때와 슬래시를 붙였을 때 이동
		//스프링에서는 메인페이지로 갈 때 모델이 필요함		
		public String index(Model model, @PageableDefault(size=3, sort="id", direction = Sort.Direction.DESC) Pageable pageable) { 
			//index 페이지로 boards를 넘긴다.
			model.addAttribute("boards", boardService.글목록(pageable));//model은 jsp의 request라고 생각하면 됨
			// /WEB-INF/views/index.jsp 로 자동
			return "index"; //controller는 리턴시 viewResolver작동, 해당 index페이지로 model의 정보를 들고 이동
			
		}
		
		@GetMapping("/board/{id}")
		public String findById(@PathVariable int id, Model model) {
			model.addAttribute("board", boardService.글상세보기(id));

			return "board/detail";
			
		}
		
		@GetMapping("/board/{id}/updateForm")
		public String updateForm(@PathVariable int id, Model model) {
			model.addAttribute("board", boardService.글상세보기(id));
			return "board/updateForm";
		}
		
		//USER권한이 필요
		@GetMapping("/board/saveForm")
		public String saveForm() {
			return "board/saveForm";
		}
}
