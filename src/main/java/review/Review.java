package review;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private int reviewId;
    private int memberId;
    private int recipeId;
    private String content;
    private LocalDateTime writeTime;
}
