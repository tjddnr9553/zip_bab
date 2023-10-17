package memberrecipe.dto;

import lombok.*;
import memberrecipe.MemberRecipe;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
public class MemberRecipePrefDto extends MemberRecipe {
    // pref
    private int under_20;
    private int over_20;
    private int over_30;
    private int over_40;
    private int over_50;
    private int male;
    private int female;
    private int hits;

    private int isBooked;
    private int totalCnt;
}
