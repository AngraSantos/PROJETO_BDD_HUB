package br.com.rsinet.hub_bdd.runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/TesteFuncional", 
glue = { "br.com.rsinet.hub_bdd.stepDefinition" },
plugin = { "pretty", "com.cucumber.listener.ExtentCucumberFormatter:reports/reports.html"},
monochrome = true)

public class RunnerTest {

	@AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File("./extension-config.xml"));
	 }

}
