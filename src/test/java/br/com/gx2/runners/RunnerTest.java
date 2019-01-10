package br.com.gx2.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = {"src/test/resources/features/login.feature",
				"src/test/resources/features/acessarTelaPesquisa.feature"},
		plugin = {"pretty", 
				"html:target/cucumber-html-report",
				"json:target/cucumber.json", 
				"junit:target/cucumber.xml",
				"rerun:target/rerun.txt"},
		glue = "br/com/gx2/steps",
		snippets = SnippetType.CAMELCASE,
		tags = "@exec"
		)

public class RunnerTest {

}
