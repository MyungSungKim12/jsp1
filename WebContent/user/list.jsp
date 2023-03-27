<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<h1>사용자 목록</h1>
<table>
	<c:forEach items="${list}" var="vo">
		<tr>
			<td>${vo.uid}</td>
			<td>${vo.upass}</td>
			<td>${vo.uname}</td>
			<td>${vo.address}</td>
			<td><fmt:formatDate type="date"
				 value="${vo.join_date}" pattern="YYYY-MM-dd hh:mm:ss"/></td>
		</tr>
		
	</c:forEach>
</table>