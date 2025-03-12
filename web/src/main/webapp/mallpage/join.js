function joinok(){
	if(frm.mid.value == ""){
		alert("아이디를 입력하세요");
	}
	else if(frm.mpass.value == ""){
		alert("패스워드를 입력하세요");
	}
	else{
		//세부검토
		var pw2 = document.getElementById("mpass2").value;
		if(pw2 != frm.mpass.value){
			alert("동일한 패스워드를 입력하셔야만 회원가입 진행 됩니다.");
		}
		else{
			frm.submit();
		}
	}
}