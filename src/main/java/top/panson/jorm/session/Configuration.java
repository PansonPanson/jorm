package top.panson.jorm.session;

import top.panson.jorm.binding.MapperRegistry;
import top.panson.jorm.mapping.MapperStatement;
import top.panson.jorm.session.defaults.DefaultSqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Panson
 * @create 2023-08-15
 */
public class Configuration {

    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    protected final Map<String, MapperStatement> mapperStatements = new HashMap<>();

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }


    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMapperStatement(MapperStatement ms) {
        mapperStatements.put(ms.get)
    }

}
