package br.com.rsinet.hub_bdd.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.driver.DriverFactory;
import br.com.rsinet.hub_bdd.pageObjects.pageObjectCadastroCliente;
import br.com.rsinet.hub_bdd.pageObjects.pageObjectTelaInicial;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class StepsCadastro {

	private WebDriver driver;
	private pageObjectTelaInicial telaInicial;
	private pageObjectCadastroCliente cadastroCliente;
	

	@Dado("^cliente esta no site de eletronicos da AdvantageDEMO$")
	public void cliente_esta_no_site_de_eletronicos_da_AdvantageDEMO() throws Throwable {
		
		driver = DriverFactory.inicioDriver();
	}

	@Dado("^clicar no icone do login$")
	public void clicar_no_icone_do_login() throws Throwable {

		telaInicial = PageFactory.initElements(driver, pageObjectTelaInicial.class);
		telaInicial.clicarBotaoLogin();
	}

	@Dado("^depois clicar em criar novo usuario$")
	public void depois_clicar_em_criar_novo_usuario() throws Throwable {

		telaInicial.clicarCriarUsuario();
	}

	@Dado("^preeche o usuario$")
	public void preeche_o_usuario() throws Throwable {

		cadastroCliente = PageFactory.initElements(driver, pageObjectCadastroCliente.class);
		cadastroCliente.usuario();
	}

	@Dado("^preenche o email$")
	public void preenche_o_email() throws Throwable{

		cadastroCliente.email();
	}

	@Dado("^preenche a senha$")
	public void preenche_a_senha() throws Throwable{

		cadastroCliente.senha();
	}

	@Dado("^confirma a senha$")
	public void confirma_a_senha() throws Throwable {

		cadastroCliente.confirmeSenha();
	}

	@Dado("^preenche o primeiro nome$")
	public void preenche_o_primeiro_nome() throws Throwable {

		cadastroCliente.primeiroNome();
	}

	@Dado("^preenche o ultimo nome$")
	public void preenche_o_ultimo_nome() throws Throwable {

		cadastroCliente.ultimoNome();
	}

	@Dado("^preenche o telefone$")
	public void preenche_o_telefone() throws Throwable {

		cadastroCliente.telefone();
	}

	@Dado("^seleciona o pais$")
	public void seleciona_o_pais() throws Throwable {

		cadastroCliente.pais();
	}

	@Dado("^preenche a cidade$")
	public void preenche_a_cidade() throws Throwable {

		cadastroCliente.cidade();

	}

	@Dado("^preenche o endereco$")
	public void preenche_o_endereco() throws Throwable {

		cadastroCliente.endereco();
	}

	@Dado("^preenche o estado$")
	public void preenche_o_estado() throws Throwable {

		cadastroCliente.estado();
	}

	@Dado("^preenche o codigo Postal$")
	public void preenche_o_codigo_Postal() throws Throwable {

		cadastroCliente.cartaoPostal();
	}

	@Quando("^confirma que esta de acordo com os termos de uso do site$")
	public void confirma_que_esta_de_acordo_com_os_termos_de_uso_do_site() {

		cadastroCliente.clicarCheckBox();

	}

	@Entao("^cliente tera seu cadastro efetuado com sucesso$")
	public void cliente_tera_seu_cadastro_efetuado_com_sucesso() {

		cadastroCliente.clicarRegistrar();

	}
	
	@After
	public void fechandoDriver() {
		
		DriverFactory.FechandoJanela();
	}
}