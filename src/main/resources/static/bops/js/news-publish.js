// Call the dataTables jQuery plugin
$(document).ready(function() {
    //根路径
    var appServer = $("#appServer").val();
    //新闻ID
    var newsId = $("#newsId").val();

    var newsPublishManage ={
        //页面初始化
        initData:function () {
            if (!newsId) {
                //不存在则是发布新闻
                return;
            }
            //ajax --- 编辑新闻
            $.ajax({
                type: "POST",
                url: appServer+"bops/ajax/news/"+newsId+"/query.action",
                cache: false,  //禁用缓存
                data: {},  //传入组装的参数
                dataType: "json",
                contentType:"application/json;charset=utf-8",
                success: function (result) {
                    if(result.success){
                        $("#title").val(result.data.title);
                        $("#preview").attr("new_path",result.data.imagePath);
                        $("#order").val(result.data.order);
                        $("#img-change").attr("src",appServer+result.data.imagePath);
                        $("#newsContent").val(result.data.content);
                    }else {
                        Ewin.alert("操作失败");
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    Ewin.alert("操作失败");
                }
            });
        },
        //其他
        save: function () {
            //保存新闻
            var param = {
                "id":newsId,
                "title":$("#title").val(),
                "imagePath":$("#preview").attr("new_path"),
                "order":$("#order").val(),
                "content":$("#newsContent").val()
            }
            $.ajax({
                type: "POST",
                url: appServer+"bops/ajax/news/publish.action",
                cache: false,  //禁用缓存
                data: JSON.stringify(param),  //传入组装的参数
                dataType: "json",
                contentType:"application/json;charset=utf-8",
                success: function (result) {
                    if(result.success){
                        window.location.href=appServer+"bops/news.action";
                    }else {
                        Ewin.alert("操作失败");
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    Ewin.alert("操作失败");
                }
            });
        }
    };
    //初始化
    var init = function () {
        //初始化数据
        newsPublishManage.initData();
        //预览图片
        $("#preview").change(function () {
            var _this = $(this);
            ImageUtil.preview(_this);
        });
        //上传
        $("#btn-save").click(function () {
            ImageUtil.upload(appServer);
        });
        //保存
        $("#btn-submit").click(function () {
            newsPublishManage.save();
        });
    }
    //页面初始化
    init();













});