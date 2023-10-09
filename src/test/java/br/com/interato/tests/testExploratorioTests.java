package br.com.interato.tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import br.com.interato.page.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class testExploratorioTests  {
    protected  WebDriver driver;






     @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        driver.get("https://hml-8l8oy.ondigitalocean.app/login/interato");
        driver.findElement(By.id("email")).sendKeys("interato.softmakers@gmail.com");
        driver.findElement(By.id("password")).sendKeys("XFeh%lRgL02TPE98");
        driver.findElement(By.cssSelector("body > div.flex.h-screen.w-screen.p-4.items-center.justify-center.bg-gray-50 > div > form > button")).click();
        }
   
    @AfterEach
    public void tearDown(){
        driver.quit();
        }
    

    @Test
    @DisplayName("Teste Exploratório onde deve cadastrar um novo paciente")
    public void TC_001_DeveCadastrarUmNovoPaciente() {
            String nomeDoFiltro = new HomePage(driver)
                .acessarFormularioPaciente()
                .registroNovoPaciente("Lucas de Brito", "lucas162257@gmail.com", "123456", "29229245054", "11940738778")
                .atualizarPagina()
                .confirmarPacienteCadastrado("Lucas de Brito")
                .nomeDoFiltro();
            
            Assertions.assertEquals("Lucas de Brito", nomeDoFiltro);
    }

    @Test
    @DisplayName("Deletar o paciente cadastrado")
    public void TC_002_DeveExcluirOPacienteCadastrado(){
        new HomePage(driver)
            .pagePaciente()
            .deletarPaciente();
            
    }
}

     
           