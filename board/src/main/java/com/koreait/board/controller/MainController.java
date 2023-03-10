package com.koreait.board.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.board.dto.GetTestResponseDto;
import com.koreait.board.dto.PostTestRequestDto;

// 해당 클래스를 REST API로 사용되는 Controller로 지정 할 수 있음
// Controller = react의 route와 비슷함
@RestController
// 해당 클래스를 특정 Request URL 패턴에서 사용하도록 지정
@RequestMapping("apis")
public class MainController {
	
	// HTTP 메서드 중 GET 방식의 요청에 대한 처리를 지정할 때 사용
	@GetMapping("/")
	public String getMain() {
		return "Hello World";
	}
	
	// PathVariable(path) : GET / DELETE 방식에서 사용할 수 있음
	//                      URL Path로 클라이언트로부터 데이터를 받아서 변수로 사용할 수 있게 함
	@GetMapping("/variable/{data}")
	public String getVariable(@PathVariable("data") String data) {
		return "You input data is '" + data + "'";
	}
	
	// HTTP 메서드 중 POST 방식의 요청에 대한 처리를 지정할 때 사용
	@PostMapping("/")
	public String postMain() {
		return "POST main Response!";
	}
	
	// @RequestBody : POST / PATCH 방식에서 사용할 수 있음
	//                클라이언트로 부터 request body로 데이터를 받고자 할 때 사용
	@PostMapping("/requestBody")
	public String postRequestBody(@RequestBody String data) {
		return "Post body data is '" + data + "'";
	}
	
	// HTTP 메서드 중 PATCH 방식의 요청에 대한 처리를 지정할 때 사용
	@PatchMapping("/")
	public String patchMain() {
		return "Patch 메서드는 수정 작업을 지정한 메서드입니다. 클라이언트로부터 데이터를 받을 땐 request body로 받습니다.";
	}
	
	// HTTP 메서드 중 DELETE 방식의 요청에 대한 처리를 지정할 때 사용
	@DeleteMapping("/")
	public String deleteMain() {
		return "Delete 메서드는 삭제 작업을 지정한 메서드입니다. 클라이언트로부터 데이터를 받을 땐 path variable로 받습니다.";
	}
	
	// request body 혹은 response body로 객체를 담을 때는 Dto 사용해서 전송 혹은 수신
	@PostMapping("/test")
	public String postTest(@Valid @RequestBody PostTestRequestDto requestBody) {
		return requestBody.toString();
	}
	@GetMapping("/test")
	public GetTestResponseDto getTest() {
		return new GetTestResponseDto(10, "Comment");
	}

}





