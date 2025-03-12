function ajax_file(){
	var mfile = document.getElementById("mfile");
	if(mfile.value == ""){
		alert("파일 첨부를 하셔야 합니다.");
	}else{
		this.ajax_post(mfile);	
	}
}

//ajax I/O로 파일 전송하는 방식
function ajax_post(mfile){
	var http,result;
	var formdata = new FormData();	//form형태의 태그를 이용하는 방식과 동일
	formdata.append("mfile",mfile.files[0]);	//배열기준으로 파일을 처리 합니다.
	
	http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(http.readyState==4 && http.status==200){
			console.log(this.response);
		}
	}	
	//POST전송
	http.open("POST","./ajax_fileok.do",true);
	http.send(formdata);	//Formdata 함수의 값을 send 함수에 인자값으로 적용하여 전송
}



