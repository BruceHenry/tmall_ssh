<!-- 模仿天猫整站j2ee 教程 为how2j.cn 版权所有-->
<!-- 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关-->
<!-- 供购买者学习，请勿私自传播，否则自行承担相关法律责任-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	
<div class="aliPayPageDiv">
	<div class="aliPayPageLogo">
		<img class="pull-left" src="img/site/simpleLogo.png">
		<div style="clear:both"></div>
	</div>
	
	<div>
		<span class="confirmMoneyText">鎵竴鎵粯娆撅紙鍏冿級</span>
		<span class="confirmMoney">
		锟?<fmt:formatNumber type="number" value="${param.total}" minFractionDigits="2"/></span>
		
	</div>
	<div>
		<img class="aliPayImg" src="img/site/alipay2wei.png">
	</div>

	
	<div>
		<a href="forepayed?order.id=${order.id}&total=${param.total}"><button class="confirmPay">纭鏀粯</button></a>
	</div>

</div>