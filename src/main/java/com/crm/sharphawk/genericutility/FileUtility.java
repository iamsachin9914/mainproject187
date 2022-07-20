package com.crm.sharphawk.genericutility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 *@author iamsachin
 *@param key
 *@throws Throwable
 */
public class FileUtility
{
	/**
	 * This generic class is used to read the data from commondata.properties file based on key which we pass as an argument for the method
	 * @param
	 *
	 */
	public String getPropertyData(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./TestData/commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;

	}


}

