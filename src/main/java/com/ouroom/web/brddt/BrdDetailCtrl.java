package com.ouroom.web.brddt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ouroom.web.item.Item;



@RestController
@RequestMapping("/BrdDetail")


public class BrdDetailCtrl {
	static final Logger logger = LoggerFactory.getLogger(BrdDetailCtrl.class);
	@Autowired BrdDetailCtrl brddt;
	@Autowired BrdDetailMapper brddtmapper;
	@Autowired Item item;
	
	@GetMapping(value="/detail/{seq}")
	public  @ResponseBody Map<String, Object> detail(@PathVariable String seq){
		logger.info("======== BrdDetailCtrl ::: detail() =======");
		item=brddtmapper.item_seq(seq);
		List<Item> item2=brddtmapper.item_opt(seq);
		System.out.println("결과  :: "+seq);
		Map<String, Object> imap = new HashMap<>();
		System.out.println("넘어온 값 :: "+ item.getTitle());
		imap.put("title", item.getTitle());
		imap.put("price", item.getPrice());
		imap.put("deli", item.getDelivery());
		imap.put("disc",item.getDiscount());
		imap.put("pho", item.getPhoto());
		imap.put("sale", item.getSale_cnt());
		imap.put("store", item.getStroe_cnt());
		imap.put("sum", item.getSum());
		imap.put("options", item2);
/*		System.out.println("options :: "+ item2);*/
		
		return imap;
	}
}
