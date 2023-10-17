package shopping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class NaverShoppingInfo {
    private String title;
    private String link;
    private String image;
    private String price;
    private String mallName;
    private String brand;
    private String maker;
}
