package follow.handler;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Follow {
    private int followId;
    private int followerId;
    private int followingId;
}
