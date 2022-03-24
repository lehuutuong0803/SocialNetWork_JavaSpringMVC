<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
        	<div class="gap no-gap signin whitish medium-opacity register">
                <div class="bg-image"
		style="background-image:url(<c:url value ="/assets/images/resources/theme-bg.jpg"/>)"></div>
                <div class="container">
                	<div class="row">
                        <div class="col-lg-12">
                            <div class="we-login-register">
                                <div class="form-title">
                                    <i class="fa fa-plus"></i>Tạo Sản Phẩm
                                    <span>Tạo sản phẩm để buôn bán cho những người bạn trên toàn thế giới</span>
                                </div>
                                <form:form class="we-form" method="POST" role="form"  modelAttribute="product" enctype="multipart/form-data">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label for="Name-Product">Tên Sản Phẩm</label>
                                            <form:input class="form-control" type="text" placeholder="Nhập tên sản phẩm" path="product_name"/>
                                            <label for="Price-Product">Giá Sản Phẩm</label>
                                            <form:input class="form-control" name="price" id="price" type="text" placeholder="Nhập giá sản phẩm" path="price"/>
                                            <label for="Amount-Product">Số Lượng Sản Phẩm</label>
                                            <form:input class="form-control" type="number" placeholder="Nhập số lượng sản phẩm" min="0" value="0" path="amount"/>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="Images-Product">Hình Ảnh Sản Phẩm</label>
                                            <form:input class="form-control" id="image" name="file" type="file" multiple="multiple" path="file"/>
                                            <div id="frames" style="margin:10px 0px"></div>
                                        </div>
                                        <label for="Note-Product">Ghi Chú Sản Phẩm</label>
                                        <form:textarea name="Note-Product" id="Note-Product" path="note"/>
                                    </div>
                                    <button class="button-vinh-product" type="submit" data-ripple="">Tạo Sản Phẩm</button>
                                </form:form>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>