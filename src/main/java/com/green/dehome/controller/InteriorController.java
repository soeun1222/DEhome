package com.green.dehome.controller;

import java.io.File;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.green.dehome.dto.InteriorDTO;
import com.green.dehome.dto.UserDTO;
import com.green.dehome.service.InteriorService;
import com.green.dehome.utils.UploadFileUtils;

@Controller
public class InteriorController {
	private static final Logger LOGGER = LoggerFactory.getLogger(InteriorController.class);
	
	@Inject
	InteriorService service;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	//시공상담 업체리스트 페이지로 이동(get)
	@RequestMapping(value = "/interior/interiorList", method = RequestMethod.GET)
	public ModelAndView getInteriorList(HttpSession session, HttpServletRequest request) throws Exception {
	
		/*--세션 유저의 위치 값--*/
		String user_nick = (String) session.getAttribute("nickname");
		String userAddr = service.userAddr(user_nick);
		
		/*--위치 설정 팝업 값 가지고 오기--*/
		String popup_addr1 = request.getParameter("popup_addr1");
		String popup_addr2 = request.getParameter("popup_addr2");
		
		/*--select value 값 한글처리하기--*/
		String popup_addr = null;
		if (popup_addr1 != null && popup_addr2 != null) {
			popup_addr = service.addrKor(popup_addr1, popup_addr2);
		}
		
		/*--위치 설정하기--*/
		String addr = null; // jsp용 주소
		String dbAddr = null; // db용 주소
		
		if (popup_addr1 != null && popup_addr2 != null) { // 팝업에서 위치 설정 시
			addr = popup_addr;
			dbAddr = "%" + popup_addr + "%";
		} else { // 처음 들어와 유저의 주소로 받아올 때
			addr = userAddr;
			dbAddr = "%" + userAddr + "%";
		}
		
		/*--DB에서 list 가지고 오기--*/
		List<InteriorDTO> locList = service.locList(dbAddr);

		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("interior/interiorList");
		mav.addObject("addr", addr); // 현재 주소
		mav.addObject("locList", locList); // 해당 주소 업체 리스트
		
		return mav;
	}
	
	
	// 더보기 업체 리스트
	@ResponseBody
	@RequestMapping(value = "/interior/interiorList", method = RequestMethod.POST)
	public String getMoreInteriorList(HttpSession session, InteriorDTO dto, String paddr1, String paddr2, String more) throws Exception {
		
		/*--세션 유저의 위치 값--*/
		String user_nick = (String) session.getAttribute("nickname");
		String userAddr = service.userAddr(user_nick);
		
		/*--위치 설정 팝업 값 가지고 오기--*/
		String popup_addr1 = paddr1;
		String popup_addr2 = paddr2;
		
		
		/*--select value 값 한글처리하기--*/
		String popup_addr = null;
		if (popup_addr1 != null && popup_addr2 != null) {
			popup_addr = service.addrKor(popup_addr1, popup_addr2);
		}
		
		/*--위치 설정하기--*/
		String addr = null; // jsp용 주소
		String dbAddr = null; // db용 주소
		
		if (!popup_addr1.isEmpty() && !popup_addr2.isEmpty()) { // 팝업에서 위치 설정 시
			addr = popup_addr;
			dbAddr = "%" + popup_addr + "%";
		} else { // 처음 들어와 유저의 주소로 받아올 때
			addr = userAddr;
			dbAddr = "%" + userAddr + "%";
		}
		
		/*--page용 파라미터 가지고 오기--*/
		int page = Integer.parseInt(more);
		int startPage = 9 + (3 * page); // 3,6,9...
		//나중에 9개 먼저 보여주고 시작하려면 아래 소스로 변경 필요함
		//int startPage = 10 + (3 * page); // 3,6,9...
		
		
		
		/*--mapper에 들어가야하는 주소와 페이지 셋팅--*/
		dto.setAddr(dbAddr);
		dto.setStartPage(startPage);
		
		/*--DB에서 list 가지고 오기--*/
		List<InteriorDTO> morelocList = service.moreLocList(dto);

		
		/*--list json으로 변경--*/
		
		//전송용 최종 json객체
		JSONObject sendJson = new JSONObject();
		// JSONArray에 담기
		JSONArray jarr = new JSONArray();
		
		for (InteriorDTO board : morelocList) {
			JSONObject jboard = new JSONObject();
			
			//한글처리(업체명, 업체주소, 업체타이틀, 업체내용)인코딩 및 디코딩시 공백 -> +표시 해결
			String com_name = URLEncoder.encode(board.getCom_name(), "UTF-8");
			com_name = com_name.replaceAll("\\+", "%20");
			String com_addr = URLEncoder.encode(board.getCom_addr(), "UTF-8");
			com_addr = com_addr.replaceAll("\\+", "%20");
			
			jboard.put("com_name", com_name);
			jboard.put("com_addr", com_addr);
			jboard.put("com_rating", board.getCom_rating());
			jboard.put("com_contract", board.getCom_contract());
			jboard.put("com_file", board.getCom_file());
			jboard.put("com_thumbfile", board.getCom_thumbfile());
			jboard.put("re_count", board.getRe_count());
			
			jarr.add(jboard);
		}
		
		sendJson.put("list", jarr);
		return sendJson.toJSONString();

	}
	
	
	//위치 설정 팝업창 이동(get)
	@RequestMapping(value="/interior/location_popup", method = RequestMethod.GET)
	public String goLocPopUp() throws Exception {
		return "interior/location_popup";
	}
	
	
	//해당 업체 페이지로 이동(get)
	@RequestMapping(value="/interior/company_page", method = RequestMethod.GET)
	public ModelAndView goCompany(HttpSession session, HttpServletRequest request, InteriorDTO dto) throws Exception {
		
		/*--세션 유저의 업체명 가져오기(일반 사용자면 null)--*/
		String user_nick = (String) session.getAttribute("nickname");
		String user_com_name = service.userComName(user_nick);
		
		/*--해당 업체 정보가져오기--*/
		String com_name = request.getParameter("name"); //list에서 던진 업체명
		
		dto.setCom_name(com_name);
		dto = service.companyInfo(dto);
		
		
		/*--업체 평점 별 표현 용--*/
		float rating = dto.getCom_rating();
		int fullStar = (int)rating;
    	int emptyStar = 5 - fullStar;
    	
    	/*--실제 리뷰 카운트--*/
    	int realReCount = service.realReCount(dto);
    	int realExCount = service.realExCount(dto);
    	
		
    	/*--업체 리뷰 리스트--*/
    	List<InteriorDTO> reList = service.comReivew(com_name);
    	
    	/*--업체 사례 리스트--*/
    	List<InteriorDTO> exList = service.comExample(com_name);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("interior/company_page");
		mav.addObject("user_com_name", user_com_name); // 세션 유저의 업체명
		mav.addObject("comInfo", dto); // 해당 업체 정보
		mav.addObject("fullStar", fullStar); // 꽉찬 별의 수
		mav.addObject("emptyStar", emptyStar); // 빈 별의 수
		mav.addObject("reList", reList); // 해당 업체 리뷰 리스트
		mav.addObject("exList", exList); // 해당 업체 사례 리스트
		
		mav.addObject("realReCount", realReCount); // 해당 업체 실제 리뷰 카운트
		mav.addObject("realExCount", realExCount); // 해당 업체 실제 사례 카운트
		
		return mav;
	}
	
	// 더보기 리뷰, 사례 리스트
	@ResponseBody
	@RequestMapping(value = "/interior/company_page", method = RequestMethod.POST)
	public String getMoreReList(InteriorDTO dto, String more, String com_name, String type) throws Exception {
		
		/*--해당 업체 정보가져오기--*/
		String re_com_name = com_name;
		
		/*--page용 파라미터 가지고 오기--*/
		//시공 리뷰
		int repage = Integer.parseInt(more);
		int startRePage = 2 + (2 * repage); // 2,4,6...
		//시공 사례
		int expage = Integer.parseInt(more);
		int startExPage = 3 + (3 * expage); // 3,6,9...
		
		/*--mapper에 들어가야하는 업체명과 페이지 셋팅--*/
		dto.setCom_name(re_com_name);
		dto.setStartRePage(startRePage);
		dto.setStartExPage(startExPage);
		
		/*--list json으로 변경--*/
		
		//전송용 최종 json객체
		JSONObject sendJson = new JSONObject();
		// JSONArray에 담기
		JSONArray jarr = new JSONArray();
		
		
		if(type.equals("re")) { // 시공 리뷰 더보기일때
			
			//시공 리뷰 추가 리스트
			List<InteriorDTO> moreReList = service.moreReList(dto);
			
			for (InteriorDTO board : moreReList) {
				JSONObject jboard = new JSONObject();
				
				//한글처리(작성자, 리뷰제목, 리뷰내용)인코딩 및 디코딩시 공백 -> +표시 해결
				String user_nick = URLEncoder.encode(board.getUser_nick(), "UTF-8");
				user_nick = user_nick.replaceAll("\\+", "%20");
				String re_title = URLEncoder.encode(board.getRe_title(), "UTF-8");
				re_title = re_title.replaceAll("\\+", "%20");
				String re_content = URLEncoder.encode(board.getRe_content(), "UTF-8");
				re_content = re_content.replaceAll("\\+", "%20");
				
				jboard.put("re_no", board.getRe_no());
				jboard.put("user_nick", user_nick);
				jboard.put("re_title", re_title);
				jboard.put("re_content", re_content);
				jboard.put("re_interest", board.getRe_interest());
				jboard.put("re_file", board.getRe_file());
				
				jarr.add(jboard);
			}
			sendJson.put("moRelist", jarr);
			
		} else { // 시공 사례 더보기일때
			
			//시공 사례 추가 리스트
			List<InteriorDTO> moreExList = service.moreExList(dto);
			
			for (InteriorDTO board : moreExList) {
				JSONObject jboard = new JSONObject();
				
				//한글처리(작성자, 리뷰제목, 리뷰내용)인코딩 및 디코딩시 공백 -> +표시 해결
				String ex_title = URLEncoder.encode(board.getEx_title(), "UTF-8");
				ex_title = ex_title.replaceAll("\\+", "%20");
				
				jboard.put("ex_no", board.getEx_no());
				jboard.put("ex_title", ex_title);
				jboard.put("ex_file", board.getEx_file());
				
				jarr.add(jboard);
			}
			sendJson.put("moExlist", jarr);
		}

		return sendJson.toJSONString();

	}
	
	
	//업체등록 페이지로 이동(get)
	@RequestMapping(value="/interior/register_com", method = RequestMethod.GET)
	public ModelAndView registerCom(HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		/*--등록전인 업체명 받아오기--*/
		List<String> comList = service.notInCompany();
		
		ModelAndView mav = new ModelAndView();
		
		if (comList == null || comList.size() == 0) {
			out.println("<script>alert('등록할 업체가 없습니다.'); history.go(-1);</script>");
			out.flush();
		} else {
			mav.setViewName("interior/register_com");
		}
		
		mav.addObject("comList", comList); // 등록전 업체명 받기
		
		return mav;
	}
	
	//업체등록 성공시 업체 리스트로 이동
	@RequestMapping(value="/interior/register_com", method = RequestMethod.POST)
	public String registerCom(MultipartFile file, Model model, InteriorDTO dto, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/*--파일업로드부분--*/
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes()); 
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "logo.png"; //none.png
		}

		dto.setCom_file(File.separator + "imgUpload" + File.separator + fileName);
		dto.setCom_thumbfile(File.separator + "imgUpload" + File.separator + "s" + File.separator + "s_" + fileName);
		
		/*--업체 insert하기--*/
		service.companyRegist(dto);
		
		
		
		return "redirect:interiorList";
	}
	
	//리뷰등록 페이지 이동(get)
	@RequestMapping(value="/interior/review_write", method = RequestMethod.GET)
	public String goReWrite() throws Exception {
		return "interior/review_write";
	}
	
	
	//리뷰등록 성공시 업체 페이지로 이동
	@RequestMapping(value="/interior/review_write", method = RequestMethod.POST)
	public ModelAndView reviewRegist(MultipartFile file, InteriorDTO dto, HttpServletRequest request, HttpSession session) throws Exception {
		
		/*--세션 유저의 위치 값--*/
		String user_nick = (String) session.getAttribute("nickname");
		dto.setUser_nick(user_nick);
		
		/*--해당 업체 이름가져오기--*/
		String com_name = request.getParameter("com_name");
		dto.setCom_name(com_name);
		
		/*--파일업로드부분--*/
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes()); 
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "logo.png"; //none.png
		}

		dto.setRe_file(File.separator + "imgUpload" + File.separator + fileName);
		dto.setRe_thumbfile(File.separator + "imgUpload" + File.separator + "s" + File.separator + "s_" + fileName);
		
		/*--리뷰 insert하기--*/
		service.reviewRegist(dto);
		
		/*--업체 리뷰 총점 더하기--*/
		service.reSum(dto);
		
		/*--업체 리뷰 카운트 더하기--*/
		service.reCount(dto);
		
		/*--업체 평점 업데이트하기--*/
		service.reRating(dto);

		/*--업체명 던지기--*/
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:company_page");
		mav.addObject("name", com_name);
		
		return mav;
	}

	//해당 리뷰 정보 페이지 이동(get)
	@RequestMapping(value="/interior/review_show", method = RequestMethod.GET)
	public ModelAndView reviewShow(HttpSession session, HttpServletRequest request, InteriorDTO dto) throws Exception {
		
		/*--세션 유저 받아오기--*/
		String user_nick = (String) session.getAttribute("nickname");
		
		/*--해당 리뷰 번호 받아오기--*/
		int re_no = Integer.parseInt(request.getParameter("re_no"));
		
		/*--해당 리뷰 정보 받아오기--*/
		dto.setUser_nick(user_nick);
		dto.setRe_no(re_no);
		InteriorDTO review = service.reviewShow(dto);
		
		
		/*--날짜 셋팅--*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String re_date = sdf.format(review.getRe_date());
		
		/*--해당 유저 좋아요 클릭 유무--*/
		InteriorDTO likeonoff = service.likeOnOff(dto);
		int like = 0;
		if (likeonoff != null) {
			like = 1;
		} else {
			like = 0;
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("interior/review_show");
		mav.addObject("review", review);
		mav.addObject("re_date", re_date);
		mav.addObject("like", like);
		
		return mav;
	}
	
	
	//좋아요 클릭 후 리뷰 정보 페이지 이동(post)
	@ResponseBody
	@RequestMapping(value = "/interior/review_show", method = RequestMethod.POST)
	public int reviewLike(HttpSession session, int re_no, String type, InteriorDTO dto) throws Exception {
		
		/*--세션 유저 받아오기--*/
		String user_nick = (String) session.getAttribute("nickname");

		
		/*--mapper에 들어가야하는 유저닉네임과 글번호 셋팅--*/
		dto.setUser_nick(user_nick);
		dto.setRe_no(re_no);
		
		/*--DB에 insert및 update or delete및 update--*/
		int likeCount = 0;
		if (type.equals("likeon")) { // 좋아요를 누른 상황
			service.reviewLikeOn(dto);
			service.reInterestCountUp(dto);
			
			/*--좋아요 수 카운트--*/
			likeCount = Integer.parseInt(service.likeCount(dto));
			
		} else if (type.equals("likeoff")) { // 좋아요를 취소한 상황
			service.reviewLikeOff(dto);
			service.reInterestCountDown(dto);
			
			/*--좋아요 수 카운트--*/
			likeCount = Integer.parseInt(service.likeCount(dto));
		}
		
		return likeCount;

	}
	
	
	//시공사례 등록 페이지 이동(get)
	@RequestMapping(value="/interior/cons_case_write", method = RequestMethod.GET)
	public String goExWrite() throws Exception {
		return "interior/cons_case_write";
	}
	
	
	//시공사례 등록 성공시 업체 페이지로 이동
	@RequestMapping(value="/interior/cons_case_write", method = RequestMethod.POST)
	public ModelAndView exRegist(MultipartFile file, InteriorDTO dto, HttpServletRequest request) throws Exception {
		
		
		/*--해당 업체 이름가져오기--*/
		String com_name = request.getParameter("com_name");
		dto.setCom_name(com_name);
		
		/*--파일업로드부분--*/
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes()); 
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "logo.png"; //none.png
		}

		dto.setEx_file(File.separator + "imgUpload" + File.separator + fileName);
		dto.setEx_thumbfile(File.separator + "imgUpload" + File.separator + "s" + File.separator + "s_" + fileName);
		
		/*--리뷰 insert하기--*/
		service.exRegist(dto);
		
		/*--업체 리뷰 카운트 더하기--*/
		service.exCount(dto);

		/*--업체명 던지기--*/
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:company_page");
		mav.addObject("name", com_name);
		
		return mav;
	}
	
	
	
	
	//해당 사례 정보 페이지 이동(get)
	@RequestMapping(value="/interior/cons_case", method = RequestMethod.GET)
	public ModelAndView exShow(HttpSession session, HttpServletRequest request, InteriorDTO dto) throws Exception {
		
		/*--세션 유저의 업체명 가져오기(일반 사용자면 null)--*/
		String user_nick = (String) session.getAttribute("nickname");
		String user_com_name = service.userComName(user_nick);
		
		/*--해당 사례 번호 받아오기--*/
		int ex_no = Integer.parseInt(request.getParameter("ex_no"));
		
		/*--해당 사례 정보 받아오기--*/
		dto.setEx_no(ex_no);
		InteriorDTO ex = service.exShow(dto);
		
		
		/*--날짜 셋팅--*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String ex_date = sdf.format(ex.getReg_date());
		

		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("interior/cons_case");
		mav.addObject("ex", ex);
		mav.addObject("ex_date", ex_date);
		mav.addObject("user_com_name", user_com_name);
		
		return mav;
	}
	
	
	//업체수정 페이지로 이동(get)
	@RequestMapping(value="/interior/edit_com", method = RequestMethod.GET)
	public ModelAndView editCom(HttpServletRequest request, InteriorDTO dto) throws Exception {
		
		/*--해당 업체 이름가져오기--*/
		String com_name = request.getParameter("com_name");
		
		/*--해당 업체 정보 가져오기--*/
		dto.setCom_name(com_name);
		dto = service.companyInfo(dto);

		/*--업체명 던지기--*/
		ModelAndView mav = new ModelAndView();
		mav.setViewName("interior/edit_com");
		mav.addObject("comInfo", dto);
		
		return mav;
	}
	
	//업체수정 완료시 업체 페이지로 이동(post)
	@RequestMapping(value="/interior/edit_com", method = RequestMethod.POST)
	public ModelAndView editComSet(MultipartFile file, HttpServletRequest request, InteriorDTO dto) throws Exception {
		
		/*--해당 업체 이름가져오기--*/
		String com_name = request.getParameter("com_name");
		
		/*--파일업로드부분--*/
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		

		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes()); 
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "logo.png"; //none.png
		}

		dto.setCom_file(File.separator + "imgUpload" + File.separator + fileName);
		dto.setCom_thumbfile(File.separator + "imgUpload" + File.separator + "s" + File.separator + "s_" + fileName);
		
		
		/*--업체 수정 update하기오기--*/
		dto.setCom_name(com_name);
		
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			service.comEditFile(dto); // 새로 업로드한 파일이 있으면 파일수정
		}
		service.comEdit(dto);
		

		/*--업체명 던지기--*/
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:company_page");
		mav.addObject("name", com_name);
		
		return mav;
	}
	
	
	//리뷰수정 페이지로 이동(get)
	@RequestMapping(value="/interior/review_edit", method = RequestMethod.GET)
	public ModelAndView editReview(HttpServletRequest request, InteriorDTO dto) throws Exception {
		
		/*--해당 리뷰 번호 받아오기--*/
		int re_no = Integer.parseInt(request.getParameter("re_no"));
		
		/*--해당 리뷰 정보 받아오기--*/
		dto.setRe_no(re_no);
		InteriorDTO review = service.reviewShow(dto);

		/*--업체명 던지기--*/
		ModelAndView mav = new ModelAndView();
		mav.setViewName("interior/review_edit");
		mav.addObject("review", review);
		
		return mav;
	}
	
		
	//리뷰수정 완료시 업체 페이지로 이동(post)
	@RequestMapping(value="/interior/review_edit", method = RequestMethod.POST)
	public ModelAndView editReviewSet(MultipartFile file, HttpServletRequest request, InteriorDTO dto) throws Exception {
		
		/*--해당 업체 이름가져오기--*/
		String com_name = request.getParameter("com_name");
		
		/*--해당 리뷰 번호 받아오기--*/
		int re_no = Integer.parseInt(request.getParameter("re_no"));
		
		/*--파일업로드부분--*/
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		

		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes()); 
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "logo.png"; //none.png
		}

		dto.setRe_file(File.separator + "imgUpload" + File.separator + fileName);
		dto.setRe_thumbfile(File.separator + "imgUpload" + File.separator + "s" + File.separator + "s_" + fileName);
		
		
		/*--리뷰 수정 update하기--*/
		dto.setRe_no(re_no);
		
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			service.reEditFile(dto); // 새로 업로드한 파일이 있으면 파일수정
		}
		service.reEdit(dto);
		

		/*--업체명 던지기--*/
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:company_page");
		mav.addObject("name", com_name);
		
		return mav;
	}
	
	//리뷰삭제 완료시 업체 페이지로 이동(get)
	@RequestMapping(value="/interior/review_delete", method = RequestMethod.GET)
	public ModelAndView deleteReview(HttpServletRequest request, InteriorDTO dto) throws Exception {
		
		/*--해당 업체 이름가져오기--*/
		String com_name = request.getParameter("com_name");
		
		/*--해당 리뷰 번호 받아오기--*/
		int re_no = Integer.parseInt(request.getParameter("re_no"));
		
		/*--해당 리뷰관련 좋아요 삭제--*/
		service.reLikeDelete(dto);
		
		/*--리뷰 삭제하기--*/
		dto.setRe_no(re_no);
		service.reDelete(dto);

		/*--업체명 던지기--*/
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:company_page");
		mav.addObject("name", com_name);
		
		return mav;
	}
	
	
	//시공사례 수정 페이지로 이동(get)
	@RequestMapping(value="/interior/cons_case_edit", method = RequestMethod.GET)
	public ModelAndView editEx(HttpServletRequest request, InteriorDTO dto) throws Exception {
		
		/*--해당 리뷰 번호 받아오기--*/
		int ex_no = Integer.parseInt(request.getParameter("ex_no"));
		
		/*--해당 리뷰 정보 받아오기--*/
		dto.setEx_no(ex_no);
		InteriorDTO ex = service.exShow(dto);

		/*--업체명 던지기--*/
		ModelAndView mav = new ModelAndView();
		mav.setViewName("interior/cons_case_edit");
		mav.addObject("ex", ex);
		
		return mav;
	}
	
	
	//시공사례 완료시 업체 페이지로 이동(post)
	@RequestMapping(value="/interior/cons_case_edit", method = RequestMethod.POST)
	public ModelAndView editExSet(MultipartFile file, HttpServletRequest request, InteriorDTO dto) throws Exception {
		
		/*--해당 업체 이름가져오기--*/
		String com_name = request.getParameter("com_name");
		
		/*--해당 리뷰 번호 받아오기--*/
		int ex_no = Integer.parseInt(request.getParameter("ex_no"));
		
		/*--파일업로드부분--*/
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		

		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes()); 
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "logo.png"; //none.png
		}

		dto.setEx_file(File.separator + "imgUpload" + File.separator + fileName);
		dto.setEx_thumbfile(File.separator + "imgUpload" + File.separator + "s" + File.separator + "s_" + fileName);
		
		
		/*--리뷰 수정 update하기--*/
		dto.setEx_no(ex_no);
		
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			service.exEditFile(dto); // 새로 업로드한 파일이 있으면 파일수정
		}
		service.exEdit(dto);
		

		/*--업체명 던지기--*/
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:company_page");
		mav.addObject("name", com_name);
		
		return mav;
	}
	
	
	//시공사례 완료시 업체 페이지로 이동(get)
	@RequestMapping(value="/interior/cons_case_delete", method = RequestMethod.GET)
	public ModelAndView deleteEx(HttpServletRequest request, InteriorDTO dto) throws Exception {
		
		/*--해당 업체 이름가져오기--*/
		String com_name = request.getParameter("com_name");
		
		/*--해당 리뷰 번호 받아오기--*/
		int ex_no = Integer.parseInt(request.getParameter("ex_no"));
		
		
		/*--리뷰 삭제하기--*/
		dto.setEx_no(ex_no);
		service.exDelete(dto);
		

		/*--업체명 던지기--*/
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:company_page");
		mav.addObject("name", com_name);
		
		return mav;
	}
	
	
	
}
