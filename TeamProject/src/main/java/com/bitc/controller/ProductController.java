package com.bitc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.dto.ProductDto;
import com.bitc.service.ProductService;
import com.github.pagehelper.PageInfo;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

//	??	
	@RequestMapping(value="/List", method=RequestMethod.GET)
	public ModelAndView openMenuList() throws Exception {
		ModelAndView mv = new ModelAndView("/product/Menu");
		
		List<ProductDto> menuList = productService.selectMenuList();
		mv.addObject("menuList", menuList);
		
		return mv;
	}
	
//	사용불가
	@RequestMapping(value="/basket", method=RequestMethod.GET)
	public ModelAndView openBasketList() throws Exception {
		ModelAndView mv = new ModelAndView("/product/Basket");
		
		List<ProductDto> basketList = productService.selectBasketList();
		mv.addObject("basketList", basketList);
		
		return mv;
	}
	
//	??	
	@RequestMapping("/menu")
	public ModelAndView paging(@RequestParam(required = false, defaultValue="1") int pageNum) throws Exception {
		ModelAndView mv = new ModelAndView("/product/Menu");
		
		PageInfo<ProductDto> page = new PageInfo<>(productService.selectMenuPageList(pageNum), 3);
		
		mv.addObject("pages", page);
		
		return mv;
	}
	
//	로그인 세션 user 필요
	@RequestMapping("/basketPaging")
	public ModelAndView basketListPage(@RequestParam(required = false, defaultValue="1") int pageNum) throws Exception {
		ModelAndView mv = new ModelAndView("/product/Basket");
		
		PageInfo<ProductDto> paging = new PageInfo<>(productService.selectBasketPageList(pageNum), 3);
		
		mv.addObject("basketPage", paging);
		
		return mv;
	}
	
//	로그인 세션 user 필요
	@RequestMapping(value="/pay", method=RequestMethod.GET)
	public String pay() throws Exception {
		return "/product/Pay";
	}
	
//	로그인 세션 user 필요
	@ResponseBody
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public Map<String, String> insertMenu(ProductDto shop) throws Exception {
		Map<String, String> result = new HashMap<String, String>();
		
		int count = productService.insertMenu(shop); // 데이터 입력
		
		if (count != 0) {
			result.put("result", "success");
		}
		else {
			result.put("result", "error");
		}
		return result;
	}
	
//	로그인 세션 user 필요
	@RequestMapping(value="/delete/{no}", method=RequestMethod.DELETE)
	public String deleteMenu(@PathVariable("no") int no) throws Exception {
		productService.deleteMenu(no);
		return "redirect:/basketPaging";
	}
	
//	로그인 세션 user 필요	
	@RequestMapping(value="/price", method=RequestMethod.GET)
	public String showPrice() throws Exception {
		productService.showPrice();
		return "redirect:/pay";
	}
}
