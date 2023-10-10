package recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RecipePref {
    private int rpId;
    private int recipeId;
    private int under_20;
    private int over_20;
    private int over_30;
    private int over_40;
    private int over_50;
    private int male;
    private int female;
    private int hits;
}
