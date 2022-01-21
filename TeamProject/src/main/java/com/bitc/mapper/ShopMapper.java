package com.bitc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitc.dto.KategorieDto;
import com.bitc.dto.ShopListDto;
import com.github.pagehelper.Page;

@Mapper
public interface ShopMapper {
//	메인 화면 카테고리
	List<KategorieDto> selectMain() throws Exception;
	
//	가게 목록
	List<ShopListDto> selectShopList(@Param("shopKate")String shopKate) throws Exception;

//	가게 목록 페이징
	Page<ShopListDto> selectShopPageList() throws Exception;
	
//	검색창 기능 - 가게명
	List<ShopListDto> search(String shopName) throws Exception;
	
}
