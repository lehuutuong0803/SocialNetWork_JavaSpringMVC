<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<section>
	<div class="gap2 gray-bg" style="height: 84.3vh">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="row merged20" id="page-contents">
						<div class="col-lg-12">
							<div class="search-meta">
								<span>Kết quả tìm kiếm ${result_search.size()}</span>
							</div>
						</div>

						<div class="col-lg-12">
							<div class="search-tab">
								<ul class="nav nav-tabs tab-btn">

									<li class="nav-item "><a class="active" href="#people"
										data-toggle="tab">Mọi người</a></li>
								</ul>

								<!-- Tab panes -->
								<div class="tab-content">
									<div class="tab-pane active fade show" id="people">
										<div class="central-meta item">
											<span class="create-post">Mọi người</span>
											<c:forEach var="item_search" items="${result_search}">
												<div class="pit-friends">
													<figure>
														<a href="http://localhost:8080/HutechSocialNetwork/user/time-line/${item_search.id}" title=""><img src="${item_search.avatar }"
															alt=""></a>
													</figure>
													<div class="pit-frnz-meta">
														<a   href="http://localhost:8080/HutechSocialNetwork/user/time-line/${item_search.id}" title="">${item_search.name}</a>
														<c:forEach var="itemF" items="${listFaculty}">
															<c:if test="${item_search.id_Faculty == itemF.getKey() }">
																<i>Khoa ${itemF.getValue()}</i>
															</c:if>
														</c:forEach>
														
														
														<ul class="add-remove-frnd">
															
															<c:if test="${item_search.status == 0  }">
															<li id ="asearch_Addfriend${item_search.id}"  class="add-tofrndlist" >
																<form:form method="POST" role="form" id="formsearch_Addfriend${item_search.id}" modelAttribute="user_friend">
																<form:input type="hidden" value="${item_search.id}" path="id" />
																<a title="Add friend" id="search_Addfriend${item_search.id}"
																  onClick="search_AddFriend(this.id)"><i  class="fa fa-user-plus"></i></a>
																</form:form>
															</li>
															</c:if>
															<c:if test="${item_search.status == 1 }">
																<li class="add-tofrndlist"><a title="Add friend"
																href="#"><i class="fas fa-user-check"></i>
																	<span>Đã kết bạn</span>
																</a></li>
															</c:if>
															<c:if test="${item_search.status == 2 }">
																<li class="add-tofrndlist"><a title="Add friend"
																href="#"><i class="fa fa-user-plus"></i>
																	<span>Chờ xác nhận</span>
																</a></li>
															</c:if>
															<c:if test="${item_search.status == 3 }">
																<li class="add-tofrndlist"><a title="Add friend"
																href="#"><i class="fa fa-user-plus">
																	
																</i>
																<span>Đồng Ý</span></a></li>
															</c:if>
															
																
															<li class="remove-frnd"><a title="Send Message"
																href="#"><i class="fa fa-comment"></i></a></li>
														</ul>
														
													</div>
												</div>
											</c:forEach>




										</div>
										<!-- searched peoples -->
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-2"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>