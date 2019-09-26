$(document).ready(function () {
    var  appServer = $("#appServer").val();

    $('body').on("click","#btn-login-out",function () {
        //登出时间
        $.ajax({
            type:"POST",
            url:appServer+"bops/ajax/login-out.action",
            dataType:"JSON",
            data:{},
            contentType:"application/json;charset=utf-8",
            success:function (result) {
                if(result.success){
                    window.location.href=appServer+"bops/login.action";
                }else {
                    Ewin.alert("修改失败");
                }
            },
            error:function () {
                Ewin.alert("异常");
            }

        });


    });


});