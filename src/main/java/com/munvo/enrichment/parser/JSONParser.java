package com.munvo.enrichment.parser;

import com.munvo.enrichment.model.Subscriber;

/*
 * author : David Gilbert
 * 
 * note : the parsing implementation has probably been made into an official library, it would probably be better to use it for more generic purposes
 * 
 */

public class JSONParser implements FileReaderParser {
	
	
	

	@Override
    public Subscriber parseSubscriber(String subLine){
    	
		
	    int id = -1;
	    String name = "";
	    String phone = "";
	    
	    //try catch exception if input has wrong format
	    try {
			//get the values from the JSON string
	    	int i = 0 ;
	    	//get first value (id)
	    	while(subLine.charAt(i) != ':'){
				i++;	
			}
			//get rid of : and space chars
			i +=2;
			//get id
			String idString = "";
			while(subLine.charAt(i) != ','){
				idString += subLine.charAt(i);
				i++;
			}
			id = Integer.parseInt(idString);	
			
			//get second value (name)
			while(subLine.charAt(i) != ':'){
				i++;	
			}
			
			//get rid of :, space and first " chars
			i +=3 ;
			//get the name
			while(subLine.charAt(i) != '"'){
				name += subLine.charAt(i);
				i++;
			}
			
			//get third value (phone)
			while(subLine.charAt(i) != ':'){
				i++;	
			}
			
			//get rid of :, space and first " char
			i +=3 ;
			//get the phone number
			while(subLine.charAt(i) != '"'){
				phone += subLine.charAt(i);
				i++;
			}
				
				
			
		} catch (NumberFormatException e) {
			System.err.println("input String to JSONParser has wrong format");
			e.printStackTrace();
		}
			
    	return new Subscriber(id,name,phone);
    }

}
