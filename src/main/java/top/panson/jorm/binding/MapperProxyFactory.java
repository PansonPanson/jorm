package top.panson.jorm.binding;

import top.panson.jorm.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @create 2023-08-13 23:25
 * @author Panson
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;


    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @SuppressWarnings("unchecked")
    public T newInstance(SqlSession sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}
