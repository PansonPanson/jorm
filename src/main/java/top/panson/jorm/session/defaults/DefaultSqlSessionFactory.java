package top.panson.jorm.session.defaults;

import top.panson.jorm.session.Configuration;
import top.panson.jorm.session.SqlSession;
import top.panson.jorm.session.SqlSessionFactory;


public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }

}
