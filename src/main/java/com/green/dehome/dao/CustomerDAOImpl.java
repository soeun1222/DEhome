package com.green.dehome.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.green.dehome.dto.CustomerDTO;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Inject
	SqlSession sqlSession;

	// QnA
	@Override // 목록보기
	public List<CustomerDTO> qna_list(CustomerDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mappers.customerMapper.qna_list", dto);
	}

	@Override
	public int countList() {
		return sqlSession.selectOne("mappers.customerMapper.count");
	}

	@Override // 상세내용보기
	public CustomerDTO qna_show(int qna_no) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mappers.customerMapper.qna_show", qna_no);
	}

	@Override // 게시글작성
	public void qna_insert(CustomerDTO customerDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("mappers.customerMapper.qna_insert", customerDTO);
	}

	@Override // 수정
	public void qna_modify(CustomerDTO customerDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("mappers.customerMapper.qna_modify", customerDTO);
	}

	@Override // 삭제
	public void qna_delete(int qna_no) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("mappers.customerMapper.qna_delete", qna_no);
	}

	@Override
	public void qna_hitUp(int qna_no) throws Exception {
		sqlSession.update("mappers.customerMapper.qna_hitUp", qna_no);
	}

	@Override
	public int qna_getHit(int qna_no) throws Exception {
		return sqlSession.selectOne("mappers.customerMapper.qna_getHit", qna_no);
	}

	@Override
	public void qna_c_insert(CustomerDTO dto) throws Exception {
		sqlSession.insert("mappers.customerMapper.qna_c_insert", dto);

	}

	@Override
	public void qna_c_processing(CustomerDTO dto) throws Exception {
		sqlSession.update("mappers.customerMapper.qna_c_processing", dto);

	}

	@Override
	public CustomerDTO qna_c_show(int qna_no) throws Exception {
		return sqlSession.selectOne("mappers.customerMapper.qna_c_show", qna_no);
	}

	@Override
	public void qna_c_modify(CustomerDTO dto) throws Exception {
		sqlSession.update("mappers.customerMapper.qna_c_modify", dto);

	}

	@Override
	public void qna_c_delete(int qna_no) throws Exception {
		sqlSession.delete("mappers.customerMapper.qna_c_delete", qna_no);

	}
	
	@Override
	public void qna_c_processing_re(CustomerDTO dto) throws Exception {
		sqlSession.update("mappers.customerMapper.qna_c_processing_re", dto);
	}
	
	

	
	// notice
	@Override // 게시글작성
	public void not_insert(CustomerDTO customerDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("mappers.customerMapper.not_insert", customerDTO);
	}

	@Override
	public List<CustomerDTO> not_list(CustomerDTO dto) throws Exception {
		return sqlSession.selectList("mappers.customerMapper.not_list", dto);
	}

	@Override
	public int not_countList() {
		return 0;
	}

	@Override
	public CustomerDTO not_show(int not_no) throws Exception {
		return sqlSession.selectOne("mappers.customerMapper.not_show", not_no);
	}

	@Override
	public void not_modify(CustomerDTO customerDTO) throws Exception {
		sqlSession.update("mappers.customerMapper.not_modify", customerDTO);
	}

	@Override
	public void not_delete(int not_no) throws Exception {
		sqlSession.delete("mappers.customerMapper.not_delete", not_no);
	}

	@Override
	public void not_hitUp(int not_no) throws Exception {
		sqlSession.update("mappers.customerMapper.not_hitUp", not_no);
	}

	@Override
	public int not_getHit(int not_no) throws Exception {
		return sqlSession.selectOne("mappers.customerMapper.not_getHit", not_no);
	}

	

}
