package kroryi.springex.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@ToString
@Data //
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private Long tno;
    @NotEmpty(message="제목을 입력하세요.")
    private String title;
    @Future
    private LocalDate dueDate;
    private boolean finished;
    @NotEmpty(message="작성자를 입력하세요.")
    private String writer;
}
