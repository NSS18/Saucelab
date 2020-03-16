package com.nopcommerce;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//To select browser
public class BrowserSelector extends BasePage {
    //Creating object of LoadProp class
    public static LoadProp loadprop=new LoadProp();
    //Reading SauceLabs username
    public static final String USERNAME=loadprop.getProperty("SAUCE_USERNAME");
    //Reading SauceLabs access key
    public static final String ACCESS_KEY=loadprop.getProperty("SAUCE_ACCESS_KEY");
    //opening SauceLabs url--->Driver creation link
    public static final String URL="https://"+USERNAME+":"+ACCESS_KEY+"@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    //reading Sauce status->true/false from configuration(edit configuration) ----->-Dsauce=true/false
    public static final boolean SAUCE_LAB=Boolean.parseBoolean(System.getProperty("Sauce"));
    //reading browser value from configuration(edit configuration)----->-Dbrowser=chrome/firefox/ie etc
    public static final String browser=System.getProperty("browser");


    //set up browser method to select browser using SauceLabs
    public  void SetUpBrowser() {

        //object of load propertied class
        LoadProp loadProp=new LoadProp();
        //To print browser name
        System.out.println("We are using-----> "+browser+" browser");

        //if sauce lab is true....................................................................................
        if (SAUCE_LAB) {
            System.out.println("running sauce lab with browser ------>" + browser);

            if (browser.equalsIgnoreCase("chrome")) {
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("platform", "Windows 8");
                caps.setCapability("version", "78.0");
                //loadProp.getProperty("url");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                loadProp.getProperty("url");

            }
            // To open firefox browser
            else if (browser.equalsIgnoreCase("firefox")) {
                DesiredCapabilities caps = DesiredCapabilities.firefox();
                caps.setCapability("platform", "Windows 7");
                caps.setCapability("version", "56");
                caps.setCapability("name", "Testing on Firefox 56");


                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                loadProp.getProperty("url");
            }

            // To open safari browser
            else if (browser.equalsIgnoreCase("safari")) {
                DesiredCapabilities caps = DesiredCapabilities.safari();
                caps.setCapability("platform", "OS X 10.10");
                caps.setCapability("version", "8.0");


                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                loadProp.getProperty("url");
            }

            // To open IE browser
            else if (browser.equalsIgnoreCase("IE")) {
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setCapability("platform", "Windows 10");
                caps.setCapability("version", "11");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                loadProp.getProperty("url");

            }

            // To open edge browser
            else if (browser.equalsIgnoreCase("edge")) {
                DesiredCapabilities caps = DesiredCapabilities.edge();
                caps.setCapability("platform", "Windows 10");
                caps.setCapability("version", "16.16299");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                loadProp.getProperty("url");

            }


            else
            {
                System.out.println("Wrong browser name or empty"+browser);

            }


        }


        //To open locally.............................................................


        else {

            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\BrowserDrivers\\chromedriver.exe");
                driver = new ChromeDriver();

            }

            // To opeen firefox browser
            else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src\\test\\Resources\\BrowserDrivers\\geckodriver.exe");
                driver = new FirefoxDriver();

            }

            // To open edge browser
            else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
//                driver.manage().window().maximize();
//                driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//                driver.get("https://demo.nopcommerce.com/");
            }

            // To open IE browser
            else if (browser.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", "src\\test\\Resources\\BrowserDrivers\\IEDriverServer.exe");
                DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

                ieCapabilities.setCapability("nativeEvents", false);
                ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
                ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
                ieCapabilities.setCapability("disable-popup-blocking", true);
                ieCapabilities.setCapability("enablePersistentHover", true);

                driver = new InternetExplorerDriver(ieCapabilities);

            }

            //if mentioned browser is not present in the config file
            else
                System.out.println("No matching browser " + browser);


        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");

    }


    //To close browser
    public void closeBrowser()
    {
        driver.quit();
    }


}

