// Call the dataTables jQuery plugin
$(document).ready(function() {
    var appServer = $("#appServer").val();

    $('#dataTable').DataTable(
        $.extend(true,HCC_CONSTANT.DATA_TABLES.DEFAULT_OPTION,{
            serverSide: false,//不开启服务端模式
            //绑定数据
            columns: [
                {
                    data: "id",//字段名
                    orderable : false,
                    width:"8%"
                },
                {
                    data: "name",//字段名
                    orderable : false,
                    width:"10%"
                },
                {
                    data: "remark",//名
                    orderable : false,
                    width:"70%"
                },
                {
                    data: "operate",//操作
                    orderable : false,
                    width:"12%"
                }
            ]
        })
    );
    $('#dataTable').on('click','.btn-edit',function () {
        var _this = $(this);
        var _tr = $(_this).closest('tr');
        $(_tr).find('input.honor-date').eq(0).prop("disabled",false);
        $(_tr).find('input.honor-event').eq(0).prop("disabled",false);
    });


    $('#dataTable').on('click','.btn-save',function () {
        var _this = $(this);
        var _tr = $(_this).closest('tr');
        var param = {};
        param.id = _tr.find('input.honor-id').eq(0).val();
        param.name = _tr.find('input.honor-date').eq(0).val();
        param.remark = _tr.find('input.honor-event').eq(0).val();

        $.ajax({
            type:"POST",
            url:appServer+"bops/ajax/company/dic/update.action",
            dataType:"JSON",
            data:JSON.stringify(param),
            contentType:"application/json;charset=utf-8",
            success:function (result) {
                if(result.success){
                    Ewin.alert("修改成功");
                    $(_tr).find('input.honor-date').eq(0).prop("disabled",true);
                    $(_tr).find('input.honor-event').eq(0).prop("disabled",true);
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