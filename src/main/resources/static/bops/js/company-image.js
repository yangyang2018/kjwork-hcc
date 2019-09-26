$(function () {
    var  appServer = $("#appServer").val();

    var companyImageManage = {
        save : function () {
            var newPath = $("#preview").attr("new_path");
            var comanyId = $("#companyId").val();
            if(!newPath){
                alert("请先上传文件");
                return;
            }
            $.ajax({
                url: appServer+'bops/ajax/image/company/update.action?newPath='+newPath+"&id="+comanyId,
                type: "POST",
                cache: false, //上传文件不需要缓存
                data: {},
                success: function (result) {
                    console.log(result);
                    alert("保存成功");
                    $("#preview").attr("new_path",result.data);
                },
                error: function (result) {
                    console.log(result);
                    alert("保存失败");
                }
            });
        }
    }
    //初始化方法
    var init = function () {
        //预览图片
        $("#preview").change(function () {
            ImageUtil.preview($(this));
        });
        //上传
        $("#btn-save").click(function () {
            ImageUtil.upload(appServer);
        });
        //保存
        $("#btn-submit").click(function () {
            companyImageManage.save();
        });
    }

    //初始化页面
    init();




})