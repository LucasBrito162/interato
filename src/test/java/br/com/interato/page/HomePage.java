package br.com.interato.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import br.com.interato.BaseTest;

public class HomePage extends BaseTest {

@FindBy(xpath = "/html/body/div[2]/nav/div/div/div[1]/div[2]/div/a[4]")
private WebElement buttonPaciente;

@FindBy(css = "body > div.min-h-screen.bg-white > header > div > div > div.flex.col-span-12.md\\:col-span-2.justify-end.items-center.tracking-tight.text-sm.font-medium.leading-none > button")
private WebElement buttonAdicionar;

@FindBy(id = "radix-:Rakrb9mmja:")
private WebElement buttonFiltro;

@FindBy(css = "#radix-\\:Rakrb9mmjaH1\\: > div:nth-child(5)")
private WebElement filtroNome;

@FindBy(id = "search")
private WebElement search;

@FindBy(css = "body > div.min-h-screen.bg-white > main > div > div > div.w-full.bg-white.p-6.rounded-lg.drop-shadow-2xl.mb-12 > div > table > tbody > tr > td:nth-child(1) > div > p")
private WebElement resultadoDoFiltro;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public CadastroPage acessarFormularioPaciente(){ 
      buttonPaciente.click();
      buttonAdicionar.click();
      return new CadastroPage(driver);
    }

    public HomePage confirmarPacienteCadastrado(){
       buttonFiltro.click();
       filtroNome.click();
       search.click();
       return new HomePage(driver);
    }

    public String nomeDoFiltro(){
        return resultadoDoFiltro.getText();
    }

}