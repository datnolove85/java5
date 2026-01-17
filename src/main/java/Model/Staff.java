package Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {
    private String id;
    private String fullname;
    @Builder.Default
    private String photo="avt.jpg";
    @Builder.Default
    private Boolean gender=false;
    @Builder.Default
    private Date birthday=new Date();
    @Builder.Default
    private Double salary=1234.6789;
    private Integer level=0;
}
