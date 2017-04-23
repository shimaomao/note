
$(function() {
    $('#switch_qlogin').click(function() {
        $('#switch_login').removeClass("switch_btn_focus").addClass('switch_btn');
        $('#switch_qlogin').removeClass("switch_btn").addClass('switch_btn_focus');
        $('#switch_bottom').animate({
            left: '0px',
            width: '70px'
        });
        $('#qlogin').css('display', 'none');
        $('#web_qr_login').css('display', 'block');

    });
    $('#switch_login').click(function() {

        $('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
        $('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
        $('#switch_bottom').animate({
            left: '154px',
            width: '70px'
        });

        $('#qlogin').css('display', 'block');
        $('#web_qr_login').css('display', 'none');
    });
    if (getParam("a") == '0') {
        $('#switch_login').trigger('click');
    }

});

function logintab() {
    scrollTo(0);
    $('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
    $('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
    $('#switch_bottom').animate({
        left: '154px',
        width: '96px'
    });
    $('#qlogin').css('display', 'none');
    $('#web_qr_login').css('display', 'block');

}

//根据参数名获得该参数 pname等于想要的参数名 
function getParam(pname) {
    var params = location.search.substr(1); // 获取参数 平且去掉？ 
    var ArrParam = params.split('&');
    if (ArrParam.length == 1) {
        //只有一个参数的情况 
        return params.split('=')[1];
    } else {
        //多个参数参数的情况 
        for (var i = 0; i < ArrParam.length; i++) {
            if (ArrParam[i].split('=')[0] == pname) {
                return ArrParam[i].split('=')[1];
            }
        }
    }
}

var reMethod = "post",
pwdmin = 6;
var element,form,layer;
$(document).ready(function() {
    layui.use(['element','form','layer'], function(){
        element = layui.element();
        form = layui.form();
        layer = layui.layer;
    });
	//注册按钮
    $('#reg').click(function() {
    	var dataVai = true;
        if ($('#user').val() == "") {
            $('#user').focus().css({
                border: "1px solid red",
                boxShadow: "0 0 2px red"
            });
            $('#userCue').html("<font color='red'><b>×用户名不能为空</b></font>");
            dataVai = false;return false;
        }
        if ($('#email').val() == "") {
            $('#email').focus().css({
                border: "1px solid red",
                boxShadow: "0 0 2px red"
            });
            $('#userCue').html("<font color='red'><b>×邮箱地址不能为空</b></font>");
            dataVai = false;return false;
        }

        if ($('#user').val().length < 4 || $('#user').val().length > 16) {
            $('#user').focus().css({
                border: "1px solid red",
                boxShadow: "0 0 2px red"
            });
            $('#userCue').html("<font color='red'><b>×用户名位4-16字符</b></font>");
            dataVai = false;return false;
        }else{
        	$('#user').css({
                border: "1px solid #D7D7D7",
                boxShadow: "none"
            });
            $('#userCue').html("");
        }
      

        if ($('#passwd').val().length < pwdmin) {
            $('#passwd').focus().css({
                border: "1px solid red",
                boxShadow: "0 0 2px red"
            });
            $('#userCue').html("<font color='red'><b>×密码不能小于" + pwdmin + "位</b></font>");
            dataVai = false;return false;
        }else{
        	$('#passwd').css({
                border: "1px solid #D7D7D7",
                boxShadow: "none"
            });
            $('#userCue').html("");
        }
        
        if ($('#passwd2').val() != $('#passwd').val()) {
            $('#passwd2').focus().css({
                border: "1px solid red",
                boxShadow: "0 0 2px red"
            });
            $('#userCue').html("<font color='red'><b>×两次密码不一致！</b></font>");
            dataVai = false;return false;
        }else{
        	 $('#passwd2').css({
                 border: "1px solid #D7D7D7",
                 boxShadow: "none"
             });
             $('#userCue').html("");
        }
        var semail = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        if (!semail.test($('#email').val())) {
            $('#email').focus().css({
                border: "1px solid red",
                boxShadow: "0 0 2px red"
            });
            $('#userCue').html("<font color='red'><b>×邮箱格式不正确</b></font>");
            dataVai = false;return false;
        } else {
            $('#email').css({
                border: "1px solid #D7D7D7",
                boxShadow: "none"
            });
            $('#userCue').html("");

        }
        $.ajax({
            type: reMethod,
            url: "/login/check/" + $("#user").val(),
            async: false,
            //同步处理
            success: function(result) {
                if (result.data) {
                    $('#user').css({
                        border: "1px solid #D7D7D7",
                        boxShadow: "none"
                    });
                    $('#userCue').html("");
                } else {
                    $('#user').focus().css({
                        border: "1px solid red",
                        boxShadow: "0 0 2px red"
                    });
                    $("#userCue").html("用户名已经存在");
                    dataVai = false;return false;
                }
            }
        });
        if(dataVai){
        	var data='{"userName":"'+$("#user").val()+'","userPassWord":"'+$("#passwd").val()+'","userEmail":"'+$("#email").val()+'"}';
        	$.ajax({
                type: reMethod,
                url: "/login/SignUp" ,
                async: false,
                data:data,
                //同步处理
                success: function(result) {
                    if (result.data) {
                        layer.confirm('注册成功', {
                            btn: ['OK'] //按钮
                        }, function(){
                            location.reload(false)
                        })
                    } else {
                        layer.msg("注册失败",{
                            time:3000,
                            icon: 2,
                            skin: 'layer-ext-moon'
                        })
                    }
                }
            });
        }
    });
    //登录按钮
    $("#singup").click(function(){
    	var u=$("#u").val();
    	var p=$("#p").val();
    	if(u!=''&p!=''){
    		var data='{"userName":"'+u+'","userPassWord":"'+p+'"}';
    		$.ajax({
                type: reMethod,
                url: "/login/SignIn" ,
                async: false,
                data:data,
                //同步处理
                success: function(result) {
                    if (result.data) {
                    	location.href="/note/note.html"
                    } else {
                        layer.msg(result.msg,{
                            time:1300,
                            icon: 2,
                            skin: 'layer-ext-moon'
                        })
                    }
                }
            });
    	}else{
            layer.msg("用户名密码不可为空",{
                icon: 0,
                time:1300,
                skin: 'layer-ext-moon'
            })
    	}
    });
});