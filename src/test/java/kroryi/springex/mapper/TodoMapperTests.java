package kroryi.springex.mapper;

import kroryi.springex.domain.TodoVO;
import kroryi.springex.dto.PageRequestDTO;
import kroryi.springex.dto.TodoDTO;
import kroryi.springex.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/root-context.xml",
        "file:src/main/webapp/WEB-INF/servlet-context.xml"})
public class TodoMapperTests {

    @Autowired(required = false)
    private TodoMapper mapper;
    @Autowired
    private TodoMapper todoMapper;

    @Autowired
    private TodoService todoService;

    @Test
    public void testNow() {
        log.info(mapper.getTime());
    }

    @Test
    public void testInsert() {
        TodoVO todoVo = TodoVO.builder()
                .title("스프링 테스트 입니다.")
                .dueDate(LocalDate.of(2024, 8, 29))
                .finished(true)
                .writer("홍길동")
                .build();
        todoMapper.insert(todoVo);
    }

    @Test
    public void testRegister() {
        TodoDTO todoDTO = TodoDTO.builder()
                .title("테스트 입니다.")
                .dueDate(LocalDate.now())
                .writer("유관순")
                .finished(false)
                .build();

        todoService.register(todoDTO);
    }

    @Test
    public void testSelectAll() {

        List<TodoVO> voList = todoMapper.selectAll();
        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectOne(){
        TodoVO todoVO = todoMapper.selectOne(27L);
        log.info(todoVO);
    }

    @Test
    public void testSelectSearch(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .types(new String[]{"t", "w"})
                .keyword("테스트")
                .from(LocalDate.of(2024,9,1))
                .to(LocalDate.of(2024,9,4))
                .build();

        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        voList.forEach(vo -> log.info(vo));
    }

}
