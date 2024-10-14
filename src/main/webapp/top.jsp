<%--
  Created by IntelliJ IDEA.
  User: Flobby
  Date: 2023/2/19
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.soft.book.model.vo.UserVO" %>
<%@ page import="com.soft.book.model.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
  UserVO user = (UserVO) request.getSession().getAttribute("user");
  request.setAttribute("user", user);
%>
<ul>
  <li>
    <a href="${pageContext.request.contextPath}/index">首页</a>
  </li>
  <li>
    <a href="#">读书</a>
  </li>
  <li>
    <a href="#">音乐</a>
  </li>
  <li>
    <a href="#">小组</a>
  </li>
  <li>
    <a href="#">同城</a>
  </li>
  <li>
    <a href="#">FM</a>
  </li>
  <li>
    <a href="#">时间</a>
  </li>
  <li>
    <a href="#">更多</a>
  </li>
</ul>

<ul>
  <%--根据user是否为空，显示不同的内容--%>
  <%
    if (user != null) {
  %>
  <li>
    <a href="${pageContext.request.contextPath}/user/userinfo">
      <img src="${user.avatar}" alt="" class="avatar">
    </a>
  </li>
  <li>
    <a href="${pageContext.request.contextPath}/logout">退出</a>
  </li>
  <%
  } else {
  %>
  <a href="${pageContext.request.contextPath}/login">去登录</a>
  <%
    }
  %>
</ul>
