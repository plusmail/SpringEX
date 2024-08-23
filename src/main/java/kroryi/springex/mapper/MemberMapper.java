package kroryi.springex.mapper;

import kroryi.springex.domain.MemberVO;
import kroryi.springex.domain.TodoVO;
import kroryi.springex.dto.PageRequestDTO;

import java.util.List;

public interface MemberMapper {

    void insert(MemberVO member);
    List<MemberVO> selectAll();

    MemberVO selectOne(String mid);

    void delete(String mid);

    void update(MemberVO member);

    List<MemberVO> selectList(PageRequestDTO pageRequestDTO);
    int getCount(PageRequestDTO pageRequestDTO);
}
