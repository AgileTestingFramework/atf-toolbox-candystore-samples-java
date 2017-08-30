package com.agiletestingframework.automationpractice.stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseStepDefs {
    @Before()
    public void before(Scenario scenario) {
        scenario.getId();

    }

    @After
    public void after(Scenario scenario) {

    }

}
