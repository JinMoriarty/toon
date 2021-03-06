package com.toon.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.toon.domain.CategoryVO;
import com.toon.domain.ToonVO;
import com.toon.domain.ToonsViewVO;
import com.toon.service.AdminService;
import com.toon.utils.UploadFileUtils;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	// 관리자화면
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void getIndex() throws Exception {
		logger.info("get index"); 
	}
	
	// 카테고리
	@RequestMapping(value = "/toons/register", method = RequestMethod.GET)
	public void getToonsRegister(Model model) throws Exception {
	 logger.info("get toons register");
	 
	 List<CategoryVO> category = null;
	 category = adminService.category();
	 model.addAttribute("category", JSONArray.fromObject(category));
	}
	
	// 작품 등록
	@RequestMapping(value = "/toons/register", method = RequestMethod.POST)
	public String postToonRegister(ToonVO vo, MultipartFile file) throws Exception {
		String imgUploadPath = uploadPath + File.separator + "imgUpload";  // 이미지를 업로드할 폴더를 설정 = /uploadPath/imgUpload
		 String ymdPath = UploadFileUtils.calcPath(imgUploadPath);  // 위의 폴더를 기준으로 연월일 폴더를 생성
		 String fileName = null;  // 기본 경로와 별개로 작성되는 경로 + 파일이름
		   
		 System.out.println("업로드패스"+imgUploadPath);
		 
		 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		  // 파일 인풋박스에 첨부된 파일이 없다면(=첨부된 파일이 이름이 없다면)
		  
		  fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);

		  // toonImg에 원본 파일 경로 + 파일명 저장
		  vo.setToonImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		  // toonThumbImg에 썸네일 파일 경로 + 썸네일 파일명 저장
		  vo.setToonThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		  
		 } else {  // 첨부된 파일이 없으면
		  fileName = File.separator + "images" + File.separator + "none.png";
		  // 미리 준비된 none.png파일을 대신 출력함
		  
		  vo.setToonImg(fileName);
		  vo.setToonThumbImg(fileName);
		 }
		      
		 adminService.register(vo);
		 
		 return "redirect:/admin/index";
		}	
	
	// 작품 목록
		@RequestMapping(value = "/toons/list", method = RequestMethod.GET)
		public void getToonsList(Model model) throws Exception {
			logger.info("get toons list");
			
			List<ToonsViewVO> list = adminService.toonslist();
			
			model.addAttribute("list",list);			
		}

	 // 작품 조회
		@RequestMapping(value = "/toons/view", method = RequestMethod.GET)
		public void getToonsview(@RequestParam("n") int toonNum, Model model) throws Exception {
		 logger.info("get toons view");
		 
		 ToonsViewVO toons = adminService.toonsView(toonNum);
		 System.out.println(toonNum);
		 model.addAttribute("toons", toons);		
		 }
		
	// 작품 수정 
		@RequestMapping(value = "/toons/modify", method = RequestMethod.GET)
		public void postToonsModify(@RequestParam("n") int toonNum, Model model) throws Exception {
		// @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 toonNum에 저장
			
			logger.info("get toons modify");
			
			ToonsViewVO toons = adminService.toonsView(toonNum);  // ToonsViewVO형태 변수 toons에 상품 정보 저장
			model.addAttribute("toons", toons);
			
			
			
			List<CategoryVO> category = null;
			category = adminService.category();
			model.addAttribute("category", JSONArray.fromObject(category));
		}
		
	// 상품 수정
		@RequestMapping(value = "/toons/modify", method = RequestMethod.POST)
		public String postToonsModify(ToonVO vo, MultipartFile file, HttpServletRequest req) throws Exception {
		 logger.info("post toons modify");
		// 새로운 파일이 등록되었는지 확인
			if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
				// 기존 파일을 삭제
				new File(uploadPath + req.getParameter("toonImg")).delete();
				new File(uploadPath + req.getParameter("toonThumbImg")).delete();
				
				// 새로 첨부한 파일을 등록
				String imgUploadPath = uploadPath + File.separator + "imgUpload";
				String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
				String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
				
				vo.setToonImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
				vo.setToonThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
				
			} else {  // 새로운 파일이 등록되지 않았다면
				// 기존 이미지를 그대로 사용
				vo.setToonImg(req.getParameter("toonImg"));
				vo.setToonThumbImg(req.getParameter("toonThumbImg"));
				
			}
			
			adminService.toonsModify(vo);
			
			return "redirect:/admin/index";
		}
		
	// 상품 삭제
		@RequestMapping(value = "/toons/delete", method = RequestMethod.POST)
		public String postToonsDelete(@RequestParam("n") int toonNum) throws Exception {
		// @RequestParam("n")으로 인해, URL주소에 있는 n의 값을 가져와 toonNum에 저장
		
			logger.info("post toons delete");
		
			adminService.toonsDelete(toonNum);
			
			return "redirect:/admin/index";
		}
		
	// ck 에디터에서 파일 업로드
		@RequestMapping(value = "/toons/ckUpload", method = RequestMethod.POST)
		public void postCKEditorImgUpload(HttpServletRequest req,HttpServletResponse res, @RequestParam MultipartFile upload) throws Exception {
		 logger.info("post CKEditor img upload");
		 
		 // 랜덤 문자 생성
		 UUID uid = UUID.randomUUID();
		 
		 OutputStream out = null;
		 PrintWriter printWriter = null;
		   
		 // 인코딩
		 res.setCharacterEncoding("utf-8");
		 res.setContentType("text/html;charset=utf-8");
		 
		 try {
		  
		  String fileName = upload.getOriginalFilename(); // 파일 이름 가져오기
		  byte[] bytes = upload.getBytes();
		  
		  // 업로드 경로
		  String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName;
		  
		  out = new FileOutputStream(new File(ckUploadPath));
		  out.write(bytes);
		  out.flush(); // out에 저장된 데이터를 전송하고 초기화
		  
		  String callback = req.getParameter("CKEditorFuncNum");
		  printWriter = res.getWriter();
		  String fileUrl = "/img" + "/ckUpload/" + uid + "_" + fileName; // 작성화면
		  System.out.println("URL 경로"+ fileUrl);
		  // 업로드시 메시지 출력
		  /* 이 형식은 업데이트 되면서 제이슨 형태로 리턴해야하는걸로 바뀜
		   * printWriter.println("<script type='text/javascript'>"
		     + "window.parent.CKEDITOR.tools.callFunction("
		     + callback+",'"+ fileUrl+"','이미지를 업로드하였습니다.')"
		     +"</script>");*/
		  printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
		  
		  printWriter.flush();
		  
		 } catch (IOException e) { e.printStackTrace();
		 } finally {
		  try {
		   if(out != null) { out.close(); }
		   if(printWriter != null) { printWriter.close(); }
		  } catch(IOException e) { e.printStackTrace(); }
		 }
		 
		 return; 
		}
		
		
}

