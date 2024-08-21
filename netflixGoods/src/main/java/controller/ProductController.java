package controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import dao.ProductDAO;
import util.Common;
import vo.ProductVO;

@Controller
public class ProductController {

	@Autowired
	ServletContext app;
	
	ProductDAO productDAO;

	public ProductController(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@RequestMapping(value = { "/shop_page.do" })
	public String list(Model model) {
		List<ProductVO> list = productDAO.s_selectList();

		model.addAttribute("list", list);
		return Common.Member.VIEW_PATH + "shop_page.jsp";
	}

	@RequestMapping("/insert.do")
	public String insert(ProductVO vo) {

		String webPath = "/resources/upload/";
		// upload까지의 절대경로를 가져온다.
		String savePath = app.getRealPath(webPath);
		System.out.println("절대경로: " + savePath);
		// 업로드 된 파일 정보
		MultipartFile photo = vo.getPhoto();

		String filename = "no_file";
		if (!photo.isEmpty()) {
			// 업로드된 실제 파일명가져오기
			filename = photo.getOriginalFilename();
			System.out.println(photo);

			// 파일을 저장할 경로 생성
			File savefile = new File(savePath, filename);

			if (!savefile.exists()) {
				savefile.mkdirs();
			} else {
				// 동일파일명이 존재하는 경우 업로드시간을 추가하여 중복을 방지하자
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time, filename);
				savefile = new File(savePath, filename);
			}
			try {
				photo.transferTo(savefile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		vo.setFilename(filename);
		productDAO.insert(vo);
		return "redirect:shop_page.do";
	}

	@RequestMapping(value = "/delete.do")
	public String delete(ProductVO vo) {
		int result = productDAO.delete(vo.getP_idx());
		if (result > 0) {
			// 성공적으로 삭제된 경우
			return "redirect:/shop_page.do";
		} else {
			// 삭제 실패한 경우

			return "error";
		}
	}

	// 수정 폼으로 이동
	@RequestMapping("modify_form.do")
	public String selectone(Model model, int p_idx) {
		ProductVO vo = productDAO.selectone(p_idx);
		model.addAttribute("vo", vo);
		System.out.println(vo);
		return Common.Member.VIEW_PATH + "modify_form.jsp";
	}

	@RequestMapping("update.do")
	public String update(ProductVO vo, int p_idx) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vo", vo);
		map.put("P_IDX", p_idx);
		System.out.println("Name: " + vo.getName());
		System.out.println("Description: " + vo.getDescription());
		System.out.println("Price: " + vo.getPrice());
		System.out.println("Stock: " + vo.getStock());
		System.out.println("Category: " + vo.getCategory());
		System.out.println(p_idx);
		System.out.println("Map Contents: " + map);
		productDAO.update(map);
		return "redirect:/shop_page.do";

	}

}
