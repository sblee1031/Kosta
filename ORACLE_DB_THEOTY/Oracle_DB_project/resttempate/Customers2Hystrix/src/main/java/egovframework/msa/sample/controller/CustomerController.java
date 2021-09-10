package egovframework.msa.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	int cnt=0;
	@GetMapping("/{customerId}")
	public String getCustomerDetail(@PathVariable String customerId) {
	//timeout test
//		long milli = 3*1000;
//		try {
//			Thread.sleep(milli);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println("request customerId :" + customerId);
//		return "[Customer id = " + customerId + " at " + System.currentTimeMillis() + "]";

		//exception test
//		throw new RuntimeException("I/O Exception");

		//circuit open test
		throw new RuntimeException("I/O Exception");
		
	}
}
