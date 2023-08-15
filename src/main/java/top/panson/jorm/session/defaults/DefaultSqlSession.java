package top.panson.jorm.session.defaults;

import com.alibaba.fastjson.JSON;
import top.panson.jorm.binding.MapperRegistry;
import top.panson.jorm.session.SqlSession;

/**
 * @author Panson
 * @create 2023-08-15
 */
public class DefaultSqlSession implements SqlSession {

    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
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
        return mapperRegistry.getMapper(type, this);
    }
}
