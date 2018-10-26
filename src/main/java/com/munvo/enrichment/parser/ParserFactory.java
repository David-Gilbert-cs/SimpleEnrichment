package com.munvo.enrichment.parser;



public class ParserFactory {

	public FileReaderParser CreateFileReaderParser(String type){
		
		//instantiate a fileReaderParser in function of the type chosen , JSON is default
	    if(type.equals("CSV")){
	        return new CSVParser();
	    }	    
	    else{
			return new JSONParser();
	    }

	}
	
}
