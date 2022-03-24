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
						<div class="col-lg-12">
							<div class="search-meta">
								<span>Lời mời kết bạn ${result_search.size()}</span>
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
											<c:if test="${result_search.size() > 0 }">
											<c:forEach var="item_search" items="${result_search}">
												<div class="pit-friends">
													<figure>
														<a href="http://localhost:8080/HutechSocialNetwork/user/time-line/${item_search.id}" title=""><img src="${item_search.avatar}"
															alt=""></a>
													</figure>
													<div class="pit-frnz-meta">
														<a   href="http://localhost:8080/HutechSocialNetwork/user/time-line/${item_search.id}" title="">${item_search.name}</a>
														<c:forEach var="itemF" items="${listFaculty}">
															<c:if test="${item_search.id_Faculty == itemF.getKey() }">
																<i>Khoa ${itemF.getValue()}</i>
															</c:if>
														</c:forEach>
														
														
														<ul id="area_${item_search.id}" class="add-remove-frnd">
														
															<form:form method="PUT" role="form" id="formAccept_timeline${item_search.id}" modelAttribute="user1">
																<form:input type="hidden" value="${item_search.id}" path="id" />
																	<li class="add-tofrndlist" ><a type="button" onClick="acceptFriend(this.id)" id="${item_search.id}" title="Add friend"
																href="#"><i class="fa fa-user-plus">Đồng ý</i></a>	</li>
															</form:form>
															

															
																
															<li class="remove-frnd"><a title="Send Message"
																href="#"><i class="fa fa-comment"></i></a></li>
														</ul>
														
													</div>
												</div>
											</c:forEach>
											</c:if>



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