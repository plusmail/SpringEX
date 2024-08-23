package kroryi.springex.service;

import kroryi.springex.dto.MemberDTO;
import kroryi.springex.dto.PageRequestDTO;
import kroryi.springex.dto.PageResponseDTO;
import kroryi.springex.dto.TodoDTO;

public interface MemberService {

    //TodoMapper insert와 연결
    void register(MemberDTO dto);

//    List<TodoDTO> getAll();
    PageResponseDTO<MemberDTO> getList(PageRequestDTO pageRequestDTO);

    MemberDTO getOne(String mid);

    void remove(String mid);

    void modify(MemberDTO memberDTO);
}
