package com.han.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.han.Service.IShopingMNGTService;

@Component
public class testrunner implements CommandLineRunner{
@Autowired
public IShopingMNGTService service;
	@Override
	public void run(String... args) throws Exception {
		
	try {	
	String result=service.ShopProdect(new String[] {"PHOTO"},
			                      new Double[] {1000.0} ,
			                      new String[] {"madhurisekhar773@gmail.com","shaikhaneef0007@gmail.com"});
	System.out.println(result);
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

}
