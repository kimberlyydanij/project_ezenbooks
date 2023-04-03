package com.ezenbooks.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ezenbooks.backend.dto.ReviewDTO;

@Service
public interface ReviewService {
	
	public List<ReviewDTO> reviewList(int book_num) throws Exception;	
	
	public int insert(ReviewDTO reviewDTO) throws Exception;
	
	public int update(ReviewDTO reviewDTO) throws Exception;
	
	public int delete(int user_id) throws Exception;
	
}
