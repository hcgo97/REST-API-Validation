package com.example.demo.repository;

import com.example.demo.DemoApplicationTests;
import org.junit.jupiter.api.Test;

public class RegExrTest extends DemoApplicationTests {

    @Test
    public void ex1(){
//        String str = "^010"; //010으로 시작하는거
//        assertFalse("23929392932".matches(str));
//        assertTrue("01035842747".matches(str));

        String regExp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$";

        String mobNum1 = "01035842747";
        System.out.println("1번 테스트결과 : " + mobNum1.matches(regExp));

        String mobNum2 = "01622221292";
        System.out.println("2번 테스트결과 : " + mobNum2.matches(regExp));

    }
}
