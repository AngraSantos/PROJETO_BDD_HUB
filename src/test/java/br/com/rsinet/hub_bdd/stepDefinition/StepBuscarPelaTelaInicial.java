package br.com.rsinet.hub_bdd.stepDefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_bdd.driver.DriverFactory;
import br.com.rsinet.hub_bdd.pageObjects.pageObjectProduto;
import br.com.rsinet.hub_bdd.pageObjects.pageObjectTelaInicial;
import br.com.rsinet.hub_bdd.utilitarios.Utilitario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class StepBuscarPelaTelaInicial {

	private WebDriver driver;
	private pageObjectTelaInicial telaInicial;
	private pageObjectProduto produto;
	private WebDriverWait wait;
//	private JavascriptExecutor js;

	@Before
	public void Driver() {

		/* iniciando o driver */
		driver = DriverFactory.inicioDriver();
		telaInicial = PageFactory.initElements(driver, pageObjectTelaInicial.class);
		produto = PageFactory.initElements(driver, pageObjectProduto.class);
		wait = new WebDriverWait(driver, 50);
	}

	@Dado("^cliente esta no site de eletronico da AdvantageDEMO$")
	public void cliente_esta_no_site_de_eletronico_da_AdvantageDEMO() throws Throwable {

		/* site definido */
		driver.get("http:www.advantageonlineshopping.com/#/");
	}

	@Quando("^deve selecionar um produto na tela inicial$")
	public void deve_selecionar_um_produto_na_tela_inicial() throws Throwable {

		telaInicial.deveClicarEmAlgumProdutoDaTelaInicialComSucesso();
	}

	@Quando("^pode escolher um produto$")
	public void pode_escolher_um_produto() throws Throwable {

		produto.altoFalante();

		/*
		 * tempo para aguardar o print na pagina correta da tela e o assert funcionar da
		 * elemento da tela: imagem da caixa de som
		 */
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html[1]/body[1]/div[3]/section[1]/article[1]/div[2]/div[1]/figure[1]/img[1]")));
		
//		js = (JavascriptExecutor) driver;
//		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");

		String url = driver.getCurrentUrl();
		System.out.println(url);
		assertEquals(url, "http://www.advantageonlineshopping.com/#/product/21");
	}

	@Quando("^deve selecionar um produto na tela inicial que esteja com erro$")
	public void deve_selecionar_um_produto_na_tela_inicial_que_esteja_com_erro() throws Throwable {

		telaInicial.deveClicarEmAlgumProdutoDaTelaInicialComErro();

		/*
		 * tempo para aguardar o print na pagina correta da tela e o assert funcionar da
		 * elemento da tela: imagem do laptop, abre um modelo errado
		 */
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html[1]/body[1]/div[3]/section[1]/article[1]/div[2]/div[1]/figure[1]/img[1]")));
		
//		js = (JavascriptExecutor) driver;
//		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");

		String url = driver.getCurrentUrl();
		System.out.println(url);
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
