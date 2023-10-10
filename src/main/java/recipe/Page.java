package recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   //@ToString을 포함
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    private int startPage;  //게시글 화면에 보여질 첫번째 번호(1)
    private int endPage;    //게시글 화면에 보여질 마지막 번호(21)
    private boolean prev, next; // 이전, 다음 활성화 여부(Prev, Next)
    private int pageNum;    //현재 조회하는 페이지 번호
    private int amount;     //화면에 표시할 데이터 개수(50개)
    private int total;      //전체게시글 수(1114개)
}
