var ImageUtil = {
    preview: function (_this) {
        //Jquery对象转化成DOM对象
        var fileDom = $(_this).get(0);
        //判断是否支持FileReader
        if (window.FileReader) {
            var reader = new FileReader();
        } else {
            alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
        }
        //获取文件
        var file = fileDom.files[0];
        var imageType = /^image\//;
        //是否是图片
        if (!imageType.test(file.type)) {
            alert("请选择图片！");
            return;
        }
        //读取完成
        reader.onload = function (e) {
            //获取图片dom
            var img = document.getElementById("img-change");
            //图片路径设置为读取的图片
            img.src = e.target.result;
        };
        reader.readAsDataURL(file);
    },
    upload: function (rootUrl) {
        var formData = new FormData();
        formData.append('enctype', 'multipart/form-data');
        formData.append("file", $('#preview')[0].files[0]);  //添加图片信息的参数
        if (!$('#preview')[0].files[0]) {
            alert("请先选择文件");
            return;
        }
        $.ajax({
            url: rootUrl + 'ajax/uploadFile.action',
            type: "POST",
            cache: false, //上传文件不需要缓存
            data: formData,
            processData: false, // 告诉jQuery不要去处理发送的数据
            contentType: false, // 告诉jQuery不要去设置Content-Type请求头
            success: function (result) {
                console.log(result);
                Ewin.alert("上传成功");
                $("#preview").attr("new_path", result.data);
            },
            error: function (result) {
                console.log(result);
                Ewin.alert("上传失败");
            }
        });
    }
}