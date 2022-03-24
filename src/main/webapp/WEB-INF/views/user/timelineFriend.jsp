<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
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
								<img class="logo-avartar-about-vinh" src="https://i.imgur.com/GN4sfZ9.jpg" alt="">
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
									<li>4.7/5</li>
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
											<li><a class=""
												href="http://localhost:8080/HutechSocialNetwork/user/time-line/${details_user.id}">Dòng
													thời gian</a></li>
											<li><a class=""
												href="http://localhost:8080/HutechSocialNetwork/user/about/${details_user.id}">Thông
													tin</a></li>
											<li><a class="active"
												href="http://localhost:8080/HutechSocialNetwork/user/friends-of/${details_user.id}">Bạn
													bè</a></li>
											<li><a class=""
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

											<li id="status_${details_user.id}"><c:forEach var="item_friend"
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
														<span> <form:form method="POST" role="form" id="form${details_user.id}" modelAttribute="user1">
																<form:input type="hidden" value="${details_user.id}" path="id" />
																<button class="btn-vinh" id="${details_user.id}"
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
						<div class="col-lg-12">
							<div class="central-meta">
								<div class="title-block">
									<div class="row">
										<div class="col-lg-6">
											<div class="align-left">
												<h5>
													Bạn bè: <span>${myFriend.size()}</span>
												</h5>
											</div>
										</div>
										<div class="col-lg-6">
											<div class="row merged20">
												<div class="col-lg-7 col-md-7 col-sm-7">

													
													<form:form method="POST" id ="form_SearchFriend" role="form" modelAttribute="search">
														<form:input type="text" placeholder="Tìm kiếm" path="Value" />
														<form:input type="hidden" value="${details_user.id}" path="id_user" />
														<button type="button" id="btnSearch"> <i class="fa fa-search"></i>
														</button>
													</form:form>
	

												</div>
												<div class="col-lg-4 col-md-4 col-sm-4">
													<div class="select-options">
														<select class="select">
															<option>Sort by</option>
															<option>A to Z</option>
															<option>See All</option>
															<option>Newest</option>
															<option>oldest</option>
														</select>
													</div>
												</div>
												<div class="col-lg-1 col-md-1 col-sm-1">
													<div class="option-list">
														<i class="fa fa-ellipsis-v"></i>
														<ul>
															<li><a title="" href="#">Show Friends Public</a></li>
															<li><a title="" href="#">Show Friends Private</a></li>
															<li><a title="" href="#">Mute Notifications</a></li>
														</ul>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- title block -->
							<div class="central-meta padding30">
								<div id="my_frieng_div" class="row merged20">

									<c:forEach var="item" items="${myFriend}">
										<div class="col-lg-4 col-md-6 col-sm-6">
											<div class="friend-block">
												<div class="more-opotnz">
													<i class="fa fa-ellipsis-h"></i>
													<ul>
														<li><a href="#" title="">Block</a></li>
														<li><a href="#" title="">UnBlock</a></li>
														<li><a href="#" title="">Mute Notifications</a></li>
														<li><a href="#" title="">hide from friend list</a></li>
													</ul>
												</div>
												<figure>
													<img src="${item.avatar}" alt="">
												</figure>

												<div class="frnd-meta">
													<div  class="frnd-name">
														<a href="http://localhost:8080/HutechSocialNetwork/user/time-line/${item.id}" title="">${item.name }</a>
														<c:forEach var="itemF" items="${listFaculty}">
															<c:if test="${item.id_Faculty == itemF.getKey() }">
																<span>Khoa ${itemF.getValue()}</span>
															</c:if>
														</c:forEach>
														<span>Ngày tạo: ${item.createAt}</span> <span>Email:
															${item.email}</span>
													</div>
													<a class="send-mesg" href="#" title="">Message</a>
													
												</div>
											</div>
										</div>
									</c:forEach>


								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>