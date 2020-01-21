package br.com.rsinet.hub_bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
		features = "scr/test/resources/TesteFuncional",
glue= {"Steps"} )

public class Runners {

	
}
