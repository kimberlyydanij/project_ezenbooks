package com.ezenbooks.backend.controller;

import java.net.http.HttpHeaders;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezenbooks.backend.dto.ReviewDTO;
import com.ezenbooks.backend.service.ReviewService;

@CrossOrigin("*")
@RestController
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	public ReviewController() {
	}

	public void setReviewService(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@GetMapping("/review/{book_num}")
	public List<ReviewDTO> reviewList(@PathVariable("book_num") int book_num ) throws Exception {
		return reviewService.reviewList(book_num);
	}
	
	// http://localhost:8090/review
	@PostMapping("/review")
	public ResponseEntity<Object> postReview(@RequestBody ReviewDTO reviewDTO) throws Exception {
		System.out.println("review_controller");
		int chk = reviewService.insert(reviewDTO);
		System.out.println("review_controller: " + chk);

		/* 여기 왜 자꾸 에러날까? 
		 * HttpHeaders headers = new HttpHeaders();
		 */
		
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

		HashMap<String, String> map = new HashMap<>();
		map.put("createDate", new Date().toString());
		map.put("message", "insert ok");

		if (chk >= 1) {
			return new ResponseEntity<Object>(map, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PutMapping("/review/{user_id}/{review_content}")
	public void putReview(@PathVariable("user_id") int user_id, @PathVariable("review_content") String review_content)
			throws Exception {
		System.out.printf("id=%d, completed=%d\n", user_id, review_content);
		ReviewDTO reviewDTO = new ReviewDTO();
		 reviewDTO.setUser_id(user_id);
		 reviewDTO.setReview_content(review_content);
		reviewService.update(reviewDTO);
	}

	// http://localhost:8090/review/11
	@ResponseBody
	@DeleteMapping("/review/{user_id}")
	public void deleteReview(@PathVariable("user_id") int user_id) throws Exception {
		System.out.printf("id=%d\n", user_id);
		reviewService.delete(user_id);
	}
}
