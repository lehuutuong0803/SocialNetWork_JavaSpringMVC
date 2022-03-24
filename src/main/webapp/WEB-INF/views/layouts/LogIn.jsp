<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<c:url var="userURL1" value="/user/test" />
<c:url var="userURL" value="/" />
<c:url var="newAPI" value="/api/user"/> <c:url var="userLogin" value="/api/user/login"/>
<!DOCTYPE html>
<html lang="en">


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>Hutech University</title>
<link rel="icon" href="<c:url value ="/assets/images/hutech1.png"/>"
	type="image/png" sizes="16x16">

<link rel="stylesheet" href="<c:url value ="/assets/css/main.min.css"/>">
<link rel="stylesheet"
	href="<c:url value ="/assets/css/weather-icon.css"/>">
<link rel="stylesheet"
	href="<c:url value ="/assets/css/weather-icons.min.css"/>">
<link rel="stylesheet" href="<c:url value ="/assets/css/style.css"/>">
<link rel="stylesheet" href="<c:url value ="/assets/css/color.css"/>">
<link rel="stylesheet"
	href="<c:url value ="/assets/css/responsive.css"/>">

</head>
<body>
	<div class="www-layout">
		<section>
			<div class="gap no-gap signin whitish medium-opacity">
				<div class="bg-image"
					style="background-image:url(<c:url value ="/assets/images/resources/theme-bg.jpg"/>)"></div>
				<div class="container">
					<div class="row">
						<div class="col-lg-8">
							<div class="big-ad">
								<figure>
									<img src="<c:url value ="/assets/images/hutech.png"/>" alt="">
								</figure>
								<h1>Chào mừng đến với Đại học Hutech</h1>
								<p>Đại học Hutech là một mẫu mạng xã hội có thể được sử dụng
									để kết nối mọi người. sử dụng mẫu này cho các hoạt động xã hội
									đa năng như việc làm, hẹn hò, đăng bài, đăng tin và hơn thế
									nữa. Bây giờ tham gia & Kết bạn tuyệt vời trên khắp thế giới
									!!!</p>

								<div class="fun-fact">
									<div class="row">
										<div class="col-lg-3 col-md-3 col-sm-4">
											<div class="fun-box">
												<i class="ti-check-box"></i>
												<h6>Người đã đăng ký</h6>
												<span>1,01,242</span>
											</div>
										</div>
										<div class="col-lg-3 col-md-3 col-sm-4">
											<div class="fun-box">
												<i class="ti-layout-media-overlay-alt-2"></i>
												<h6>Bài đã xuất bản</h6>
												<span>21,03,245</span>
											</div>
										</div>
										<div class="col-lg-3 col-md-3 col-sm-4">
											<div class="fun-box">
												<i class="ti-user"></i>
												<h6>Người dùng trực tuyến</h6>
												<span>40,145</span>
											</div>
										</div>
									</div>
								</div>
								<div class="barcode">
									<figure>
										<img
											src="<c:url value ="/assets/images/resources/Barcode.jpg"/>"
											alt="">
									</figure>
									<div class="app-download">
										<span>Tải xuống ứng dụng di động và quét mã QR để đăng
											nhập</span>
										<ul class="colla-apps">
											<li><a title=""
												href="https://play.google.com/store?hl=en"><img
													src="<c:url value ="/assets/images/android.png"/>" alt="">android</a></li>
											<li><a title=""
												href="https://www.apple.com/lae/ios/app-store/"><img
													src="<c:url value ="/assets/images/apple.png"/>" alt="">iPhone</a></li>
											<li><a title=""
												href="https://www.microsoft.com/store/apps"><img
													src="<c:url value ="/assets/images/windows.png"/>" alt="">Windows</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<decorator:body />

					</div>
				</div>
			</div>
		</section>

	</div>

	<script src="<c:url value ="/assets/js/main.min.js"/>"></script>
	<script src="<c:url value ="/assets/js/script.js"/>"></script>
	<script src="<c:url value="/assets/js/jquery-ui.min.js"/>"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<decorator:getProperty property="page.script"></decorator:getProperty>
	<script>
		jQuery(document).ready(function($) {
			
		
			//LogIn
			$('#btnLogin').click(function(e) {
				e.preventDefault();
				var data = {};
				var formData = $('#formLogin').serializeArray();
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				$.ajax({
					url : '${userLogin}',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
					
						window.location.href = "/HutechSocialNetwork/user/home";
					},
					error : function(error) {
						window.location.href = "/HutechSocialNetwork/register";
						alert("Đăng nhập thất bại!");
					}
				});
			});
			
			//Register
			$('#btnRegister').click(function(e) {
				e.preventDefault();
				var data = {};
				var formData = $('#formSubmit').serializeArray();
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				$.ajax({
					url : '${newAPI}',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						window.location.href = "/HutechSocialNetwork/";
						alert("Đăng ký thành công. Hãy đăng nhập nào!!!");
					},
					error : function(error) {
						window.location.href = "/HutechSocialNetwork/register";
						alert("Đăng ký thất bại. Vui lòng nhập đầy đủ thông tin!!!");
					}
				});
			});
			
			//-----------------
			$('#us3').locationpicker({
			  location: {
			    latitude: -8.681013,
			    longitude: 115.23506410000005
			  },
			  radius: 0,
			  inputBinding: {
			    latitudeInput: $('#us3-lat'),
			    longitudeInput: $('#us3-lon'),
			    radiusInput: $('#us3-radius'),
			    locationNameInput: $('#us3-address')
			  },
			  enableAutocomplete: true,
			  onchanged: function (currentLocation, radius, isMarkerDropped) {
			    // Uncomment line below to show alert on each Location Changed event
			    //alert("Location changed. New location (" + currentLocation.latitude + ", " + currentLocation.longitude + ")");
			  }
			});
			
		if ($.isFunction($.fn.toast)) {
			$.toast({
				heading: 'Welcome To Pitnik',
				text: '',
				showHideTransition: 'slide',
				icon: 'success',
				loaderBg: '#fa6342',
				position: 'bottom-right',
				hideAfter: 3000,
			});

			$.toast({
				heading: 'Information',
				text: 'Now you can full demo of pitnik and hope you like',
				showHideTransition: 'slide',
				icon: 'info',
				hideAfter: 5000,
				loaderBg: '#fa6342',
				position: 'bottom-right',
			});
			$.toast({
				heading: 'Support & Help',
				text: 'Report any <a href="#">issues</a> by email',
				showHideTransition: 'fade',
				icon: 'error',
				hideAfter: 7000,
				loaderBg: '#fa6342',
				position: 'bottom-right',
			});
		}	

		});	
</script>
</body>

</html>