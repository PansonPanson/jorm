package top.panson.jorm.session.defaults;

import com.alibaba.fastjson.JSON;
import top.panson.jorm.binding.MapperRegistry;
import top.panson.jorm.session.Configuration;
import top.panson.jorm.session.SqlSession;

/**
 * @author Panson
 * @create 2023-08-15
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + JSON.toJSONString(parameter));
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
