let contextPath = document.body.dataset.contextPath;
let req = new XMLHttpRequest();

const a = () => {
	let loginId = f.loginId.value;
	req.open('GET', contextPath + '/member/idcheck.do?loginId=' + loginId);
	req.send();
}

req.onload = () => {
	let obj = JSON.parse(req.responseText) // 받은 응답을 json으로 파싱
	let txt = '중복된 아이디'
	if (obj.flag) {
		txt = '사용 가능한 아이디'
		f.flag.value = true
	}
	//console.log(txt)
	document.getElementById('res').innerHTML = txt;
}

const b = () => {
	if (f.flag.value == 'false') {
		alert('아이디 중복체크 하시오.')
		f.id.focus()
		return
	}
	if (f.password.value == '') {
		alert("패스워드 입력하시오.")
		f.password.focus()
		return
	}
	if (f.nickname.value == '') {
		alert("이름 입력하시오.")
		f.nickname.focus()
		return
	}
	if (f.email.value == '') {
		alert("패스워드 입력하시오.")
		f.email.focus()
		return
	}
	if (f.birthday.value == '') {
		alert("이름 입력하시오.")
		f.birthday.focus()
		return
	}
	if (f.gender.value == '') {
		alert("이름 입력하시오.")
		f.gender.focus()
		return
	}
	f.submit(); // 서버로 전송함수
}

const c = () => {
	f.flag.value = false
}