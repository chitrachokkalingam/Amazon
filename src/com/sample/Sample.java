package com.sample;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {
public static void main(String[] args) throws Exception {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
List<WebElement> elements = driver.findElements(By.tagName("a"));
System.out.println("Total number of tags:" + elements.size());
int brokencount =0;
for(WebElement a:elements)
{
	String attribute = a.getAttribute("href");
	URL url = new URL("https://www.facebook.com/");
	URLConnection con = url.openConnection();
	HttpURLConnection connection =(HttpURLConnection) con;
	int response =connection.getResponseCode();
	if(response!=200)
	{
		brokencount++;
		System.out.println("Broken Link name:" +attribute);
	}
	
}
System.out.println("Total broken link count :"+ brokencount );	
}
}
