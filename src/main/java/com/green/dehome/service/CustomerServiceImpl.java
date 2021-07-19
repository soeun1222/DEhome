package com.green.dehome.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.green.dehome.dao.CustomerDAO;
import com.green.dehome.dto.CustomerDTO;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {
	@Inject
	CustomerDAO customerDao;

	// QnA

	@Override // 게시글작성
	public void qna_insert(CustomerDTO customerDTO) throws Exception {
		customerDao.qna_insert(customerDTO);
	}

	@Override // 게시글전체목록
	public List<CustomerDTO> qna_list(CustomerDTO dto) throws Exception {
		return customerDao.qna_list(dto);
	}

	@Override
	public int countList() {
		return customerDao.countList();
	}

	@Override // 게시글상세보기
	public CustomerDTO qna_show(int qna_no) throws Exception {
		return customerDao.qna_show(qna_no);
	}

	@Override
	public void qna_hitUp(int qna_no) throws Exception {
		customerDao.qna_hitUp(qna_no);

	}

	@Override
	public int qna_getHit(int qna_no) throws Exception {
		return customerDao.qna_getHit(qna_no);
	}

	@Override // 게시글수정
	public void qna_modify(CustomerDTO customerDTO) throws Exception {
		customerDao.qna_modify(customerDTO);

	}

	@Override // 게시글삭제
	public void qna_delete(int qna_no) throws Exception {
		customerDao.qna_delete(qna_no);

	}

	// QNA_C
	@Override
	public void qna_c_insert(CustomerDTO dto) throws Exception {
		customerDao.qna_c_insert(dto);

	}

	@Override
	public void qna_c_processing(CustomerDTO dto) throws Exception {
		customerDao.qna_c_processing(dto);

	}

	@Override
	public CustomerDTO qna_c_show(int qna_no) throws Exception {
		return customerDao.qna_c_show(qna_no);
	}

	@Override
	public void qna_c_modify(CustomerDTO dto) throws Exception {
		customerDao.qna_c_modify(dto);

	}

	@Override
	public void qna_c_delete(int qna_no) throws Exception {
		customerDao.qna_c_delete(qna_no);

	}
	
	//qna_processing 처리
	public void qna_c_processing_re(CustomerDTO dto) throws Exception{
		customerDao.qna_c_processing_re(dto);
	}
		
		

	// Notice
	@Override // 게시글전체목록
	public List<CustomerDTO> not_list(CustomerDTO dto) throws Exception {
		return customerDao.not_list(dto);
	}

	@Override
	public int not_countList() {
		return customerDao.not_countList();
	}

	@Override // 게시글상세보기
	public CustomerDTO not_show(int not_no) throws Exception {
		return customerDao.not_show(not_no);
	}

	@Override // 게시글작성
	public void not_insert(CustomerDTO customerDTO) throws Exception {
		customerDao.not_insert(customerDTO);
	}

	@Override // 게시글수정
	public void not_modify(CustomerDTO customerDTO) throws Exception {
		customerDao.not_modify(customerDTO);

	}

	@Override // 게시글삭제
	public void not_delete(int not_no) throws Exception {
		customerDao.not_delete(not_no);

	}

	@Override
	public void not_hitUp(int not_no) throws Exception {
		customerDao.not_hitUp(not_no);

	}

	@Override
	public int not_getHit(int not_no) throws Exception {
		return customerDao.not_getHit(not_no);
	}

}
