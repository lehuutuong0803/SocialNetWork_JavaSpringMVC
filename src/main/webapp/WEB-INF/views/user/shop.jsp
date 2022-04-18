<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<c:url var="PostURL"
	value="http://localhost:8080/HutechSocialNetwork/user/post" />
		<c:url var="edit_PostURL"
	value="http://localhost:8080/HutechSocialNetwork/user/edit-post" />
		<c:url var="edit_Avatar"
	value="http://localhost:8080/HutechSocialNetwork/user/edit-avatar" />
<%!int data = 0;%>
<section>
	<div class="gap2 gray-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="row merged20" id="page-contents">
						<div class="user-profile">
							<figure>
								<div class="edit-pp">
									<label class="fileContainer"> <i class="fa fa-camera"></i>
										<input type="file">
									
									</label>
								</div>
								<img class="logo-avartar-about-vinh" src="https://i.imgur.com/GN4sfZ9.jpg"
									alt="">
								<ul class="profile-controls">
									<li><a href="#" title="Add friend" data-toggle="tooltip"><i
											class="fa fa-user-plus"></i></a></li>
									<li><a href="#" title="Follow" data-toggle="tooltip"><i
											class="fa fa-star"></i></a></li>
									<li><a class="send-mesg" href="#" title="Send Message"
										data-toggle="tooltip"><i class="fa fa-comment"></i></a></li>
									<li>
										<div class="edit-seting" title="Edit Profile image">
											<i class="fa fa-sliders"></i>
											<ul class="more-dropdown">
												<li><a href="setting.html" title="">Update Profile
														Photo</a></li>
												<li><a href="setting.html" title="">Update Header
														Photo</a></li>
												<li><a href="setting.html" title="">Account
														Settings</a></li>
												<li><a href="support-and-help.html" title="">Find
														Support</a></li>
												<li><a class="bad-report" href="#" title="">Report
														Profile</a></li>
												<li><a href="#" title="">Block Profile</a></li>
											</ul>
										</div>
									</li>
								</ul>
								<ol class="pit-rate">
									<li class="rated"><i class="fa fa-star"></i></li>
									<li class="rated"><i class="fa fa-star"></i></li>
									<li class="rated"><i class="fa fa-star"></i></li>
									<li class="rated"><i class="fa fa-star"></i></li>
									<li class=""><i class="fa fa-star"></i></li>
									<li><span>4.7/5</span></li>
								</ol>
							</figure>

							<div class="profile-section">
								<div class="row">
									<div class="col-lg-2 col-md-3">
										<div class="profile-author">
											<div class="profile-author-thumb">
												<img alt="author" src="${details_user.avatar}">
												<div class="edit-dp">
													
														<c:if test="${details_user.id == User_Infor.id}">
														<label class="fileContainer"> <i
														class="fa fa-camera"></i> 
														<form:form action="${edit_Avatar}" method="POST"
														 modelAttribute="user1"  enctype="multipart/form-data">
															<form:input type="hidden" value="${User_Infor.id}" path="id"/>
															<form:input type="file" path="file"/>
															<button type="submit">Đổi</button>
														</form:form>
														</label>
														
														</c:if>
														
														
													
												</div>
											</div>

											<div class="author-content">
												<a class="h4 author-name" href="about.html">${details_user.name}</a>
												<div class="country">Khoa ${ faculty1}</div>
											</div>
										</div>
									</div>
									<div class="col-lg-10 col-md-9">
										<ul class="profile-menu">
											<li><a 
												href="http://localhost:8080/HutechSocialNetwork/user/time-line/${details_user.id}">Dòng
													thời gian</a></li>
											<li><a class=""
												href="http://localhost:8080/HutechSocialNetwork/user/about/${details_user.id}">Thông
													tin</a></li>
											<li><a class=""
												href="http://localhost:8080/HutechSocialNetwork/user/friends-of/${details_user.id}">Bạn
													bè</a></li>
													<li><a class="active"
												href="http://localhost:8080/HutechSocialNetwork/user/shop/${details_user.id}">Cửa hàng</a></li>
										
											<li>
												<div class="more">
													<i class="fa fa-ellipsis-h"></i>
													<ul class="more-dropdown">
														<li><a href="timeline-groups.html">Profile Groups</a>
														</li>
														<li><a href="statistics.html">Profile Analytics</a></li>
													</ul>
												</div>
											</li>
										</ul>
										<ol class="folw-detail">
											<!-- Status Friend -->
											<c:set var="status_friend" scope="session" value="${0}" />
											<c:set var="status_follower" scope="session" value="${0}" />

											<li id="status${details_user.id}">
											<c:forEach var="item_friend" items="${MyFriend}">

													<c:if
														test="${details_user.id == item_friend.id && details_user.id != User_Infor.id }">
														<span>Bạn bè</span>
														<ins>

															<form:form method="DELETE" id="formUnfriend${details_user.id}" role="form" modelAttribute="user1">
																<form:input type="hidden" path="id" value="${details_user.id}" />
																<button class="post-btn hover_addfriend_vinh" onClick="unfriend(this.id)" type="button" id="${details_user.id}">Hủy kết bạn</button>
															</form:form>

														</ins>
														<c:set var="status_friend" scope="session" value="${1}" />
													</c:if>

												</c:forEach> <c:if
													test="${status_friend ==0 && details_user.id != User_Infor.id }">
													<c:forEach var="item_follower" items="${MyFollower}">

														<c:if
															test="${details_user.id == item_follower.id && details_user.id != User_Infor.id }">
															<span>
															
															<form:form method="PUT" role="form" id="formAccept_timeline" modelAttribute="user1">
																<form:input type="hidden" value="${details_user.id}" path="id" />
																<button type="submit" id = "Accept_timeline">Chấp nhận</button>
															</form:form>
															
															 </span>
															<c:set var="status_follower" scope="session" value="${1}" />
														</c:if>

													</c:forEach>
													<c:forEach var="item_follower" items="${Follower}">

														<c:if
															test="${details_user.id == item_follower.id && details_user.id != User_Infor.id }">
															<span>Chờ xác nhận</span>
															<c:set var="status_follower" scope="session" value="${1}" />
														</c:if>

													</c:forEach>
													<c:if
														test="${status_follower ==0 && details_user.id != User_Infor.id }">
														<span> <form:form method="POST" role="form" id="form${details_user.id}" modelAttribute="user1">
																<form:input type="hidden" value="${details_user.id}" path="id" />
																<button class="btn-vinh" id="${details_user.id}" onClick="addfriend_timeline(this.id)"
																type="button">Kết bạn</button>
															</form:form>
															
														</span>
													</c:if>
												</c:if></li>

											<!-- End Status Friend -->
										</ol>
									</div>
								</div>
							</div>
						</div>
						<!-- user profile banner  -->
						<div class="col-lg-3">
							<aside class="sidebar static left">
								<!-- badges -->
								<div class="widget">
									<div class="weather-widget low-opacity bluesh">
										<div class="bg-image"
											style="background-image: url(images/resources/weather.jpg)"></div>
										<span class="refresh-content"><i class="fa fa-refresh"></i></span>
										<div class="weather-week">
											<div class="icon sun-shower">
												<div class="cloud"></div>
												<div class="sun">
													<div class="rays"></div>
												</div>
												<div class="rain"></div>
											</div>
										</div>
										<div class="weather-infos">
											<span class="weather-tem">25</span>
											<h3>
												Cloudy Skyes<i>Sicklervilte, New Jersey</i>
											</h3>
											<div class="weather-date skyblue-bg">
												<span>MAY<strong>21</strong></span>
											</div>
										</div>
										<div class="monthly-weather">
											<ul>
												<li><span>Sun</span> <a href="#" title=""><i
														class="wi wi-day-sunny"></i></a> <em>40°</em></li>
												<li><span>Mon</span> <a href="#" title=""><i
														class="wi wi-day-cloudy"></i></a> <em>10°</em></li>
												<li><span>Tue</span> <a href="#" title=""><i
														class="wi wi-day-hail"></i></a> <em>20°</em></li>
												<li><span>Wed</span> <a href="#" title=""><i
														class="wi wi-day-lightning"></i></a> <em>34°</em></li>
												<li><span>Thu</span> <a href="#" title=""><i
														class="wi wi-day-showers"></i></a> <em>22°</em></li>
												<li><span>Fri</span> <a href="#" title=""><i
														class="wi wi-day-windy"></i></a> <em>26°</em></li>
												<li><span>Sat</span> <a href="#" title=""><i
														class="wi wi-day-sunny-overcast"></i></a> <em>30°</em></li>
											</ul>
										</div>

									</div>
									<!-- Weather Widget -->
								</div>
								<!-- recent activites -->
								
								<!-- who's following -->
							</aside>
						</div>
						<!-- sidebar -->
						<!-- sidebar -->
							<div class="col-lg-6">
								<!-- shop product post -->
								<!-- suggested friends -->

								<c:forEach var="item_product" items="${productList}">
								<div class="central-meta item">
										<div class="classic-post">
											<figure>
												<img style="width:135px;height:115px;" src="${item_product.image}" alt="">
												<span>Hàng tốt</span>
											</figure>
											<div class="classic-pst-meta">
												<div class="more">
													<div class="more-post-optns"><i class="ti-more-alt"></i>
														<ul>
															<li><i class="fa fa-pencil-square-o"></i>Chỉnh sửa</li>
															<li><i class="fa fa-trash-o"></i>Xóa</li>
														</ul>
													</div>
												</div>
												<h4><i class="fa fa-check-circle" title="verified"></i> <a href="http://localhost:8080/HutechSocialNetwork/user/detailed-product/${item_product.id}" title="">${item_product.product_name}</a></h4>
												<p>${item_product.note}</p>
												<span onchange="amount()" class="prise">${item_product.formatCurrency} ₫</span>
												<div class="location-area">
													<i>Ngày đăng: ${item_product.createat}</i>
														<button style="border: none;
						    										background-color: #fa6342;
																    border-radius: 30px;
																    color: #ffffff;"	 type="submit" id="${item_product.id}" onClick="addCart(this.id)" href="#" class="main-btn" title="">Thêm vào giỏ hàng</button>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
									<!-- shop product post -->
							</div><!-- centerl meta -->
							<!-- sidebar -->

						<!-- centerl meta -->
						<div class="col-lg-3">
							<aside class="sidebar static right">
								<!-- page like widget -->
								<div class="widget">
									<img src="../..//assets/images/slogan-hutech.png">
								</div>
								<div class="widget">
									<img src="../..//assets/images/slogan-hutech-1.png">
								</div>
								
								<!-- little links -->
							</aside>
						</div>
						<!-- sidebar -->
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- content -->
<!-- Modal -->
