<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<div class="gap no-gap signin whitish medium-opacity">
	<div class="bg-image"
		style="background-image:url(<c:url value ="/assets/images/resources/theme-bg.jpg"/>)"></div>
	<div class="col-lg-6 "
		style="padding: 2rem; margin-left: auto; margin-right: auto;">
		<!-- shop product post -->
		<!-- suggested friends -->
		<div class="load-more">
			<h1 style="text-align: center; margin-bottom: 20px; color: #252428;">*Quản
				lý hóa đơn*</h1>
			<c:forEach var="item_invoice" items="${invoice}">
				<div class="central-meta item"
					style="box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.16), 0 0 0 1px rgba(0, 0, 0, 0.08);">
					<div class="classic-post">

						<div class="classic-pst-meta" style="max-width:100%;">
							<div class="more">
								<div class="more-post-optns">
									<i class="ti-more-alt"></i>
									<ul>
										<li><i class="fa fa-pencil-square-o"></i>Chỉnh sửa</li>
										<li><i class="fa fa-trash-o"></i>Xóa</li>
									</ul>
								</div>
							</div>
							<h4 style="font-size:20px;color:black">
								<i class="fa fa-check-circle" title="verified"></i> Mã Hóa
								Đơn: #${item_invoice.id}
							</h4>
							<c:forEach var="itemOwner" items="${buyer}">
								<c:if test="${item_invoice.buyer_id == itemOwner.value.id}">
									<h4 style="font-size:20px;color:black">
										Người Mua:
										<a
											href="http://localhost:8080/HutechSocialNetwork/user/time-line/${itemOwner.value.id}"
											title="">${itemOwner.value.name}</a>
									</h4>
								</c:if>
							</c:forEach>

							<p style="font-size:15px;color:black">Ghi chú: ${item_invoice.note}</p>
							<p style="font-size:15px;color:black">Địa chỉ giao: ${item_invoice.address}</p>
							<p style="font-size:15px;color:black">Số lượng: ${item_invoice.quantity}</p>
					
							<c:if test="${item_invoice.paymentmethod ==  1}">
							<p style="font-size:15px;color:black">Phương thức thanh toán: Online</p>
							</c:if>
							<c:if test="${item_invoice.paymentmethod ==  0}">
							<p style="font-size:15px;color:black">Phương thức thanh toán: Ship cod</p>
							</c:if>
							<span style="font-size:20px" class="prise">${item_invoice.formatCurrency} ₫</span>
							<div class="location-area">
								<i style="font-size:15px;color:black">Ngày đăng: ${item_invoice.createAt}</i>
							</div>
							<input type="hidden" id="user_Invoice${item_invoice.id}" value="${item_invoice.buyer_id}"/>
								<div style="display:inline-block" id="area_invoice${item_invoice.id}">
								<c:if test="${item_invoice.status ==  0}">
									<button style="background: #fa6342;
										    border: medium none;
										    border-radius: 30px;
										    color: #fff;
										    padding: 5px 10px;" id="${item_invoice.id}" type="submit" onClick="verifyInvoice(this.id)" class="main-btn" title="">Xác nhận</button>
								</c:if>
								<c:if test="${item_invoice.status ==  1}">
									<button style="background: #fa6342;
										    border: medium none;
										    border-radius: 30px;
										    color: #fff;
										    padding: 5px 10px;" class="main-btn" title="">Đã xác nhận</button>
								</c:if>
								</div>
								
								
								<button style="background: #fa6342;
										    border: medium none;
										    border-radius: 30px;
										    color: #fff;
										    padding: 5px 10px;" type="button" href="#" data-bs-toggle="modal"
									data-bs-target="#detailed_${item_invoice.id}" class="main-btn" title="">Xem
									chi tiết</button>
							
						</div>
					</div>
				</div>
				<div class="modal fade" id="detailed_${item_invoice.id}" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Xem chi tiết
									đơn hàng</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<div class="central-meta item" >
								<c:forEach var="item_Detail" items="${details}">
									<c:if test="${item_Detail.invoice_id == item_invoice.id}">
										<c:forEach var="item_Product" items="${productdetail}">
											<c:if test="${item_Product.id == item_Detail.product_id}">
												<div class="classic-post" style="display:flex">
													<figure>
														<img style="width: 135px; height: 115px;"
															src="${item_Product.image}" alt="">
														<span>Hàng tốt</span>
													</figure>
													<div class="classic-pst-meta">
														<div class="more">
															<div class="more-post-optns">
																<i class="ti-more-alt"></i>
																<ul>
																	<li><i class="fa fa-pencil-square-o"></i>Chỉnh sửa</li>
																	<li><i class="fa fa-trash-o"></i>Xóa</li>
																</ul>
															</div>
														</div>
														<h4 style="font-size:20px">
															<i class="fa fa-check-circle" title="verified"></i> <a
																href="http://localhost:8080/HutechSocialNetwork/user/detailed-product/${item_Product.id}"
																title="">${item_Product.product_name}</a>
														</h4>
														<span style="font-size:20px" onchange="amount()" class="prise">Giá: ${item_Product.formatCurrency} ₫</span>
														<div class="location-area">
															<i style="font-size:15px;color:black">Ngày đăng: ${item_Product.createat}</i>
														</div>
													</div>
												</div>
											</c:if>
										</c:forEach>
									</c:if>
								</c:forEach>
									
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<!-- shop product post -->
		</div>
	</div>
</div>
