<!-- 模仿天猫整站j2ee 教程 为how2j.cn 版权所有-->
<!-- 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关-->
<!-- 供购买者学习，请勿私自传播，否则自行承担相关法律责任-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<script>
var deleteOrder = false;
var deleteOrderid = 0;

$(function(){
	$("a[orderStatus]").click(function(){
		var orderStatus = $(this).attr("orderStatus");
		if('all'==orderStatus){
			$("table[orderStatus]").show();	
		}
		else{
			$("table[orderStatus]").hide();
			$("table[orderStatus="+orderStatus+"]").show();			
		}
		
		$("div.orderType div").removeClass("selectedOrderType");
		$(this).parent("div").addClass("selectedOrderType");
	});
	
	$("a.deleteOrderLink").click(function(){
		deleteOrderid = $(this).attr("oid");
		deleteOrder = false;
		$("#deleteConfirmModal").modal("show");
	});
	
	$("button.deleteConfirmButton").click(function(){
		deleteOrder = true;
		$("#deleteConfirmModal").modal('hide');
	});	
	
	$('#deleteConfirmModal').on('hidden.bs.modal', function (e) {
		if(deleteOrder){
			var page="foredeleteOrder";
			$.post(
				    page,
				    {"order.id":deleteOrderid},
				    function(result){
						if("success"==result){
							$("table.orderListItemTable[oid="+deleteOrderid+"]").hide();
						}
						else{
							location.href="login.jsp";
						}
				    }
				);
			
		}
	})		
	
	$(".ask2delivery").click(function(){
		var link = $(this).attr("link");
		$(this).hide();
		page = link;
		$.ajax({
			   url: page,
			   success: function(result){
				alert("鍗栧宸茬鍙戯紝鍒锋柊褰撳墠椤甸潰锛屽嵆鍙繘琛岀‘璁ゆ敹璐?")
			   }
			});
		
	});
});

</script>
	
<div class="boughtDiv">
	<div class="orderType">
		<div class="selectedOrderType"><a orderStatus="all" href="#nowhere">鎵?鏈夎鍗?</a></div>
		<div><a  orderStatus="waitPay" href="#nowhere">寰呬粯娆?</a></div>
		<div><a  orderStatus="waitDelivery" href="#nowhere">寰呭彂璐?</a></div>
		<div><a  orderStatus="waitConfirm" href="#nowhere">寰呮敹璐?</a></div>
		<div><a  orderStatus="waitReview" href="#nowhere" class="noRightborder">寰呰瘎浠?</a></div>
		<div class="orderTypeLastOne"><a class="noRightborder">&nbsp;</a></div>
	</div>
	<div style="clear:both"></div>
	<div class="orderListTitle">
		<table class="orderListTitleTable">
			<tr>
				<td>瀹濊礉</td>
				<td width="100px">鍗曚环</td>
				<td width="100px">鏁伴噺</td>
				<td width="120px">瀹炰粯娆?</td>
				<td width="100px">浜ゆ槗鎿嶄綔</td>
			</tr>
		</table>
	
	</div>
	
	<div class="orderListItem">
		<c:forEach items="${orders}" var="o">
			<table class="orderListItemTable" orderStatus="${o.status}" oid="${o.id}">
				<tr class="orderListItemFirstTR">
					<td colspan="2">
					<b><fmt:formatDate value="${o.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></b> 
					<span>璁㈠崟鍙?: ${o.orderCode} 
					</span>
					</td>
					<td  colspan="2"><img width="13px" src="img/site/orderItemTmall.png">澶╃尗鍟嗗満</td>
					<td colspan="1">
						<a class="wangwanglink" href="#nowhere">
							<div class="orderItemWangWangGif"></div>
						</a>
						
					</td>
					<td class="orderItemDeleteTD">
						<a class="deleteOrderLink" oid="${o.id}" href="#nowhere">
							<span  class="orderListItemDelete glyphicon glyphicon-trash"></span>
						</a>
						
					</td>
				</tr>
				<c:forEach items="${o.orderItems}" var="oi" varStatus="st">
					<tr class="orderItemProductInfoPartTR" >
						<td class="orderItemProductInfoPartTD"><img width="80" height="80" src="img/productSingle_middle/${oi.product.firstProductImage.id}.jpg"></td>
						<td class="orderItemProductInfoPartTD">
							<div class="orderListItemProductLinkOutDiv">
								<a href="foreproduct?product.id=${oi.product.id}">${oi.product.name}</a>
								<div class="orderListItemProductLinkInnerDiv">
											<img src="img/site/creditcard.png" title="鏀寔淇＄敤鍗℃敮浠?">
											<img src="img/site/7day.png" title="娑堣垂鑰呬繚闅滄湇鍔?,鎵胯7澶╅??璐?">
											<img src="img/site/promise.png" title="娑堣垂鑰呬繚闅滄湇鍔?,鎵胯濡傚疄鎻忚堪">						
								</div>
							</div>
						</td>
						<td  class="orderItemProductInfoPartTD" width="100px">
						
							<div class="orderListItemProductOriginalPrice">锟?<fmt:formatNumber type="number" value="${oi.product.originalPrice}" minFractionDigits="2"/></div>
							<div class="orderListItemProductPrice">锟?<fmt:formatNumber type="number" value="${oi.product.promotePrice}" minFractionDigits="2"/></div>
		
		
						</td>
						<c:if test="${st.count==1}">
						 
							<td valign="top" rowspan="${fn:length(o.orderItems)}" class="orderListItemNumberTD orderItemOrderInfoPartTD" width="100px">
								<span class="orderListItemNumber">${o.totalNumber}</span>
							</td>
							<td valign="top" rowspan="${fn:length(o.orderItems)}" width="120px" class="orderListItemProductRealPriceTD orderItemOrderInfoPartTD">
								<div class="orderListItemProductRealPrice">锟?<fmt:formatNumber  minFractionDigits="2"  maxFractionDigits="2" type="number" value="${o.total}"/></div>
								<div class="orderListItemPriceWithTransport">(鍚繍璐癸細锟?0.00)</div>
							</td>
							<td valign="top" rowspan="${fn:length(o.orderItems)}" class="orderListItemButtonTD orderItemOrderInfoPartTD" width="100px">
								<c:if test="${o.status=='waitConfirm' }">
									<a href="foreconfirmPay?order.id=${o.id}">
										<button class="orderListItemConfirm">纭鏀惰揣</button>
									</a>
								</c:if>
								<c:if test="${o.status=='waitPay' }">
									<a href="forealipay?order.id=${o.id}&total=${o.total}">
										<button class="orderListItemConfirm">浠樻</button>
									</a>								
								</c:if>
								
								<c:if test="${o.status=='waitDelivery' }">
									<span>寰呭彂璐?</span>
									
<%-- 									<button class="btn btn-info btn-sm ask2delivery" link="admin_order_delivery?order.id=${o.id}">鍌崠瀹跺彂璐?</button> --%>
									
								</c:if>

								<c:if test="${o.status=='waitReview' }">
									<a href="forereview?order.id=${o.id}">
										<button  class="orderListItemReview">璇勪环</button>
									</a>
								</c:if>
							</td>						
						</c:if>
					</tr>
				</c:forEach>		
				
			</table>
		</c:forEach>
		
	</div>
	
</div>