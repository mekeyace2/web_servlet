function wordck(){
	//var w = "010123-45678";
	var w = "0101235678";
	
	//let ck = /[0-9]/;		//0~9
	//let ck = /[a-zA-z]/;	//a~z(소문자)
	//console.log(ck.test(w));			//true, false
	
	//let ck = /[0-9]/;	//0~9숫자 외에 단어
	//console.log(w.match(ck));		//배열형태의 값을 출력
	
	//$ : 해당 패턴에 문자열을 대입하여 체크하는 방식
	let ck = /^\d{2,3}\d{3,4}\d{4}$/;	//true(01012345678), false(010-1234-5678)
	console.log(ck.test(w));
}




function eventok(){
	if(f.ename.value==""){
		alert("고객명을 입력하세요!");
	}
	else if(f.etel.value==""){
		alert("연락처를 입력하세요");
	}
	else if(f.email.value==""){
		alert("이메일을 입력하세요");
	}
	else if(f.ememo.value==""){
		alert("이벤트 참여이유를 입력하세요");
	}
	else if(f.info1.checked == false){
		alert("개인정보활용에 동의 하셔야만 이벤트에 참여가 됩니다.");
	}
	else if(f.info2.checked == false){
		alert("제 3자에 정보제공에 동의 하셔야만 이벤트에 참여가 됩니다.");
	}
	else{
		//정규식 코드 사용 (연락처 확인)
		let ck = /^\d{2,3}\d{3,4}\d{4}$/;	//숫자 외에 다른 문자일 경우 false
		if(ck.test(f.etel.value) == false){
			alert("전화번호를 정상적으로 입력하세요");
		}
		else{	//정규식 코드(true)
			f.submit();
		}
		
	}
}