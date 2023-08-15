package top.panson.jorm.session;


/**
 * @create 2023-08-14 22:20
 * @author Panson
 */
public interface SqlSessionFactory {

    SqlSession openSession();
}
