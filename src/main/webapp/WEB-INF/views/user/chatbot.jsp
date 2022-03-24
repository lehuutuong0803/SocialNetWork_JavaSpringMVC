<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>




	
	<div class="gap no-gap signin whitish medium-opacity register">
                <div class="bg-image"
		style="background-image:url(<c:url value ="/assets/images/resources/theme-bg.jpg"/>)"></div>
                <div id ="main">
	<h2 id="title_chatBox">Hutech ChatBot</h2>
	<div id= "msg_area">

	<div id="robot">
		<div id="bot_send"></div>
		<div id ="bot"></div>
		<h3 id="botname">Hte Bot</h3>

	</div>
</div>	
</div>


	<div id="input">
		<input style="border-radius:5px" type="text" placeholder="New Message" id="msg_send">
		<button id="sendtext" class="fa fa-paper-plane">Send</button>
	</div>
           </div>

