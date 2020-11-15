<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<c:set var = "pageName" value = "로그인 아이디 찾기" />
	<%@ include file = "../../part/head.jspf" %>
	
	<script>

		var findLoginIdSubmitDone = false;
		
		function findLoginIdSubmit(form) {

				if ( findLoginIdSubmitDone ) {
					alert('처리중 입니다.');

					return;
				}

				form.name.value = form.name.value.trim();

				if ( form.name.value.length == 0 ) {
						alert('이름을 입력해주세요.');
						form.name.focus();
						return;
					}

				form.email.value = form.email.value.trim();

				if ( form.email.value.length == 0 ) {
						alert('이메일을 입력해주세요.');
						form.email.focus();
						return;
					}  

				form.submit();
				findLoginIdSubmitDone = true;
			
			}
	</script>

	<form action="./doFindLoginId" method="POST" onsubmit="findLoginIdSubmit(this); return false;">


		<div>
			이름 : <input type="text" name="name" maxlength="30" placeholder="이름을 입력해주세요." />
		</div>
		
		<div>
			이메일 : <input type="email" name="email" maxlength="50" placeholder="이메일을 입력해주세요."/>
		</div>
		<div>
			<input type="submit" value="찾기">
		</div>
		
	</form>
	
	<div>
		<a onclick="history.back();">뒤로가기</a>
	</div>

	<%@ include file = "../../part/foot.jspf" %>