package top.panson.jorm.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.panson.jorm.binding.MapperProxyFactory;
import top.panson.jorm.binding.MapperRegistry;
import top.panson.jorm.session.SqlSession;
import top.panson.jorm.session.SqlSessionFactory;
import top.panson.jorm.session.defaults.DefaultSqlSessionFactory;
import top.panson.jorm.test.dao.IUserDao;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2023-08-14 00:11
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);


    @Test
    public void testMapperProxyFactory() {
        // 1. 注册 Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("top.panson.jorm.test.dao");

        // 2. 从 SqlSession 工厂获取 Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 4. 测试验证
        String res = userDao.queryUserName("10001");
        logger.info("测试结果：{}", res);
    }
}
