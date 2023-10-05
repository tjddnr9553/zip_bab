package review;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class Review {
    private int reviewId;
    private int writerId;
    private int recipe_id;
    private String content;
    private Date writeTime;
}
