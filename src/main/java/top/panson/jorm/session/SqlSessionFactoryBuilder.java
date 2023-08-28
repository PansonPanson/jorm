package top.panson.jorm.session;

import top.panson.jorm.builder.xml.XMLConfigBuilder;
import top.panson.jorm.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;


public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

}