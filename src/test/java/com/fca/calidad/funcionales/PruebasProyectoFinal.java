package com.fca.calidad.funcionales;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PruebasProyectoFinal {
private WebDriver driver;
private String baseUrl;
private boolean acceptNextAlert = true;
private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Documents\\calidadDeSoftware\\chromedriver.exe");
	driver = new ChromeDriver();
	baseUrl = "https://www.google.com/";
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	//ADD
	//===================================================
	  @Test
	  public void testUntitledTestCaseAdd() throws Exception {
	    driver.get("https://mern-crud.herokuapp.com/");
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("prueba");
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("prueba@gmail.com");
	    driver.findElement(By.name("age")).click();
	    driver.findElement(By.name("age")).clear();
	    driver.findElement(By.name("age")).sendKeys("18");
	    driver.findElement(By.xpath("//div[3]/div[2]/div/div")).click();
	    driver.findElement(By.xpath("//div/span")).click();
	    driver.findElement(By.xpath("//form/button")).click();
	    driver.findElement(By.xpath("//i")).click();
	    // Warning: assertTextPresent may require manual changes
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
	  }

	//EDIT
	//======================================================

	@Test
	  public void testUntitledTestCaseEdit() throws Exception {
	    driver.get("https://mern-crud.herokuapp.com/");
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button")).click();
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("Prueba2");
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("prueba2@gmail.com");
	    driver.findElement(By.xpath("//form/button")).click();
	    driver.findElement(By.xpath("//i")).click();
	    // Warning: assertTextPresent may require manual changes
	    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
	  }

	//DELETE
	//=======================================================

	 @Test
	  public void testUntitledTestCaseDelete() throws Exception {
	    driver.get("https://mern-crud.herokuapp.com/");
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button[2]")).click();
	    driver.findElement(By.xpath("//div[3]/button")).click();
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.xpath("//i")).click();
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.xpath("//i")).click();
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.xpath("//i")).click();
	    // Warning: assertTextNotPresent may require manual changes
	    assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]prueba2@gmail\\.com[\\s\\S]$"));
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}