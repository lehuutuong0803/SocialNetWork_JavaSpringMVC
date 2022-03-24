
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<c:url var="addFriend" value="api/friend" />
<c:url var="unfriendAPI" value="/api/friend" />
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
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value ="/assets/css/main.min.css"/>">
<link rel="stylesheet"
	href="<c:url value ="/assets/css/weather-icons.min.css"/>">
<link rel="stylesheet"
	href="<c:url value ="/assets/css/toast-notification.css"/>">
<link rel="stylesheet"
	href="<c:url value ="/assets/css/page-tour.css"/>">
<link rel="stylesheet" href="<c:url value ="/assets/css/style.css"/>">
<link rel="stylesheet" href="<c:url value ="/assets/css/color.css"/>">
<link rel="stylesheet"
	href="<c:url value ="/assets/css/responsive.css"/>">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
	integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script type="text/javascript"
			src="https://unpkg.com/kd-shim-sockjs-client@0.3.4/sockjs-0.3.4.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"
			integrity="sha512-tL4PIUsPy+Rks1go4kQG8M8/ItpRMvKnbBjQm4d2DQnFwgcBYRRN00QdyQnWSCwNMsoY/MfJY8nHp2CzlNdtZA=="
			crossorigin="anonymous"></script>
<script type="text/javascript">

</script>
<script type="text/javascript">

function notification(){
	if(Notification.permission ==="granted"){
	}else if(Notification.permission !=="denied"){
		Notification.requestPermission().then(permission => {
		});
	}
}
function showNotification(ntf){
	var n = ntf;
	const notification = new Notification("Thông báo mới từ HUTECH", {
		body: n,
		icon: "https://res.cloudinary.com/dbjjh1p4j/image/upload/v1638019082/keaxjifni7ygdct9mdwp.png"
	});
}
//Show box
      var stompClient = null;

            
            
            function connect1() {
                var socket = new SockJS('/HutechSocialNetwork/gs-guide-websocket');
                stompClient = Stomp.over(socket);
                stompClient.connect({}, function(frame) {
                    console.log('Connected: ' + frame);
                    stompClient.subscribe('/topic/messages1', function(messageOutput) {
                      var x = JSON.parse(messageOutput.body);
                      var y =1;
              		
                    	  $('#response').append(x.userid + ": "
                                  + x.content + " (" + x.time + ")");
                    	  $('#1content_chatbox'+x.boxid).append(
									'<li class="me">'+
									'<div class="chat-thumb"><img src="'+x.useravatar+'" alt=""></div>'+
										'<div class="notification-event">'+
											'<span class="chat-message-item">'+ x.content+'</span>'+
											'<span class="notification-date"><time datetime="2004-07-24T18:18" class="entry-date updated">'+x.time+'</time></span>'+
										'</div>'+
									'</li>'
							);
                       
                    });
                    
                    stompClient.subscribe('/topic/notification', function(messageOutput) {
                        var x = JSON.parse(messageOutput.body);
                    	
                    		
                    		   var str = "Bạn có một đơn hàng từ " + x.username_buyer;
                               showNotification(str);
                              
                    	
                             });
                    	
                 
                     
                    stompClient.subscribe('/topic/verification', function(messageOutput) {
                        var x = JSON.parse(messageOutput.body);
                       
                            var str = "Đơn hàng #"+x.invoiceid+" đã được xác nhận bời "+ x.username_buyer;
                            showNotification(str);
                            $('#area_invoice'+x.invoiceid).text('');
                            $('#area_invoice'+x.invoiceid).append(
                            	'<button style="background: #fa6342; border: medium none; border-radius: 30px; color: #fff; padding: 5px 10px;" class="main-btn" title="">Đã xác nhận</button>'	
                            	
                            );
                            $('#area_historyinvoice'+x.invoiceid).text('');
                            $('#area_historyinvoice'+x.invoiceid).append(
                            		'<button style="background: #fa6342; border: medium none; border-radius: 30px; color: #fff; padding: 5px 10px;" class="main-btn" title="">Đã xác nhận</button>'	
                            	
                            );
                        
        
                      });
                });
            }
            
            function disconnect() {
                if(stompClient != null) {
                    stompClient.disconnect();
                }
                setConnected(false);
                console.log("Disconnected");
            }
            function sendMessage(obj) {
            	var id= obj;
            	var userid = document.getElementById('user'+id).value;
            	var friendid = document.getElementById('friend'+id).value;
            	var boxid =  document.getElementById('box'+id).value;
                var text = document.getElementById('content'+id).value;
                stompClient.send("/app/chat", {},
                  JSON.stringify({'userid':userid, 'friendid':friendid, 'boxid':boxid, 'content':text}));
            }
            function sendNotification(obj) {
            	var userId = obj;
            	var username_buyer = "${User_Infor.name}";
            	stompClient.send("/app/noti", {},
                        JSON.stringify({'userid':userId, 'username_buyer':username_buyer}));
            }
            function verifyInvoice(obj){
            	var id = obj;
            	var userid = document.getElementById('user_Invoice'+id).value;
            	var username_buyer = "${User_Infor.name}";
            	stompClient.send("/app/verifyInvocie", {},
                        JSON.stringify({'userid':userid, 'username_buyer':username_buyer,'invoiceid':id}));
            }
           
            
            
            connect1();
        </script>
<style type="text/css">
#start1 {
	margin: auto;
	display: flex;
}

#main {
	width: 100vw;
	max-width: 540px;
	height: 78.5vh;
	position:relative;
	background-color:#fff;
	margin: auto;
	/* text-align: center; */
	box-shadow: inset 0 0 10px 4px #1116;
}

#title_chatBox {
	text-align: center;
	font-family: sans-serif;
	background: #0063ae;
	color: #fff;
	padding: 8px;
	text-shadow: 1px 1px 4px #111;
	margin-bottom: 8px;
}

#msg_area {
	height: 82%;
	padding: 0 12px;
	overflow-y: scroll;
	scroll-behavior: smooth;
}

#bot {
	width: 50px;
	height: 50px;
	background-size: 100%;
	background-url
	(bot.jpg);
}

#robot {
	display: flex;
	justify-content: center;
	align-items: center;
}

#botname {
	font-family: monospace;
	font-size: 20px;
}

#input {
	height: 7%;
	min-height: 42px;
	position:relative;
	display: grid;
	grid-template-columns: 70% 30%;
	margin: 8px 16px;
	border-radius: 32px;
	width: 28.2%;
	margin: auto;
}

#sendtext {
	outline: none;
	border-radius:5px;
	font-size: 20px;
	color: #eee;
	background: #0063ae;
}

.left-chat, .right-chat {
	font-size: 18px;
	font-family: monospace;
	display: inline-block;
	width: auto;
	max-width: 60%;
	padding: 14px;
	margin: 8px 14px
}

.msgCon1, .msgCon2 {
	width: 100%;
	display: inline-block;
}

.msgCon1 {
	text-align: right;
}

.msgCon2 {
	text-align: left;
}

.left-chat {
	color: #000;
	background: #b3bfca;
	border-radius: 0 16px 16px 16px;
}

.right-chat {
	color: #fff;
	background: #1c1f46;
	border-radius: 16px 16px 0px 16px;
	float: right;
}
</style>
</head>
<body >

<script>

</script>

	<div class="wavy-wraper">
		<div class="wavy">
			<span style="-i: 1;">h</span> <span style="-i: 2;">u</span> <span
				style="-i: 3;">t</span> <span style="-i: 4;">e</span> <span
				style="-i: 5;">c</span> <span style="-i: 6;">h</span> <span
				style="-i: 7;">.</span> <span style="-i: 8;">.</span> <span
				style="-i: 9;">.</span>
		</div>
	</div>

	<div class="theme-layout">

		<div class="postoverlay"></div>

		<div class="responsive-header">
			<div class="mh-head first Sticky">
				<span class="mh-btns-left"> <a class="" href="#menu"><i
						class="fa fa-align-justify"></i></a>
				</span> <span class="mh-text"> <a href="newsfeed.html" title=""><img
						src="..//assets/images/logo2.png" alt=""></a>
				</span> <span class="mh-btns-right"> <a class="fa fa-sliders"
					href="#shoppingbag"></a>
				</span>
			</div>
			<div class="mh-head second">
				<form class="mh-form">
					<input placeholder="search" /> <a href="#/" class="fa fa-search"></a>
				</form>
			</div>
			<nav id="menu" class="res-menu">
				<ul>
					<li><span>Home Pages</span>
						<ul>
							<li><a href="index.html" title="">Pitnik Default</a></li>
							<li><a href="company-landing.html" title="">Company
									Landing</a></li>
							<li><a href="pitrest.html" title="">Pitrest</a></li>
							<li><a href="redpit.html" title="">Redpit</a></li>
							<li><a href="redpit-category.html" title="">Redpit
									Category</a></li>
							<li><a href="soundnik.html" title="">Soundnik</a></li>
							<li><a href="soundnik-detail.html" title="">Soundnik
									Single</a></li>
							<li><a href="career.html" title="">Pitjob</a></li>
							<li><a href="shop.html" title="">Shop</a></li>
							<li><a href="classified.html" title="">Classified</a></li>
							<li><a href="pitpoint.html" title="">PitPoint</a></li>
							<li><a href="pittube.html" title="">Pittube</a></li>
							<li><a href="chat-messenger.html" title="">Messenger</a></li>
						</ul></li>
					<li><span>Pittube</span>
						<ul>
							<li><a href="pittube.html" title="">Pittube</a></li>
							<li><a href="pittube-detail.html" title="">Pittube
									single</a></li>
							<li><a href="pittube-category.html" title="">Pittube
									Category</a></li>
							<li><a href="pittube-channel.html" title="">Pittube
									Channel</a></li>
							<li><a href="pittube-search-result.html" title="">Pittube
									Search Result</a></li>
						</ul></li>
					<li><span>PitPoint</span>
						<ul>
							<li><a href="pitpoint.html" title="">PitPoint</a></li>
							<li><a href="pitpoint-detail.html" title="">Pitpoint
									Detail</a></li>
							<li><a href="pitpoint-list.html" title="">Pitpoint List
									style</a></li>
							<li><a href="pitpoint-without-baner.html" title="">Pitpoint
									without Banner</a></li>
							<li><a href="pitpoint-search-result.html" title="">Pitpoint
									Search</a></li>
						</ul></li>
					<li><span>Pitjob</span>
						<ul>
							<li><a href="career.html" title="">Pitjob</a></li>
							<li><a href="career-detail.html" title="">Pitjob Detail</a></li>
							<li><a href="career-search-result.html" title="">Job
									seach page</a></li>
							<li><a href="social-post-detail.html" title="">Social
									Post Detail</a></li>
						</ul></li>
					<li><span>Timeline</span>
						<ul>
							<li><a href="timeline.html" title="">Timeline</a></li>
							<li><a href="timeline-photos.html" title="">Timeline
									Photos</a></li>
							<li><a href="timeline-videos.html" title="">Timeline
									Videos</a></li>
							<li><a href="timeline-groups.html" title="">Timeline
									Groups</a></li>
							<li><a href="timeline-friends.html" title="">Timeline
									Friends</a></li>
							<li><a href="timeline-friends2.html" title="">Timeline
									Friends-2</a></li>
							<li><a href="about.html" title="">Timeline About</a></li>
							<li><a href="blog-posts.html" title="">Timeline Blog</a></li>
							<li><a href="friends-birthday.html" title="">Friends'
									Birthday</a></li>
							<li><a href="newsfeed.html" title="">Newsfeed</a></li>
							<li><a href="search-result.html" title="">Search Result</a></li>
						</ul></li>
					<li><span>Favourit Page</span>
						<ul>
							<li><a href="fav-page.html" title="">Favourit Page</a></li>
							<li><a href="fav-favers.html" title="">Fav Page Likers</a></li>
							<li><a href="fav-events.html" title="">Fav Events</a></li>
							<li><a href="fav-event-invitations.html" title="">Fav
									Event Invitations</a></li>
							<li><a href="event-calendar.html" title="">Event
									Calendar</a></li>
							<li><a href="fav-page-create.html" title="">Create New
									Page</a></li>
							<li><a href="price-plans.html" title="">Price Plan</a></li>
						</ul></li>
					<li><span>Forum</span>
						<ul>
							<li><a href="forum.html" title="">Forum</a></li>
							<li><a href="forum-create-topic.html" title="">Forum
									Create Topic</a></li>
							<li><a href="forum-open-topic.html" title="">Forum Open
									Topic</a></li>
							<li><a href="forums-category.html" title="">Forum
									Category</a></li>
						</ul></li>
					<li><span>Featured</span>
						<ul>
							<li><a href="chat-messenger.html" title="">Messenger
									(Chatting)</a></li>
							<li><a href="notifications.html" title="">Notifications</a></li>
							<li><a href="badges.html" title="">Badges</a></li>
							<li><a href="faq.html" title="">Faq's</a></li>
							<li><a href="contribution.html" title="">Contriburion
									Page</a></li>
							<li><a href="manage-page.html" title="">Manage Page</a></li>
							<li><a href="weather-forecast.html" title="">weather-forecast</a></li>
							<li><a href="statistics.html" title="">Statics/Analytics</a></li>
							<li><a href="shop-cart.html" title="">Shop Cart</a></li>
						</ul></li>
					<li><span>Account Setting</span>
						<ul>
							<li><a href="setting.html" title="">Setting</a></li>
							<li><a href="privacy.html" title="">Privacy</a></li>
							<li><a href="support-and-help.html" title="">Support &
									Help</a></li>
							<li><a href="support-and-help-detail.html" title="">Support
									Detail</a></li>
							<li><a href="support-and-help-search-result.html" title="">Support
									Search</a></li>
						</ul></li>
					<li><span>Authentication</span>
						<ul>
							<li><a href="login.html" title="">Login Page</a></li>
							<li><a href="register.html" title="">Register Page</a></li>
							<li><a href="logout.html" title="">Logout Page</a></li>
							<li><a href="coming-soon.html" title="">Coming Soon</a></li>
							<li><a href="error-404.html" title="">Error 404</a></li>
							<li><a href="error-404-2.html" title="">Error 404-2</a></li>
							<li><a href="error-500.html" title="">Error 500</a></li>
						</ul></li>
					<li><span>Tools</span>
						<ul>
							<li><a href="typography.html" title="">Typography</a></li>
							<li><a href="popup-modals.html" title="">Popups/Modals</a></li>
							<li><a href="post-versions.html" title="">Post Versions</a></li>
							<li><a href="sliders.html" title="">Sliders / Carousel</a></li>
							<li><a href="google-map.html" title="">Google Maps</a></li>
							<li><a href="widgets.html" title="">Widgets</a></li>
						</ul></li>
				</ul>
			</nav>
			<nav id="shoppingbag">
				<div>
					<div class="">
						<form method="post">
							<div class="setting-row">
								<span>use night mode</span> <input type="checkbox"
									id="nightmode" /> <label for="nightmode" data-on-label="ON"
									data-off-label="OFF"></label>
							</div>
							<div class="setting-row">
								<span>Notifications</span> <input type="checkbox" id="switch2" />
								<label for="switch2" data-on-label="ON" data-off-label="OFF"></label>
							</div>
							<div class="setting-row">
								<span>Notification sound</span> <input type="checkbox"
									id="switch3" /> <label for="switch3" data-on-label="ON"
									data-off-label="OFF"></label>
							</div>
							<div class="setting-row">
								<span>My profile</span> <input type="checkbox" id="switch4" />
								<label for="switch4" data-on-label="ON" data-off-label="OFF"></label>
							</div>
							<div class="setting-row">
								<span>Show profile</span> <input type="checkbox" id="switch5" />
								<label for="switch5" data-on-label="ON" data-off-label="OFF"></label>
							</div>
						</form>
						<h4 class="panel-title">Account Setting</h4>
						<form method="post">
							<div class="setting-row">
								<span>Sub users</span> <input type="checkbox" id="switch6" /> <label
									for="switch6" data-on-label="ON" data-off-label="OFF"></label>
							</div>
							<div class="setting-row">
								<span>personal account</span> <input type="checkbox"
									id="switch7" /> <label for="switch7" data-on-label="ON"
									data-off-label="OFF"></label>
							</div>
							<div class="setting-row">
								<span>Business account</span> <input type="checkbox"
									id="switch8" /> <label for="switch8" data-on-label="ON"
									data-off-label="OFF"></label>
							</div>
							<div class="setting-row">
								<span>Show me online</span> <input type="checkbox" id="switch9" />
								<label for="switch9" data-on-label="ON" data-off-label="OFF"></label>
							</div>
							<div class="setting-row">
								<span>Delete history</span> <input type="checkbox" id="switch10" />
								<label for="switch10" data-on-label="ON" data-off-label="OFF"></label>
							</div>
							<div class="setting-row">
								<span>Expose author name</span> <input type="checkbox"
									id="switch11" /> <label for="switch11" data-on-label="ON"
									data-off-label="OFF"></label>
							</div>
						</form>
					</div>
				</div>
			</nav>
		</div>
		<div class="mess-chatbox">
			<button>
				<a href="http://localhost:8080/HutechSocialNetwork/user/chatbot"><img
					src="https://res.cloudinary.com/dbjjh1p4j/image/upload/v1638019108/eqzmtra4qk8ibjronqnj.png">
				</a>
			</button>
		</div>
		<div class="mess-phone">
			<button>
				<a href="http://localhost:8080/HutechSocialNetwork/user/video-call"><img
					src="https://res.cloudinary.com/dbjjh1p4j/image/upload/v1639211424/ohgj47kifyyaptqdoshj.png">
				</a>
			</button>
		</div>
		<!-- responsive header -->

		<!-- header -->
		<%@include file="/WEB-INF/views/layouts/user/header.jsp"%>


		<decorator:body />


		<%@include file="/WEB-INF/views/layouts/user/footer.jsp"%>

		<!-- JavaScript Bundle with Popper -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
			crossorigin="anonymous"></script>
		<script src="<c:url value ="/assets/js/main-vinh.js"/>"></script>
		<script src="<c:url value ="/assets/js/main.min.js"/>"></script>
		<script src="<c:url value ="/assets/js/jquery-stories.js"/>"></script>
		<script src="<c:url value ="/assets/js/toast-notificatons.js"/>"></script>
		<script
			src="../../../cdnjs.cloudflare.com/ajax/libs/gsap/1.18.2/TweenMax.min.js"></script>
		<!-- For timeline slide show -->
		<script
			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA8c55_YHLvDHGACkQscgbGLtLRdxBDCfI"></script>
		<!-- for location picker map -->
		<script src="<c:url value ="/assets/js/locationpicker.jquery.js"/>"></script>
		<!-- for loaction picker map -->
		<script src="<c:url value ="/assets/js/map-init.js"/>"></script>
		<!-- map initilasition -->
		<script src="<c:url value ="/assets/js/page-tour-init.js"/>"></script>
		<script src="<c:url value ="/assets/js/script.js"/>"></script>
		<script src="<c:url value="/assets/js/jquery-ui.min.js"/>"></script>
		<script src="<c:url value="/assets/js/jquery-latest.min.js"/>"></script>
		<script src="<c:url value="/assets/js/jquery.nicescroll.js"/>"></script>

		<decorator:getProperty property="page.script"></decorator:getProperty>


		

		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"
			integrity="sha512-bZS47S7sPOxkjU/4Bt0zrhEtWx0y0CRkhEp8IckzK+ltifIIE9EMIMTuT/mEzoIMewUINruDBIR/jJnbguonqQ=="
			crossorigin="anonymous" referrerpolicy="no-referrer"></script>
		<script async="" src="https://drv.tw/inc/wd.js"></script>

		<script src="https://unpkg.com/peerjs@1.3.1/dist/peerjs.min.js"></script>
		
		<script src="<c:url value ="/assets/js/ckeditor/ckeditor.js"/>"></script>
       	<script>
           	CKEDITOR.replace('Note-Product');
  		 </script>

		<script type="text/javascript">
			const PRE = "DELTA"
			const SUF = "MEET"
			var room_id;
			var getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia;
			var local_stream;
			var screenStream;
			var peer = null;
			var currentPeer = null
			var screenSharing = false
			function stop(){
				window.location ="video-call";
			}
			function research_randomRoom(){
				$.ajax({
					url : '/HutechSocialNetwork/api/user/researchrandomroom',
					type : 'GET',
					success : function(result) {
						peer.destroy();
						 randomRoom();
					},
					error : function(error) {
						alert("Chấp nhận thất bại!!!");
					}
				});
			}
			function randomRoom(){
				var data = {};
				var formData = $('#form_VideoCall').serializeArray();
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				$.ajax({
					url : '/HutechSocialNetwork/api/user/availableroom',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					success : function(result) {
						if(result == "false"){
							alert("Hiện tại không có người. Hãy đợi một chút!!!")
							testRoom();
						}else{
							joinRandomRoom(result);
						}


					},
					error : function(error) {
						alert("Random thất bại!!!");
					}
				});
			}
			function joinRandomRoom(roomcode){
				alert("Đã thấy phòng!");
				var room = roomcode;
				$.ajax({
					url : '/HutechSocialNetwork/api/user/joinrandomroom',
					type : 'POST',
					data : room,
					success : function(result) {
						joinRoom(roomcode)
					},
					error : function(error) {
						alert("JoinRandomRoom thất bại!!!");
					}
				});
			}
			//Notify
				function notification(){
					if(Notification.permission ==="granted"){
					}else if(Notification.permission !=="denied"){
						Notification.requestPermission().then(permission => {
						});
					}
				}
				function showNotification(ntf){
					var n = ntf;
					const notification = new Notification("Thông báo mới từ HUTECH", {
						body: n,
						icon: "https://res.cloudinary.com/dbjjh1p4j/image/upload/v1638019082/keaxjifni7ygdct9mdwp.png"
					});
				}
			//Add cartItem
			function addCart(productcode){
				var code = productcode;
				$.ajax({
					url : '/HutechSocialNetwork/api/user/addcart',
					type : 'POST',
					data : code,
					success : function(result) {
						var ntf = "Bạn đã thêm sản phẩm vào giỏ hàng!"
							showNotification(ntf);
					},
					error : function(error) {
						alert("AddCart thất bại!!!");
					}
				});
			}
			function testRoom() {
				$.ajax({
							url : '/HutechSocialNetwork/api/user/videocalltest',
							type : 'GET',
							success : function(result) {
								if(result == "false"){
									alert("Vui long thuc hien lai!");
								}else{
									createrandomRoom(result);
								}
							},
							error : function(error) {
								alert("Chấp nhận thất bại!!!");
							}
						});
			
			}
			function createrandomRoom(roomcode) {
				alert("Đang tìm kiếm!!!");
				$(".meet-area").addClass("mett-area-block");
				$(".back-vinh").addClass("back-none-vinh");
			    console.log("Creating Room")
			    let room = roomcode;
			  
			    
			    room_id = PRE + room + SUF;
			    peer = new Peer(room_id)
			    peer.on('open', (id) => {
			        console.log("Peer Connected with ID: ", id)
			        hideModal()
			        getUserMedia({ video: true, audio: true }, (stream) => {
			            local_stream = stream;
			            setLocalStream(local_stream)
			        }, (err) => {
			            console.log(err)
			        })
			        notify("Đợi một chút!.")
			    })
			    peer.on('call', (call) => {
			        call.answer(local_stream);
			        call.on('stream', (stream) => {
			            setRemoteStream(stream)
			        })
			        currentPeer = call;
			    })
				
			}

			function normalRoom(){
				var roomcode = "normaljoin";
			var data = {};
			var formData = $('#form_VideoCall').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			$.ajax({
						url : '/HutechSocialNetwork/api/user/joinroom',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						success : function(result) {
							if(result == 0 ){
								alert("Mã phòng không tồn tại!")
								return;
							}else if(result == 1 ){
								joinRoom(roomcode);
							}else if(result == 2){
								alert("Phòng đã đầy!")
								return;
							}	
						},
						error : function(error) {
							alert("Chấp nhận thất bại!!!");
						}
					});
				
			}
			function createRoom() {
				let room1 = document.getElementById("room-input").value;
					if (room1 == " " || room1 == "") {
						alert("Vui lòng nhập mã phòng để tạo!")
				        return;
				    }
				var data = {};
				var formData = $('#form_VideoCall').serializeArray();
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				$.ajax({
							url : '/HutechSocialNetwork/api/user/videocall',
							type : 'POST',
							contentType : 'application/json',
							data : JSON.stringify(data),
							success : function(result) {
								if(result > 0 ){
									initializeRoom();
								}else{
									alert("Mã phòng đã có!")
									return;
								}
								
										
							},
							error : function(error) {
								alert("Chấp nhận thất bại!!!");
							}
						});
			
			}
			function close(){
				window.location.href = "/HutechSocialNetwork/user/video-call";
			}
			function initializeRoom(){
				$(".meet-area").addClass("mett-area-block");
				$(".back-vinh").addClass("back-none-vinh");
			    console.log("Creating Room")
			    let room = document.getElementById("room-input").value;
			  
			    
			    room_id = PRE + room + SUF;
			    peer = new Peer(room_id)
			    peer.on('open', (id) => {
			        console.log("Peer Connected with ID: ", id)
			        hideModal()
			        getUserMedia({ video: true, audio: true }, (stream) => {
			            local_stream = stream;
			            setLocalStream(local_stream)
			        }, (err) => {
			            console.log(err)
			        })
			        notify("Đợi một chút!.")
			    })
			    peer.on('call', (call) => {
			        call.answer(local_stream);
			        call.on('stream', (stream) => {
			            setRemoteStream(stream)
			        })
			        currentPeer = call;
			    })
				
			}

			function setLocalStream(stream) {

			    let video = document.getElementById("local-video");
			    video.srcObject = stream;
			    video.play();
			}
			function setRemoteStream(stream) {

			    let video = document.getElementById("remote-video");
			    video.srcObject = stream;
			    video.play();
			}

			function hideModal() {
			    document.getElementById("entry-modal").hidden = true
			}

			function notify(msg) {
			    let notification = document.getElementById("notification")
			    notification.innerHTML = msg
			    notification.hidden = false
			    setTimeout(() => {
			        notification.hidden = true;
			    }, 3000)
			}
			
			function joinRoom(roomcode) {
					let room1 = roomcode;
				
				if(room1 == "normaljoin"){
					 room1 = document.getElementById("room-input").value;
				}
				
				if (room1 == " " || room1 == "") {
					alert("Vui lòng nhập mã phòng để vào!")
			        return;
			    }
				$(".meet-area").addClass("mett-area-block")
				$(".back-vinh").addClass("back-none-vinh");
			    console.log("Joining Room")
			    room_id = PRE + room1 + SUF;
			    hideModal()
			    peer = new Peer()
			    peer.on('open', (id) => {
			        console.log("Connected with Id: " + id)
			        getUserMedia({ video: true, audio: true }, (stream) => {
			            local_stream = stream;
			            setLocalStream(local_stream)
			            notify("Joining peer")
			            let call = peer.call(room_id, stream)
			            call.on('stream', (stream) => {
			                setRemoteStream(stream);
			            })
			            currentPeer = call;
			        }, (err) => {
			            console.log(err)
			        })

			    })
			}

			function startScreenShare() {
			    if (screenSharing) {
			        stopScreenSharing()
			    }
			    navigator.mediaDevices.getDisplayMedia({ video: true }).then((stream) => {
			        screenStream = stream;
			        let videoTrack = screenStream.getVideoTracks()[0];
			        videoTrack.onended = () => {
			            stopScreenSharing()
			        }
			        if (peer) {
			  
			            let sender = currentPeer.peerConnection.getSenders().find(function (s) {
			                return s.track.kind == videoTrack.kind;
			            })
			            sender.replaceTrack(videoTrack)
			            screenSharing = true;
			        }
			        console.log(screenStream)
			    })
			}

			function stopScreenSharing() {
			    if (!screenSharing) return;
			    let videoTrack = local_stream.getVideoTracks()[0];
			    if (peer) {
			        let sender = currentPeer.peerConnection.getSenders().find(function (s) {
			            return s.track.kind == videoTrack.kind;
			        })
			        sender.replaceTrack(videoTrack)
			    }
			    screenStream.getTracks().forEach(function (track) {
			        track.stop();
			    });
			    screenSharing = false
			}
		</script>



		<script type="text/javascript">
		

		
		function formatCash(str) {
		 	return str.split('').reverse().reduce((prev, next, index) => {
		 		return ((index % 3) ? next : (next + ',')) + prev
		 	})
		}
			function start(obj){
				$('#bot_send').text("");
				$('#bot_send').append('<div class="left"> Hello myself Hte, How can i help you?');
				
			}
			document.getElementById('sendtext').addEventListener("click", async (e) => {
				e.preventDefault();
					var req = document.getElementById('msg_send').value;
					if(req == undefined || req ==""){
						
					}else{
						var res ="";
						await axios.get(`https://api.monkedev.com/fun/chat?msg=`+req).then(data => {
							res = JSON.stringify(data.data.response)
						})
						let data_req = document.createElement('div');
						let data_res = document.createElement('div');

						let container1 = document.createElement('div');
						let container2 = document.createElement('div');

						container1.setAttribute("class","msgCon1");
						container2.setAttribute("class","msgCon2");

						data_req.innerHTML ="Me: "+ req ;
						data_res.innerHTML ="Bot: "+res ;


						data_req.setAttribute("class","right-chat");
						data_res.setAttribute("class","left-chat");

						let message = document.getElementById('msg_area');

						
						message.appendChild(container1);
						message.appendChild(container2);

						container1.appendChild(data_req);
						container2.appendChild(data_res);

						document.getElementById('msg_send').value = "";

					function scroll() {
						var scrollMsg = document.getElementById('msg_area')
						scrollMsg.scrollTop = scrollMsg.scrollHeight ;
					}
					scroll();
						
					}
				});
			//Chat
			function showBox(obj){
				

				var id = obj;
				var data = {};
				var formData = $('#form_chat' + id).serializeArray();
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				$.ajax({
					url : '/HutechSocialNetwork/api/chat',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					success : function(result) {
						$('#chat'+id).text("");
						$('#1content_chat'+id).text("");
					
						for ( var index in result) {
							if(result[index].source_id == ${User_Infor.id}){
							$('#1content_chat'+id).append(
									'<li class="me">'+
									'<div class="chat-thumb"><img src="'+result[index].user_avatar+'" alt=""></div>'+
										'<div class="notification-event">'+
											'<span class="chat-message-item">'+result[index].content+'</span>'+
											'<span class="notification-date"><time datetime="2004-07-24T18:18" class="entry-date updated">'+result[index].date+'</time></span>'+
										'</div>'+
									'</li>'
							);

							
							}else{
								
								$('#1content_chat'+id).append(
										'<li class="you">'+
										'<div class="chat-thumb"><img src="'+result[index].friend_avatar+'" alt=""></div>'+
											'<div class="notification-event">'+
												'<span class="chat-message-item">'+result[index].content+'</span>'+
												'<span class="notification-date"><time datetime="2004-07-24T18:18" class="entry-date updated">'+result[index].date+'</time></span>'+
											'</div>'+
										'</li>'
								);

							}
							
						}
						
						$("#_chat"+id).addClass("show");
					},
					error : function(error) {
						alert("Thất bại!!!");
					}
				});
			}
      
			//DeletePost
			function delete_post(obj) {
				var id = obj;
				
				  var status = confirm("Bạn muốn xóa bài viết này!!!");
				  
				  if (status == true) {
					  
						
						var id = obj;
						var data = {};
						var formData = $('#formDeletePost' + id).serializeArray();
						$.each(formData, function(i, v) {
							data["" + v.name + ""] = v.value;
						});
						$.ajax({
							url : '/HutechSocialNetwork/api/post',
							type : 'DELETE',
							contentType : 'application/json',
							data : JSON.stringify(data),
							success : function(result) {
								$('#postA'+id).text("Bài viết #"+id+" đã xóa");

							},
							error : function(error) {
								alert("Thất bại!!!");
							}
						});
					  
					  
				  } else {
				 
				  }

				}
			
			//CommetPost
			function comment_click(obj) {
				
				var id = obj;
				var data = {};
				var formData = $('#form_CommentPos' + id).serializeArray();
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				$.ajax({
					url : '/HutechSocialNetwork/api/comment',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					success : function(result) {
						$('#comment_pos'+id).text("");
						var x = 0;

						$('#item_commen'+id).text("");
						for ( var index in result) {
							x+=1;
							$('#item_commen'+id).append(
									'<li> <div class="comet-avatar">'+
									'<img src="'+result[index].avatarUser+'" alt="">'+
								'</div>'+
								'<div class="we-comment">'+
									'<h5>'+
										'<a href="time-line.html" title="">'+result[index].nameUser+'</a>'+
								'	</h5>'+
									'<p>'+result[index].content+'</p>'+
									'<div class="inline-itms">'+
									'<span>'+result[index].date+'</span> <a class="we-reply" href="#"'+
											'title="Reply"><i class="fa fa-reply"></i></a> <a'+
											'href="#" title=""><i class="fa fa-heart"></i><span>20</span></a>'+
									'</div>'+
								'</div>'+
							'</li>'
							)
							
						}
						$('#comment_pos'+id).append(''+x+'');
						

					},
					error : function(error) {
						alert("Thất bại!!!");
					}
				});

			}
			function search_AddFriend(obj){
				var id = obj;
				var data = {};
				var formData = $('#form'+id)
						.serializeArray();
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				$.ajax({
					url : '/HutechSocialNetwork/api/friend',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					success : function(result) {
						alert("Đã gửi lời mời kết bạn!!!");
						$('#a'+id).text("");
						$('#a'+id).append(
								'<a><i class="fa fa-user-plus"></i><span>Chờ xác nhận</span></a>'

						);
					},
					error : function(error) {
						alert("Kết bạn thất bại!!!");
					}
				});
			}
			//
			function like_click(obj) {

				var id = obj;
				var data = {};
				var formData = $('#form_LikePost' + id).serializeArray();
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				$.ajax({
					url : '/HutechSocialNetwork/api/like',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					success : function(result) {
						$('#like_post' + id).text("");
						if (result.status > 0) {
							$('#like_post' + id).append(
									' ' + result.amount + ' '

							);
						} else {
							$('#like_post' + id).append(
									'Đã thích  ' + result.amount + ' '

							);
						}

					},
					error : function(error) {
						alert("Thất bại!!!");
					}
				});

			}

			//Searchfriend
			$('#btnSearch')
					.click(
							function(e) {
								e.preventDefault();
								var data = {};
								var formData = $('#form_SearchFriend')
										.serializeArray();
								$.each(formData, function(i, v) {
									data["" + v.name + ""] = v.value;
								});
								$
										.ajax({
											url : '/HutechSocialNetwork/api/friend/search',
											type : 'POST',
											contentType : 'application/json',
											data : JSON.stringify(data),
											success : function(result) {
												$('#my_frieng_div').text("");
												for ( var index in result) {
													$('#my_frieng_div')
															.append(
																	'<div class="col-lg-4 col-md-6 col-sm-6">'
																			+ '<div class="friend-block">'
																			+ '<div class="more-opotnz">'
																			+ '<i class="fa fa-ellipsis-h"></i>'
																			+ '<ul>'
																			+ '<li><a href="#" title="">Block</a></li>'
																			+ '<li><a href="#" title="">UnBlock</a></li>'
																			+ '<li><a href="#" title="">Mute Notifications</a></li>'
																			+ '<li><a href="#" title="">hide from friend list</a></li>'
																			+ '</ul>'
																			+ '</div>'
																			+ '<figure>'
																			+ '<img src="'+result[index].avatar+'" alt="">'
																			+ '</figure>'
																			+

																			'<div class="frnd-meta">'
																			+ '<div  class="frnd-name">'
																			+ '<a href="http://localhost:8080/HutechSocialNetwork/user/time-line/'+result[index].id+'" title="">'
																			+ result[index].name
																			+ '</a>'
																			+

																			'<span>Khoa '
																			+ result[index].faculty_name
																			+ '</span>'
																			+

																			'<span>Ngày tạo: '
																			+ result[index].createAt
																			+ '</span> <span>Email: '
																			+ result[index].email
																			+ '</span>'
																			+ '</div>'
																			+ '<a class="send-mesg" href="#" title="">Message</a>'
																			+

																			'</div>'
																			+ '</div>'
																			+ '</div>');
												}

											},
											error : function(error) {
												alert("Tìm kiếm thất bại!!!");
											}
										});
							});
			//Unfriend
			function unfriend(obj){
				var id = obj;
				var data = {};
				var formData = $('#formUnfriend'+id)
						.serializeArray();
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				$
						.ajax({
							url : '${unfriendAPI}',
							type : 'DELETE',
							contentType : 'application/json',
							data : JSON.stringify(data),
							success : function(result) {
								alert("Hủy kết bạn thành công!!!");
								$('#status'+id).text("");
								$('#status'+id).append(
										
										' <form:form method="POST" role="form" id="form${details_user.id}" modelAttribute="user1">'+
																'<form:input type="hidden" value="${details_user.id}" path="id" />'+
																'<button class="btn-vinh" id="${details_user.id}" onClick="addfriend_timeline(this.id)"'+
																'type="button">Kết bạn</button>'+
															'</form:form>'
										);
							},
							error : function(error) {
								alert("Hủy kết bạn thất bại!!!");
							}
						});
				
			}
			//AcceptFriend
			
			function acceptFriend(obj){
				var id = obj;
				var data = {};
				var formData = $('#formAccept_timeline'+id)
						.serializeArray();
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				$
						.ajax({
							url : '/HutechSocialNetwork/api/friend',
							type : 'PUT',
							contentType : 'application/json',
							data : JSON.stringify(data),
							success : function(result) {
								alert("Đã gửi lời mời kết bạn!!!");
								$('#area_'+id).text("");
								$('#area_'+id)
										.append(

												'<li class="add-tofrndlist" ><a  title="Add friend" href="#"><i class="fa fa-user-plus">Bạn bè</i></a></li>'+
												'<li class="remove-frnd"><a title="Send Message" href="#"><i class="fa fa-comment"></i></a></li>'

										);
							},
							error : function(error) {
								alert("Chấp nhận thất bại!!!");
							}
						});
			}
			
			$('#formAccept_timeline')
					.click(
							function(e) {
								e.preventDefault();
								var data = {};
								var formData = $('#formAccept_timeline')
										.serializeArray();
								$.each(formData, function(i, v) {
									data["" + v.name + ""] = v.value;
								});
								$
										.ajax({
											url : '/HutechSocialNetwork/api/friend',
											type : 'PUT',
											contentType : 'application/json',
											data : JSON.stringify(data),
											success : function(result) {
												alert("Đã gửi lời mời kết bạn!!!");
												$('#status_Friend').text("");
												$('#status_Friend')
														.html(

																'<span>Bạn bè</span>'
																		+ '<button class="post-btn hover_addfriend_vinh" type="button" id="btnUnfriend">Hủy kết bạn</button>'

														);
											},
											error : function(error) {
												alert("Chấp nhận thất bại!!!");
											}
										});
							});
			//AddFriend
			function addfriend_timeline(obj){
				var id = obj;
				var data = {};
				var formData = $('#form'+id)
						.serializeArray();
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				$.ajax({
					url : '/HutechSocialNetwork/api/friend',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					success : function(result) {
						alert("Đã gửi lời mời kết bạn!!!");
						$('#status'+id).text("");
						$('#status'+id).append(
								'<span>Chờ xác nhận</span>'

						);
					},
					error : function(error) {
						alert("Kết bạn thất bại!!!");
					}
				});
			
			}
			//EditQuantityCart
			function EditQuantityCart(obj){
				var id = obj;
				var quantity = $("#quantity-"+id).val();
				window.location ="editcart/"+id+"/"+quantity;
			}
			
		
		</script>
		<script>
			jQuery(document)
					.ready(
							function($) {

								//-----------------
								$('#us3')
										.locationpicker(
												{
													location : {
														latitude : -8.681013,
														longitude : 115.23506410000005
													},
													radius : 0,
													inputBinding : {
														latitudeInput : $('#us3-lat'),
														longitudeInput : $('#us3-lon'),
														radiusInput : $('#us3-radius'),
														locationNameInput : $('#us3-address')
													},
													enableAutocomplete : true,
													onchanged : function(
															currentLocation,
															radius,
															isMarkerDropped) {
														// Uncomment line below to show alert on each Location Changed event
														//alert("Location changed. New location (" + currentLocation.latitude + ", " + currentLocation.longitude + ")");
													}
												});

								if ($.isFunction($.fn.toast)) {
									$.toast({
										heading : 'Welcome To Pitnik',
										text : '',
										showHideTransition : 'slide',
										icon : 'success',
										loaderBg : '#fa6342',
										position : 'bottom-right',
										hideAfter : 3000,
									});

									$
											.toast({
												heading : 'Information',
												text : 'Now you can full demo of pitnik and hope you like',
												showHideTransition : 'slide',
												icon : 'info',
												hideAfter : 5000,
												loaderBg : '#fa6342',
												position : 'bottom-right',
											});
									$
											.toast({
												heading : 'Support & Help',
												text : 'Report any <a href="#">issues</a> by email',
												showHideTransition : 'fade',
												icon : 'error',
												hideAfter : 7000,
												loaderBg : '#fa6342',
												position : 'bottom-right',
											});
								}

							});
		</script>
</body>


</html>