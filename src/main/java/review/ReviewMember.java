package review;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
public class ReviewMember extends Review {
    // Member
//    private String username;
    private String nickname;
//    private String password;
//    private String email;
//    private LocalDate birthday;
//    private int gender;

    // Custom
    private String formattedDateTime;

    @Override
    public void setWriteTime(LocalDateTime writeTime) {
        super.setWriteTime(writeTime);
        this.formattedDateTime = writeTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

//    public String getFormattedDateTime() {
//        return this.getWriteTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//    }
}
