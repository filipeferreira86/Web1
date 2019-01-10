package br.com.gx2.steps;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class Steps {
	
	WebDriver driver;
	WebDriverWait espera;
	Actions act;
	
	@Before
	public void antes() {
		System.setProperty("webdriver.gecko.driver",
				"C:/Users/filipe.jesus/Documents/Testes/scripts/jars/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		espera = new WebDriverWait(driver, 20);
		act = new Actions(driver);
	}

	@Dado("^que estou na pagina \"([^\"]*)\"$")
	public void queEstouNaPagina(String site) throws Throwable {
		driver.get(site);
	}

	@Quando("^eu informar \"([^\"]*)\" no campo \"([^\"]*)\"$")
	public void euInformarNoCampo(String login, String id) throws Throwable {
		WebElement efUsuario = driver.findElement(By.id(id));
		efUsuario.sendKeys(login);
	}

	@Quando("^informar \"([^\"]*)\" no campo \"([^\"]*)\"$")
	public void informarNoCampo(String senha, String id) throws Throwable {
		WebElement efSenha = driver.findElement(By.id(id));
		efSenha.sendKeys(senha);
	}
	
	@Quando("^clicar no botão \"([^\"]*)\"$")
	public void clicarNoBotão(String name) throws Throwable {
		WebElement btnConfirmar = espera.until(ExpectedConditions.elementToBeClickable(By.name(name)));
		btnConfirmar.click();
	}

	@Então("^deve logar no site exibindo mensagem \"([^\"]*)\"$")
	public void deveLogarNoSiteExibindoMensagem(String res) throws Throwable {
//		WebElement lblRes = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/span/div/div/b"));
		WebElement lblRes = espera.until(ExpectedConditions.elementToBeClickable(By.id("datahora")));
		Assert.assertTrue(lblRes.getText().contains(res));
	}
	
	
	@Dado("^que estou na logado e na tela inicial$")
	public void queEstouNaLogadoENaTelaInicial() throws Throwable {
		// seria para verificar se estou na tela inicial
	}

	@Quando("^eu colocar o mouse sobre o item de menu \"([^\"]*)\"$")
	public void euColocarOMouseSobreOItemDeMenu(String id) throws Throwable {
		WebElement mnAcao = driver.findElement(By.id(id));
		act.moveToElement(mnAcao).perform();
	}

	@Quando("^clicar no item \"([^\"]*)\"$")
	public void clicarNoItem(String pesq) throws Throwable {
		WebElement mnPesquisar = espera.until(ExpectedConditions.elementToBeClickable(By.id(pesq)));
		act.moveToElement(mnPesquisar).perform();
		act.click().perform();
	}

	@Então("^deve ser exibido \"([^\"]*)\"$")
	public void deveSerExibido(String arg1) throws Throwable {
		
	}
	
	
	@After
	public void fechando() {
		driver.quit();
	}
	
}
