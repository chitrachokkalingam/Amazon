package com.sample;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class BrokenImage {
public static void main(String[] args) throws IOException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	List<WebElement> elements = driver.findElements(By.tagName("img"));
	System.out.println("The Total number of tags:" + elements.size());
	int brokencount = 0;
	for (WebElement e:elements)
	{
		String attribute = e.getAttribute("src");
		System.out.println(attribute);
		URL url = new URL("https://www.facebook.com/");
		URLConnection con = url.openConnection();
		HttpURLConnection connection=(HttpURLConnection) con;
		int responseCode = connection.getResponseCode();
		if(responseCode!=200)
		{
			brokencount++;
			System.out.println("broken image name:" + attribute );
			
	}
	
}
	System.out.println("Total no of broken:"+ brokencount);
}}

