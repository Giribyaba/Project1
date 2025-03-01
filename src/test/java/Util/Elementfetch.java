package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.Common;

public class Elementfetch {
	
	public WebElement Element(String identifierType, String identifierVlaue )
	{
		switch(identifierType)
		{
		case "XPATH":
			return Common.driver.findElement(By.xpath(identifierVlaue));
		case "ID":
		return Common.driver.findElement(By.xpath(identifierVlaue));
		}
		return null;
	}

}
