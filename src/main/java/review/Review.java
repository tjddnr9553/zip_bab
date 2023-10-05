package review;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@RequiredArgsConstructor
public class Review {
    private int reviewId;
    private int writerId;
    private int recipeId;
    private String content;
    private LocalDateTime writeTime;
}
