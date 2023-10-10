package member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
	private int memberId;
	private String loginId;
	private String nickname;
	private String password;
	private String email;
	private LocalDate birthday;
	private int gender;
	private String profile;

}
