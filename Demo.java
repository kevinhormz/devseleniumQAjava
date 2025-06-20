package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import java.util.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Container;
import java.awt.Font;
//import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Demo extends JFrame{
	
	JLabel init = new JLabel("URL");
	JLabel codes = new JLabel("Information");
	
	JTextArea initialtapearea = new JTextArea();
	JTextArea codetextarea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(codetextarea);
	JButton Run = new JButton("RUN");
	JButton Reset = new JButton("RESET");

	Container turingMachineInterface = getContentPane();
	public static int pointer=0;
	public static int h;
	public static String dangit;

	StringBuffer str = new StringBuffer();
	public static String dangit1 = "";
	
	public Demo ()
	{
	setTitle("Quality Assurance for Webpages");
	setSize(800,800);
	setLocationRelativeTo(null);            //setting the GUI on the center of the screen
	setLayout(null);
	setVisible(true);						//For the gui to be visible
	setResizable(false);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	turingMachineInterface.add(init);
	turingMachineInterface.add(codes);
	turingMachineInterface.add(initialtapearea);
	turingMachineInterface.add(codetextarea);
	turingMachineInterface.add(Run);
	turingMachineInterface.add(Reset);

	init.setBounds(375,1,200,20);
	init.setFont(new Font("Arial", Font.BOLD, 14)); 
	initialtapearea.setBounds(315,20,150,20);
	codes.setBounds(345,90, 500,20 );
	codes.setFont(new Font("Arial", Font.PLAIN, 18)); 
	codetextarea.setBounds(10,120,750,500);
	codetextarea.setLineWrap(true);
	codetextarea.setWrapStyleWord(true);
	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	Run.setBounds(345, 650, 100,20);
	Reset.setBounds(345, 675, 100,20);
	
	
	
	
	Reset.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			initialtapearea.setText("");
	
			codetextarea.setText("");
		}
	}
	);

;

}

	

	public class SomeClass {
	    public static String baseUrl;

	    public static void getUrl() {
	        Scanner sc = new Scanner(System.in);
	        baseUrl = sc.nextLine();
	    }
	}
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\chromedriver.exe");
 		
 		ChromeOptions option = new ChromeOptions();
         option.addArguments("--remote-allow-origins=*");
 
 		WebDriver driver = new ChromeDriver(option);
 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 		
 		Demo b = new Demo();
 	
 		System.out.println("Enter URL: ");
 		SomeClass.getUrl();
 		
 		if (SomeClass.baseUrl.contains("https://")) {
 			driver.get(SomeClass.baseUrl); //webpage URL
 		}
 		
 		else {
 			driver.get("https://"+SomeClass.baseUrl); //webpage URL
 		}
 		
 		
 		if (SomeClass.baseUrl.contains("infosoft")) {
	            // Navigate to the wp-login page
	            driver.get("https://"+SomeClass.baseUrl+"/wp-login.php");
	            // Locate the username and password fields and log in button
	            WebElement usernameField = driver.findElement(By.id("user_login"));
	            WebElement passwordField = driver.findElement(By.id("user_pass"));
	            WebElement loginButton = driver.findElement(By.id("wp-submit"));

	            // Fill in the login form
	            usernameField.sendKeys("Digitalfeet");
	            passwordField.sendKeys("VH&wqiE#lHs@yO^V");
	            loginButton.click();

	            // Optional: wait or assert URL or dashboard element
	            if (driver.getCurrentUrl().contains("wp-admin")) {
	                System.out.println("Login successful!");
	                b.codetextarea.append("WP-Admin Login successful!");
	                b.codetextarea.append("\n");
	            } 
	            else if (driver.getPageSource().contains("id=\"authcode\"")){
	            	try {
	                    WebElement authCodeField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("authcode")));
	                    System.out.println("Authentication code field appeared.");
	                } catch (Exception e) {
	                    // Field did not appear within 10 seconds — continue without it
	                    System.out.println("No authentication code field found. Proceeding.");
	                }
	            	Thread.sleep(10000);
	            	if (driver.getCurrentUrl().contains("wp-admin")) {
	                    System.out.println("WP-Admin Login successful!");
	                    b.codetextarea.append("WP-Admin Login successful!");
	                    b.codetextarea.append("\n");
	                } 
	            	else {
	                    System.out.println("WP-Admin Login failed.");
	                    b.codetextarea.append("WP-Admin Login failed!");
	                    b.codetextarea.append("\n");
	                }
	            }
	            else {
	                System.out.println("Login failed.");
	                b.codetextarea.append("WP-Admin Login successful!");
	                b.codetextarea.append("\n");
	            }
		}
		else if (SomeClass.baseUrl.contains("digitalfeet")) {
            // Navigate to the wp-login page
            driver.get("https://digitalfeet.com/wp-login.php");
            // Locate the username and password fields and log in button
            WebElement usernameField = driver.findElement(By.id("user_login"));
            WebElement passwordField = driver.findElement(By.id("user_pass"));
            WebElement loginButton = driver.findElement(By.id("wp-submit"));

            // Fill in the login form
            usernameField.sendKeys("tools@digitalfeet.com");
            passwordField.sendKeys("1T#*kSkTJFO06dic");
            loginButton.click();

            // Optional: wait or assert URL or dashboard element
            if (driver.getCurrentUrl().contains("wp-admin")) {
                System.out.println("WP-Admin Login successful!");
                b.codetextarea.append("WP-Admin Login successful!");
                b.codetextarea.append("\n");
            } 
            else if (driver.getPageSource().contains("id=\"authcode\"")){
            	try {
                    WebElement authCodeField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("authcode")));
                    System.out.println("Authentication code field appeared.");
                } catch (Exception e) {
                    // Field did not appear within 10 seconds — continue without it
                    System.out.println("No authentication code field found. Proceeding.");
                }
            	Thread.sleep(10000);
            	if (driver.getCurrentUrl().contains("wp-admin")) {
                    System.out.println("WP-Admin Login successful!");
                    b.codetextarea.append("WP-Admin Login successful!");
                    b.codetextarea.append("\n");
                } 
            	else {
                    System.out.println("WP-Admin Login failed.");
                    b.codetextarea.append("WP-Admin Login failed!");
                    b.codetextarea.append("\n");
                }
            }
         
            else {
                System.out.println("WP-Admin Login failed.");
                b.codetextarea.append("WP-Admin Login failed!");
                b.codetextarea.append("\n");
            }
		}
		else if (SomeClass.baseUrl.contains("pointtaken")) {
            // Navigate to the wp-login page
            driver.get("https://pointtaken.no/wp-admin");
            // Locate the username and password fields and log in button
            WebElement usernameField = driver.findElement(By.id("user_login"));
            WebElement passwordField = driver.findElement(By.id("user_pass"));
            WebElement loginButton = driver.findElement(By.id("wp-submit"));
            
            
            
            // Fill in the login form
            usernameField.sendKeys("tools@digitalfeet.com");
            passwordField.sendKeys("Cagayandeoro83!");
            loginButton.click();

            // Optional: wait or assert URL or dashboard element
            if (driver.getCurrentUrl().contains("wp-admin")) {
                System.out.println("WP-Admin Login successful!");
                b.codetextarea.append("WP-Admin Login successful!");
                b.codetextarea.append("\n");
            } 
            else if (driver.getPageSource().contains("id=\"authcode\"")){
            	try {
                    WebElement authCodeField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("authcode")));
                    System.out.println("Authentication code field appeared.");
                } catch (Exception e) {
                    // Field did not appear within 10 seconds — continue without it
                    System.out.println("No authentication code field found. Proceeding.");
                }
            	Thread.sleep(10000);
            	if (driver.getCurrentUrl().contains("wp-admin")) {
                    System.out.println("WP-Admin Login successful!");
                    b.codetextarea.append("WP-Admin Login successful!");
                    b.codetextarea.append("\n");
                } 
            	else {
                    System.out.println("WP-Admin Login failed.");
                    b.codetextarea.append("WP-Admin Login failed!");
                    b.codetextarea.append("\n");
                }
            }
            
            
            else {
                System.out.println("WP-Admin Login failed.");
                b.codetextarea.append("WP-Admin Login failed!");
                b.codetextarea.append("\n");
            }
		}
		else if (SomeClass.baseUrl.contains("cloudway")) {
            // Navigate to the wp-login page
            driver.get("https://cloudway.com/wp-login.php");
            // Locate the username and password fields and log in button
            WebElement usernameField = driver.findElement(By.id("user_login"));
            WebElement passwordField = driver.findElement(By.id("user_pass"));
            WebElement loginButton = driver.findElement(By.id("wp-submit"));

            // Fill in the login form
            usernameField.sendKeys("digitalfeet");
            passwordField.sendKeys("X7ADM$%C&D2DZfxceEMAoUwN");
            loginButton.click();

            // Optional: wait or assert URL or dashboard element
            if (driver.getCurrentUrl().contains("wp-admin")) {
                System.out.println("WP-Admin Login successful!");
                b.codetextarea.append("WP-Admin Login successful!");
                b.codetextarea.append("\n");
                
            } 
            else if (driver.getPageSource().contains("id=\"authcode\"")){
            	try {
                    WebElement authCodeField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("authcode")));
                    System.out.println("Authentication code field appeared.");
                } catch (Exception e) {
                    // Field did not appear within 10 seconds — continue without it
                    System.out.println("No authentication code field found. Proceeding.");
                }
            	Thread.sleep(10000);
            	if (driver.getCurrentUrl().contains("wp-admin")) {
                    System.out.println("WP-Admin Login successful!");
                    b.codetextarea.append("WP-Admin Login successful!");
                    b.codetextarea.append("\n");
                } 
            	else {
                    System.out.println("WP-Admin Login failed.");
                    b.codetextarea.append("WP-Admin Login failed!");
                    b.codetextarea.append("\n");
                }
            }
            
            else {
                System.out.println("WP-Admin Login failed.");
                b.codetextarea.append("WP-Admin Login failed!");
                b.codetextarea.append("\n");
               
            }
		}
 		
 		driver.get("https://"+SomeClass.baseUrl);
 		
 		
 		
 		String parameter = "page_id=";
 		int startIndex = SomeClass.baseUrl.indexOf(parameter) + parameter.length(); // Start after "page_id="
 		int endIndex = SomeClass.baseUrl.indexOf("&", startIndex);
 		
 		if (endIndex == -1) {
            endIndex = SomeClass.baseUrl.length();
        }
 		
 		String value = SomeClass.baseUrl.substring(startIndex, endIndex);
 		
 		try {
 			
 			WebElement passwordFieldpp = driver.findElement(By.xpath("//input[@type='password']"));// if passwordprotected
 	 		WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit' and @name='Submit']"));
 	 		
 	 		//System.out.println(passwordFieldpp.toString());
 	 		if(passwordFieldpp.toString().contains("input[@type='password'")) {
 	 			if (SomeClass.baseUrl.contains("digitalfeet")) {
 	 	 			//WebElement passwordField = driver.findElement(By.id("pwbox-"+value));  // Update with correct locator
 	 	            //passwordField.sendKeys("digitalfeet");  // Replace with your actual password   
 	 	            //WebElement loginButton = driver.findElement(By.id("loginButton"));  // Update with correct locator
 	 	            //loginButton.click();
 	 	            passwordFieldpp.sendKeys("digitalfeet");
 	 	            submitButton.submit(); // Or use submit() if form is used: passwordField.submit();
 	 	 		}
 	 		}
 	 		
 			
 		} catch (NoSuchElementException e) {
 		   
 		} catch (Exception e) {
 		    System.out.println("An unexpected error occurred: " + e.getMessage());
 		    b.codetextarea.append("An unexpected error occurred: " + e.getMessage());
 		    b.codetextarea.append("\n");
 		}
 		
 		
 		
 		
 		
 	
 		
 		
 		driver.manage().window().maximize();
 		Thread.sleep(3000);
 		try {
 		System.out.println("Page title: " + driver.getTitle()); // get webpage title
 		b.codetextarea.append("Page title: " + driver.getTitle());
 		b.codetextarea.append("\n");
 		System.out.println("Meta title: " + driver.getTitle()); // get meta title
 		b.codetextarea.append("Meta title: " + driver.getTitle());
 		b.codetextarea.append("\n");
 		System.out.println("Meta description: "+driver.findElement(By.xpath("//meta[@property='og:description']")).getDomAttribute("content")); // get meta description
 		b.codetextarea.append("Meta description: "+driver.findElement(By.xpath("//meta[@property='og:description']")).getDomAttribute("content")); // get meta description
 		b.codetextarea.append("\n");
 		System.out.println("Featured image: " + driver.findElement(By.xpath("//meta[@property='og:image']")).getDomAttribute("content")); // get featured image url
 		b.codetextarea.append("Featured image: " + driver.findElement(By.xpath("//meta[@property='og:image']")).getDomAttribute("content")); // get featured image url
 		b.codetextarea.append("\n");
 		System.out.print("Image dimension: " + driver.findElement(By.xpath("//meta[@property='og:image:width']")).getDomAttribute("content")+ "x"); //get image width
 		b.codetextarea.append("Image dimension: " + driver.findElement(By.xpath("//meta[@property='og:image:width']")).getDomAttribute("content")+ "x"); //get image width
 	
 		System.out.println(driver.findElement(By.xpath("//meta[@property='og:image:height']")).getDomAttribute("content")); // get image height
 		b.codetextarea.append(driver.findElement(By.xpath("//meta[@property='og:image:height']")).getDomAttribute("content")); // get image height
 		b.codetextarea.append("\n");
 		System.out.println("Fav icon: "+driver.findElement(By.xpath("//link[@rel='icon']")).getDomAttribute("href"));// get favicon
 		b.codetextarea.append("Fav icon: "+driver.findElement(By.xpath("//link[@rel='icon']")).getDomAttribute("href"));// get favicon
 		b.codetextarea.append("\n");
 		} catch (Exception e) {
            // Skip bayless
            System.out.println("Skip");
        }
 		
 		//FOR ALT TEXT
 		List<WebElement> images = driver.findElements(By.tagName("img"));
 		for (WebElement img : images) {
            String altText = img.getDomAttribute("alt");

            // Check if alt attribute is missing or empty
            if (altText == null || altText.isEmpty()) {
                System.out.println("Image with missing or empty alt text: " + img.getDomAttribute("src"));
                b.codetextarea.append("Image with missing or empty alt text: " + img.getDomAttribute("src"));
                b.codetextarea.append("\n");
            }
        }
 		
 		//FOR H1 TAG
 		 List<WebElement> h1Elements = driver.findElements(By.tagName("h1"));
         // Check if there is exactly one <h1> tag
         if (h1Elements.size() == 1) {
             System.out.println("There is exactly one <h1> tag on the page.");
             b.codetextarea.append("There is exactly one <h1> tag on the page.");
             b.codetextarea.append("\n");
         } else if (h1Elements.size() == 0) {
             System.out.println("There is no <h1> tag on the page.");
             b.codetextarea.append("There is no <h1> tag on the page.");
             b.codetextarea.append("\n");
         } else {
             System.out.println("There are " + h1Elements.size() + " <h1> tags on the page.");
             b.codetextarea.append("There are " + h1Elements.size() + " <h1> tags on the page.");
             b.codetextarea.append("\n");
         }
 		
         //FOR PRIVACY POLICY
         List<WebElement> links = driver.findElements(By.tagName("a"));
         boolean foundPrivacyPolicy = false;
         boolean foundPersonvernerklæring = false;
         
         for (WebElement link : links) {
             String linkText = link.getText().toLowerCase();
             
             // Check for "Privacy Policy" or "Personvernerklæring"
             if (linkText.contains("privacy policy")) {
                 System.out.println("Found Privacy Policy link: " + link.getDomAttribute("href"));
                 b.codetextarea.append("Found Privacy Policy link: " + link.getDomAttribute("href"));
                 b.codetextarea.append("\n");
                 foundPrivacyPolicy = true;
             }
             if (linkText.contains("personvernerklæring")) {
                 System.out.println("Found Personvernerklæring link: " + link.getDomAttribute("href"));
                 b.codetextarea.append("Found Personvernerklæring link: " + link.getDomAttribute("href"));
                 b.codetextarea.append("\n");
                 foundPersonvernerklæring = true;
             }
         }
         if (!foundPrivacyPolicy && !foundPersonvernerklæring) {
             System.out.println("No Privacy Policy or Personvernerklæring found on the page.");
             b.codetextarea.append("No Privacy Policy or Personvernerklæring found on the page.");
         }
         
         //EXTERNAL LINKS OPENING NEW TABS
         boolean anyBadLinkFound = false;
         boolean foundIssue = false;
         for (WebElement link : links) {
             String href = link.getDomAttribute("href");
             String target = link.getDomAttribute("target");
             String marker = ".com/";
             String BaseUrlkeepCom = "";
             
             
             int idx = SomeClass.baseUrl.indexOf(marker);
             if (idx != -1) {
                 BaseUrlkeepCom = SomeClass.baseUrl.substring(0, idx + marker.length()); // keep '.com/'
             }
             
             if (href == null || href.isEmpty() || href.startsWith("#")) continue;
             if (href.contains("wordpress")) continue; // Skip Wordpress links
             if (href.contains(BaseUrlkeepCom)) 
             {
            	 continue;
             }
             try {
                 URI linkUri = new URI(href);
                 String linkDomain = linkUri.getHost();

                 if (linkDomain != null && !linkDomain.equalsIgnoreCase(SomeClass.baseUrl)) {
                     // External link
                     if (!"_blank".equalsIgnoreCase(target)) {
                         System.out.println("❌ External link DOES NOT open in new tab:");
                         System.out.println("→ " + href);
                         b.codetextarea.append("❌ External link DOES NOT open in new tab:");
                         b.codetextarea.append("\n");
                         b.codetextarea.append("→ " + href);
                         b.codetextarea.append("\n");
                         foundIssue = true;
                     }
                 }
             } catch (URISyntaxException e) {
                 // Skip malformed URLs
                 System.out.println("Skipping invalid link: " + href);
                 b.codetextarea.append("Skipping invalid link: " + href);
             }
         }
        
         if (!foundIssue) {
             System.out.println("✅ All external links open in a new tab.");
             b.codetextarea.append("✅ All external links open in a new tab.");
             b.codetextarea.append("\n");
         }
         
         // FORMS
         List<WebElement> forms = driver.findElements(By.tagName("form"));
         System.out.println("Form found: " + forms.size());
         b.codetextarea.append("Form found: " + forms.size());
         b.codetextarea.append("\n");
         String pageSource = driver.getPageSource().toLowerCase();

         if (pageSource.contains("gform_wrapper") || pageSource.contains("gravityforms")) {
             System.out.println("✅ Gravity Forms detected");
             b.codetextarea.append("✅ Gravity Forms detected");
             b.codetextarea.append("\n");
         }
         if (pageSource.contains("ninja-forms-form") || pageSource.contains("nf-form")) {
             System.out.println("✅ Contact Form 7 detected");
             b.codetextarea.append("✅ Gravity Forms detected");
             b.codetextarea.append("\n");
         }
         if (pageSource.contains("wpcf7-form") || pageSource.contains("contact-form-7")) {
             System.out.println("✅ Contact Form 7 detected");
             b.codetextarea.append("✅ Contact Form 7 detected");
             b.codetextarea.append("\n");
         }
         if (pageSource.contains("wpforms-form") || pageSource.contains("wpforms-submit")) {
             System.out.println("✅ WPForms detected");
             b.codetextarea.append("✅ WPForms detected");
             b.codetextarea.append("\n");
         }
         if (pageSource.contains("fluentform") || pageSource.contains("fluentform-wrapper")) {
             System.out.println("✅ Fluent Forms detected");
             b.codetextarea.append("✅ Fluent Forms detected");
             b.codetextarea.append("\n");
         }
         if (pageSource.contains("formidable-form") || pageSource.contains("frm_forms")) {
             System.out.println("✅ Formidable Forms detected");
             b.codetextarea.append("✅ Formidable Forms detected");
             b.codetextarea.append("\n");
         }
         
         // CRAWLABLE CHECK
         try {
             WebElement metaRobots = driver.findElement(By.xpath("//meta[@name='robots']"));
             String content = metaRobots.getDomAttribute("content");
             
             if (content.toLowerCase().contains("noindex") || content.toLowerCase().contains("nofollow")) {
                 System.out.println("❌ Page is NOT crawlable due to robots meta tag: " + content);
                 b.codetextarea.append("❌ Page is NOT crawlable due to robots meta tag: " + content);
                 b.codetextarea.append("\n");
             } else {
                 System.out.println("✅ Page is crawlable (robots meta tag is friendly): " + content);
                 b.codetextarea.append("✅ Page is crawlable (robots meta tag is friendly): " + content);
                 b.codetextarea.append("\n");
             }
         } catch (Exception e) {
             System.out.println("✅ No robots meta tag found — likely crawlable");
             b.codetextarea.append("✅ No robots meta tag found — likely crawlable");
             b.codetextarea.append("\n");
         }
         
 		driver.close();
 		
 		
	}

}
