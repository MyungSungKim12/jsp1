<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<h1>게시글 정보</h1>
<h5>[${vo.id}] ${vo.title}</h5>
<hr>
<div>${vo.writer} ${vo.date}</div>
<hr>
<p>${vo.body}</p>
<hr>
<button id="btnUpdate">수정</button>
<button id="btnDelete">삭제</button>

<script>

	$("#btnUpdate").on("click", function(){
		location.href="/posts/update?id=" + ${vo.id};
		
	});
	
	$("#btnDelete").on("click", function() {
		if(!confirm(`${vo.id}번 게시글을 삭제하실래요?`)) return;
		$.ajax({
			type:"post",
			url:"/posts/delete",
			data: {id: ${vo.id}},
			success:function(){
				alert('삭제완료');
				location.href('/posts');
			}
		})
	});
</script>