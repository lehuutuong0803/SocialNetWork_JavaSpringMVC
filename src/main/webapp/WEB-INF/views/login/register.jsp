<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<div class="col-lg-4">
	<div class="we-login-register">
		<div class="form-title">
	          <i class="fa fa-key"></i>Đăng ký
	          <span>Đăng ký ngay bây giờ và gặp gỡ những người bạn tuyệt vời trên khắp thế giới.</span>
      	</div>
		<form:form class="we-form" method="POST" role="form" id="formSubmit"
			modelAttribute="user_account">
			
			
				<label for="pwd">Tên đăng nhập:</label>
				<form:input type="text"
				path="username" class="form-control" placeholder="Nhập tên đăng nhập"/> 
	
	
				<label for="pwd">Mật khẩu:</label>
				<form:input type="password" placeholder="Nhập mật khẩu"
				path="password" class="form-control" /> 

				<label for="pwd">Tên người dùng:</label>
				<form:input type="text" placeholder="Nhập tên người dùng"
				path="name" class="form-control" />


				<label for="pwd">Số điện thoại:</label>
				<form:input type="text" placeholder="Nhập số điện thoại"
				maxlength="10" path="phone" onkeypress="return onlyNumberKey(event)" class="form-control" /> 
	
		
				<label for="pwd">Email:</label>
				<form:input type="email" placeholder="Nhập email" path="email" class="form-control" />
			
		
				<label for="pwd">Ngày sinh:</label>
				<form:input type="date" name="bday" path="birthday" class="form-control" />
		
		
				<label for="pwd">Giới thiệu bản thân:</label>
				<form:textarea rows="2" type="text" placeholder="Giới thiệu bản thân"
				path="intro" class="form-control" />
				
				<label for="pwd">Nhập mã số sinh viên:</label>
			 	<form:input type="text" placeholder="Nhập mssv" maxlength="10"
				path="student_number" onkeypress="return onlyNumberKey(event)" />
					
        		<label>Gender:</label>
        		<span>Male</span> <form:radiobutton path="gender" value="1"/>
				<span>Female</span> <form:radiobutton path="gender" value="0"/>

				<form:select path="id_Faculty" multiple="true" class="form-control">
					<form:options items="${_Faculty}"/>
				</form:select>
				<br>
				
				<button type="button" id="btnRegister">Đăng ký</button>
		</form:form>


		<a data-ripple="" title="" href="#" class="with-smedia facebook"><i
			class="fa fa-facebook"></i></a> <a data-ripple="" title="" href="#"
			class="with-smedia twitter"><i class="fa fa-twitter"></i></a> <a
			data-ripple="" title="" href="#" class="with-smedia instagram"><i
			class="fa fa-instagram"></i></a> <a data-ripple="" title="" href="#"
			class="with-smedia google"><i class="fa fa-google-plus"></i></a> <span>
			Bạn co săn san để tạo một tai khoản? <a
			class="we-account underline" href="#" title="">Đăng nhập</a>
		</span>
	</div>
</div>
<script>
    function onlyNumberKey(evt) {
          
        // Only ASCII character in that range allowed
        var ASCIICode = (evt.which) ? evt.which : evt.keyCode
        if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57))
            return false;
        return true;
    }
</script>

<script>
    function detailssubmit() {
        alert("Your details were Submitted");
    }
</script>