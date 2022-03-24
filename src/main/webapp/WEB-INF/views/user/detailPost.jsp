<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<c:url var="edit_PostURL"
	value="http://localhost:8080/HutechSocialNetwork/user/edit-post" />

									<c:forEach var="item_friend" items="${MyFriend}">
										<c:if test="${detail_Post.userID == item_friend.id}">
											<div class="central-meta item">
												<div class="user-post">
													<div class="friend-info">
														<figure>
															<img src="${User_Infor.avatar}" alt="">
														</figure>
														<div class="friend-name">
															<div class="more">
																<div class="more-post-optns">

																	<c:if test="${detail_Post.userID == User_Infor.id}">
																		<i class="ti-more-alt"></i>
																		<ul>
																			<li data-bs-toggle="modal"
																				data-bs-target="#exampleModal-${detail_Post.id}"><i
																				class="fa fa-pencil-square-o"></i>Edit Post</li>
																			<li><i class="fa fa-trash-o"></i>Delete Post</li>
																			<li class="bad-report"><i class="fa fa-flag"></i>Report
																				Post</li>
																			<li><i class="fa fa-address-card-o"></i>Boost
																				This Post</li>
																			<li><i class="fa fa-clock-o"></i>Schedule Post</li>
																			<li><i class="fa fa-wpexplorer"></i>Select as
																				featured</li>
																			<li><i class="fa fa-bell-slash-o"></i>Turn off
																				Notifications</li>
																		</ul>
																	</c:if>

																</div>
															</div>
															<ins>
																<a
																	href="http://localhost:8080/HutechSocialNetwork/user/time-line/${item_friend.id}"
																	title="">${item_friend.name }</a> Đã đăng
															</ins>
															<span><i class="fa fa-globe"></i> Ngày đăng: ${ detail_Post.createAt}
															</span>
														</div>
														<div class="post-meta">
															<p>${detail_Post.content }</p>
															<figure>


																<div class="img-bunch">
																	<div class="row">
																		<c:if test="${detail_Image.size()>0 }">
																			<c:forEach var="item_image" items="${detail_Image}">
																				<c:if test="${item_image.id_post == detail_Post.id }">
																					<div class="col-lg-6 col-md-6 col-sm-6">
																						<figure>
																							<a href="#" title="" data-toggle="modal"
																								data-target="#img-comt"> <img style="height: 580px !important"
																								src="${item_image.image }" alt="">
																							</a>
																						</figure>
																					</div>
																				</c:if>
																			</c:forEach>
																		</c:if>
																	</div>
																</div>


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
																				id="form_LikePost${detail_Post.id}" role="form"
																				modelAttribute="like">
																				<form:input type="hidden" value="${detail_Post.id}"
																					path="idpost" />
																				<button id="${detail_Post.id}"
																					onClick="like_click(this.id)" type="button">❤</button>

																				<span id="like_post${detail_Post.id}"> <c:if
																						test="${detail_Post.status == 1}">
																				Đã thích</c:if> ${detail_Post.amount}
																				</span>
																			</form:form>
																			<!-- Like -->
																		</div>
																	</li>
																	<li><span class="comment" title="Comments">
																			<i class="fa fa-commenting"></i> <ins>52</ins>
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
																<ul id="item_comment${detail_Post.id }">
																	<c:forEach var="item_comment" items="${commet_Post}">
																		<c:if test="${item_comment.post_id == detail_Post.id }">
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
																			id="form_CommentPost${detail_Post.id}" role="form"
																			modelAttribute="comment">
																			<form:textarea placeholder="Bình luận của bạn"
																				path="content"></form:textarea>
																			<form:input type="hidden" value="${detail_Post.id}"
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

																			<div>
																				<button style="color: black;" id="t${detail_Post.id}"
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

											<div class="modal fade" id="exampleModal-${detail_Post.id}"
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
																	<span class="user-infor-name-vinh">${detail_Post.id}</span>
																</figure>

																<form:form  method="POST"  action="${edit_PostURL}"
																	modelAttribute="edit_Post" enctype="multipart/form-data">
																	<div class="newpst-input">
																		<div class="post-meta">
																			<form:input type="hidden" value="${detail_Post.id}" path="id"/>
																			<form:textarea placeholder="${detail_Post.content}"
																				path="content"/>
																			<figure>
																				<div class="img-bunch">
																					<div class="row">
																						<c:if test="${detail_Image.size()>0 }">
																							<c:forEach var="item_image" items="${detail_Image}">
																								<c:if
																									test="${item_image.id_post == detail_Post.id }">
																									<div class="col-lg-6 col-md-6 col-sm-6">
																										<figure>
																											<a href="#" title="" data-toggle="modal"
																												data-target="#img-comt"> <img
																												src="${item_image.image}"alt="">
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
																					class="fileContainer"> 
																					<form:input type="file" path="file" multiple="multiple" />
																				</label></li>
																			</ul>
																			<button id="a${detail_Post.id}" class="post-btn"
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
