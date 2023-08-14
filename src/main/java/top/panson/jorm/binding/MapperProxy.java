package top.panson.jorm.binding;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

/**
 * @create 2023-08-13 23:25
 * @author Panson
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {


    private static final long serialVersionUID = -5739508078954644013L;

    /**
     * key： 接口名 + 方法名
     * value:
     */
    private Map<String, String> sqlSession;

    private final Class<T> mapperInterface;

    public MapperProxy(Map<String, String> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(Objects.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            return "调用了代理方法：" + sqlSession.get(mapperInterface.getName() + "." + method.getName());
        }
    }
}
