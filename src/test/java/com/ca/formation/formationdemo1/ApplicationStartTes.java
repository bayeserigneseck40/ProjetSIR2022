package com.ca.formation.formationdemo1.applicationtest;

        import com.ca.formation.formationdemo1.ProjetSIRApplication;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ApplicationStartTest {
    @Test
    public void applicationStarts() {
        ProjetSIRApplication.main(new String[] {});
    }
}
