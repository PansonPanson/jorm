package top.panson.jorm.session;

import top.panson.jorm.builder.xml.XMLConfigBuilder;
import top.panson.jorm.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @author Panson
 * @create 2023-08-15
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        return build(xmlConfigBuilder.parse(reader));
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }
}
