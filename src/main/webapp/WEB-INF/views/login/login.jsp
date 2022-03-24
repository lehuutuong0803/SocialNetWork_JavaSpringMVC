<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<div class="col-lg-4">
	<div class="we-login-register">
		<div class="form-title">
			<i class="fa fa-key"></i>đăng nhập <span>đăng nhập ngay bây
			giờ và gặp gỡ những người bạn tuyệt vời trên khắp thế giới. </span>
		</div>
		
		<form:form class="we-form" method="POST" id="formLogin"  role="form" modelAttribute="user">
			<form:input type="text" placeholder="Nhập tên đăng nhập" path="username" />
			<form:input type="password" placeholder="Nhập mật khẩu" path="password" />
			
			<button type="button" id="btnLogin">đăng nhập</button>
				
		</form:form>
		
		<a class="with-smedia facebook" href="#" title="" data-ripple=""><i
			class="fa fa-facebook"></i></a> <a class="with-smedia twitter" href="#"
			title="" data-ripple=""><i class="fa fa-twitter"></i></a> <a
			class="with-smedia instagram" href="#" title="" data-ripple=""><i
			class="fa fa-instagram"></i></a> <a class="with-smedia google" href="#"
			title="" data-ripple=""><i class="fa fa-google-plus"></i></a> <span>không
			có tài khoản? <a class="we-account underline" href="<c:url value = "/register"/>" title="">đăng
				ký ngay bây giờ</a>
		</span>
	</div>
</div>