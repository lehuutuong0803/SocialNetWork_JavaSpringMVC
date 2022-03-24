<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<c:url var="ViewProfile"
	value="http://localhost:8080/HutechSocialNetwork/user/time-line/${User_Infor.id}" />
<c:url var="LogOut"
	value="http://localhost:8080/HutechSocialNetwork/" />
<c:url var="Search"
	value="http://localhost:8080/HutechSocialNetwork/user/search" />

<div class="topbar stick">
		<div class="logo">
			<a title="" href="http://localhost:8080/HutechSocialNetwork/user/home"><img class="img-logo-vinh" src="https://res.cloudinary.com/dbjjh1p4j/image/upload/v1638019082/keaxjifni7ygdct9mdwp.png" alt=""></a>
		</div>
		<div class="top-area">
			<div class="main-menu">
				<span>
			    	<i class="fa fa-braille"></i>
			    </span>
			</div>
			<div class="top-search">
			
				<form:form action="${Search}" method="POST" role="form" modelAttribute="user_friend">
					<form:input type="text" path="name" />
					<button type="submit" data-ripple><i class="ti-search"></i></button>
				</form:form>
				
			</div>
			<div class="page-name">
			    <span >Trang Chủ</span>
			 </div>
			<ul class="setting-areas">
				<li><a href="http://localhost:8080/HutechSocialNetwork/user/home" title="Home" data-ripple=""><i class="fa fa-home"></i></a></li>
				<li>
					<a href="http://localhost:8080/HutechSocialNetwork/user/addfriend-page" title="Friend Requests" data-ripple="">
						<i   class="fa fa-user"></i>
					</a>
					
				</li>
				
				<li>
					<a href="#" title="Notification" data-ripple="">
						<i class="fa fa-bell"></i>
					</a>
					<div class="dropdowns">
						<span>4 New Notifications <a href="#" title="">Mark all as read</a></span>
						<ul class="drops-menu">
							<li>
								<a href="notifications.html" title="">
									<figure>
										<img src="..//assets/images/resources/thumb-1.jpg" alt="">
										<span class="status f-online"></span>
									</figure>
									<div class="mesg-meta">
										<h6>sarah Loren</h6>
										<span>commented on your new profile status</span>
										<i>2 min ago</i>
									</div>
								</a>
							</li>
							<li>
								<a href="notifications.html" title="">
									<figure>
										<img src="..//assets/images/resources/thumb-2.jpg" alt="">
										<span class="status f-online"></span>
									</figure>
									<div class="mesg-meta">
										<h6>Jhon doe</h6>
										<span>Nicholas Grissom just became friends. Write on his wall.</span>
										<i>4 hours ago</i>
										<figure>
											<span>Today is Marina Valentine’s Birthday! wish for celebrating</span>
											<img src="..//assets/images/birthday.png" alt="">
										</figure>
									</div>
								</a>
							</li>
							<li>
								<a href="notifications.html" title="">
									<figure>
										<img src="..//assets/images/resources/thumb-3.jpg" alt="">
										<span class="status f-online"></span>
									</figure>
									<div class="mesg-meta">
										<h6>Andrew</h6>
										<span>commented on your photo.</span>
										<i>Sunday</i>
										<figure>
											<span>"Celebrity looks Beautiful in that outfit! We should see each"</span>
											<img src="..//assets/images/resources/admin.jpg" alt="">
										</figure>
									</div>
								</a>
							</li>
							<li>
								<a href="notifications.html" title="">
									<figure>
										<img src="..//assets/images/resources/thumb-4.jpg" alt="">
										<span class="status f-online"></span>
									</figure>
									<div class="mesg-meta">
										<h6>Tom cruse</h6>
										<span>nvited you to attend to his event Goo in</span>
										<i>May 19</i>
									</div>
								</a>
								<span class="tag">New</span>
							</li>
							<li>
								<a href="notifications.html" title="">
									<figure>
										<img src="..//assets/images/resources/thumb-5.jpg" alt="">
										<span class="status f-online"></span>
									</figure>
									<div class="mesg-meta">
										<h6>Amy</h6>
										<span>Andrew Changed his profile picture. </span>
										<i>dec 18</i>
									</div>
								</a>
								<span class="tag">New</span>
							</li>
						</ul>
						<a href="notifications.html" title="" class="more-mesg">View All</a>
					</div>
				</li>
				<li>
					<a href="#" title="Messages" data-ripple=""><i class="fa fa-commenting"></i>
					<div class="dropdowns">
						<span>5 New Messages <a href="#" title="">Mark all as read</a></span>
						<ul class="drops-menu">
							<li>
								<a class="show-mesg" href="#" title="">
									<figure>
										<img src="..//assets/images/resources/thumb-1.jpg" alt="">
										<span class="status f-online"></span>
									</figure>
									<div class="mesg-meta">
										<h6>sarah Loren</h6>
										<span><i class="ti-check"></i> Hi, how r u dear ...?</span>
										<i>2 min ago</i>
									</div>
								</a>
							</li>
							<li>
								<a class="show-mesg" href="#" title="">
									<figure>
										<img src="..//assets/images/resources/thumb-2.jpg" alt="">
										<span class="status f-offline"></span>
									</figure>
									<div class="mesg-meta">
										<h6>Jhon doe</h6>
										<span><i class="ti-check"></i> We’ll have to check that at the office and see if the client is on board with</span>
										<i>2 min ago</i>
									</div>
								</a>
							</li>
							<li>
								<a class="show-mesg" href="#" title="">
									<figure>
										<img src="..//assets/images/resources/thumb-3.jpg" alt="">
										<span class="status f-online"></span>
									</figure>
									<div class="mesg-meta">
										<h6>Andrew</h6>
										<span> <i class="fa fa-paperclip"></i>Hi Jack's! It’s Diana, I just wanted to let you know that we have to reschedule..</span>
										<i>2 min ago</i>
									</div>
								</a>
							</li>
							<li>
								<a class="show-mesg" href="#" title="">
									<figure>
										<img src="..//assets/images/resources/thumb-4.jpg" alt="">
										<span class="status f-offline"></span>
									</figure>
									<div class="mesg-meta">
										<h6>Tom cruse</h6>
										<span><i class="ti-check"></i> Great, I’ll see you tomorrow!.</span>
										<i>2 min ago</i>
									</div>
								</a>
								<span class="tag">New</span>
							</li>
							<li>
								<a class="show-mesg" href="#" title="">
									<figure>
										<img src="..//assets/images/resources/thumb-5.jpg" alt="">
										<span class="status f-away"></span>
									</figure>
									<div class="mesg-meta">
										<h6>Amy</h6>
										<span><i class="fa fa-paperclip"></i> Sed ut perspiciatis unde omnis iste natus error sit </span>
										<i>2 min ago</i>
									</div>
								</a>
								<span class="tag">New</span>
							</li>
						</ul>
						<a href="chat-messenger.html" title="" class="more-mesg">View All</a>
					</div>
				</li>
				<li><a href="#" title="Languages" data-ripple=""><i class="fa fa-globe"></i><em>VN</em></a>
					<div class="dropdowns languages">
						<div data-gutter="10" class="row">
							<div class="col-md-3">
							  <ul class="dropdown-meganav-select-list-lang">
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/UK.png">English(UK)
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/US.png">English(US)
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/DE.png">Deutsch
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/NED.png">Nederlands
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/FR.png">Français
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/SP.png">Español
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/ARG.png">Español (AR)
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/IT.png">Italiano
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/PT.png">Português (PT)
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/BR.png">Português (BR)
								  </a>
								</li>

							  </ul>
							</div>
							<div class="col-md-3">
							  <ul class="dropdown-meganav-select-list-lang">
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/FIN.png">Suomi
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/SW.png">Svenska
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/DEN.png">Dansk
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/CZ.png">Čeština
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/HUN.png">Magyar
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/ROM.png">Română
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/JP.png">日本語
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/CN.png">简体中文
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/PL.png">Polski
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/GR.png">Ελληνικά
								  </a>
								</li>

							  </ul>
							</div>
							<div class="col-md-3">
							  <ul class="dropdown-meganav-select-list-lang">
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/TUR.png">Türkçe
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/BUL.png">Български
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/ARB.png">العربية
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/KOR.png">한국어
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/ISR.png">עברית
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/LAT.png">Latviski
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/UKR.png">Українська
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/IND.png">Bahasa Indonesia
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/MAL.png">Bahasa Malaysia
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/TAI.png">ภาษาไทย
								  </a>
								</li>

							  </ul>
							</div>
							<div class="col-md-3">
							  <ul class="dropdown-meganav-select-list-lang">
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/CRO.png">Hrvatski
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/LIT.png">Lietuvių
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/SLO.png">Slovenčina
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/SERB.png">Srpski
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/SLOVE.png">Slovenščina
								  </a>
								</li>
								<li class="active">
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/NAM.png">Tiếng Việt
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/PHI.png">Filipino
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/ICE.png">Íslenska
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/EST.png">Eesti
								  </a>
								</li>
								<li>
								  <a href="#">
									<img title="Image Title" alt="Image Alternative text" src="..//assets/images/flags/RU.png">Русский
								  </a>
								</li>
							  </ul>
							</div>
						  </div>
					</div>
				</li>
			</ul>
			<!-- Setting -->
			<div class="user-img">
				<c:if test="${ not empty User_Infor }">
						<h5>${User_Infor.name }</h5>
				</c:if>
				<img class="img-avatar-vinh" src="${User_Infor.avatar}">
				<!-- <img src="..//assets/images/resources/admin.jpg">  -->
				<span class="status f-online"></span>
				<div class="user-setting">
					
					<ul class="log-out">
						<li><a href="${ViewProfile}" title=""><i class="ti-user"></i> Trang cá nhân</a></li>
						<li><a href="setting.html" title=""><i class="ti-pencil-alt"></i>Chỉnh sửa thông tin</a></li>
						<li><a href="http://localhost:8080/HutechSocialNetwork/user/cart" title=""><i class="ti-pencil-alt"></i>Giỏ hàng</a></li>
						<li><a href="http://localhost:8080/HutechSocialNetwork/user/insert-product" title=""><i class="ti-pencil-alt"></i>Quản lý sản phẩm</a></li>
						<li><a href="http://localhost:8080/HutechSocialNetwork/user/purchase-history" title=""><i class="ti-pencil-alt"></i>Lịch sử mua hàng</a></li>
						<li><a href="http://localhost:8080/HutechSocialNetwork/user/selled" title=""><i class="ti-pencil-alt"></i>Quản lý hóa đơn</a></li>
						<li><a href="${LogOut}" title=""><i class="ti-power-off"></i>Đăng xuất</a></li>
					</ul>
				</div>
			</div>
			<span class="ti-settings main-menu" data-ripple=""></span>
		</div>
		<nav>
			<ul class="nav-list">
				<li><a class="" href="#" title=""><i class="fa fa-home"></i> Home Pages</a>
					<ul>
						<li><a href="index.html" title="">Pitnik Default</a></li>
						<li><a href="company-landing.html" title="">Company Landing</a></li>
						<li><a href="pitrest.html" title="">Pitrest</a></li>
						<li><a href="redpit.html" title="">Redpit</a></li>
						<li><a href="redpit-category.html" title="">Redpit Category</a></li>
						<li><a href="soundnik.html" title="">Soundnik</a></li>
						<li><a href="soundnik-detail.html" title="">Soundnik Single</a></li>
						<li><a href="career.html" title="">Pitjob</a></li>
						<li><a href="shop.html" title="">Shop</a></li>
						<li><a href="classified.html" title="">Classified</a></li>
						<li><a href="pitpoint.html" title="">PitPoint</a></li>
						<li><a href="pittube.html" title="">Pittube</a></li>
						<li><a href="chat-messenger.html" title="">Messenger</a></li>
					</ul>
				</li>
				<li><a class="" href="#" title=""><i class="fa fa-film"></i> Pittube</a>
					<ul>
						<li><a href="pittube.html" title="">Pittube</a></li>
						<li><a href="pittube-detail.html" title="">Pittube single</a></li>
						<li><a href="pittube-category.html" title="">Pittube Category</a></li>
						<li><a href="pittube-channel.html" title="">Pittube Channel</a></li>
						<li><a href="pittube-search-result.html" title="">Pittube Search Result</a></li>
					</ul>
				</li>
				<li><a class="" href="#" title=""><i class="fa fa-female"></i> PitPoint</a>
					<ul>
						<li><a href="pitpoint.html" title="">PitPoint</a></li>
						<li><a href="pitpoint-detail.html" title="">Pitpoint Detail</a></li>
						<li><a href="pitpoint-list.html" title="">Pitpoint List style</a></li>
						<li><a href="pitpoint-without-baner.html" title="">Pitpoint without Banner</a></li>
						<li><a href="pitpoint-search-result.html" title="">Pitpoint Search</a></li>
					</ul>
				</li>
				<li><a class="" href="#" title=""><i class="fa fa-graduation-cap"></i> Pitjob</a>
					<ul>
						<li><a href="career.html" title="">Pitjob</a></li>
						<li><a href="career-detail.html" title="">Pitjob Detail</a></li>
						<li><a href="career-search-result.html" title="">Job seach page</a></li>
						<li><a href="social-post-detail.html" title="">Social Post Detail</a></li>
					</ul>
				</li>
				<li><a class="" href="#" title=""><i class="fa fa-repeat"></i> Timeline</a>
					<ul>
						<li><a href="timeline.html" title="">Timeline</a></li>
						<li><a href="timeline-photos.html" title="">Timeline Photos</a></li>
						<li><a href="timeline-videos.html" title="">Timeline Videos</a></li>
						<li><a href="timeline-groups.html" title="">Timeline Groups</a></li>
						<li><a href="timeline-friends.html" title="">Timeline Friends</a></li>
						<li><a href="timeline-friends2.html" title="">Timeline Friends-2</a></li>
						<li><a href="about.html" title="">Timeline About</a></li>
						<li><a href="blog-posts.html" title="">Timeline Blog</a></li>
						<li><a href="friends-birthday.html" title="">Friends' Birthday</a></li>
						<li><a href="newsfeed.html" title="">Newsfeed</a></li>
						<li><a href="search-result.html" title="">Search Result</a></li>
					</ul>
				</li>
				<li><a class="" href="#" title=""><i class="fa fa-heart"></i> Favourit Page</a>
					<ul>
						<li><a href="fav-page.html" title="">Favourit Page</a></li>
						<li><a href="fav-favers.html" title="">Fav Page Likers</a></li>
						<li><a href="fav-events.html" title="">Fav Events</a></li>
						<li><a href="fav-event-invitations.html" title="">Fav Event Invitations</a></li>
						<li><a href="event-calendar.html" title="">Event Calendar</a></li>
						<li><a href="fav-page-create.html" title="">Create New Page</a></li>
						<li><a href="price-plans.html" title="">Price Plan</a></li>
					</ul>
				</li>
				<li><a class="" href="#" title=""><i class="fa fa-forumbee"></i> Forum</a>
					<ul>
						<li><a href="forum.html" title="">Forum</a></li>
						<li><a href="forum-create-topic.html" title="">Forum Create Topic</a></li>
						<li><a href="forum-open-topic.html" title="">Forum Open Topic</a></li>
						<li><a href="forums-category.html" title="">Forum Category</a></li>
					</ul>
				</li>
				<li><a class="" href="#" title=""><i class="fa fa-star-o"></i> Featured</a>
					<ul>
						<li><a href="chat-messenger.html" title="">Messenger (Chatting)</a></li>
						<li><a href="notifications.html" title="">Notifications</a></li>
						<li><a href="badges.html" title="">Badges</a></li>
						<li><a href="faq.html" title="">Faq's</a></li>
						<li><a href="contribution.html" title="">Contriburion Page</a></li>
						<li><a href="manage-page.html" title="">Manage Page</a></li>
						<li><a href="weather-forecast.html" title="">weather-forecast</a></li>
						<li><a href="statistics.html" title="">Statics/Analytics</a></li>
						<li><a href="shop-cart.html" title="">Shop Cart</a></li>
					</ul>
				</li>
				<li><a class="" href="#" title=""><i class="fa fa-gears"></i> Account Setting</a>
					<ul>
						<li><a href="setting.html" title="">Setting</a></li>
						<li><a href="privacy.html" title="">Privacy</a></li>
						<li><a href="support-and-help.html" title="">Support & Help</a></li>
						<li><a href="support-and-help-detail.html" title="">Support Detail</a></li>
						<li><a href="support-and-help-search-result.html" title="">Support Search</a></li>
					</ul>
				</li>
				<li><a class="" href="#" title=""><i class="fa fa-lock"></i> Authentication</a>
					<ul>
						<li><a href="login.html" title="">Login Page</a></li>
						<li><a href="register.html" title="">Register Page</a></li>
						<li><a href="logout.html" title="">Logout Page</a></li>
						<li><a href="coming-soon.html" title="">Coming Soon</a></li>
						<li><a href="error-404.html" title="">Error 404</a></li>
						<li><a href="error-404-2.html" title="">Error 404-2</a></li>
						<li><a href="error-500.html" title="">Error 500</a></li>
					</ul>
				</li>
				<li><a class="" href="#" title=""><i class="fa fa-wrench"></i> Tools</a>
					<ul>
						<li><a href="typography.html" title="">Typography</a></li>
						<li><a href="popup-modals.html" title="">Popups/Modals</a></li>
						<li><a href="post-versions.html" title="">Post Versions</a></li>
						<li><a href="sliders.html" title="">Sliders / Carousel</a></li>
						<li><a href="google-map.html" title="">Google Maps</a></li>
						<li><a href="widgets.html" title="">Widgets</a></li>
					</ul>
				</li>
			</ul>
			
		</nav><!-- nav menu -->
	</div><!-- topbar -->
	
	
	<div class="fixed-sidebar right">
	
		<div class="button-vinh-show-chat">
			<button id="connect" style="letter-spacing: 0.3rem;font-size: 20px;"  class="btn-show-chat"  >Bạn Bè</button>
		</div>
	
		<div class="chat-friendz">
		<!-- Chat -->
			<ul class="chat-users" id="chat_area">
			<c:forEach var="item_friend" items="${MyFriend}">
			<!-- User -->
			<form:form method="POST" id="form_chatbox${item_friend.id+User_Infor.id}" role="form" modelAttribute="chat">
			
			<form:input type="hidden" value="${item_friend.id+User_Infor.id}" path="box_id" />
			<li style="display: flex;
    align-items: center;
    margin-bottom: 10px;" id="box${item_friend.id+User_Infor.id}" onclick="showBox(this.id)" type="button">
					<div class="author-thmb">
						<img class="img-mess-vinh" id="${item_friend.id+User_Infor.id}" src="${item_friend.avatar}" alt="">
						<span class="status-vinh f-online"></span>
					</div>
					<div class="name-vinh">
						<span>${item_friend.name}</span>
					</div>
			
			</li>
			</form:form>
			<!-- User -->
			<!-- Chat box -->
			<div id="_chatbox${item_friend.id+User_Infor.id}" class="chat-vinh">
				<div class="chat-head">
					<span class="status f-online"></span>
					<h6>${item_friend.name}</h6>
					<div class="more">
						<div class="more-optns"><i class="ti-more-alt"></i>
							<ul>
								<li>block chat</li>
								<li>unblock chat</li>
								<li>conversation</li>
							</ul>
						</div>
						<span class="close-mesage"><i class="ti-close"></i></span>
					</div>
				</div>
				<div  id="content_chatbox${item_friend.id+User_Infor.id}" class="chat-list">
				
					<ul id="1content_chatbox${item_friend.id+User_Infor.id}">
						<li class="me">
							<div class="chat-thumb"><img src="${User_Infor.avatar}" alt=""></div>
							<div class="notification-event">
								<span class="chat-message-item">
									HI, Jack i have faced a problem with your software. are you available now, when i install this i have to received an error.
								</span>
								<span class="notification-date"><time datetime="2004-07-24T18:18" class="entry-date updated">Today at 2:12pm</time></span>
							</div>
						</li>
						<li class="you">
							<div class="chat-thumb"><img src="${item_friend.avatar}" alt=""></div>
							<div class="notification-event">
								<span class="chat-message-item">
									Hi tina, Please let me know your purchase code, and show me the screnshot of error.
								</span>
								<span class="notification-date"><time datetime="2004-07-24T18:18" class="entry-date updated">Today at 2:14pm</time></span>
							</div>
						</li>
						
					</ul>
					
				
						<textarea id="contentMessage${item_friend.id+User_Infor.id}" placeholder="Hãy nhập tin nhắn" ></textarea>
						<input id="userMessage${item_friend.id+User_Infor.id}" type="hidden" value="${User_Infor.id}" />
						<input id="friendMessage${item_friend.id+User_Infor.id}" type="hidden" value="${item_friend.id}" />
						<input id="boxMessage${item_friend.id+User_Infor.id}" type="hidden" value="${item_friend.id+User_Infor.id}"/>
						
						<div class="add-smiles-1">
							<span title="add icon" class="em em-expressionless"></span>
							<div class="smiles-bunch">
								<i class="em em---1"></i>
								<i class="em em-smiley"></i>
								<i class="em em-anguished"></i>
								<i class="em em-laughing"></i>
								<i class="em em-angry"></i>
								<i class="em em-astonished"></i>
								<i class="em em-blush"></i>
								<i class="em em-disappointed"></i>
								<i class="em em-worried"></i>
								<i class="em em-kissing_heart"></i>
								<i class="em em-rage"></i>
								<i class="em em-stuck_out_tongue"></i>
							</div>
						</div>
						<div>
						<button id="Message${item_friend.id+User_Infor.id}" class="btn-show-chat-1" onClick=" sendMessage(this.id)" type="button">Gửi</button>
						</div>

				</div>
			</div>
			
			<!-- Chat box -->
			</c:forEach>
			</ul>
		<!-- /Chat -->
			
			<div>
				<a href="https://www.freepik.com" title="Freepik">Freepik</a> from 
				<a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a>
			</div>
			
		</div>	
	</div><!-- right sidebar user chat -->