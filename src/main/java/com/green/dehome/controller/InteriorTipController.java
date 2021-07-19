package com.green.dehome.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.green.dehome.dto.InteriorTipDTO;
import com.green.dehome.service.InteriorTipService;
import com.green.dehome.utils.UploadFileUtils;

@Controller
public class InteriorTipController {
	
	@Inject
	InteriorTipService service;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	// 인테리어팁 전체 리스트
	@RequestMapping(value = "/interior/interiorTip", method = RequestMethod.GET)
	public ModelAndView getInteriorTip(HttpSession session, InteriorTipDTO dto) throws Exception {
		// 세션에 닉네임 받아서 넣기
		String user_nick = (String) session.getAttribute("nickname");
		dto.setTip_user_nick(user_nick);
		
		ModelAndView mav = new ModelAndView();
		
		List<InteriorTipDTO> tipListConstruct = null;
		tipListConstruct = service.tiplistConstruct(dto);
		mav.addObject("tipListConstruct", tipListConstruct);
		
		List<InteriorTipDTO> tipListStorage = null;
		tipListStorage = service.tipListStorage(dto);
		mav.addObject("tipListStorage", tipListStorage);
		
		List<InteriorTipDTO> tipListDecorate = null;
		tipListDecorate = service.tipListDecorate(dto);
		mav.addObject("tipListDecorate", tipListDecorate);
		
		List<InteriorTipDTO> tipListCleaning = null;
		tipListCleaning = service.tipListCleaning(dto);
		mav.addObject("tipListCleaning", tipListCleaning);
		
		List<InteriorTipDTO> tipListDiy = null;
		tipListDiy = service.tipListDiy(dto);
		mav.addObject("tipListDiy", tipListDiy);
		
		List<InteriorTipDTO> tipListReform = null;
		tipListReform = service.tipListReform(dto);
		mav.addObject("tipListReform", tipListReform);
		
		List<InteriorTipDTO> tipListKitchen = null;
		tipListKitchen = service.tipListKitchen(dto);
		mav.addObject("tipListKitchen", tipListKitchen);
		
		List<InteriorTipDTO> tipListLighting = null;
		tipListLighting = service.tipListLighting(dto);
		mav.addObject("tipListLighting", tipListLighting);
		
		mav.addObject("bmuser", dto.getTip_bmuser());
		mav.addObject("nick", user_nick);
		mav.setViewName("interior/interiorTip");

		return mav;
	}
	
	// 카테고리별 인테리어팁 리스트
	@RequestMapping(value = "/interior/interiorTipList", method = RequestMethod.GET)
	public ModelAndView tipList(HttpServletRequest request, HttpSession session, InteriorTipDTO dto, @RequestParam String category) throws Exception {
		// 세션에 닉네임 받아서 넣기
		String user_nick = (String) session.getAttribute("nickname");
		dto.setTip_user_nick(user_nick);
		
		List<InteriorTipDTO> tipListCategory = null;
		tipListCategory = service.tipListCategory(dto, category);

		ModelAndView mav = new ModelAndView();
		mav.addObject("tipListCategory", tipListCategory);
		mav.addObject("category", category);
		mav.addObject("nick", user_nick);
		mav.addObject("bmuser", dto.getTip_bmuser());
		
		return mav;
	}
	
	// 인테리어팁 작성 페이지 이동
	@RequestMapping(value = "/interior/interiorTipWrite", method = RequestMethod.GET)
	public void tipWrite() throws Exception {}
	
	// 팁 작성 성공하면 해당 카테고리의 인테리어팁 리스트로 이동
	@RequestMapping(value = "/interior/interiorTipList", method = RequestMethod.POST)
	public ModelAndView tipWriteGo(MultipartFile file, HttpServletRequest request, HttpSession session, InteriorTipDTO dto) throws Exception {
		// 세션에 닉네임 받아서 넣기
		String user_nick = (String) session.getAttribute("nickname");
		dto.setTip_user_nick(user_nick);
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if (file != null) {
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes());
		} else {
			fileName = uploadPath + File.separator + "images" + File.separator + "logo.png";
		}

		dto.setTip_file(File.separator + "imgUpload" + File.separator + fileName);
		dto.setTip_thumb(
				File.separator + "imgUpload"  + File.separator + "s" + File.separator + "s_" + fileName);
		
		service.tipWrite(dto);
		
		String category = dto.getTip_category();
		
		List<InteriorTipDTO> tipListCategory = service.tipListCategory(dto, category);
		
		// 해당 유저 북마크 여부
		InteriorTipDTO bmOnOff = service.bmOnOff(dto);
		int bm = 0;
		if (bmOnOff != null) {
			bm = 1;
		} else {
			bm = 0;
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("bm", bm);
		mav.addObject("tipListCategory", tipListCategory);
		mav.addObject("category", category);
		mav.addObject("nick", user_nick);
		mav.addObject("bmuser", dto.getTip_bmuser());
		mav.setViewName("interior/interiorTipList");
		
		return mav;
	}
	
	// 인테리어팁 상세페이지
	@RequestMapping(value = "/interior/interiorTipPage", method = RequestMethod.GET)
	public ModelAndView goTipPage(@RequestParam int tip_no, InteriorTipDTO dto, HttpServletRequest request,
			HttpSession session, HttpServletResponse response) throws Exception {
		InteriorTipDTO dto2 = service.tipListPage(dto, tip_no);
		String user_nick = (String) session.getAttribute("nickname");
		dto.setTip_user_nick(user_nick);
		
		// 조회수 중복 쿠키
		Cookie[] cookies = request.getCookies();
		
		// 비교하기 위해 새로운 쿠키
		Cookie viewCookie = null;
		
		if (cookies != null && cookies.length > 0) {
		    for (int i = 0; i < cookies.length; i++){
		        if (cookies[i].getName().equals("|" + tip_no + "|") ){ 
		            viewCookie = cookies[i];
		        }
		    }
		}
		
		if (viewCookie == null) {
			Cookie newCookie = new Cookie("|" + tip_no + "|", URLEncoder.encode(user_nick, "UTF-8"));
			if(!dto2.getTip_user_nick().equals(user_nick)) {
				newCookie.setMaxAge(1*24*60*60);
				response.addCookie(newCookie);
				service.setCount(tip_no);
			}
			
		} else {
			String value = viewCookie.getValue();
		}
		
		// 시간 설정.
		String time = null;
		if (dto2.getYear() == 0) {
			if (dto2.getMonth() == 0) {
				if (dto2.getDay() == 0) {
					if (dto2.getHour() == 0) {
						if (dto2.getMinute() == 0) {
							if (dto2.getSecond() != 0) {
								time = dto2.getSecond() + "초 전";
							} else {
								time = "방금 전";
							}
						} else {
							time = dto2.getMinute() + "분 전";
						}
					} else {
						time = dto2.getHour() + "시간 전";
					}
				} else {
					time = dto2.getDay() + "일 전";
				}
			} else {
				time = dto2.getMonth() + "달 전";
			}
		} else {
			time = dto2.getYear() + "년 전";
		}
		
		// 해당 유저 북마크 여부
		InteriorTipDTO bmOnOff = service.bmOnOff(dto);
		int bm = 0;
		if (bmOnOff != null) {
			bm = 1;
		} else {
			bm = 0;
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("bm", bm);
		mav.addObject("time", time);
		mav.addObject("dto2", dto2);
		mav.addObject("category", dto2.getTip_category());
		mav.setViewName("interior/interiorTipPage");
		
		return mav;
	}
	
	// 북마크 클릭 후 인테리어팁 상세 페이지 이동
	@ResponseBody
	@RequestMapping(value = "/interior/interiorTipPage", method = RequestMethod.POST)
	public int tipBookmark(HttpSession session, int tip_no, String type, InteriorTipDTO dto) throws Exception {
		/*--세션 유저 받아오기--*/
		String user_nick = (String) session.getAttribute("nickname");
		
		/*--mapper에 들어가야하는 유저닉네임과 글번호 셋팅--*/
		dto.setTip_user_nick(user_nick);
		dto.setTip_no(tip_no);
		
		/*--DB에 insert및 update or delete및 update--*/
		int bmCount = 0;
		if (type.equals("bmOn")) { // 북마크 추가
			service.bmOn(dto);
			service.bmCountUp(dto);
			
			bmCount = Integer.parseInt(service.bmCount(dto));
			// 북마크가 0일때 및 아닐때 tip_bmuser 컬럼에 닉네임 저장
			if (bmCount == 1) {
				service.bmUpdate(dto);
			} else {
				service.bmUpdateCon(dto);
			}
		} else if (type.equals("bmOff")) { // 북마크 해제
			service.bmOff(dto);
			service.bmCountDown(dto);
			
			bmCount = Integer.parseInt(service.bmCount(dto));
			System.out.println(bmCount);
			// 북마크가 2이상일때 및 1일때 tip_bmuser 컬럼에 저장된 닉네임 제거
			if (bmCount >= 1) {
				service.bmReplace(dto);
			} else {
				service.bmReplaceOne(dto);
			}
		}
		
		// 해당 유저 북마크 여부
		InteriorTipDTO bmOnOff = service.bmOnOff(dto);
		int bm = 0;
		if (bmOnOff != null) {
			bm = 1;
		} else {
			bm = 0;
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("bm", bm);
		mav.setViewName("interior/interiorTipPage");
		
		return bmCount;
	}
}
