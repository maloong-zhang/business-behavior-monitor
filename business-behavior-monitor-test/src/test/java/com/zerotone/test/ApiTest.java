package com.zerotone.test;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration
public class ApiTest {

  private UserEntity userEntity = null;

  @Before
  public void init() {
    userEntity = new UserEntity();
    userEntity.setUserId("10001");
    userEntity.setUserName("李二狗");
    userEntity.setUserAge(25);
    userEntity.setOrderId("109099893222");
  }

  @Test
  public void test_log_00() throws InterruptedException {
    log.info("测试日志00 {} {} {}", userEntity.userId, userEntity.userName, com.alibaba.fastjson.JSON.toJSONString(userEntity));
  }

  @Test
  public void test_log_01() throws InterruptedException {
    log.info("测试日志01 {} {} {}", userEntity.userId, userEntity.userName, com.alibaba.fastjson.JSON.toJSONString(userEntity));
  }

  @Test
  public void test_log_02() throws InterruptedException {
    log.info("测试日志02 {} {} {}", userEntity.userId, userEntity.userName, com.alibaba.fastjson.JSON.toJSONString(userEntity));
  }

  @Test
  public void test_log_03() throws InterruptedException {
    log.info("测试日志03 {} {} {}", userEntity.userId, userEntity.userName, com.alibaba.fastjson.JSON.toJSONString(userEntity));
  }


  @Data
  static class UserEntity {
    private String userId;
    private String userName;
    private Integer userAge;
    private String orderId;
  }
}
