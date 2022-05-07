package home.beav.auth.mapper;

import home.beav.auth.vo.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {

    List<Test> findAll();

}
