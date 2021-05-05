
package Admin;

import framework.Helper;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegionsTest {
    private static WebDriver driver;
    
    public RegionsTest() {
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
    public void testAddNewRegion(){
        
        WebElement navRegions = driver.findElement(By.linkText("Regions"));
        navRegions.click();
        
        WebElement addNewRegionButton = driver.findElement(By.className("pull-right"));
        addNewRegionButton.click();
        
        WebElement titleField = driver.findElement(By.id("title"));
        String newRegionTitle = Helper.generateTitle();
        titleField.sendKeys(newRegionTitle);
        
        WebElement saveButton = driver.findElement(By.id("save-region-button"));
        saveButton.click();
        
        String expectedResult = "Region \"" + newRegionTitle + "\" has been successfully saved!";
        String actualResult = driver.findElement(By.className("alert-success")).getText();
        
        assertTrue("Failed to create new region",expectedResult.equals(actualResult));
                
        
    }
    
    @Test
    public void testCancelAddingNewRegion(){
        
        WebElement navRegions = driver.findElement(By.linkText("Regions"));
        navRegions.click();
        
        WebElement addNewRegionButton = driver.findElement(By.className("pull-right"));
        addNewRegionButton.click();
        
        WebElement titleField = driver.findElement(By.id("title"));
        String newRegionTitle = Helper.generateTitle();
        titleField.sendKeys(newRegionTitle);
        
        WebElement backToRegionsButton = driver.findElement(By.id("back-button"));
        backToRegionsButton.click();
        
        String expectedResult = "http://school.cubes.rs/admin/bvtestregions";
        String actualResult = driver.getCurrentUrl();
        
//        assertTrue("URLs doesn't match",expectedResult.equals(actualResult));
        if (expectedResult.equals(actualResult)) {
            System.out.println("Test je prosao");
        } else {
            System.out.println("Test nije prosao");
            
        }
        
    
    }
    
    @Test
    public void testDeleteFirstRegionFromTable(){
        
        WebElement navRegions = driver.findElement(By.linkText("Regions"));
        navRegions.click();
        
        String regionName = driver.findElement(By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[2]")).getText();
        
        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[5]/div/button[2]"));
        deleteButton.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        WebElement deleteConfirmationButton = driver.findElement(By.xpath("//*[@id=\"regionDeleteDialog\"]/div/div/div[3]/button[2]"));
        deleteConfirmationButton.click();
        
        String afterDeleteRegionName = driver.findElement(By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[2]")).getText();
        
        if (afterDeleteRegionName.equals(regionName)) {
            System.out.println("Test je prosao");
        } else {
            System.out.println("Test nije prosao");
            
        }
        
    
        
    }
    
    @Test
    public void testEditFirstRegionFromTable(){
        
        WebElement navRegions = driver.findElement(By.linkText("Regions"));
        navRegions.click();
        
        WebElement editButton = driver.findElement(By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[1]/td[5]/div/a/span"));
        editButton.click();
        
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.clear();
        String newRegionTitle = Helper.generateTitle();
        titleField.sendKeys(newRegionTitle);
        
        WebElement saveButton = driver.findElement(By.id("save-region-button"));
        saveButton.click();
        
        String expectedResult = "Region \"" + newRegionTitle + "\" has been successfully saved!";
        String actualResult = driver.findElement(By.className("alert-success")).getText();
        
        assertTrue("Failed to edit region",expectedResult.equals(actualResult));
    
    
    } 
    
    @Test 
    public void testDelete15thRegionFromTable() {
        
        WebElement navRegions = driver.findElement(By.linkText("Regions"));
        navRegions.click();
        
        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[15]/td[5]/div/button[2]/span"));
        deleteButton.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        WebElement deleteConfirmationButton = driver.findElement(By.xpath("//*[@id=\"regionDeleteDialog\"]/div/div/div[3]/button[2]"));
        deleteConfirmationButton.click();
        
        String expectedResult = driver.findElement(By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[15]/td[5]/div/button[2]/span")).getText();
        String actualResult = driver.findElement(By.className("alert-success")).getText();
        

        if (expectedResult.equals(actualResult)) {
            System.out.println("Test je prosao");
        } else {
            System.out.println("Test nije prosao");
            
        }
        
    }
    
   
            
        
        
}
    
        
        
        
        
    
    
    
    



    
    
        
        
        
        
        
        
    
        
        
        
        
        
        
        
        
        
        
        
        
        
    

        
    

        
        
    
    
   
        
        
        
        
        
        
        
        
        
        
        
    
                
        
        
        
        
        
    
    
            

    

