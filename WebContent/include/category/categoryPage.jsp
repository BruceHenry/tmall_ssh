<!-- ģ����è��վj2ee �̳� Ϊhow2j.cn ��Ȩ����-->
<!-- ���̳̽�����ѧϰʹ�ã��������ڷǷ���;���ɴ�����һ�к���뱾վ�޹�-->
<!-- ��������ѧϰ������˽�Դ������������ге���ط�������-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<title>模仿天猫官网-${category.name}</title>	
<div id="category">
	<div class="categoryPageDiv">
		<img src="img/category/${category.id}.jpg">
		<%@include file="sortBar.jsp"%>
		<%@include file="productsByCategory.jsp"%>
		
	</div>

</div>