//게시물 등록시 체크하는 함수
function writeck(){
	if(frm.subject.value==""){
		alert("제목을 입력하셔야 합니다.");
		frm.subject.focus();
	}
	else if(frm.writer.value==""){
		alert("글쓴이를 입력하셔야 합니다.");
		frm.writer.focus();
	}
	else if(frm.pw.value==""){
		alert("비밀번호를 입력하셔야 합니다.");
		frm.pw.focus();
	}
	else {
		//CKEDITOR.instances.html id이름.getData() : ckeditor를 로드
		var txt = CKEDITOR.instances.editor.getData();
		
		if(txt == ""){
			alert("내용을 입력하셔야 합니다.");
		}
		else if(txt.length < 60){
			alert("최소 60자 이상 입력 되어야 합니다.");
		}
		else{
			frm.submit();	
		}	
	}
}



