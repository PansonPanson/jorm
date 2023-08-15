package top.panson.jorm.session;

import java.util.Objects;

/**
 * @create 2023-08-14 22:21
 * @author Panson
 */
public interface SqlSession {

    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    <T> T getMapper(Class<T> type);

}
