/**
 * Created by bobo on 2017/5/3.
 */

//var link = document.documentURI;

var layer;
$(function () {
    init();
});
var type, uri;

function init() {

    var cookies = document.cookie;
    cookies = cookies.replace(/\s+/g, "");

    for (var i = 0; i < cookies.split(";").length; i++) {
        var cookie = cookies.split(";")[i];
        if (cookie.split("=")[0] == 'share-type') type = cookie.split("=")[1];
        if (cookie.split("=")[0] == 'share-uri') uri = cookie.split("=")[1];
    }

    layui.use(['layer'],
        function () {
            layer = layui.layer;
            inputPin();
        });

}

function inputPin(){
    if (!type) {
        layer.msg("该笔记已被删除或被取消分享");

        location.href = "/";
    }
    var pin;

    if (type == 1) {
        layer.prompt({title: '输入PIN，并确认', formType: 1}, function (val, index) {
            pin = val;
            layer.close(index);
            showNote(pin);
        });
    }else{
        showNote(pin);
    }
}

function showNote(pin) {
    if (type == 1 && !pin) {
        layer.msg("PIN码不能为空");
    }

    $.ajax({
        url: '/s/' + uri,
        data: '{"pin":"' + pin + '"}',
        type: 'post',
        success: function (data) {
            if (data.code == 2000) {
            $("#note_title_B").html(data.data.title);
            $("#note_text").html(data.data.txt);
            } else if (data.code == 4103) {
                layer.msg(data.msg,inputPin());

            } else {
                layer.msg(data.data);
            }
        }
    });

}