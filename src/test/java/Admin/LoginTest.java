
package Admin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTest {
    private static WebDriver driver;
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "/Users/Tasic/desktop/workspace/BrzeVestiTest/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login");
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test 
    public void testLinkRedirection(){
        WebElement navLinkRedirection = driver.findElement(By.linkText("Brze Vesti"));
        navLinkRedirection.click();
        
       String expectedResult = "http://bvtest.school.cubes.rs";
       String actualResult = driver.getCurrentUrl();
       
       if (expectedResult.equals(actualResult)) {
            System.out.println("Test je prosao");
        } else {
            System.out.println("Test nije prosao");
            
        }
       
    }
}
