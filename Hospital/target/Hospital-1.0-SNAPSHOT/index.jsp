<%--
  Created by IntelliJ IDEA.
  User: 斯洪霄
  Date: 2021/12/26
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>医疗管理系统</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/patientcss.css">
    <link rel="stylesheet" href="css/image.css">
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .content {
            margin: 0 auto;
            width: 1900px;
            height: 800px;
            background: white;
            opacity: .6;
        }

        .nav-bar {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            width: 1900px;
            height: 60px;
            background: aqua;
            opacity: 1;
        }

        .nav-bar h2 {
            margin: 0 auto;
            width: 150px;
            height: 60px;
            line-height: 60px;
            vertical-align: middle;
        }

        .username {
            padding-left: 20px;
            width: 120px;
            height: 40px;
            border-radius: 10px;
            background: #cccccc;
            line-height: 40px;
            vertical-align: bottom;
            margin: 10px 0 10px 160px;
        }

        .control {
            display: flex;
            flex-direction: row;
            justify-content: space-around;
            width: 480px;
            height: 60px;
            line-height: 60px;
            vertical-align: bottom;
        }

        .control input {
            margin-top: 10px;
            height: 40px;
            width: 120px;
            background: cornflowerblue;
            border: none;
            border-radius: 5px;
            font-size: 20px;
        }

        .side-content h3 {
            line-height: 60px;
            vertical-align: middle;
            text-align: center;
        }

        .body {
            display: flex;
            flex-direction: row;
            justify-content: space-around;
        }

        .left-side, .right-side {
            display: flex;
            flex-direction: column;
            justify-content: space-around;
            margin: 100px auto;
            text-align: center;
            width: 240px;
            height: 512px;
        }

        .left-side input, .right-side input {
            margin: 0 auto;
            width: 160px;
            height: 50px;
            background: cornflowerblue;
            border: none;
            border-radius: 5px;
            font-size: 20px;
        }
    </style>
</head>
<body>
<!--<h2 style="text-align: center; margin: 0 auto">欢迎来到医疗管理系统</h2>-->
<div class="content">
    <div class="nav-bar left">
        <div class="username">
            用户:&nbsp;&nbsp;${admin.username}
        </div>
        <div class="username">
            在线人数：&nbsp;&nbsp;${OnlineCount}
        </div>
        <h2>医疗管理系统</h2>
        <div class="control">
            <input type="button" value="申请注销" id="button1" onclick="goto1()" onmousedown="changeColor1()"
                   onmouseup="exchangeColor1()" style="margin-left: 50px;">
            <input type="button" value="退出系统" id="button2" onclick="goto2()" onmousedown="changeColor2()"
                   onmouseup="exchangeColor2()" style="margin-right: 100px;">
        </div>
    </div>
    <%--滚动字幕--%>
    <marquee direction="left" style="margin: 0 auto; width: 1900px; background: darkgrey" scrollamount="20"
             onmouseout="this.start()" onmouseover="this.stop()">在这里，你将感受到最优质的服务。
    </marquee>
    <%--轮播图--%>
    <div class="body">
        <div class="left-side">
            <input type="button" id="button3" onclick="goto3()" onmousedown="changeColor3()"
                   onmouseup="exchangeColor3()" value="患者信息管理">
            <input type="button" id="button4" onclick="goto4()" onmousedown="changeColor4()"
                   onmouseup="exchangeColor4()" value="住院信息管理">
            <input type="button" id="button7" onclick="goto7()" onmousedown="changeColor7()"
                   onmouseup="exchangeColor7()" value="挂号系统">
            <input type="button" id="button8" onclick="goto8()" onmousedown="changeColor8()"
                   onmouseup="exchangeColor8()" value="费用查询">
            <input type="button" id="button12" onclick="goto12()" onmousedown="changeColor12()"
                   onmouseup="exchangeColor12()" value="患者反馈">
        </div>
        <div class="banner">
            <!--无序列表承载轮播的图片-->
            <ul class="img">
                <li><img src="img/8.jpeg" alt="第1张图片" style="width: 1024px; height: 512px;"></li>
                <li><img src="img/2.jpeg" alt="第2张图片" style="width: 1024px; height: 512px;"></li>
                <li><img src="img/3.jpeg" alt="第3张图片" style="width: 1024px; height: 512px;"></li>
                <li><img src="img/4.jpeg" alt="第4张图片" style="width: 1024px; height: 512px;"></li>
                <li><img src="img/5.jpeg" alt="第5张图片" style="width: 1024px; height: 512px;"></li>
                <li><img src="img/6.jpeg" alt="第6张图片" style="width: 1024px; height: 512px;"></li>
            </ul>
            <!--用来放置圆点具体实施在js代码中呈现-->
            <ul class="num"></ul>
            <!--左右点击按钮-->
            <div class="btn">
                <span class="prev"><</span>
                <span class="next">></span>
            </div>
        </div>
        <div class="right-side">
            <input type="button" id="button5" onclick="goto5()" onmousedown="changeColor5()"
                   onmouseup="exchangeColor5()" value="药品管理">
            <input type="button" id="button6" onclick="goto6()" onmousedown="changeColor6()"
                   onmouseup="exchangeColor6()" value="药品库存管理">
            <input type="button" id="button9" onclick="goto9()" onmousedown="changeColor9()"
                   onmouseup="exchangeColor9()" value="医生管理">
            <input type="button" id="button10" onclick="goto10()" onmousedown="changeColor10()"
                   onmouseup="exchangeColor10()" value="科室管理">
            <input type="button" id="button11" onclick="goto11()" onmousedown="changeColor11()"
                   onmouseup="exchangeColor11()" value="手术管理">
        </div>
    </div>

</div>
</body>
<script src="js/jquery-3.5.1.js"></script>
<script src="js/image.js"></script>
<script>
    function goto1() {
        window.location.href = 'Delete.do?id=${admin.id}';
    }
    function goto2() {
        window.location.href = 'Logout.do';
    }
    function goto3() {
        window.location.href = 'FindAllPatient.do';
    }
    function goto4() {
        window.location.href = 'FindInPatient.do';
    }
    function goto5() {
        window.location.href = 'mfindAll.do';
    }
    function goto6() {
        window.location.href = 'msfindAll.do';
    }
    function goto7(){
        window.location.href = 'findByRegist.do';
    }
    function goto8(){
        window.location.href = 'cost.do';
    }
    function goto9(){
        window.location.href = 'dfindAll.do';
    }
    function goto10(){
        window.location.href = 'kfindAll.do';
    }
    function goto11(){
        window.location.href = 'sfindAll.do';
    }
    function goto12(){
        window.location.href = 'ShowBlog.do';
    }

    function changeColor1() {
        $('#button1').css('background', 'blue');
    }

    function changeColor2() {
        $('#button2').css('background', 'blue');
    }

    function changeColor3() {
        $('#button3').css('background', 'blue');
    }

    function changeColor4() {
        $('#button4').css('background', 'blue');
    }
    function changeColor5() {
        $('#button5').css('background', 'blue');
    }
    function changeColor6() {
        $('#button6').css('background', 'blue');
    }
    function changeColor7() {
        $('#button7').css('background', 'blue');
    }
    function changeColor8() {
        $('#button8').css('background', 'blue');
    }
    function changeColor9() {
        $('#button9').css('background', 'blue');
    }
    function changeColor10() {
        $('#button10').css('background', 'blue');
    }
    function changeColor11() {
        $('#button11').css('background', 'blue');
    }
    function changeColor12() {
        $('#button12').css('background', 'blue');
    }


    function exchangeColor1() {
        $('#button1').css('background', 'cornflowerblue');
    }

    function exchangeColor2() {
        $('#button2').css('background', 'cornflowerblue');
    }

    function exchangeColor3() {
        $('#button3').css('background', 'cornflowerblue');
    }

    function exchangeColor4() {
        $('#button4').css('background', 'cornflowerblue');
    }
    function exchangeColor5() {
        $('#button5').css('background', 'cornflowerblue');
    }

    function exchangeColor6() {
        $('#button6').css('background', 'cornflowerblue');
    }
    function exchangeColor7() {
        $('#button7').css('background', 'cornflowerblue');
    }

    function exchangeColor8() {
        $('#button8').css('background', 'cornflowerblue');
    }
    function exchangeColor9() {
        $('#button9').css('background', 'cornflowerblue');
    }
    function exchangeColor10() {
        $('#button10').css('background', 'cornflowerblue');
    }
    function exchangeColor11() {
        $('#button11').css('background', 'cornflowerblue');
    }
    function exchangeColor12() {
        $('#button12').css('background', 'cornflowerblue');
    }
</script>
</html>
