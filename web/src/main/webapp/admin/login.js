function login(){
	if(frm.adm_id.value==""){
		alert("아이디를 입력하세요");
	}
	else if(frm.adm_pw.value==""){
		alert("패스워드를 입력하세요");
	}
	else if(frm.adm_no.value==""){
		alert("사원번호를 입력하세요");
	}
	else{
		//frm.method = "get";
		//frm.action = "./adminok.do";
		//frm.submit();
		
		//location.href = GET 방식
		//btoa : base64 암호
		var id = btoa(frm.adm_id.value);
		var pw = btoa(frm.adm_pw.value);
		var no = btoa(frm.adm_no.value);
		location.href="./adminok.do?adm_id="+id+"&adm_pw="+pw+"&adm_no="+no;
	}
}


