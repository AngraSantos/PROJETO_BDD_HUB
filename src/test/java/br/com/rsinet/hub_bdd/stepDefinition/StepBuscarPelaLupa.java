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

public class StepBuscarPelaLupa {

	private pageObjectTelaInicial telaInicial;
	private pageObjectProduto produto;
	private WebDriver driver;
	private WebDriverWait wait;
//	private JavascriptExecutor js;

	@Before
	public void Driver() {

		/* iniciando o driver */
		driver = DriverFactory.inicioDriver();
		telaInicial = PageFactory.initElements(driver, pageObjectTelaInicial.class);
		produto = PageFactory.initElements(driver, pageObjectProduto.class);
		wait = new WebDriverWait(driver, 10);
	}
	
	@Dado("^cliente esta no site eletronico da AdvantageDEMO$")
	public void cliente_esta_no_site_eletronico_da_AdvantageDEMO() throws Throwable {

		/* site definido */
		driver.get("http:www.advantageonlineshopping.com/#/");
	}
	
	@Quando("^na lupa escreva o nome do item desejado$")
	public void na_lupa_escreva_o_nome_do_item_desejado() throws Throwable {

		telaInicial.deveBuscarAlgumProdutoPelaLupa("laptop");
	}

	@Quando("^produto encontrado clique nele$")
	public void produto_encontrado_clique_nele() throws Throwable {

		produto.laptop15z();

		/*
		 * tempo para aguardar o print na pagina correta da tela e o assert funcionar da
		 * elemento da tela: imagem do laptop
		 */
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html[1]/body[1]/div[3]/section[1]/article[1]/div[2]/div[1]/figure[1]/img[1]")));
		
//		js = (JavascriptExecutor) driver;
//		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");

		String url = driver.getCurrentUrl();
		System.out.println(url);
		assertEquals(url, "http://www.advantageonlineshopping.com/#/product/2?viewAll=laptop");
	}

	@Quando("^na lupa escreva o nome do produto desejado que nao tenha no site$")
	public void na_lupa_escreva_o_nome_do_produto_desejado_que_nao_tenha_no_site() throws Throwable {

		telaInicial.deveBuscarAlgumProdutoPelaLupa("HP ZBOOK G2 MOBILE WORKSTATION");
		
		/*
		 * tempo para aguardar o print na pagina correta da tela e o assert funcionar da
		 * elemento da tela: texto na pagina
		 */
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html[1]/body[1]/div[3]/section[1]/article[1]/div[3]/div[1]")));
		
//		js = (JavascriptExecutor) driver;
//		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");

		String url = driver.getCurrentUrl();
		System.out.println(url);
		assertEquals(url,"http://www.advantageonlineshopping.com/#/search/?viewAll=HP%20ZBOOK%20G2%20MOBILE%20WORKSTATION");
		
//			assertTrue(driver.getPageSource().contains("No results for"));
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
	public void fechandoDriver() {

		DriverFactory.FechandoJanela();
	}

}
