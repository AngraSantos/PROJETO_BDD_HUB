package br.com.rsinet.hub_bdd.stepDefinition;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.driver.DriverFactory;
import br.com.rsinet.hub_bdd.pageObjects.pageObjectProduto;
import br.com.rsinet.hub_bdd.pageObjects.pageObjectTelaInicial;
import br.com.rsinet.hub_bdd.utilitarios.Utilitario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;

public class StepBuscarPelaLupa {
	
	WebDriver driver;
	pageObjectTelaInicial telaInicial;
	pageObjectProduto produto;
	JavascriptExecutor js;
	
	
	@Before
	public void Driver () {
		
		driver = DriverFactory.inicioDriver();
	}
	
	@Dado("^na lupa escreva o nome do item desejado$")
	public void na_lupa_escreva_o_nome_do_item_desejado() throws Throwable {

		telaInicial = PageFactory.initElements(driver, pageObjectTelaInicial.class);
		telaInicial.deveBuscarAlgumProdutoPelaLupa("laptop");	
	}

	@Dado("^produto encontrado clique nele$")
	public void produto_encontrado_clique_nele() throws Throwable {
		
		produto = PageFactory.initElements(driver, pageObjectProduto.class);
		produto.laptop15z();
		
		js = (JavascriptExecutor) driver;         
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
		
	}
	
	@Dado("^na lupa escreva o nome do produto desejado que nao tenha no site$")
	public void na_lupa_escreva_o_nome_do_produto_desejado_que_nao_tenha_no_site() throws Throwable {
		
		telaInicial = PageFactory.initElements(driver, pageObjectTelaInicial.class);
		telaInicial.deveBuscarAlgumProdutoPelaLupa("HP ZBOOK G2 MOBILE WORKSTATION");

		js = (JavascriptExecutor) driver;         
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
	}

	
	@Entao("^ele ira tirar um print$")
	public void ele_ira_tirar_um_print() throws Throwable {

		Utilitario.getScreenshot(driver);
	}


	@Entao("^ele ira tirar um Print$")
	public void ele_ira_tirar_um_Print() throws Throwable {

		Utilitario.getScreenshot(driver);
	}
	
	@After
	public void fechandoDriver () {
		
		DriverFactory.FechandoJanela();
	}



}
