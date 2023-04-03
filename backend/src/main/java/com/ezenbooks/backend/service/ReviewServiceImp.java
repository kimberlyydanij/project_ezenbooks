package com.ezenbooks.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezenbooks.backend.dao.ReviewDAO;
import com.ezenbooks.backend.dto.ReviewDTO;

@Service
public class ReviewServiceImp implements ReviewService{
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	public ReviewServiceImp() {
	
	}
	
	public void setReviewDAO(ReviewDAO reviewDAO) {
		this.reviewDAO = reviewDAO;
	}
	
	@Override
	public List<ReviewDTO> reviewList(int book_num) throws Exception {
		return reviewDAO.reviewList(book_num);
	}

	@Override
	public int insert(ReviewDTO reviewdDTO) throws Exception {
		System.out.println("ReviewService");
		return reviewDAO.insertReview(reviewdDTO);
	}

	@Override
	public int update(ReviewDTO reviewDTO) throws Exception {
		return reviewDAO.updateReview(reviewDTO);
	}

	@Override
	public int delete(int user_id) throws Exception {
		return reviewDAO.deleteReview(user_id);
	}
}