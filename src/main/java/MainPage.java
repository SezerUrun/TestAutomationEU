import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public MainPage(WebDriver driver){
        this.driver=driver;
    }

    public void login(String eMail,String password){

    }

    public void setFrom(String name){
        try {
            Thread.sleep(1000);
            WebElement webElement = driver.findElement(By.id("OriginInput"));
            scrollTo(webElement);
            webElement.sendKeys(name);
		    webElement = driver.findElement(By.id("react-autowhatever-1-section-0-item-0"));
		    webElement.click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void setTo(String name){
        try {
            Thread.sleep(1000);
            WebElement webElement = driver.findElement(By.id("DestinationInput"));
            scrollTo(webElement);
            webElement.sendKeys(name);
            webElement = driver.findElement(By.id("react-autowhatever-1-section-0-item-0"));
            webElement.click();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

	public void setDepartOn(String dayName, String day,String month,String year){
        try {
		    Thread.sleep(1000);
            WebElement webElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/div[1]/div/div[1]/div/div/form/div/div[2]/div[1]/div[1]"));
            scrollTo(webElement);
            webElement.click();
            webElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/div[1]/div/div[1]/div/div/form/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]"));
            scrollTo(webElement);
            webElement = driver.findElement(By.xpath("//td[@aria-label='"+dayName+", "+day+" "+month+" "+year+"']"));
            webElement.click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
	}

	public void setReturnOn(String dayName,String day,String month,String year){
        try {
            Thread.sleep(1000);
            WebElement webElement=driver.findElement(By.id("oneWayCheckbox"));
            scrollTo(webElement);
            if(webElement.isSelected()){
                webElement.click();
            }
            webElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/div[1]/div/div[1]/div/div/form/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div[3]/div"));
            scrollTo(webElement);
            webElement.click();
            webElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/div[1]/div/div[1]/div/div/form/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/div[2]/div/div[3]"));
            scrollTo(webElement);
            webElement = driver.findElement(By.xpath("//td[@aria-label='"+dayName+", "+day+" "+month+" "+year+"']"));
            webElement.click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
	}
	public void enableTransitFilter(){
		try{
			WebElement webElement = driver.findElement(By.id("transitFilter"));
			scrollTo(webElement);
			webElement.click();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void setPassengerCountAndClass(int passengerCount,String passengerType,String ticketClass){
        try{
			Thread.sleep(1000);
            WebElement webElement = driver.findElement(By.className("passenger-select-button"));
            scrollTo(webElement);
            webElement.click();
			for(int i=0;i<passengerCount;i++){
				Thread.sleep(1000);
				webElement=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/div[1]/div/div[1]/div/div/form/div/div[3]/div[1]/div[3]/div[1]/div[1]/div["+passengerType+"]/div[2]/button[2]"));
				webElement.click();
			}
			Thread.sleep(1000);
			webElement=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[2]/div[1]/div/div[1]/div/div/form/div/div[3]/div[1]/div[3]/div[1]/div[2]/div["+ticketClass+"]/button"));
            webElement.click();
        }
        catch(Exception e){
            e.printStackTrace();
        }
	}
	public void clickOnSearchButton(){
		try{
            Thread.sleep(1000);
            WebElement webElement = driver.findElement(By.className("primary-btn"));
            scrollTo(webElement);
            webElement.click();
            Thread.sleep(1000);
            if(driver.getCurrentUrl().equals("https://www.enuygun.com")){
                System.out.println("Result page is not displayed.");
            }
            else{
                System.out.println("Result page is displayed.");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
	}
    public Object scrollTo(WebElement element){
        String jsStmt = String.format("window.scrollTo(%d, %d);", element.getLocation().x, element.getLocation().y);
        return true ? getJSExecutor().executeScript(jsStmt, "") : getJSExecutor().executeAsyncScript(jsStmt, "");
    }

    protected JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) driver;
    }
}
