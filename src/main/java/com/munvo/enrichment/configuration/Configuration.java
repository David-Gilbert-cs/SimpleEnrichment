package com.munvo.enrichment.configuration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/*
 * author : david-parr 
 * updated by : David Gilbert
 * 
 * Goal: The Configuration class will read your configuration file and instantiates the variables.
 * implementation specifics : Singleton class
 */
public class Configuration {
	
	private static Configuration configurationInstance = null; 

    private String studentName;
    private String type;
    private String fileName;
    
    public static Configuration getInstance() 
    { 
        if (configurationInstance == null) {
        	configurationInstance = new Configuration(); 
        }
  
        return configurationInstance; 
    } 
    

    public Configuration() {
        Config config = ConfigFactory.load();
        this.studentName = config.getString("name");
        this.type = config.getString("type");
        this.fileName = config.getString("fileName");
    }

    public String getStudentName() {
        return studentName;
    }

    public String getType() {
        return type;
    }

    public String getFileName() {
        return fileName;
    }
}