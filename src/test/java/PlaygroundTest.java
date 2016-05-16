import static org.junit.Assert.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaygroundTest {
 private static WebDriver driver;
 JavascriptExecutor exe = (JavascriptExecutor)driver; 

 @BeforeClass
 public static void beforeclass(){
  driver = new FirefoxDriver();
  driver.get("http://timvroom.com/selenium/playground/");
}
 @Test
 public void TesAt(){
  driver.findElement(By.id("answer1")).sendKeys(driver.getTitle());
 }
 
 @Test
 public void TestB(){
  driver.findElement(By.id("name")).sendKeys("Kilgore Trout");
 }
 
 @Test
 public void TestC(){
  driver.findElement(By.id("occupation")).sendKeys("Scifiauthor");
 }
 
 @Test
 public void TestD(){
  List<WebElement> Bluebox = driver.findElements(By.className("bluebox"));
  driver.findElement(By.id("answer4")).sendKeys(Integer.toString(Bluebox.size()));
 }
 
 @Test
 public void TestE(){
  driver.findElement(By.linkText("click me")).click();
 }
 
 @Test
 public void TestF(){
  String ClassNamn = driver.findElement(By.id("redbox")).getAttribute("class");
  driver.findElement(By.id("answer6")).sendKeys(ClassNamn);
 }
 
 @Test
 public void TestG(){
   exe.executeScript("ran_this_js_function()");  
 }
 
 @Test
 public void TestH(){
  Long sparat =(Long) exe.executeScript("return got_return_from_js_function()");
  driver.findElement(By.id("answer8")).sendKeys(Long.toString(sparat));
 }
 
 @Test
 public void TestI(){
  driver.findElement(By.name("wrotebook")).click();
 }
 
 @Test
 public void TestJ(){
  String SparaText = driver.findElement(By.id("redbox")).getText();
  driver.findElement(By.id("answer10")).sendKeys(SparaText);
 }
 
 @Test
 public void TestK(){
  Point green = driver.findElement(By.id("greenbox")).getLocation();
  Point orange = driver.findElement(By.id("orangebox")).getLocation();
  
  if( green.y < orange.y){
   driver.findElement(By.id("answer11")) .sendKeys("green"); 
   System.out.println("Green is on top");
  } else { 
   driver.findElement(By.id("answer11")) .sendKeys("orange"); 
   System.out.println("Orange is on top");

 }
}
  @Test
  public void TestL(){
   Dimension d = new Dimension(850,650);
   //Resize the current window to the given dimension
   driver.manage().window().setSize(d); 
 } 
  
  @Test
  public void TestM(){
  List<WebElement> Element = driver.findElements(By.id("ishere"));
  if (Element.size()== 1){ 
   driver.findElement(By.id("answer13")) .sendKeys("yes"); 
  } else { 
   driver.findElement(By.id("answer13")) .sendKeys("no"); 
  } 
 }
  
  @Test
  public void TestN(){
  Boolean Element2 = driver.findElement(By.id("purplebox")).isDisplayed();
  if (Element2){ 
   driver.findElement(By.id("answer14")) .sendKeys("yes"); 
  } else { 
   driver.findElement(By.id("answer14")) .sendKeys("no");
  }
 }
  
  @Test
  public void TestO(){
   driver.findElement(By.linkText("click then wait")).click();
   WebDriverWait wait = new WebDriverWait(driver, 10); 
   wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("click after wait"))); 
   wait.pollingEvery(1, TimeUnit.MILLISECONDS);
   driver.findElement(By.linkText("click after wait")).click(); 
  } // Passes sometimes but other times won't, seems to come down to browser lag
  
  @Test
  public void TestP(){
   driver.switchTo().alert().accept();
  }
  
  @Test
  public void TestQ(){
   driver.findElement(By.id("submitbutton")).click();
  }
  
  @Test
  public void TestResultat(){
   //kollar resultat
   driver.findElement(By.id("checkresults")).click();
  }
  
 /* @AfterClass
  public static void AfterClass(){
   driver.close(); 
  } */
}