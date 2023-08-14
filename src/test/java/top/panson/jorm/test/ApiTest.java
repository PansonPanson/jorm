package top.panson.jorm.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.panson.jorm.binding.MapperProxyFactory;
import top.panson.jorm.test.dao.IUserDao;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2023-08-14 00:11
 */
public class ApiTest {

    private Logger log = LoggerFactory.getLogger(ApiTest.class);


    @Test
    public void testMapperProxyFactory() {
        MapperProxyFactory<IUserDao> mapperProxyFactory = new MapperProxyFactory<>(IUserDao.class);

        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("top.panson.jorm.test.dao.IUserDao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");
        IUserDao proxyUserDao = mapperProxyFactory.newInstance(sqlSession);
        String name = proxyUserDao.queryUserName("1");
        log.info("name is : {}", name);
    }
}
