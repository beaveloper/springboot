package home.beav.auth;

import home.beav.auth.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.util.List;

@SpringBootTest
@Slf4j
class DbTests {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private TestMapper testMapper;

    @Test
    void test() {

        try(Connection con = sqlSessionFactory.openSession().getConnection()){
            System.out.println("커넥션 성공");
        }catch(Exception e){
            e.printStackTrace();
        }

        List<home.beav.auth.vo.Test> list = testMapper.findAll();
        list.forEach(x -> log.info(x.toString()));

    }

}
