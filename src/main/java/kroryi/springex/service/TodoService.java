package kroryi.springex.service;

import kroryi.springex.dto.TodoDTO;

public interface TodoService {

    //TodoMapper insert와 연결
    void register(TodoDTO dto);
}
