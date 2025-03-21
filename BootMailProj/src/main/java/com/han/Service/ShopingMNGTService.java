package com.han.Service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
@Service
public class ShopingMNGTService implements IShopingMNGTService {
@Autowired
private JavaMailSender sender;
@Value("${spring.mail.username}")
private String fromEmaiId;

	@Override
	public String ShopProdect(String[] items, Double[] prices, String[] toEmailIds)throws Exception {
//caluculate, String fromEmailId
		Double totAmt=0.0;
		for(Double p:prices) {
			totAmt=totAmt+p;
		}
		String msg1=Arrays.toString(items)+"ARE PURCHASED HAVING PRICES"+Arrays.toString(prices)+"WITH BILL AMOUNT"+totAmt;
		String msg2=sendMail(msg1, toEmailIds, fromEmaiId);
		return msg1+"...."+msg2;
	}


private String sendMail(String msg,String[] toEmailIds,String fromEmailId)throws Exception{
	//create and send multi part mime msg
	MimeMessage message=sender.createMimeMessage();//represent email msg
	MimeMessageHelper helper=new MimeMessageHelper(message, true);//represent email msg allowing the attachments
	//setting the header value
	helper.setSentDate(new Date());
	helper.setFrom(fromEmailId);
	helper.setCc(toEmailIds);
	helper.setSubject("open to know it");
	//set multipart body
	helper.setText(msg);
	helper.addAttachment("madhu.png",new ClassPathResource("madhu.png"));//img part
	//send msg
	sender.send(message);
	
	return "email msg is sent";
}
}
