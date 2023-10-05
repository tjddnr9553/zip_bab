$(document).ready(function() {
	let type = $('#type').data('type')
	let txt = '판매자'
	if (type == 1) {
		txt = '구매자'
	}
	$('#type').text(txt)
})