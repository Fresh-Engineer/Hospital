<%--
  Created by IntelliJ IDEA.
  User: sihongxiao
  Date: 2021/12/28
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>反馈表</title>
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
    <div class="blog">
        <div class="blog_input">
            <form class="blog_text" action="AddBlog.do" method="post">
                <label>
                    <textarea maxlength="80" rows="2" cols="42" name="blog" placeholder="说点什么吧"
                              onkeyup="wordStatic(this)" class="blog_content" id="blog" required="required"></textarea>
                    <span id="wordsLength" class="words_length">0/80</span>
                </label>
                <label>
                    <input type="text" placeholder="请输入姓名，不超过十位" maxlength="10" autocomplete="off" name="user_name"
                           class="user_name" id="user_name" required="required">
                    <input type="submit" style="color: white" class="blog_sent" value="发送">
                    <input type="button" style="color: white" class="reset" value="重置"
                           onclick="clearTextArea(); this.form.blog.value='';this.form.user_name.value='';">
                </label>
            </form>
        </div>
    </div>

    <div class="blog_body">
        <ul id="ul">
            <c:forEach items="${list}" var="list">
                <li>
                    <div class="blog_father">
                        <h3>${list.user_name}</h3>
                        <p>${list.blog_content}</p>
                        <span>时间： ${list.date}</span>
                        <div class="blog_bottom">
                            <a href="ShowUpdate.do?father_id=${list.father_id}">编辑</a>
                            <a href="DeleteBlog.do?father_id=${list.father_id}">删除</a>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
    <a href="index.jsp"><h2>返回系统主页</h2></a>
    <script src="js/jquery-3.5.1.js"></script>
    <script src="js/index.js"></script>
</div>
</body>
</html>