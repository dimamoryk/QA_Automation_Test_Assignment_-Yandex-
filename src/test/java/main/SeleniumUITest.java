package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class SeleniumUITest {

    public static void demonstrateSeleniumBestPractice() {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://site.com/login");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")))
                    .sendKeys("admin");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-btn")))
                    .click();

            String currentUrl = driver.getCurrentUrl();
            String expectedUrl = "https://site.com/dashboard";

            assert Objects.equals(currentUrl, expectedUrl) : "Ошибка: URL не совпадает! Ожидалось" + expectedUrl + ", получено" + currentUrl;

            System.out.println("✅ Тест авторизации пройден успешно! URL корректен.");
        } catch (Exception e) {
            System.err.println("❌ Тест упал с ошибкой: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();

        }
    }

    public static void main(String... args) {
        demonstrateSeleniumBestPractice();
    }
}
