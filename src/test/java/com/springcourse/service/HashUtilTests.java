package com.springcourse.service;

import com.springcourse.domain.util.HashUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class HashUtilTests {

    @Test
    public void getSecureHashTest(){
        String hash = HashUtil.getSecurityHash("123");
        System.out.println(hash);
        //act
        assertThat(hash.length()).isEqualTo(64);
    }
}
