package com.kj;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.kj.constant.DictionaryEnum;
import com.kj.constant.HccConstant;
import com.kj.model.*;
import com.kj.service.*;
import net.minidev.json.writer.UpdaterMapper;
import net.sf.ehcache.search.query.QueryManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HccApplicationTests {

	@Autowired
	private SuppImageService suppImageService;

	@Autowired
	private SuppDictionaryService suppDictionaryService;
	@Autowired
	private SuppServicesService suppServicesService;

	@Autowired
	private SuppCompanyService suppCompanyService;

	@Autowired
	private SuppNewsService suppNewsService;

	@Test
	public void contextLoads() {

		List<SuppImage> suppImages = suppImageService.selectListByType(11);

		for (SuppImage suppImage : suppImages) {

			System.out.println(suppImage);
		}
	}

	@Test
	public void testDictionary() {

		List<SuppDictionary> suppDictionaries = suppDictionaryService.selectList(DictionaryEnum.COMPANY_SERVICEBASE.getCode().toString());

		for (SuppDictionary suppDictionary : suppDictionaries) {

			System.out.println(suppDictionary);
		}
	}
	@Test
	public void testSuppServices() {

//		List<SuppServices> suppServices = suppServicesService.selectTopThree();
		List<SuppServices> suppServices = suppServicesService.selectList();

		for (SuppServices supp : suppServices) {

			System.out.println(supp);
		}
	}



	@Test
	public void testSuppCompany() {

		/*SuppCompany suppCompany = suppCompanyService.selectCompany();


		System.out.println(suppCompany);*/

		SuppCompany suppCompany =new SuppCompany();
		suppCompany.setName("www");
		suppCompanyService.update(suppCompany,new EntityWrapper<SuppCompany>().eq(false,"name","yyy"));
	}


	@Test
	public void testSuppNews() {

		Page<SuppNews> page = new Page(1,3);
		Page<SuppNews> suppNewsPage = suppNewsService.selectPage(page, new EntityWrapper<SuppNews>().orderBy("`order`", true));

		List<SuppNews> records = suppNewsPage.getRecords();


		System.out.println(suppNewsPage.isSearchCount());

		System.out.println(suppNewsPage.getTotal());
		System.out.println(suppNewsPage.getCurrent());
		System.out.println(suppNewsPage.getRecords());

	}


}
