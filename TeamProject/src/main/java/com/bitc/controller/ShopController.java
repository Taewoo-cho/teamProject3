package com.bitc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.bitc.dto.KategorieDto;
import com.bitc.dto.ShopListDto;
import com.bitc.service.ShopService;
import com.github.pagehelper.PageInfo;

@Controller
public class ShopController {
	
	@Autowired
	private ShopService shopService;

//	메인 화면 카테고리
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public ModelAndView selectMain() throws Exception {
		ModelAndView mv = new ModelAndView("/shop/Main");;
		
		List<KategorieDto> kate = shopService.selectMain();
		mv.addObject("kate", kate);
		
		return mv;
	}
	

//	가게 목록
	@RequestMapping(value="/shopList/{shopKate}", method=RequestMethod.GET)
	public ModelAndView selectShopList(@PathVariable("shopKate") String shopKate) throws Exception {
		ModelAndView mv = new ModelAndView("/shop/ShopList");
		
		List<ShopListDto> shopList = shopService.selectShopList(shopKate);
		mv.addObject("shopList", shopList);
	
		return mv;
	}
	
//	가게 목록 페이징
	@RequestMapping("/shopList")
	public ModelAndView paging(@RequestParam(required = false, defaultValue="1") int pageNum) throws Exception {
		ModelAndView mv = new ModelAndView("/shop/shopList/{shopKate}");
		
		PageInfo<ShopListDto> page = new PageInfo<>(shopService.selectShopPageList(pageNum), 3);
		
		mv.addObject("pages", page);
		
		return mv;
	}
		 
	
//	검색창 기능 - 가게명
 	@ResponseBody
	@RequestMapping(value="/ajax/search", method=RequestMethod.POST)
	public Object search(@RequestParam("shopName") String shopName) throws Exception {

		List<ShopListDto> searchList = shopService.search(shopName);

		return searchList;
	}

}
