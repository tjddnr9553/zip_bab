package memberrecipe;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberRecipe {
    private int memberRecipeId;
    private int memberId;
    private String title;
    private String subTitle;
    private String way;
    private String ingredientInfo;
    private String manual_01;
    private String manual_02;
    private String manual_03;
    private String manual_04;
    private String manual_05;
    private String manual_06;
    private String manual_07;
    private String manual_08;
    private String manual_09;
    private String manual_10;
    private String manual_11;
    private String manual_12;
    private String manual_img_01;
    private String manual_img_02;
    private String manual_img_03;
    private String manual_img_04;
    private String manual_img_05;
    private String manual_img_06;
    private String manual_img_07;
    private String manual_img_08;
    private String manual_img_09;
    private String manual_img_10;
    private String manual_img_11;
    private String manual_img_12;
    private String completePicture;
    private String calorie;
    private LocalDateTime writeTime;
    private LocalDateTime editTime;
}
