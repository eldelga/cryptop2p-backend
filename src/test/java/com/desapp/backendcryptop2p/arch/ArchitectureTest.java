package com.desapp.backendcryptop2p.arch;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest; 
import com.tngtech.archunit.lang.ArchRule;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;


import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@SpringBootTest
@AnalyzeClasses(packages = "com.desapp.backendcryptop2p")

public class ArchitectureTest { 
        @ArchTest
        static ArchRule services_must_be_in_correct_package =
            classes()
                    .that().haveSimpleNameEndingWith("Service")
                    .should().resideInAPackage("com.desapp.backendcryptop2p.service");

        @ArchTest
        static ArchRule controllers_must_be_in_correct_package =
            classes()
                    .that().haveSimpleNameEndingWith("Controller")
                    .should().resideInAPackage("com.desapp.backendcryptop2p.controller");
        @ArchTest
            static ArchRule Repositories_must_be_in_correct_package =
            classes()
                    .that().haveSimpleNameEndingWith("Repository")
                    .should().resideInAPackage("com.desapp.backendcryptop2p.persistence");

        @ArchTest
        public static final ArchRule controllersShouldBeSuffixed = classes()
            .that().resideInAPackage("com.desapp.backendcryptop2p.controller")
            .should().haveSimpleNameEndingWith("Controller");

        @ArchTest
        public static final ArchRule servicesShouldBeSuffixed = classes()
            .that().resideInAPackage("com.desapp.backendcryptop2p.service")
            .should().haveSimpleNameEndingWith("Service");

        @ArchTest
        public static final ArchRule persistencesShouldBeSuffixed = classes()
            .that().resideInAPackage("com.desapp.backendcryptop2p.persistence")
            .should().haveSimpleNameEndingWith("Repository");           
        
}