/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginTest;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ruinan
 */
public class TestLogin {
    @Before
    public void setUp(){
        
    
    }
     @Test
    public void helloWorldTestThatFails() {
        public WebDriver driver;
        private WebDriverWait wait;
        driver.get("http://www.google.com/");
        
        driver.findElement(By.id("lst-ib")).sendKeys("Hello World!" + Keys.RETURN);
        
        WebElement rightHandSideHeader = driver.findElement(By.xpath("//div[contains(@class, 'kno-ecr-pt')]"));
        assertEquals("\"Hello, World!\" program", rightHandSideHeader.getText());
    }
    
    @Test
    public void helloWorldTestThatSucceeds() {
        driver.get("http://www.google.com/");
        
        driver.findElement(By.id("lst-ib")).sendKeys("Hello World!" + Keys.RETURN);
        
        By rightHandSideSelector = By.xpath("//div[contains(@class, 'kno-ecr-pt')]");
        waitUntil(d -> d.findElement(rightHandSideSelector).isDisplayed());
        assertEquals("\"Hello, World!\" program", driver.findElement(rightHandSideSelector).getText());
    }
}
