package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class MainClass {

    static Scanner scan;
    static BrowserClass browserClass;
    static WebDriver driver;

        public static void main(String[] args) throws IOException {
        scan = new Scanner(System.in);
        browserClass = new BrowserClass();
        System.out.println("Please Enter A Browser Name: ");
        browserClass.chooseBrowser(scan.next());
        System.out.println("Please choose a for BESTBUY and choose b for TARGET then press ENTER!!!");
        browserClass.chooseWebsite();
        
        
        
       
        
        
    }
    
    
}

class BrowserClass{

    WebDriver driver;

    public void chooseBrowser(String browserName) throws IOException {
        // To read the properties file
        FileInputStream file = new FileInputStream("drivers\\browserData\\browserData.properties");
        Properties properties = new Properties();
        properties.load(file);


        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty(properties.getProperty("chrome"), properties.getProperty("chromePath"));
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            
        }else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty(properties.getProperty("firefox"), properties.getProperty("firePath"));
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            
        }else if (browserName.equalsIgnoreCase("opera")) {
            System.setProperty(properties.getProperty("opera"), properties.getProperty("operaPath"));
            driver = new OperaDriver();
            driver.manage().window().maximize();
            
        }else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty(properties.getProperty("edge"), properties.getProperty("edgePath"));
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            
            
        }else {
            System.out.println("The browser name you provided is not supported yet");
        }
        
    }

    public String chooseWebsite() throws IOException  {
        FileInputStream file = new FileInputStream("WebsiteName\\websiteData.properties");
        Properties properties = new Properties();
        properties.load(file);
        Scanner scan = new Scanner(System.in);
        String key = scan.next();
       
       switch(key){
           case "a":{
               driver.get(properties.getProperty("bestbuy"));
               System.out.println(driver.getTitle());
            //    All the code should be over here for buying the product
               break;
           }
           case "b":{
               driver.get(properties.getProperty("target"));
               //    All the code should be over here for buying the product
               break;
           }
           default:{
               System.out.println("Your input is not valid!!!");
               break;
           }
       }
       return key;
    }

/* 
    public void switchBetweenSites() throws IOException {
        if(chooseWebsite().equals("a")){
            System.out.println("We are on the BestBuy.com");
        }else if (chooseWebsite().equals("b")) {
            System.out.println("We are on the Target.com");
        }
        
    } */

   


}


	


