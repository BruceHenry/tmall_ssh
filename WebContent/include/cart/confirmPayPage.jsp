<!-- 模仿天猫整站j2ee 教程 为how2j.cn 版权所有-->
<!-- 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关-->
<!-- 供购买者学习，请勿私自传播，否则自行承担相关法律责任-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	
<div class="confirmPayPageDiv">
	<div class="confirmPayImageDiv">
		<img src="img/site/comformPayFlow.png">
		<div  class="confirmPayTime1">
			<fmt:formatDate value="${order.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
		</div>
		<div  class="confirmPayTime2">
			<fmt:formatDate value="${order.payDate}" pattern="yyyy-MM-dd HH:mm:ss"/> 
		</div>
		<div class="confirmPayTime3">
			yyyy-MM-dd HH:mm:ss 
		</div>
		

	</div>
	<div class="confirmPayOrderInfoDiv">
		<div class="confirmPayOrderInfoText">鎴戝凡鏀跺埌璐э紝鍚屾剰鏀粯瀹濅粯娆?</div>
	</div>
	<div class="confirmPayOrderItemDiv">
		<div class="confirmPayOrderItemText">璁㈠崟淇℃伅</div>
		<table class="confirmPayOrderItemTable">
			<thead>
				<th colspan="2">瀹濊礉</th>		
				<th width="120px">鍗曚环</th>		
				<th width="120px">鏁伴噺</th>		
				<th width="120px">鍟嗗搧鎬讳环 </th>		
				<th width="120px">杩愯垂</th>		
			</thead>
			<c:forEach items="${order.orderItems}" var="oi">
				<tr>
					<td><img width="50px" src="img/productSingle_middle/${oi.product.firstProductImage.id}.jpg"></td>
					<td class="confirmPayOrderItemProductLink">
						<a href="#nowhere">${oi.product.name}</a>
					</td>
					<td>锟?<fmt:formatNumber type="number" value="${oi.product.originalPrice}" minFractionDigits="2"/></td>
					<td>1</td>
					<td><span class="conformPayProductPrice">锟?<fmt:formatNumber type="number" value="${oi.product.promotePrice}" minFractionDigits="2"/></span></td>
					<td><span>蹇?? 锛? 0.00 </span></td>
				</tr>
			</c:forEach>
		</table>
		
		<div class="confirmPayOrderItemText pull-right">
			瀹炰粯娆撅細 <span class="confirmPayOrderItemSumPrice">锟?<fmt:formatNumber type="number" value="${order.total}" minFractionDigits="2"/></span>
		</div>
		
		
	</div>
	<div class="confirmPayOrderDetailDiv">
		
		<table class="confirmPayOrderDetailTable">
			<tr>
				<td>璁㈠崟缂栧彿锛?</td>
				<td>${order.orderCode} <img width="23px" src="img/site/confirmOrderTmall.png"></td>
			</tr>
			<tr>
				<td>鍗栧鏄电О锛?</td>
				<td>澶╃尗鍟嗛摵 <span class="confirmPayOrderDetailWangWangGif"></span></td>
			</tr>
			<tr>
				<td>鏀惰揣淇℃伅锛? </td>
				<td>${order.address}锛?${order.receiver}锛? ${order.mobile}锛?${order.post} </td>
			</tr>
			<tr>
				<td>鎴愪氦鏃堕棿锛?</td>
				<td><fmt:formatDate value="${order.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
		</table>
		
	</div>
	<div class="confirmPayButtonDiv">
		<div class="confirmPayWarning">璇锋敹鍒拌揣鍚庯紝鍐嶇‘璁ゆ敹璐э紒鍚﹀垯鎮ㄥ彲鑳介挶璐т袱绌猴紒</div>
		<a href="foreorderConfirmed?order.id=${order.id}"><button class="confirmPayButton">纭鏀粯</button></a>
	</div>
</div>