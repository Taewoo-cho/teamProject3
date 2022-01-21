package com.bitc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.dto.ProductDto;
import com.github.pagehelper.Page;

@Mapper
public interface ProductMapper {
	public List<ProductDto> selectMenuList() throws Exception;

	public List<ProductDto> selectBasketList() throws Exception;
	
	Page<ProductDto> selectMenuPageList() throws Exception;

	Page<ProductDto> selectBasketPageList() throws Exception;

	public int insertMenu(ProductDto shop) throws Exception;

	public void deleteMenu(int no) throws Exception;

	public void showPrice() throws Exception;
}
