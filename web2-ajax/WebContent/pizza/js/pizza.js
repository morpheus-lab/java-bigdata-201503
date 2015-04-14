// XHR
var request = null;

// XHR 객체 생성
function createRequest() {
	try {
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(otherms) {
			try {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if (request == null) {
		alert("XHR 객체 생성 실패");
	}
}

// AJAX를 통해 고객이름으로 주소를 조회하고 표시하는 함수
function getCustomerInfo() {
	var name = document.getElementById("name").value;
	var url = "lookUpCustomer?name=" + name;
	
	request.open("GET", url, true);	// req 메서드, url, async 여부
	request.onreadystatechange = updatePage;
	request.send(null);
}

function updatePage() {
	if (request.readyState == 4) {
		// 응답 메시지의 body 부분의 문자열을 받아옴
		var customerAddress = request.responseText;
		// pizza.html의 고객 주소 <textarea>에 위 값을 표시
		document.getElementById("addr").value = customerAddress;
	}
}


















