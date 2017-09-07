package network.pluto.bibliotheca;

import network.pluto.bibliotheca.configurations.BibliothecaConfiguration;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class BibliothecaApplicationTests {

    @Test
    public void contextLoads() {
    }

    @SpringBootApplication
    @Import(BibliothecaConfiguration.class)
    static class TestConfiguration {

    }

}
