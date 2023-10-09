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

@FindBy(css = "body > div.min-h-screen.bg-white > nav > div > div > div.flex.items-center.h-full > div.hidden.md\\:block.h-full > div > a:nth-child(3)" )
private WebElement buttonTerapeuta;

@FindBy(css = "#headlessui-menu-button-\\:Rct4rb9mmja\\: > svg")
private WebElement buttonOpcao;

@FindBy(id = "headlessui-menu-item-:r3:")
private WebElement buttonDelete;

@FindBy(css = "#headlessui-dialog-panel-\\:r5\\: > button.text-white.bg-danger.flex.h-10.w-full.items-center.justify-center.rounded-md.border.text-sm.transition-all.focus\\:outline-none")
private WebElement buttonConfirmDelete;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public CadastroPage acessarFormularioPaciente(){ 
      buttonPaciente.click();
      buttonAdicionar.click();
      return new CadastroPage(driver);
    }

    public HomePage confirmarPacienteCadastrado(String nome){
       buttonFiltro.click();
       filtroNome.click();
       search.sendKeys(nome);
       return new HomePage(driver);
    }

    public HomePage atualizarPagina(){
        buttonTerapeuta.click();
        buttonPaciente.click();
        return new HomePage(driver);
    }

    public String nomeDoFiltro(){
        return resultadoDoFiltro.getText();
    }

    public HomePage deletarPaciente(){
        buttonOpcao.click();
        buttonDelete.click();
        buttonConfirmDelete.click();
        return new HomePage(driver);
    }
    
    public HomePage pagePaciente(){ 
      buttonPaciente.click();
      return new HomePage(driver);
    }
}
