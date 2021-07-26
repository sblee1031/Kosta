package com.day.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
/**
 * Restpul용 요청방식 종류
 * @Get - 검색
 * POST - 추가
 * PUT - 수정
 * DELETE - 삭제
 *
 */
public class RestController {
	private Logger log = Logger.getLogger(RestController.class);
	@PostMapping("/board")
	public Map<String, Object> write(@RequestBody //요청전달데이터가 application/json타입으로 전달됨
			Map<String,String> map) {
		log.error("/board 추가 시작");
		log.error("map: "+map);
		
		Map<String, Object> result = new HashMap<>();
		result.put("status", 1);
		result.put("msg", "성공11");
		
		return result;
	}
/*	@PostMapping(value = "/board/reply/{no}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> reply(@PathVariable int no, 
								@RequestBody Map<String, String>map) {
		log.error(map);
		ResponseEntity<String> responseEntity = //new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		new ResponseEntity<>("답글쓰기 실패",HttpStatus.INTERNAL_SERVER_ERROR);
		log.error(responseEntity.getBody());
		return responseEntity;
	}*/
	
	@PostMapping(value = "/board/reply/{no}")
	public ResponseEntity<Map<String,Object>> reply(@PathVariable int no, 
			@RequestBody Map<String, String>map) {
		Map<String, Object> result = new HashMap<>();
		result.put("msg", "답글쓰기 실패");
		ResponseEntity<Map<String,Object>> responseEntity = //new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				//new ResponseEntity<>(result,HttpStatus.INTERNAL_SERVER_ERROR);
				new ResponseEntity<>(result,HttpStatus.OK);
				log.error(responseEntity.getBody());
				return responseEntity;
	}
	
	//@GetMapping("/board/list")
	//public List<Map<String, Object>> list(){
	@GetMapping(value = {"/board/list", "/board/list/{word}"})
	//public List<Map<String, Object>> list(@PathVariable(required = false) String word){
	public List<Map<String, Object>> list(@PathVariable(name = "word") Optional<String> optWord){
		String word = null;
		List<Map<String, Object>> resultList = new ArrayList<>();
		if(optWord.isPresent()) {
			word = optWord.get();
			log.error("/board 단어검색 시작 word:"+word);
			Map<String, Object> result = new HashMap<> ();
			result.put("no", 1);
			result.put("title", "제목1");
			result.put("content","내용1");
			resultList.add(result);
			result.put("no", 1);
			result.put("title", "제목1");
			result.put("content","내용1");
			resultList.add(result);
		}else {
			Map<String, Object> result = new HashMap<> ();
			log.error("/board 전체검색 시작");
			result.put("no", 1);
			result.put("title", "제목1");
			result.put("content","내용1");
			resultList.add(result);

			result = new HashMap<>();
			result.put("no", 2);
			result.put("title", "제목2");
			result.put("content","내용2");
			resultList.add(result);
			
			result = new HashMap<>();
			result.put("no", 3);
			result.put("title", "제목3");
			result.put("content","내용3");
			resultList.add(result);
		}
		return resultList;
	}
	
	@GetMapping("/board/{no}")
	public Map<String, Object> info(@PathVariable int no) {
		Map<String, Object> result = new HashMap<> ();
		result.put("no", no);
		result.put("title", "제목1");
		result.put("content","내용1");
		return result;
	}
	
	@PutMapping("/board/{no}")
/*	public void modify(@PathVariable int no, 
			@RequestBody Map<String, String> map
			) {
		log.error(map);
	}*/
		public ResponseEntity<String> modify(@PathVariable int no, 
			@RequestBody Map<String, String> map
			) {
		log.error(map);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
		}
	@DeleteMapping("/board/{no}")
	public ResponseEntity<String> remove(@PathVariable int no){
		ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		return responseEntity;
		
	}
	
}
