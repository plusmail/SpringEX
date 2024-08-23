package kroryi.springex.domain;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Getter //
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
    @NotEmpty
    private String mid;
    @NotEmpty
    private String mpw;
    private String mname;
}
