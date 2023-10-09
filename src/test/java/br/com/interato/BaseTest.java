package br.com.interato;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;




public class BaseTest  {
    protected  WebDriver driver;


    public BaseTest(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
  
}
