package kroryi.springex.service;

import kroryi.springex.domain.MemberVO;
import kroryi.springex.dto.MemberDTO;
import kroryi.springex.dto.PageRequestDTO;
import kroryi.springex.dto.PageResponseDTO;
import kroryi.springex.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper mapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(MemberDTO dto) {
        log.info("Register todo: {}" , dto);
        MemberVO vo = modelMapper.map(dto, MemberVO.class);
        log.info(vo);

        mapper.insert(vo);
    }

    @Override
    public PageResponseDTO<MemberDTO> getList(PageRequestDTO pageRequestDTO) {
        // PageRequestDTO  skip, size, page
        List<MemberVO> voList = mapper.selectList(pageRequestDTO);
        List<MemberDTO> dtoList = voList.stream()
                .map(
                        vo -> modelMapper.map(vo, MemberDTO.class)
                ).collect(Collectors.toList());
        int total = mapper.getCount(pageRequestDTO);

        log.info("getList-> {}", dtoList);

        PageResponseDTO<MemberDTO> pageResponseDTO = PageResponseDTO.<MemberDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }

    @Override
    public MemberDTO getOne(String mid) {

        MemberVO vo = mapper.selectOne(mid);
        if (vo == null) {
            log.info("Not found Member: {}", mid);
            return null;
        }
        MemberDTO dto = modelMapper.map(vo, MemberDTO.class);

        return dto;
    }
    public void remove(String mid){
        mapper.delete(mid);
    }

    public void modify(MemberDTO dto){
        MemberVO vo = modelMapper.map(dto, MemberVO.class);
        mapper.update(vo);
    }
}
