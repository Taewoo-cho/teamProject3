package com.bitc.service;

import java.util.List;

import com.bitc.dto.KategorieDto;
import com.bitc.dto.ShopListDto;
import com.github.pagehelper.Page;

public interface ShopService {
//	메인 화면 카테고리
	List<KategorieDto> selectMain() throws Exception;
	
//	가게 목록
	List<ShopListDto> selectShopList(String shopKate) throws Exception;
	
//	가게 목록 페이징
	Page<ShopListDto> selectShopPageList(int pageNum) throws Exception;
	
//	검색창 기능 - 가게명
	List<ShopListDto> search(String shopName) throws Exception;

}
