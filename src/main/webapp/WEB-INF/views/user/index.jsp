<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<c:url var="PostURL"
	value="http://localhost:8080/HutechSocialNetwork/user/post" />
<c:url var="edit_PostURL"
	value="http://localhost:8080/HutechSocialNetwork/user/edit-post" />
<section >
	<div  class="gap2 gray-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="row merged20" id="page-contents">
						<div class="col-lg-3">
							<aside class="sidebar static left">
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
								<!-- weather widget-->
								
								<c:forEach var="item_birthday" items="${birthday_friend}">
								
								
								<div class="widget whitish low-opacity">
									<div style="background-image: url(images/resources/dob2.png)"
										class="bg-image"></div>
									<div class="dob-head">
										<img class="img-avatar-vinh" src="${item_birthday.avatar }" alt="">
										<span>Sinh nhật thứ ${item_birthday.age }</span>
										<div class="dob">
											<i>${item_birthday.birthday_string}</i> 
										</div>
									</div>
									<div class="dob-meta">
										<figure>
											<img src="..//assets/images/resources/dob-cake.gif" alt="">
										</figure>
										<h6>
											Sinh Nhật <a href="#" title="">${item_birthday.name}</a>
										</h6>
										<p>Hãy chúc người bạn của bạn một ngày sinh nhật vui vẻ!</p>
									</div>
								</div>
								
								</c:forEach>
								<!-- birthday widget -->
								
							
								<div class="widget stick-widget">
									<!-- Friend -->
									<h4 class="widget-title">Sinh viên cùng khoa</h4>

									<ul class="followers">

										<c:forEach var="item" items="${Friend}">
											<li>
												<figure>
													<img src="${item.avatar}" alt="">
												</figure>
												<div class="friend-meta">
													<h4>
														<a
															href="http://localhost:8080/HutechSocialNetwork/user/time-line/${item.id}"
															title=""> ${ item.name }</a> <br>
														<c:if test="${ item.gender == 0 }">
															<span>Nữ</span>
														</c:if>
														<c:if test="${ item.gender > 0 }">
															<span>Nam</span>
														</c:if>
													</h4>

													<c:url var="AddFriendURL" value="addfriend">
														<c:param name="id" value="${item.id}" />
													</c:url>
													<form:form action="${AddFriendURL}" method="POST"
														role="form" modelAttribute="user_friend">
														<form:input type="hidden" value="${item.id}" path="id" />
														<button class="hover_addfriend_vinh" type="submit">Kết
															bạn</button>
													</form:form>

												</div>
											</li>
										</c:forEach>


									</ul>
								</div>
								<!-- who's following -->
							</aside>
						</div>
						<!-- sidebar -->
						<div class="col-lg-9">
							<div class="central-meta postbox">
								<span class="create-post">Tạo bài viết mới</span>
								<div class="new-postbox">
									<figure>
										<img class="img-avatar-vinh" src="${User_Infor.avatar}" alt="">
									</figure>

									<form:form method="post" action="${PostURL}"
										modelAttribute="Post" enctype="multipart/form-data">
										<div class="newpst-input">
											<form:textarea rows="2" placeholder="Bạn đang nghĩ gì thế?"
												path="content" />
										</div>
										<div class="attachments">
											<ul>
												<li><span class="add-loc"> <i
														class="fa fa-map-marker"></i>
												</span></li>
												<li><i class="fa fa-image"></i> <label
													class="fileContainer"> <form:input type="file"
															id="image" name="image[]" path="file" multiple="multiple" />
												</label></li>
											</ul>
											<div id="frames" style="margin:10px 0px"></div>
											<button class="post-btn" type="submit" data-ripple="">Đăng
												Tải</button>
										</div>
									</form:form>


									<div class="add-location-post">
										<span>Drag map point to selected area</span>
										<div class="row">

											<div class="col-lg-6">
												<label class="control-label">Lat :</label> <input
													type="text" class="" id="us3-lat" />
											</div>
											<div class="col-lg-6">
												<label>Long :</label> <input type="text" class=""
													id="us3-lon" />
											</div>
										</div>
										<!-- map -->
										<div id="us3"></div>
									</div>
								</div>
							</div>
							<!-- add post new box -->
							<div class="loadMore">
								<c:forEach var="item_post" items="${Friend_post }">
									<c:forEach var="item_friend" items="${MyFriend}">
										<c:if test="${item_post.userID == item_friend.id}">
											<div id="postA${item_post.id}" class="central-meta item">
												<div class="user-post">
													<div class="friend-info">
														<figure>
															<img class="img-avatar-vinh" src="${item_friend.avatar}" alt="">
														</figure>
														<div class="friend-name">
															<div class="more">
																<div class="more-post-optns">

																	<c:if test="${item_post.userID == User_Infor.id}">
																		<i class="ti-more-alt"></i>
																		<ul>
																			<li data-bs-toggle="modal"
																				data-bs-target="#exampleModal-${item_post.id}"><i
																				class="fa fa-pencil-square-o"></i>Sửa bài</li>
																			<li style="display:flex"><i class="fa fa-trash-o"></i> 
																			<form:form
																					method="DELETE" role="form"
																					id="formDeletePost${item_post.id}"
																					modelAttribute="Post">
																					<form:input type="hidden" value="${item_post.id}"
																						path="id" />
																					<a id="${item_post.id}"
																						onClick="delete_post(this.id)" type="button">
																						Xóa bài</a>
																				</form:form></li>
																		</ul>
																	</c:if>

																</div>
															</div>
															<ins>
																<a
																	href="http://localhost:8080/HutechSocialNetwork/user/time-line/${item_friend.id}"
																	title="">${item_friend.name }</a> Đã đăng
															</ins>
															<span><i class="fa fa-globe"></i> Ngày đăng: ${ item_post.createAt}
															</span>
														</div>
														<div class="post-meta">
															<p>${item_post.content }</p>
															<figure>

																<!-- 1 hình -->
																
																<!-- <div class="col-lg-12 col-md-12 col-sm-12">
																	<figure>
																		<a href="#" title="" data-toggle="modal"
																			data-target="#img-comt"> <img style="height:580px !important"
																			src="${item_image.image }" alt="">
																		</a>
																	</figure>
																</div>  -->
																
																<!-- 1 Hình -->
																<c:set var="image_amount" scope="session" value="${0}" />
																<c:forEach var="item_image" items="${list_Image}">
																				<c:if test="${item_image.id_post == item_post.id }">
																					<c:set var="image_amount" scope="session" value="${image_amount +1}" />
																				</c:if>
																</c:forEach>
																<c:if test="${image_amount == 1}">
																<div class="img-bunch">
																	<div class="row">
																		<c:if test="${list_Image.size()>0 }">
																			<c:forEach var="item_image" items="${list_Image}">
																				<c:if test="${item_image.id_post == item_post.id }">
																					<div class="col-lg-12 col-md-12 col-sm-12">
																						<figure>
																							<a href="#" title="" data-toggle="modal"
																								data-target="#img-comt"> <img style="height:580px !important"
																								src="${item_image.image }" alt="">
																							</a>
																						</figure>
																					</div>
																				</c:if>
																			</c:forEach>
																		</c:if>
																	</div>
																</div>
																
																</c:if>
																
																<c:if test="${image_amount > 1}">
																<div class="img-bunch">
																	<div class="row">
																		<c:if test="${list_Image.size()>0 }">
																			<c:forEach var="item_image" items="${list_Image}">
																				<c:if test="${item_image.id_post == item_post.id }">
																					<div class="col-lg-6 col-md-6 col-sm-6">
																						<figure>
																							<a href="#" title="" data-toggle="modal"
																								data-target="#img-comt"> <img 
																								src="${item_image.image }" alt="">
																							</a>
																						</figure>
																					</div>
																				</c:if>
																			</c:forEach>
																		</c:if>
																	</div>
																</div>
																</c:if>
																


																<ul class="like-dislike">
																	<li><a class="bg-purple" href="#"
																		title="Save to Pin Post"><i
																			class="fa fa-thumb-tack"></i></a></li>
																	<li><a class="bg-blue" href="#" title="Like Post"><i
																			class="ti-thumb-up"></i></a></li>
																	<li><a class="bg-red" href="#"
																		title="dislike Post"><i class="ti-thumb-down"></i></a></li>
																</ul>
															</figure>
															<div class="we-video-info">
																<ul>
																	<li>
																		<div class="likes heart1" title="Like/Dislike">
																			<!-- Like -->
																			<form:form method="POST"
																				id="form_LikePostb${item_post.id}" role="form"
																				modelAttribute="like">
																				<form:input type="hidden" value="${item_post.id}"
																					path="idpost" />
																				<button id="b${item_post.id}"
																					onClick="like_click(this.id)" type="button">❤</button>

																				<span id="like_postb${item_post.id}"> <c:if
																						test="${item_post.status == 1}">
																				Đã thích</c:if> ${item_post.amount}
																				</span>
																			</form:form>
																			<!-- Like -->
																		</div>
																	</li>

																	<li><span class="comment" title="Comments">
																			<i class="fa fa-commenting"></i> <ins
																				id="comment_post${item_post.id}">${item_post.amountComment}</ins>
																	</span></li>

																	<li><span> <a class="share-pst" href="#"
																			title="Share"> <i class="fa fa-share-alt"></i>
																		</a> <ins>20</ins>
																	</span></li>
																</ul>

															</div>
														</div>

														<div class="coment-area" style="display: none;">
															<ul class="we-comet">
																<li><a href="#" title="" class="showmore underline">more
																		comments+</a></li>
																<!-- Comment -->
																<ul id="item_comment${item_post.id }">
																	<c:forEach var="item_comment" items="${commet_Post}">
																		<c:if test="${item_comment.post_id == item_post.id }">
																			<li class="commentList">
																				<div class="comet-avatar">
																					<img src="${item_comment.avatarUser}" alt="">
																				</div>
																				<div class="we-comment">
																					<h5>
																						<a href="time-line.html" title="">${item_comment.nameUser}</a>
																					</h5>
																					<p>${item_comment.content}</p>
																					<div class="inline-itms">
																						<span>${item_comment.createAt}</span> <a
																							class="we-reply" href="#" title="Reply"><i
																							class="fa fa-reply"></i></a> <a href="#" title=""><i
																							class="fa fa-heart"></i><span>20</span></a>
																					</div>
																				</div>

																			</li>
																		</c:if>
																	</c:forEach>
																</ul>



																<li class="post-comment">
																	<div class="comet-avatar">
																		<img src="${User_Infor.avatar}" alt="">
																	</div>
																	<div class="post-comt-box">

																		<form:form method="POST"
																			id="form_CommentPost${item_post.id}" role="form"
																			modelAttribute="comment">
																			<form:textarea placeholder="Bình luận của bạn"
																				path="content" class="Commentarea"></form:textarea>
																			<form:input type="hidden" value="${item_post.id}"
																				path="post_id" />
																			<form:input type="hidden" value="${User_Infor.id}"
																				path="user_id" />
																			<div class="add-smiles">
																				<div class="uploadimage">
																					<i class="fa fa-image"></i> <label
																						class="fileContainer"> <input type="file">
																					</label>
																				</div>
																				<span class="em em-expressionless" title="add icon"></span>


																			</div>

																			<div class="cha-btn">
																				<button class="btn-dang" id="t${item_post.id}"
																					onClick="comment_click(this.id)" type="button">Đăng</button>
																			</div>
																		</form:form>
																	</div>
																</li>
															</ul>
														</div>
													</div>

												</div>
											</div>

											<div class="modal fade" id="exampleModal-${item_post.id}"
												tabindex="-1" aria-labelledby="exampleModalLabel"
												aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title text-vinh" id="exampleModalLabel">Chỉnh
																sửa bài viết</h5>
															<button type="button" class="btn-close"
																data-bs-dismiss="modal" aria-label="Close"></button>
														</div>
														<div class="modal-body">
															<div class="new-postbox-1">
																<figure>
																	<img class="img-avatar-vinh" src="${User_Infor.avatar}"
																		alt="">
																	<span class="user-infor-name-vinh">${item_post.id}</span>
																</figure>

																<form:form method="POST" action="${edit_PostURL}"
																	modelAttribute="edit_Post"
																	enctype="multipart/form-data">
																	<div class="newpst-input">
																		<div class="post-meta">
																			<form:input type="hidden" value="${item_post.id}"
																				path="id" />
																			<form:textarea placeholder="${item_post.content}"
																				path="content" />
																			<figure>
																				<div class="img-bunch">
																					<div class="row">
																						<c:if test="${list_Image.size()>0 }">
																							<c:forEach var="item_image" items="${list_Image}">
																								<c:if
																									test="${item_image.id_post == item_post.id }">
																									<div class="col-lg-6 col-md-6 col-sm-6">
																										<figure>
																											<a href="#" title="" data-toggle="modal"
																												data-target="#img-comt"> <img
																												src="${item_image.image }" alt="">
																											</a>
																										</figure>
																									</div>
																								</c:if>
																							</c:forEach>
																						</c:if>
																					</div>
																				</div>
																			</figure>
																		</div>
																		<div class="attachments">
																			<ul>
																				<li><span class="add-loc"> <i
																						class="fa fa-map-marker"></i>
																				</span></li>
																				<li><i class="fa fa-image"></i> <label
																					class="fileContainer"> <form:input
																							type="file" id="image" name="image[]" path="file" multiple="multiple" />
																				</label></li>
																			</ul>
																			<div id="frames" style="margin:10px 0px"></div>
																			<button id="a${item_post.id}" class="post-btn"
																				type="submit" data-ripple="">Lưu bài</button>
																		</div>

																	</div>
																</form:form>



															</div>
														</div>

													</div>
												</div>
											</div>
										</c:if>
									</c:forEach>
								</c:forEach>



							</div>
						</div>
						<!-- centerl meta -->
					</div>
				</div>
			</div>
		</div>
	</div>
</section>


