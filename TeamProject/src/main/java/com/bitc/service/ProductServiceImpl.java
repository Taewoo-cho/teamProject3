package com.bitc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.dto.ProductDto;
import com.bitc.mapper.ProductMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<ProductDto> selectMenuList() throws Exception {
		return productMapper.selectMenuList();
	}

	@Override
	public List<ProductDto> selectBasketList() throws Exception {
		return productMapper.selectBasketList();
	}

	@Override
	public Page<ProductDto> selectMenuPageList(int pageNum) throws Exception {
		PageHelper.startPage(pageNum, 3);
		return productMapper.selectMenuPageList();
	}

	@Override
	public Page<ProductDto> selectBasketPageList(int pageNum) throws Exception {
		PageHelper.startPage(pageNum, 3);
		return productMapper.selectBasketPageList();
	}

	@Override
	public int insertMenu(ProductDto shop) throws Exception {
		int result = productMapper.insertMenu(shop);
		
		return result;
	}

	@Override
	public void deleteMenu(int no) throws Exception {
		productMapper.deleteMenu(no);
	}

	@Override
	public void showPrice() throws Exception {
		productMapper.showPrice();		
	}
}
