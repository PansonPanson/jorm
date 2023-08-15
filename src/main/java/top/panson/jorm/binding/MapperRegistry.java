package top.panson.jorm.binding;

import cn.hutool.core.lang.ClassScanner;
import top.panson.jorm.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Panson
 * @create 2023-08-15
 */
public class MapperRegistry {

    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
         final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
         if(mapperProxyFactory == null) {
             throw new RuntimeException("Type " + type + " is not known to the MapperRegistry.");
         }
         try {
             return mapperProxyFactory.newInstance(sqlSession);
         } catch (Exception e) {
             throw new RuntimeException("fail to call mapperProxyFactory.newInstance: " + e, e);
         }
    }



    public <T> void addMapper(Class<T> type) {
        if(type != null && type.isInterface()) {
            if(hasMapper(type)) {
                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry.");
            }
        }
        knownMappers.put(type, new MapperProxyFactory<>(type));
    }

    public <T> boolean hasMapper(Class<T> type) {
        return knownMappers.containsKey(type);
    }

    public void addMappers(String packageName) {
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        for(Class<?> mapperClass : mapperSet) {
            addMapper(mapperClass);
        }
    }
}
