package org.opencart.stepsdefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.opencart.managers.DriverManager;

import java.awt.dnd.DragGestureEvent;


public class Hooks {
    static int counter = 0;

    @BeforeAll
    public static void beforeAllTheStepsAreExecuted(){
        System.out.println("The execution started");
    }

    @Before
    public void beforeEachTest(){
        counter++;
        System.out.println("The test [" + counter + "] started");
    }

    @After
    public void afterEachTest(){
        DriverManager.getInstance().quitTheDriver();
        System.out.println("The test [" + counter + "] finished");
    }



    @AfterAll
    public static void afterAllTheTestsAreExecuted(){
        System.out.println("The execution of all the features is finished");
    }




}
