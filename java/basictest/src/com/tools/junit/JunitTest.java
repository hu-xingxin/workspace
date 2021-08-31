package com.tools.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author huxingxin
 * @createTime 2021年07月30日 17:08:28
 * @Description 测试 JunitTest1 和 JunitTest2
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({JunitTest1.class, JunitTest2.class})
public class JunitTest {

}
