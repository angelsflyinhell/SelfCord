package lib;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Browser {

    public static String loginURL = "https://discord.com/login";
    public static String clientURL = "https://discord.com/channels/@me";
    public static String baseURL = "https://discord.com";

    public static volatile boolean isLoaded = false;

    public static class Login {

        public static WebDriver driver = new ChromeDriver();

        public static void withDiscord() {
            driver.get(loginURL);
            try {
                System.out.println("Breaching...");
                onReady(driver);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void onReady(WebDriver driver) throws IOException {
            while (!isLoaded) {
                if (driver.getCurrentUrl().contains(clientURL))
                    isLoaded = true;
            }
            System.out.println("[INFO] Logged In");
        }

    }

    public static class Client {

        public static void waitForChannel(String guildId, String channelId) {
            boolean url = false;

            while(!url) {
                if(Login.driver.getCurrentUrl().contains(baseURL + "/channels/" + guildId + "/" + channelId)) {
                    url = true;
                    System.out.println("[INFO] Got Channel");
                }
            }
        }

        public static void sendMessage(String message) {
            WebElement currentElement = Login.driver.switchTo().activeElement();
            currentElement.sendKeys(message);
            currentElement.sendKeys(Keys.ENTER);
            System.out.println("[INFO] Sent Message '" + message + "'");
        }
    }
}
