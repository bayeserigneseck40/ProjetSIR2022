package com.ca.formation.formationdemo1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class FormationDemo1ApplicationTests {

    @Test
    void contextLoads(ApplicationContext context)  {

        assertThat(context).isNotNull();
    
    }

}
