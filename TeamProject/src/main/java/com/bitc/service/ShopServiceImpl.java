package com.bitc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.dto.KategorieDto;
import com.bitc.dto.ShopListDto;
import com.bitc.mapper.ShopMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopMapper shopmapper;
	
//	메인 화면 카테고리
	@Override
	public List<KategorieDto> selectMain() throws Exception {
		return shopmapper.selectMain();
	}
	
//	가게 목록
	@Override
	public List<ShopListDto> selectShopList(String shopKate) throws Exception {
		return shopmapper.selectShopList(shopKate);
	}

//	가게 목록 페이징
	@Override
	public Page<ShopListDto> selectShopPageList(int pageNum) throws Exception {
		PageHelper.startPage(pageNum, 3);
		return shopmapper.selectShopPageList();
	}	
	
//	검색창 기능 - 가게명
	@Override
	public List<ShopListDto> search(String shopName) throws Exception {
		return shopmapper.search(shopName);
	}
	
}
