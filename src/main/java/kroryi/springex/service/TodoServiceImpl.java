package kroryi.springex.service;

import kroryi.springex.domain.TodoVO;
import kroryi.springex.dto.PageRequestDTO;
import kroryi.springex.dto.PageResponseDTO;
import kroryi.springex.dto.TodoDTO;
import kroryi.springex.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO dto) {
        log.info("Register todo: {}" , dto);
        TodoVO todoVO = modelMapper.map(dto, TodoVO.class);
        log.info(todoVO);

        todoMapper.insert(todoVO);
    }

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        // PageRequestDTO  skip, size, page
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        List<TodoDTO> dtoList = voList.stream()
                .map(
                        vo -> modelMapper.map(vo, TodoDTO.class)
                ).collect(Collectors.toList());
        int total = todoMapper.getCount(pageRequestDTO);

        log.info("getList-> {}", dtoList);

        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }

//    @Override
//    public List<TodoDTO> getAll() {
//
//        return todoMapper
//                .selectAll()
//                .stream()
//                .map( vo -> modelMapper.map(vo, TodoDTO.class))
//                .collect(Collectors.toList());
//    }

    @Override
    public TodoDTO getOne(Long tno) {

        TodoVO todoVO = todoMapper.selectOne(tno);
        if (todoVO == null) {
            log.info("Not found todo: {}", tno);
            return null;
        }
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);

        return todoDTO;
    }
    public void remove(Long tno){
        todoMapper.delete(tno);
    }

    public void modify(TodoDTO todoDTO){
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        todoMapper.update(todoVO);
    }
}
