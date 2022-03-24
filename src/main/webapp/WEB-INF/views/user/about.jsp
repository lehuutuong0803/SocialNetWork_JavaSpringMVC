<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<c:url var="newAPI" value="user/time-line/${details_user.id}"/>
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
								<!-- <img src="https://res.cloudinary.com/dbjjh1p4j/image/upload/v1635955131/ehi0kisng0lxoxlh4hva.jpg" alt=""> -->
								<img class="logo-avartar-about-vinh" alt="" src="https://i.imgur.com/GN4sfZ9.jpg">
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
													<label class="fileContainer"> <i
														class="fa fa-camera"></i> <input type="file">
													</label>
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
											<c:url var="TimeLineURL" value="time-line">
																	<c:param name="id" value="${details_user.id}"/>															
												</c:url>
												
											<li><a class="" href="http://localhost:8080/HutechSocialNetwork/user/time-line/${details_user.id}">Dòng thời gian</a></li>
											<li><a class="active" href="http://localhost:8080/HutechSocialNetwork/user/about/${details_user.id}">Thông tin</a></li>
											<li><a class="" href="http://localhost:8080/HutechSocialNetwork/user/friends-of/${details_user.id}">Bạn bè</a>
											<li><a class=""
												href="http://localhost:8080/HutechSocialNetwork/user/shop/${details_user.id}">Cửa hàng</a></li>
											</li>
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

											<li id="status_Friend"><c:forEach var="item_friend"
													items="${MyFriend}">

													<c:if
														test="${details_user.id == item_friend.id && details_user.id != User_Infor.id }">
														<span>Bạn bè</span>
														<ins>

															<form:form method="DELETE" id="formUnfriend" role="form" modelAttribute="user1">
																<form:input type="hidden" path="id" value="${details_user.id}" />
																<button class="post-btn hover_addfriend_vinh" type="button" id="btnUnfriend">Hủy kết bạn</button>
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
														<span> <form:form method="POST" role="form" id="formAddFriend_timeline" modelAttribute="user1">
																<form:input type="hidden" value="${details_user.id}" path="id" />
																<button class="btn-vinh" id="AddFriend_timeline"
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
						<div class="col-lg-4 col-md-4">
							<aside class="sidebar">
								<div class="central-meta stick-widget">
									<span class="create-post">Personal Info</span>
									<div class="personal-head">
										<span class="f-title"><i class="fa fa-user"></i> Giới thiệu:</span>
										<p>${details_user.intro }</p>
										<span class="f-title"><i class="fa fa-birthday-cake"></i>
											Ngày Sinh:</span>
										<p>${details_user.birthday }</p>
										<span class="f-title"><i class="fa fa-phone"></i>
											Số điện thoại:</span>
										<p>${details_user.phone }</p>

										<span class="f-title"><i class="fa fa-male"></i>
											Giới tính:</span>
										<p>
											<c:if test="${ details_user.gender == 0 }">
												Nữ
											</c:if>
											<c:if test="${ details_user.gender > 0 }">
												Nam
												</c:if>
										</p>
									
										<span class="f-title"><i class="fa fa-briefcase"></i>
											Khoa:</span>
										<p>${faculty1}</p>
										<span class="f-title"><i class="fa fa-handshake-o"></i>
											Tham gia:</span>
										<p>${details_user.createAt }</p>

										<span class="f-title"><i class="fa fa-envelope"></i>
											Email:</span>
										<p>
											${details_user.email }
										</p>

									</div>
								</div>
							</aside>
						</div>
						<div class="col-lg-8 col-md-8">
								<div class="central-meta">
									<span class="create-post">Thông tin chung<a href="#" title="">Xem tất cả</a></span>
									<div class="row">
										<div class="col-lg-6">
											<div class="gen-metabox">
												<span><i class="fa fa-puzzle-piece"></i> Sở thích</span>
												<p>
													Tôi thích đi xe đạp, bơi lội và tập thể dục. Tôi cũng thích đọc các tạp chí thiết kế, tìm kiếm trên internet và cũng say sưa xem một bộ Phim hollywood hay khi bên ngoài trời đang mưa.
												</p>
											</div>
											<div class="gen-metabox">
												<span><i class="fa fa-plus"></i> Sở thích khác</span>
												<p>
													Bơi lội, Lướt sóng, Lặn Uber, Anime, Nhiếp ảnh, Hình xăm, Nghệ thuật đường phố.
												</p>
											</div>
										</div>
										<div class="col-lg-6">
											<div class="gen-metabox">
												<span><i class="fa fa-mortar-board"></i> Giáo dục</span>
												<p>
													Thạc sĩ khoa học máy tính, mười sáu năm bằng cấp Từ <a href="#" title="">Oxford Uniersity, London</a>
												</p>
											</div>
											<div class="gen-metabox">
												<span><i class="fa fa-certificate"></i> Làm việc và kinh nghiệm</span>
												<p>
													Hiện đang làm việc trong cơ quan phát triển web "bàn tay màu" trong 5 năm qua với tư cách là <a href="#" title="">Senior UI/UX Designer</a>
												</p>
											</div>
										</div>
										<div class="col-lg-6">
											<div class="gen-metabox no-margin">
												<span><i class="fa fa-sitemap"></i> Mạng xã hội</span>
												<ul class="sociaz-media">
													<li><a class="facebook" href="#" title=""><i class="fa fa-facebook"></i></a></li>
													<li><a class="twitter" href="#" title=""><i class="fa fa-twitter"></i></a></li>
													<li><a class="google" href="#" title=""><i class="fa fa-google-plus"></i></a></li>
													<li><a class="vk" href="#" title=""><i class="fa fa-vk"></i></a></li>
													<li><a class="instagram" href="#" title=""><i class="fa fa-instagram"></i></a></li>
													
												</ul>
											</div>
										</div>
										<div class="col-lg-6">
											<div class="gen-metabox no-margin">
												<span><i class="fa fa-trophy"></i> Danh hiệu</span>
												<ul class="badged">
													<li><img src="../..//assets/images/badges/badge2.png" alt=""></li>
													<li><img src="../..//assets/images/badges/badge19.png" alt=""></li>
													<li><img src="../..//assets/images/badges/badge21.png" alt=""></li>
													<li><img src="../..//assets/images/badges/badge3.png" alt=""></li>
													<li><img src="../..//assets/images/badges/badge4.png" alt=""></li>
												</ul>
											</div>
										</div>
									</div>	
								</div>
								
								
							</div>
						</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- content -->