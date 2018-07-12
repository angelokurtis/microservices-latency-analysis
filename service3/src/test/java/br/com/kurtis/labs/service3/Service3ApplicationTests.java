package br.com.kurtis.labs.service3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Service3ApplicationTests {

  static {
    System.setProperty("SERVICE1_ADDRESS", "");
    System.setProperty("SERVICE2_ADDRESS", "");
    System.setProperty("SERVICE3_ADDRESS", "");
    System.setProperty("SERVICE4_ADDRESS", "");
  }

  @Test
  public void contextLoads() {
  }

}
