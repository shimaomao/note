var element, form, layer, layedit,laydate;
var noteListCache = new Array();
var bookListCache = new Array();
var noteTitle_def = '声明';
var notetxt_def = '本系统作为个人毕业设计而开发。开放免费试用。';
var noteText,userCache,pwdDiv;
$(function() {
    init();
    //用户名称
    initUser();
    //查询记事本 ()
    selectNoteBook();
    //添加笔记本
    showAddNoteBook();
    //点击笔记本查询笔记
    loadNoteListInit();
    //点击添加笔记本
    showAddNote();
    //展示笔记
    showNote();
    //初始化，模拟点击第一个tab
    var li = $(".book_BLI")[0];
    $(li).trigger("click");
    //初始化，模拟点击第一个li
    var div = $(".layui-tab-item")[0];
    $(div).addClass("layui-show");

    //展示编辑笔记本
    showEditBook();
    //编辑笔记本
    editBook();
    //编辑笔记
    editNote();

    //更新用户
    signOut();

});

function initUser(){
    $.ajax({
        url: '/user/signUser',
        type: 'get',
        success: function(data) {
            if (data.data) {
                userCache  = data.data;
                $("#userName_B").html(userCache.userName);
                $("#user_name_B").val(userCache.userName);
                 if (userCache.userBirthday) {
                $("#user_birthday_B").val(new Date(userCache.userBirthday).Format("yyyy-MM-dd"));
                var a= jsGetAge(new Date(userCache.userBirthday).Format("yyyy-MM-dd"));
                //alert(a);
                $("#user_age_B").val(a);
                }
                $("input[type='radio'][name='userSex'][value='"+userCache.userSex+"']").attr("checked","checked");
            }else{
                $("#userName_B").html('未登录');
                alert("未登录");
                location.href="/"
            }
        }
    });
    $("#userName_B").click(function(){
        layer.open({
            type: 1,
            title: '修改资料',
            shadeClose: true,
            skin: 'layui-layer-rim',
            //加上边框
            content: $("#edit_user")
        });
    });
    $("#update_password_B").click(function(){
        pwdDiv = layer.open({
            //area: ['800px', '600px'],
            type: 1,
            shadeClose: true,
            title: "修改密码",
            skin: 'layui-layer-rim',
            //加上边框
            content: $("#update_password_D"),
            end: function(index, layero) {
                $("#old_pwd_I").val('');
                $("#new_pwd_I").val('');
                $("#new_pwd_II").val('');
            }
        })
    });
}

function signOut(){
    $("#signOut_B").click(function() {
        $.post('/notej/notebook');
        location.href="/"
    });
}

function getNoteText(){
    return noteText;
}
function shareNote(noteId, data) {
    var res;
    $.ajax({
        url: '/notej/note/' + noteId + '/share',
        type: 'post',
        data: data,
        async: false,
        success: function (data) {
            res = data;
        }
    });
    return res;
}

function editNote() {

    $("#share_note").click(function () {
        var noteId = $(this).attr('note_id');
        layer.confirm('分享笔记', {
            shadeClose: true,
            time: 0 //不自动关闭
            , btn: ['私密分享', '公开分享']

        }, function (index) {
            layer.prompt({title: '输入口令，不输入将默认随机口令', formType: 1,allowBlank: true}, function (val, index2) {
                //layer.msg('得到了'+val);
                if (val.length > 8) {
                    layer.msg("pin码不能超过8位");
                    return;
                }
                layer.close(index2);
                layer.close(index);
                var data = '{"pin":"' + val + '","type":1}';
                var res = shareNote(noteId, data);
                layer.alert("分享地址：" + res.data.uri + (res.data.pin != '' ? "</br>PIN码：" + res.data.pin : ""), {
                    icon: 6,
                    title: "分享成功",
                    area: ['400px']
                });

            });
        }, function (index) {
            //layer.alert('见到你真的很高兴', {icon: 6});
            //layer.close(index);
            var data = '{"type":0}';
            var res = shareNote(noteId, data);
            layer.alert("分享地址：" + res.data.uri + (res.data.pin != '' ? "</br>PIN码：" + res.data.pin : ""), {
                icon: 6,
                title: "分享成功",
                area: ['400px']
            });
        });
    });

    $('#del_note').click(function() {
        var noteId = $(this).attr('note_id');
        layer.msg('确定要删除笔记吗？', {
            time: 0 ,//不自动关闭
            btn: ['是', '否'],
            yes: function(index) {
                layer.close(index);
                //删除笔记，逻辑删除
                $.ajax({
                    url: '/notej/note/' + noteId,
                    type: 'delete',
                    success: function(data) {
                        if (data.data) {
                            $('.note_C[noteid=' + noteId + ']').remove();
                            $("#note_top").hide();
                            $("#note_text_id").html(notetxt_def);
                            $("#note_title_B").html(noteTitle_def);
                        }
                    }
                });
            }
        });
    });
    $('#edit_note').click(function() {
        var noteId = $(this).attr('note_id');
        $.each(noteListCache,
            function(i, v) {
                if (v.noteId == noteId) {
                    $("#note_title").val(v.noteTitle);

                    $.each($("#note_book_id option"),
                        function(index, value) {
                            if ($(value).val() == v.noteBookId) {
                                $(value).attr("selected", true);
                            } else {
                                $(value).attr("selected", false);
                            }
                        });
                    $("#noteid_B").val(v.noteId);
                    noteText = v.noteBookText;
                    form.render();
                }
            });
                layer = layui.layer;
                layer.open({
                    area: ['800px', '600px'],
                    type: 1,
                    shadeClose: true,
                    title: "编辑笔记",
                    skin: 'layui-layer-rim',
                    //加上边框
                    content: $("#addnote_div_B"),
                    end: function (index, layero) {
                        $("#note_title").val('');
                        //$("#noteBookText").val('');
                        form.render();
                    }
                });



    });
}

var bookIsChange = false;
//打开笔记本管理窗口
function showEditBook() {
    $("#editBook").click(function() {
        $("#book_table_list").html('');
        $.each(bookListCache,
            function(i, v) {
                var str = '<tr id="book_tr_' + v.noteBookId + '">' + '<td id="book_name_' + v.noteBookId + '" >' + v.noteBookName + '</td>' + '<td>' + '<button bookid="' + v.noteBookId + '" class="layui-btn layui-btn-small edit_book"> <i class="layui-icon">&#xe642;</i></button>';
                if (v.noteBookType != 1) {

                    str += '<button bookid="' + v.noteBookId + '" class="layui-btn layui-btn-small del_book"> <i class="layui-icon">&#xe640;</i></button>';
                }
                str += '</td>' + '</tr>';
                $("#book_table_list").append(str);
            });

        layer.open({
            area: ['350px'],
            type: 1,
            shadeClose: true,
            title: "笔记本管理",
            skin: 'layui-layer-rim',
            //加上边框
            content: $("#edit_book_B"),
            end: function(index, layero) {
                if (bookIsChange) location.reload(false);
            }
        })
    });
}
function editBook() {
    //修改笔记本名称
    $("#book_table_list").on('click', '.edit_book',
        function() {
            var bookid = $(this).attr("bookid");
            layer.prompt({
                    title: '输入新的笔记本名称'
                },
                function(pass, index) {
                    layer.close(index);
                    //更新名称
                    var data = '{"noteBookId":"' + bookid + '","noteBookName":"' + pass + '"}';
                    $.ajax({
                        url: '/notej/notebook',
                        data: data,
                        type: 'patch',
                        success: function(data) {
                            if (data.data) {
                                $("#book_name_" + bookid).html(pass);
                                bookIsChange = true;
                            }
                        }
                    });

                })
        });
    //删除笔记本
    $("#book_table_list").on('click', '.del_book',
        function() {
            var bookid = $(this).attr("bookid");
            layer.msg('删除笔记本<br/>如果该笔记本下存在笔记，将被转移到默认笔记本中', {
                time: 0 //不自动关闭
                ,
                btn: ['了解', '不删了'],
                yes: function(index) {
                    layer.close(index);
                    $.ajax({
                        url: '/notej/notebook/' + bookid,
                        type: 'delete',
                        success: function(data) {
                            if (data.data) {
                                $("#book_tr_" + bookid).remove();
                                bookIsChange = true;
                            }
                        }
                    });
                }
            });
        });
}

var noteEdit;
function init() {
    layui.use(['element', 'form', 'layer', 'layedit','laydate'],
        function() {
            element = layui.element();
            form = layui.form();
            layer = layui.layer;
            layedit = layui.layedit;
            laydate = layui.laydate;
            form.on('submit(addBook)',
                function(data) {
                    $.post('/notej/notebook', JSON.stringify(data.field),
                        function(result) {
                            if (result.data) {
                                //返回数据
                                $("#addBook").before('<li class="book_BLI" bookId="' + result.data.noteBookId + '" ><a href="javascript:void(0)">' + result.data.noteBookName + '</a></li>');
                                $("#bookList_content_B").append('<div class="layui-tab-item"><div class="noteList_div_C"><ul class="noteList_ul_B"bookId="' + result.data.noteBookId + '"><li class="add_note_C" bookId="' + result.data.noteBookId + '"><a href="javascript:void(0)">添加</a></li></ul></div></div>');
                                $("#note_book_id").append('<option value="' + result.data.noteBookId + '">' + result.data.noteBookName + '</option>');
                                form.render('select'); //刷新下拉框
                                layer.closeAll();
                                $("input[name='noteBookName']").val('');
                                bookListCache.push(result.data);
                            } else {
                                //alert(result.msg)
                            }
                        });
                    return false;
                });

            form.on('submit(addNote)',
                function(data) {
                    //data.field.noteBookText=$($("#note_text_ifr").contents().find("iframe").contents().find("body")).html();
                    //data.field.noteBookText = layedit.getContent(noteEdit);
                    //layer.msg( note_text_ifr_name.window.getnoteEdit());
                    data.field.noteBookText = note_text_ifr_name.window.getnoteEdit();
                    var noteid = $("#noteid_B").val();
                    if(!noteid) {
                        $.post('/notej/note', JSON.stringify(data.field),
                            function (result) {
                                //获取对应的添加按钮
                                var li = $('.add_note_C[bookid="' + data.field.noteBookId + '"]');
                                $(li).after('<li  class="note_C" noteId="' + result.data.noteId + '" ><a href="javascript:void(0)">' + result.data.noteTitle + '</a></li>');
                                //layer.open(result);
                                layer.closeAll();
                                noteListCache.push(result.data);
                            });
                    }else{
                        data.field.noteId = noteid;
                        $.ajax({
                            url: '/notej/note',
                            data: JSON.stringify(data.field),
                            type: 'patch',
                            success: function(data) {
                                if (data.data) {
                                    location.reload(false);
                                }
                            }
                        });
                    }


                    //var m = '';
                    //$.ajax({
                    //    url: '/notej/notebook',
                    //    data: data,
                    //    type: m,
                    //    success: function(data) {
                    //        if (data.data) {
                    //            $("#book_name_" + bookid).html(pass);
                    //            bookIsChange = true;
                    //        }
                    //    }
                    //});


                    return false;
                });
            form.on('submit(update_user_B)',
                function(data) {
                    $.ajax({
                        url: '/user/info',
                        data: JSON.stringify(data.field),
                        type: 'patch',
                        success: function(data) {
                            if (data.data) {
                                layer.closeAll();
                                //location.reload(false);
                            }
                        }
                    });
                    return false;
                });
             form.on('submit(update_pwd_B)',
                function(data) {
                    var newPwdII = $("#new_pwd_II").val();
                    var newPwd = data.field.newPwd;

                    if(newPwdII!=newPwd){
                        layer.tips('两次密码输入不相同', '#new_pwd_II');
                    }else if (newPwdII.length<6){
                        layer.tips('密码长度必须大于6位', '#new_pwd_II');
                    }
                     else {
                        $.ajax({
                            url: '/user/pwd',
                            data: JSON.stringify(data.field),
                            type: 'patch',
                            success: function (data) {
                                if (data.data) {
                                   layer.msg("密码修改成功",{
                                       time:1400,
                                       icon: 2,
                                       skin: 'layer-ext-moon'
                                   });
                                   layer.close(pwdDiv);
                                }else{
                                    layer.msg(data.msg,{
                                        time:2000,
                                        icon: 2,
                                        skin: 'layer-ext-moon'
                                    })
                                }
                            }
                        });
                    }
                    return false;
                });

            var start = {
                max: laydate.now()
                //,max: '2099-06-16 23:59:59'
                ,istoday: false
                ,choose: function(datas){

                    var a= jsGetAge(datas);
                    //alert(a);
                    $("#user_age_B").val(a);
                }
            };
            document.getElementById('user_birthday_B').onclick = function(){
                start.elem = this;
                laydate(start);
            }
        });
    //点击变色
    $("li").click(function() {
        $(this).siblings().removeClass("active");
        $(this).addClass("active");
    });

};

//添加笔记
function showAddNote() {
    $("body").on('click', '.add_note_C',
        function() {
            var bookId = $(this).attr("bookId");
            $.each($("#note_book_id option"),
                function(index, value) {
                    if ($(value).val() == bookId) {
                        $(value).attr("selected", true);
                    } else {
                        $(value).attr("selected", false);
                    }
                });
            form.render();
            noteText = '';
            layer.open({
                area: ['800px', '600px'],
                type: 1,
                shadeClose: true,
                title: "添加笔记",
                skin: 'layui-layer-rim',
                //加上边框
                content: $("#addnote_div_B"),
                end: function(index, layero) {
                    $("#note_title").val('');
                    $("#noteBookText").val('');
                    form.render();
                }
            })
        })
}

//添加笔记本
function showAddNoteBook() {
    $("#addBook").click(function() {
        layer.open({
            type: 1,
            title: '新建笔记本',
            shadeClose: true,
            skin: 'layui-layer-rim',
            //加上边框
            content: $("#addBook_div_B")
        });
    });
}

function loadNoteListInit() { //TODO
    $(".book_BLI").click(function() {
        //判断是否第一次点击
        var load = $(this).attr("is_load");
        if (load) return;
        $(this).attr("is_load", "true");
        var bookId = $(this).attr("bookId");
        loadNoteList(bookId);
    });
}

function loadNoteList(bookId, pageNum) {
    $.ajax({
        type: "get",
        url: "/notej/note/" + bookId,
        async: false,
        //data:data,
        //同步处理
        success: function(result) {
            var page = result.data.page;
            var list = result.data.list;
            $.each(list,
                function(index, value) {
                    $(".noteList_ul_B[bookid='" + bookId + "']").append('<li class="note_C" noteId="' + value.noteId + '" ><a href="javascript:void(0)">' + value.noteTitle + '</a></li>');
                    noteListCache.push(value);
                });

        }
    });
}

//createTime
//    :
//    1490168325000
//noteBookId
//    :
//    1
//noteBookTag
//    :
//    "标识"
//noteId
//    :
//    2
//noteState
//    :
//    0
//noteTitle
//    :
//    "第一"
//userId
//    :
//    12
function selectNoteBook() {
    //查询用户的记事本
    $.ajax({
        type: "get",
        url: "/notej/notebook",
        async: false,
        //data:data,
        //同步处理
        success: function(result) {
            if (result.data) {
                bookList(result.data);
            } else {
              //  alert(result.msg)
            }
        }
    });
}

function bookList(data) {
    $("#bookList_content_B").html('');
    bookListCache = data;
    $.each(data,
        function(index, value) {
            $("#addBook").before('<li class="book_BLI" bookId="' + value.noteBookId + '" ><a href="javascript:void(0)">' + value.noteBookName + '</a></li>');
            $("#bookList_content_B").append('<div class="layui-tab-item"><div class="noteList_div_C"><ul class="noteList_ul_B"bookId="' + value.noteBookId + '"><li class="add_note_C" bookId="' + value.noteBookId + '" ><a href="javascript:void(0)">添加新笔记</a></li></ul></div></div>');
            $("#note_book_id").append('<option value="' + value.noteBookId + '">' + value.noteBookName + '</option>');
        });
    $("#bookList_content_B").after('<fieldset class="layui-elem-field">' + '<div id="note_top" style="display: none" >添加时间 <span id="note_createtime" style="margin-right: 200px;">2017年04月03日</span> ' + ' <button note_id="" id="edit_note" class="layui-btn layui-btn-mini edit_note"> <i class="layui-icon"></i> </button> ' + '<button note_id="" id="del_note" class="layui-btn layui-btn-mini del_note"> <i class="layui-icon">&#xe640;</i> </button><button note_id="" id="share_note" class="layui-btn layui-btn-mini del_note"> <i class="layui-icon">&#xe641;</i> </button></div>' + ' <legend id="note_title_B">' + noteTitle_def + '</legend> <div id="note_text_id" class="layui-field-box"> ' + notetxt_def + '</div></fieldset>');

}

function showNote() {
    $("body").on('click', '.note_C',
        function() {
            var noteid = $(this).attr("noteid");
            $.each(noteListCache,
                function(i, v) {
                    if (v.noteId == noteid) {
                        $("#note_top").show();
                        $("#note_createtime").html(new Date(v.createTime).Format("yyyy-MM-dd hh:mm:ss"));
                        $("#note_title_B").html(v.noteTitle);
                        $("#note_text_id").html('');
                        $("#note_text_id").html(v.noteBookText);
                        $("#edit_note").attr("note_id", v.noteId);
                        $("#share_note").attr("note_id", v.noteId);
                        $("#del_note").attr("note_id", v.noteId);
                    }
                })
        })
}