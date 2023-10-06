package member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private int memberId;
	private String username;
	private String nickname;
	private String password;
	private String email;
	private LocalDate birthday;
	private int gender;

}
