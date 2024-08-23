package kroryi.springex.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


@ToString
@Data //
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    @NotEmpty
    private String mid;
    @NotEmpty
    private String mpw;
    private String mname;
}
