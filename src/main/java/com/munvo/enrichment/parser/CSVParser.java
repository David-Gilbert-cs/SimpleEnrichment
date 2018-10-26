package com.munvo.enrichment.parser;

import com.munvo.enrichment.model.Subscriber;

/*
 *author : David Gilbert 
 * 
 */



public class CSVParser implements FileReaderParser {

	@Override
	public Subscriber parseSubscriber(String subLine) {

		
		int id = -1;
	    String name = "";
	    String phone = "";
		
	    
	    //get first value
	    int i = 0 ;
	    String idString = "" ;
		while(subLine.charAt(i) != ','){
			idString += subLine.charAt(i);
			i++;
			
		}
		id = Integer.parseInt(idString);
		//get rid of , and  "
		i +=2;
		//get second value 
		while(subLine.charAt(i) != '"'){
			name += subLine.charAt(i);
			i++;
		}
		//get rid of , and  "
		i +=2;
		//get third value 
				while(subLine.charAt(i) != '"'){
					phone += subLine.charAt(i);
					i++;
				}
		
		
		return new Subscriber(id, name, phone);
	}

}
