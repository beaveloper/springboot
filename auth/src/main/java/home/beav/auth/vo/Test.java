package home.beav.auth.vo;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class Test {

    private long seq;
    private String title;
    private String content;
    private LocalDateTime date;

}