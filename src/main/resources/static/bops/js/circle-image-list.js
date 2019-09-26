$(document).ready(function() {
    //根路径
    var appServer = $("#appServer").val();
    var circleManage={

        save:function (_this) {
            var _tr = $(_this).closest("tr");
            //保存新闻
            var param = {
                "id":_tr.find('td').eq(0).text(),
                "newPath":_tr.find('.btn-preview').attr("new_path")
            }
            $.ajax({
                type: "POST",
                url: appServer+"bops/ajax/image/circle/update.action?id="+param.id+"&newPath="+param.newPath,
                cache: false,  //禁用缓存
                data: {},  //传入组装的参数
                dataType: "json",
                success: function (result) {
                    if(result.success){
                        Ewin.alert("修改成功");
                    }else {
                        Ewin.alert("修改失败");
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    Ewin.alert("修改异常");
                }
            });



        }


    }
    //初始化
    var init = function () {
        //上传
        $("#dataTable").on("change",".btn-preview",function () {
            var _this = $(this);
            var _tr = $(_this).closest("tr");
            console.log(_tr)
            //Jquery对象转化成DOM对象
            var fileDom = $(_this).get(0);
            //判断是否支持FileReader
            if (window.FileReader) {
                var reader = new FileReader();
            } else {
                Ewin.alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
            }
            //获取文件
            var file = fileDom.files[0];
            var imageType = /^image\//;
            //是否是图片
            if (!imageType.test(file.type)) {
                Ewin.alert("请选择图片！");
                return;
            }
            //读取完成
            reader.onload = function (e) {
                //获取图片dom
                var img = $(_tr).find(".img-change").get(0);
                //图片路径设置为读取的图片
                img.src = e.target.result;
            };
            reader.readAsDataURL(file);
        });

        //上传
        $("#dataTable").on("click",".btn-save",function () {
            var _this = $(this);
            var _tr = $(_this).closest("tr");
            console.log(_tr);
            var formData = new FormData();
            formData.append('enctype', 'multipart/form-data');
            formData.append("file", $(_tr).find('.btn-preview').get(0).files[0]);  //添加图片信息的参数
            if (!$(_tr).find('.btn-preview')[0].files[0]) {
                Ewin.alert("请先选择文件");
                return;
            }
            $.ajax({
                url: appServer + 'ajax/uploadFile.action',
                type: "POST",
                cache: false, //上传文件不需要缓存
                data: formData,
                processData: false, // 告诉jQuery不要去处理发送的数据
                contentType: false, // 告诉jQuery不要去设置Content-Type请求头
                success: function (result) {
                    console.log(result);
                    Ewin.alert("上传成功");
                    $(_tr).find('.btn-preview').attr("new_path", result.data);
                },
                error: function (result) {
                    console.log(result);
                    Ewin.alert("上传失败");
                }
            });
        });

        //保存
        $("#dataTable").on('click','.btn-submit',function () {
            var _this =$(this);
            circleManage.save(_this);
        });
    }

    init();














});