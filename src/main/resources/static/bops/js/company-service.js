// Call the dataTables jQuery plugin
$(document).ready(function() {
    var appServer = $("#appServer").val();

    $('#dataTable').DataTable(
        $.extend(true,HCC_CONSTANT.DATA_TABLES.DEFAULT_OPTION,{
            serverSide: false,//不开启服务端模式
            //绑定数据
            columns: [
                {
                    data: "id",//Id
                    orderable : false,
                    width:"5%"
                },
                {
                    data: "title",//关键字
                    orderable : false,
                    width:"20%"
                },
                {
                    data: "content",//描述
                    orderable : false,
                    width:"55%"
                },
                {
                    data: "order",//排序
                    orderable : false,
                    width:"5%"
                },
                {
                    data: "operate",//操作
                    orderable : false,
                    width:"15%"
                }
            ]
        })
    );

    $('#dataTable').on('click','.btn-edit',function () {
        var _this = $(this);
        var _tr = $(_this).closest('tr');
        $(_tr).find('input.service-title').eq(0).prop("disabled",false);
        $(_tr).find('input.service-content').eq(0).prop("disabled",false);
        $(_tr).find('input.service-order').eq(0).prop("disabled",false);
    });


    $('#dataTable').on('click','.btn-save',function () {
        var _this = $(this);
        var _tr = $(_this).closest('tr');
        var param = {};
        param.id = _tr.find('input.service-id').eq(0).val();
        param.title = _tr.find('input.service-title').eq(0).val();
        param.content = _tr.find('input.service-content').eq(0).val();
        param.order = _tr.find('input.service-order').eq(0).val();

        $.ajax({
            type:"POST",
            url:appServer+"bops/ajax/services/update.action",
            dataType:"JSON",
            data:JSON.stringify(param),
            contentType:"application/json;charset=utf-8",
            success:function (result) {
                if(result.success){
                    Ewin.alert("修改成功");
                    window.location.href=appServer+'bops/company-service.action';
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