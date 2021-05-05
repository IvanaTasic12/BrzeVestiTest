
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


public class DashboardTest {
    private static WebDriver driver;
    
    public DashboardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "/Users/Tasic/desktop/workspace/BrzeVestiTest/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @AfterClass
    public static void tearDownClass() {
        driver.quit();
        
    }
    
    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login");
        login();
    }
    
    @After
    public void tearDown() {
        logout();
        
    }
    
    private void login(){
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("qa@cubes.rs");
        
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("cubesqa");
        
        WebElement loginButton = driver.findElement(By.className("btn-primary"));
        loginButton.click();
        
    }
    
    private void logout(){
        WebElement navCubesQaButton = driver.findElement(By.className("dropdown-toggle"));
        navCubesQaButton.click();
        
        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        logoutButton.click();
    }
    
    @Test
    
    public void testLinkSignatures (){
        
        WebElement navSignatures = driver.findElement(By.linkText("Signatures"));
        navSignatures.click();
        
        String expectedResult = "http://bvtest.school.cubes.rs/admin/signatures";
        String actualResult = driver.getCurrentUrl();
        
        if (expectedResult.equals(actualResult)) {
            System.out.println("Test je prosao");
        } else {
            System.out.println("Test nije prosao");
            
        }
        
       
    }
    
    @Test
    
    public void testLinkCategories(){
        
        WebElement navCategories = driver.findElement(By.linkText("Categories"));
        navCategories.click();
        
        String expectedResult = "http://bvtest.school.cubes.rs/admin/categories";
        String actualResult = driver.getCurrentUrl();
        
        if (expectedResult.equals(actualResult)) {
            System.out.println("Test je prosao");
        } else {
            System.out.println("Test nije prosao");
            
        }
        
    }
    
    @Test
    
    public void testLinkRegions(){
        
        WebElement navRegions = driver.findElement(By.linkText("Regions"));
        navRegions.click();
        
        String expectedResult = "http://bvtest.school.cubes.rs/admin/regions";
        String actualResult = driver.getCurrentUrl();
        
        if (expectedResult.equals(actualResult)) {
            System.out.println("Test je prosao");
        } else {
            System.out.println("Test nije prosao");
            
        }
        
    }
    
    @Test
    
    public void testLinkPortals(){
        
        WebElement navPortals = driver.findElement(By.linkText("Portals"));
        navPortals.click();
        
        String expectedResult = "http://bvtest.school.cubes.rs/admin/portals";
        String actualResult = driver.getCurrentUrl();
        
        if (expectedResult.equals(actualResult)) {
            System.out.println("Test je prosao");
        } else {
            System.out.println("Test nije prosao");
            
        }
        
        
    }
    
    @Test
    
    public void testLinkSources(){
        
        WebElement navSources = driver.findElement(By.linkText("Sources"));
        navSources.click();
        
        String expectedResult = "http://bvtest.school.cubes.rs/admin/sources";
        String actualResult = driver.getCurrentUrl();
        
        if (expectedResult.equals(actualResult)) {
            System.out.println("Test je prosao");
        } else {
            System.out.println("Test nije prosao");
            
        }
        
    }
    
    @Test
    
    public void testElementPresents(){
        
        WebElement titleDashboard = driver.findElement(By.className("panel-heading"));
        System.out.println(titleDashboard.getAttribute("textContent"));
        
        String expectedResult = "Dashboard";
        String actualResult = titleDashboard.getAttribute("textContent");
        
        if (expectedResult.equals(actualResult)) {
            System.out.println("Test je prosao");
        } else {
            System.out.println("Test nije prosao");
            
        }
        
        
    }
    
   

    
}
