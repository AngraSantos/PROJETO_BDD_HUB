package br.com.rsinet.hub_bdd.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/TesteFuncional", 
glue = { "br.com.rsinet.hub_bdd.stepDefinition" },
tags = {"@cadastroValido, @cadastroInvalido"})

public class RunnerTest {

}
