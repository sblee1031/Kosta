package com.day.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.day.dto.Customer;
import com.day.dto.RepBoard;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.exception.RemoveException;
import com.day.service.RepBoardService;

@RestController
@RequestMapping("/board/*")
public class RepBoardController {
	private Logger log = Logger.getLogger(RepBoardController.class);
	@Autowired
	private RepBoardService service;
	@PostMapping("/write")
	public Map<String, Object> write(@RequestBody RepBoard repBoard) {
		//System.out.println(repBoard);
		Map<String, Object> result = new HashMap<>();
		try {
			log.error(repBoard);
			service.write(repBoard);
			result.put("status",1);
		} catch (AddException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("status",0);//실패
			result.put("msg",e.getMessage());//실패
		}
		return result;
	}
	
	@PostMapping("/reply/{no}")
	public Map<String, Object> reply(@PathVariable int no,//부모글번호
			@RequestBody RepBoard repBoard) {
		Map<String, Object> result = new HashMap<>();
		try {
			repBoard.setParentNo(no);
			service.reply(repBoard);
			result.put("status",1);
		} catch (AddException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("status",0);//실패
			result.put("msg",e.getMessage());//실패
		}
		return result;
	}
	
	@GetMapping(value = {"/list","/list/{word}"})
	public Map<String, Object> list(@PathVariable(name = "word") Optional<String> optWord){
		Map<String, Object> result =new HashMap<String, Object>();
		List<RepBoard> list = new ArrayList<RepBoard>();
		try {
		if(optWord.isPresent()) {
			list = service.list(optWord.get());
		}else {
			list = service.list();
		}
		result.put("status", 1);
		result.put("list", list);
		}catch(FindException e) {
			result.put("status", 0);
			result.put("msg", e.getMessage());
		}
		return result;
	}
	
	@GetMapping("/{no}")
	public Map<String, Object> info(@PathVariable(name = "no") int boardNo){
		Map<String, Object> result =new HashMap<>();
		RepBoard board = new RepBoard();
		try {
			board = service.info(boardNo);
		result.put("status", 1);
		result.put("board", board);
		}catch(FindException e) {
			result.put("status", 0);
			result.put("msg", e.getMessage());
		}
		return result;
	}
	
	@PutMapping("/{no}")
	public Map<String, Object> modify(@PathVariable int no, 
			@RequestBody RepBoard repBoard
			) {
		Map<String, Object> result =new HashMap<>();
		log.error(repBoard);
		Customer boardC = new Customer();
		boardC.setId("id1");
		try {
			repBoard.setBoardNo(no);
			repBoard.setBoardC(boardC);
			service.modify(repBoard);
			result.put("status", 1);
		} catch (AddException e) {
			e.printStackTrace();
			result.put("status", 0);
			result.put("msg", e.getMessage());
		}
		return result;
		}
	
		@DeleteMapping("/{no}")
	   public Map<String, Object> remove(@PathVariable int no) {
	      
	       Map<String, Object> result = new HashMap<String, Object>();
	      //---->session의 loginInfo속성으로 차후 변경
	      Customer boardC = new Customer();
	      boardC.setId("id1");
	      RepBoard repBoard = new RepBoard();
	      repBoard.setBoardNo(no);
	      repBoard.setBoardC(boardC);
	      try {
	      service.remove(repBoard);
	      result.put("status",1);
	      }catch(RemoveException e) {
	         e.printStackTrace();
	         result.put("status",0);
	         result.put("msg",e.getMessage());
	      }
	      return result;
	   }
		
/*		 @DeleteMapping("/{no}") 
		 public void remove(@PathVariable int no,
		  @RequestBody RepBoard repBoard){ 
			 Map<String, Object> result =new HashMap<>();
		 log.error(repBoard); 
		 try { repBoard.setBoardNo(no);
			 repBoard.setBoardC(repBoard.getBoardC()); 
			 service.remove(repBoard);
			  result.put("status", 1); 
		  } catch (RemoveException e) {
			  e.printStackTrace();
		  result.put("status", 0);
		  result.put("msg", e.getMessage()); } 
		 //return result;
		 }*/
		 
	
}
