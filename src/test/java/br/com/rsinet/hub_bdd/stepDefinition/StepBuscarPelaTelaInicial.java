package br.com.rsinet.hub_bdd.stepDefinition;

import static org.junit.Assert.assertEquals;

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

public class StepBuscarPelaTelaInicial {

	private WebDriver driver;
	private pageObjectTelaInicial telaInicial;
	private pageObjectProduto produto;
	JavascriptExecutor js;

	@Before
	public void Driver() {

		driver = DriverFactory.inicioDriver();
		telaInicial = PageFactory.initElements(driver, pageObjectTelaInicial.class);
		produto = PageFactory.initElements(driver, pageObjectProduto.class);
	}

	@Dado("^cliente esta no site de eletronico da AdvantageDEMO$")
	public void cliente_esta_no_site_de_eletronico_da_AdvantageDEMO() throws Throwable {

		driver.get("http:www.advantageonlineshopping.com/#/");
	}

	@Dado("^deve selecionar um produto na tela inicial$")
	public void deve_selecionar_um_produto_na_tela_inicial() throws Throwable {

		telaInicial.deveClicarEmAlgumProdutoDaTelaInicialComSucesso();
	}

	@Entao("^pode escolher um produto$")
	public void pode_escolher_um_produto() throws Throwable {

		produto.altoFalante();

		js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");

		String url = driver.getCurrentUrl();
		assertEquals(url, "http://www.advantageonlineshopping.com/#/product/21");
	}

	@Dado("^deve selecionar um produto na tela inicial que esteja com erro$")
	public void deve_selecionar_um_produto_na_tela_inicial_que_esteja_com_erro() throws Throwable {

		telaInicial.deveClicarEmAlgumProdutoDaTelaInicialComErro();

		js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");

		String url = driver.getCurrentUrl();
		assertEquals(url, "http://www.advantageonlineshopping.com/#/product/10");
	}

	@Entao("^deve printar a tela$")
	public void deve_printar_a_tela() throws Throwable {

		Utilitario.getScreenshot(driver);
	}

	@Entao("^deve Printar a tela$")
	public void deve_Printar_a_tela() throws Throwable {

		Utilitario.getScreenshot(driver);
	}

	@After
	private void fechandoDriver() {

		DriverFactory.FechandoJanela();
	}
}
