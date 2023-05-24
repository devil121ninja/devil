package com.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {
	public static void main(String[] args) throws IOException {
		File propertiefile =new File("E:\\new Work Space For Selenium\\com.banking\\Configuration\\config.properties");
		FileInputStream file = new FileInputStream(propertiefile);
		System.out.println(propertiefile.exists());
		
		Properties p = new Properties();
		p.load(file);
		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("baseUrl"));
	}

}
