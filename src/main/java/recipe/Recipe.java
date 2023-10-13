package recipe;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private int recipeId;
    private String title;
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
    private String manual_img_13;
    private String manual_img_14;
    private String manual_img_15;
    private String manual_img_16;
    private String manual_img_17;
    private String manual_img_18;
    private String manual_img_19;
    private String manual_img_20;
    private String completePicture; //완성사진
    private double calorie;    //열량

    private int pageNum;    //현재 조회하는 페이지 번호
    private int amount;     //화면에 표시할 데이터 개수(30개)
}
