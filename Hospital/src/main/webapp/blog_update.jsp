<%--
  Created by IntelliJ IDEA.
  User: sihongxiao
  Date: 2021/12/28
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑反馈</title>
    <style>
        * {
            padding: 0;
            margin: 0;
        }

        h1 {
            text-align: center;
            font-size: 45px;
            font-family: 楷体;
            line-height: 80px;
            vertical-align: middle;
        }
        a {
            text-decoration: none;
            text-align: center;
        }
        a h3 {
            margin: 0 auto;
        }
    </style>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/common.css">
</head>
<body>
<div id="push">
    <h1>患者反馈表</h1>
    <marquee direction="left" style="margin: 0 150px; width: 1503px; background: darkgrey" scrollamount="20"
             onmouseout="this.start()" onmouseover="this.stop()">大家好！文明留言，从我做起！
    </marquee>
    <c:forEach var="blogFather" items="${blogFather}">
        <div class="blog">
            <div class="blog_input">
                <form class="blog_text" action="UpdateBlog.do" method="post">
                    <label>
                        <textarea maxlength="80" rows="2" cols="42" name="blog_content" onkeyup="wordStatic(this)"
                                  class="blog_content" id="blog"
                                  required="required">${blogFather.blog_content}</textarea>
                        <span id="wordsLength" class="words_length">0/80</span>
                    </label>
                    <label>
                        <input type="text" placeholder="请输入姓名，不超过十位" required="required" value="${blogFather.user_name}"
                               maxlength="10" autocomplete="off" name="user_name"
                               class="user_name" id="user_name">
                        <input type="text" name="father_id" value="${blogFather.father_id}" hidden>
                        <input type="submit" style="color: white" class="blog_sent" value="发送">
                        <input type="button" style="color: white" class="reset" value="重置"
                               onclick="clearTextArea(); this.form.blog.value='';this.form.user_name.value='';">
                    </label>
                </form>
            </div>
        </div>
    </c:forEach>
    <a href="javascript:" onclick="history.go(-1)"><h3>取消</h3></a>
</div>

<script src="js/jquery-3.5.1.js"></script>
<script src="js/index.js"></script>
</body>
</html>
