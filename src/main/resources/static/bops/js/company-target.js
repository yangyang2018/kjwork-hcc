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
                    data: "name",//关键字
                    orderable : false,
                    width:"20%"
                },
                {
                    data: "remark",//描述
                    orderable : false,
                    width:"60%"
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
        $(_tr).find('input.target-key').eq(0).prop("disabled",false);
        $(_tr).find('input.target-desc').eq(0).prop("disabled",false);
    });


    $('#dataTable').on('click','.btn-save',function () {
        var _this = $(this);
        var _tr = $(_this).closest('tr');
        var param = {};
        param.id = _tr.find('input.target-id').eq(0).val();
        param.name = _tr.find('input.target-key').eq(0).val();
        param.remark = _tr.find('input.target-desc').eq(0).val();

        $.ajax({
            type:"POST",
            url:appServer+"bops/ajax/company/dic/update.action",
            dataType:"JSON",
            data:JSON.stringify(param),
            contentType:"application/json;charset=utf-8",
            success:function (result) {
                if(result.success){
                    Ewin.alert("修改成功");
                    $(_tr).find('input.target-key').eq(0).prop("disabled",true);
                    $(_tr).find('input.target-desc').eq(0).prop("disabled",true);
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