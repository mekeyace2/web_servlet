<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 내용확인</title>
<style>
.data1 {
 width:400px;
 height:30px;
 line-height: 30px;
 border-bottom: 1px solid gray;
}
.n {
	display: flex;
	flex-direction: row;
	justify-content: flex-start;
	align-content: center;
}
.data2{
border: 1px solid gray;
width:800px;
height:400px;
overflow-y:auto;
}
</style>
</head>
<body>
<span class="n">등록일 : <div class="data1"></div></span><br>
<span class="n">제목 : <div class="data1"></div></span><br>
<span class="n">글쓴이 : <div class="data1"></div></span><br>
<span class="n">조회수 : <div class="data1"></div></span><br>
<span class="n">내용 : <div class="data2"></div>
</span><br>
<span class="n">첨부파일 : <div class="data1"></div></span><br>
<input type="button" value="글목록" onclick="notice_info(1)">
<input type="button" value="글수정" onclick="notice_info(2)">
<input type="button" value="글삭제" onclick="notice_info(3)">
</body>
<script>
function notice_info(p){
	switch(p){
	case 1:
		location.href='./notice_list.do';
	break;
	case 2:
		location.href='./notice_modify.do';
	break;
	case 3:
		if(confirm("해당 게시물을 삭제시 복구 되지 않습니다.")){
			location.href='./notice_delete.do';
		}
	break
	}
}

</script>
</html>



