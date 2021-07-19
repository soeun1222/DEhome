package com.green.dehome.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.green.dehome.dao.InteriorTipDAO;
import com.green.dehome.dto.InteriorDTO;
import com.green.dehome.dto.InteriorTipDTO;
import com.green.dehome.dto.TradeDTO;

@Service
public class InteriorTipServiceImpl implements InteriorTipService {
	
	@Inject
	private InteriorTipDAO dao;
	
	@Override
	public List<InteriorTipDTO> tiplistConstruct(InteriorTipDTO dto) throws Exception {
		return dao.tipListConstruct(dto);
	}


	@Override
	public List<InteriorTipDTO> tipListStorage(InteriorTipDTO dto) throws Exception {
		return dao.tipListStorage(dto);
	}

	@Override
	public List<InteriorTipDTO> tipListDecorate(InteriorTipDTO dto) throws Exception {
		return dao.tipListDecorate(dto);
	}

	@Override
	public List<InteriorTipDTO> tipListCleaning(InteriorTipDTO dto) throws Exception {
		return dao.tipListCleaning(dto);
	}

	@Override
	public List<InteriorTipDTO> tipListDiy(InteriorTipDTO dto) throws Exception {
		return dao.tipListDiy(dto);
	}

	@Override
	public List<InteriorTipDTO> tipListReform(InteriorTipDTO dto) throws Exception {
		return dao.tipListReform(dto);
	}

	@Override
	public List<InteriorTipDTO> tipListKitchen(InteriorTipDTO dto) throws Exception {
		return dao.tipListKitchen(dto);
	}

	@Override
	public List<InteriorTipDTO> tipListLighting(InteriorTipDTO dto) throws Exception {
		return dao.tipListLighting(dto);
	}

	@Override
	public List<InteriorTipDTO> tipListCategory(InteriorTipDTO dto, String category) throws Exception {
		return dao.tipListCategory(dto, category);
	}
	
	@Override
	public void tipWrite(InteriorTipDTO dto) throws Exception {
		dao.tipWrite(dto);
	}

	@Override
	public InteriorTipDTO tipListPage(InteriorTipDTO dto, int tip_no) {
		return dao.tipListPage(dto, tip_no);
	}

	@Override
	public void setCount(int tip_no) {
		dao.setCount(tip_no);
	}


	@Override
	public void tipBookmark(InteriorTipDTO dto) throws Exception {
		dao.tipBookmark(dto);
	}


	@Override
	public InteriorTipDTO bmOnOff(InteriorTipDTO dto) throws Exception {
		return dao.bmOnOff(dto);
	}


	@Override
	public void bmOn(InteriorTipDTO dto) throws Exception {
		dao.bmOn(dto);
	}


	@Override
	public void bmOff(InteriorTipDTO dto) throws Exception {
		dao.bmOff(dto);
	}


	@Override
	public void bmCountUp(InteriorTipDTO dto) throws Exception {
		dao.bmCountUp(dto);
	}


	@Override
	public void bmCountDown(InteriorTipDTO dto) throws Exception {
		dao.bmCountDown(dto);
	}


	@Override
	public String bmCount(InteriorTipDTO dto) throws Exception {
		return dao.bmCount(dto);
	}


	@Override
	public void bmUpdate(InteriorTipDTO dto) throws Exception {
		System.out.println("@@@### bmUpdate start");
		dao.bmUpdate(dto);
		System.out.println("@@@### bmUpdate end");
	}


	@Override
	public void bmUpdateCon(InteriorTipDTO dto) throws Exception {
		System.out.println("@@@### bmUpdateCon start");
		dao.bmUpdateCon(dto);
		System.out.println("@@@### bmUpdateCon end");
	}


	@Override
	public void bmReplaceOne(InteriorTipDTO dto) throws Exception {
		System.out.println("@@@### bmReplaceOne start");
		dao.bmReplaceOne(dto);
		System.out.println("@@@### bmReplaceOne end");
	}


	@Override
	public void bmReplace(InteriorTipDTO dto) throws Exception {
		System.out.println("@@@### bmReplace start");
		dao.bmReplace(dto);
		System.out.println("@@@### bmReplace end");
	}
	
}
