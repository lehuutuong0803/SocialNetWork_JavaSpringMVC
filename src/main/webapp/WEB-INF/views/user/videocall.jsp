<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<div class="gap no-gap signin whitish medium-opacity"
	style="height: 84.3vh">
	<div class="bg-image"
		style="background-image:url(<c:url value ="/assets/images/resources/theme-bg.jpg"/>)"></div>
	<div class="back-vinh">
		<h1 class="title">Hutech Meet</h1>
		<p id="notification" hidden></p>

			<form:form method="POST" id="form_VideoCall"
					role="form" modelAttribute="videocall">
			<div class="entry-modal" id="entry-modal">
				<p>Tạo hoặc vào phòng</p>
				
				<form:input type="text" id="room-input" placeholder="Nhập mã phòng" path="roomcode" />
				<div>
					<button type="button" onClick="createRoom()">Tạo phòng</button>
					<button type="button" onClick="normalRoom()">Vào phòng</button>
				</div>
				<p></p>
				<button type="button" onClick="randomRoom()">Tìm kiếm người lạ</button>
			</div>
			</form:form>



		

	</div>
	<div class="meet-area">
		<!-- Remote Video Element-->
		<video id="remote-video"></video>

		<!-- Local Video Element-->
		<video id="local-video"></video>
		<div class="meet-controls-bar">
			<button onclick="startScreenShare()">Chia sẻ màn hình</button>
			<button type="button" onClick="research_randomRoom()">Tìm kiếm người lạ</button>
				<button onClick="stop()">Kết thúc</button>
		</div>
	</div>

</div>