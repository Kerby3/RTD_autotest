/*package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}*/

package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Main {

    WebDriver wd;

    @BeforeTest()
    public void beforeTestFixture() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        wd = WebDriverManager
                .chromedriver()
                .capabilities(chromeOptions)
                .create();
    }

    @Test()
    public void firstTest() {
        wd.get("https://nodejs.org/en");
        wd.manage().window().maximize(); //действие 1, открытие браузера во весь экран
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }
        By homeH1 = By.xpath("/html/body/div[1]/div[2]/main/section[1]/div[1]/h1");
        WebElement homeH1Element = wd.findElement(homeH1);
        String homeH1Text = homeH1Element.getText();
        Assert.assertEquals(homeH1Text, "Run JavaScript Everywhere"); //проверка 1, заголовок H1 это строка Run JavaScript Everywhere

        By learnBtn = By.xpath("/html/body/div[1]/div[1]/nav/div[2]/div[1]/a[1]");
        WebElement learnBtnElement = wd.findElement(learnBtn);
        learnBtnElement.click(); //действие 1, нажатие на пункт Learn

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }

        By learnH1 = By.xpath("//*[@id=\"introduction-to-nodejs\"]");
        WebElement learnH1Element = wd.findElement(learnH1);
        boolean learnH1ElementPresented = learnH1Element.isDisplayed();
        Assert.assertTrue(learnH1ElementPresented); //проверка 2, заголовок H1 страницы Learn отображается

        By about = By.xpath("/html/body/div[1]/div[1]/nav/div[2]/div[1]/a[2]");
        WebElement aboutElement = wd.findElement(about);
        aboutElement.click(); //действие 2, нажатие на пункт About

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }

        By brand = By.xpath("/html/body/div[1]/div[2]/aside/section[1]/ul/li[2]/a");
        WebElement brandElement = wd.findElement(brand);
        brandElement.click(); //действие 3, нажатие на ссылку Branding of Node.js

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }

        By brandH1 = By.xpath("//*[@id=\"branding-of-nodejs\"]");
        WebElement brandH1Element = wd.findElement(brandH1);
        boolean isBrandH1ElementIsPresented = brandH1Element.isDisplayed();
        Assert.assertTrue(isBrandH1ElementIsPresented); //проверка 3, заголовок H1 страницы About пункта Branding of Node.js отображается

        By themeBtn = By.xpath("/html/body/div[1]/div[1]/nav/div[2]/div[2]/button[2]");
        WebElement themeBtnElement = wd.findElement(themeBtn);
        themeBtnElement.click(); //действие 4, нажатие на кнопку смены темы
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }

        By inputBtn = By.xpath("/html/body/div[1]/div[1]/nav/div[2]/div[2]/button[1]");
        WebElement inputBtnElement = wd.findElement(inputBtn);
        inputBtnElement.click(); //действие 5, нажатие на кнопку поля ввода
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }

        By input = By.xpath("/html/body/div[1]/div[1]/nav/div[2]/div[2]/div/div/div/div[1]/form/input");
        WebElement inputElement = wd.findElement(input);
        inputElement.sendKeys("How To"); //действие 6, ввод в поле ввода текста How To
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }
        inputElement.sendKeys(Keys.ENTER); //действие 7, нажатие клавиши ентер

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }

        By link = By.xpath("/html/body/div[1]/main/div/div[2]/div[2]/a[1]");
        WebElement linkElement = wd.findElement(link);
        linkElement.click(); //действие 8, переход по первой ссылке

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException i) {
            i.printStackTrace(System.err);
        }
        wd.quit();
    }
}
