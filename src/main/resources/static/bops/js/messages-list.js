// Call the dataTables jQuery plugin
$(document).ready(function() {
    var appServer = $("#appServer").val();

    var messageManage = {
        getQueryCondition : function(data) {
            var param = {};
            //组装分页参数
            param.page = Math.floor(data.start / data.length)+1;
            param.pageSize = data.length;
            param.draw = data.draw;
            param.subject = $("#subject").val();
            return param;
        },
        handleItem : function(item) {
            var id = item.id;
            $.ajax({
                type: "post",
                url: appServer+"bops/ajax/messages/"+id+"/handle.action",
                cache: false,  //禁用缓存
                data: {},  //传入组装的参数
                dataType: "json",
                success: function (result) {
                    console.log(result);
                    _table.ajax.reload( null, false );//刷新表格不更改分页信息
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    Ewin.alert("查询失败");
                }
            });
        },
        deleteItem : function(item) {
            var id = item.id;
            //删除
            $.ajax({
                type: "GET",
                url: appServer+"bops/ajax/messages/"+id+"/delete.action",
                cache: false,  //禁用缓存
                data: {},  //传入组装的参数
                dataType: "json",
                success: function (result) {
                    console.log(result);
                    _table.ajax.reload( null, false );//刷新表格不更改分页信息
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    Ewin.alert("查询失败");
                }
            });
        }
    };

    var $dataTable = $('#dataTable');
    //初始化表格
    var _table = $dataTable.DataTable($.extend(true,HCC_CONSTANT.DATA_TABLES.DEFAULT_OPTION,{
        ajax: function (data, callback, settings) {
            //封装请求参数
            console.log("数据:"+data);
            var param = messageManage.getQueryCondition(data);
            console.log("ajax请求数据:"+param);
            $.ajax({
                type: "POST",
                url: appServer+"bops/ajax/messages/page.action",
                cache: false,  //禁用缓存
                data: JSON.stringify(param),  //传入组装的参数
                dataType: "json",
                contentType:"application/json;charset=utf-8",
                success: function (result) {
                    console.log(result);
                    //setTimeout仅为测试延迟效果
                    setTimeout(function () {
                        //封装返回数据
                        var returnData = {};
                        returnData.draw = result.data.draw;//这里直接自行返回了draw计数器,应该由后台返回
                        returnData.recordsTotal = result.data.totalCount;//返回数据全部记录
                        returnData.recordsFiltered = result.data.totalCount;//后台不实现过滤功能，每次查询均视作全部结果
                        returnData.data = result.data.data;//返回的数据列表
                        //console.log(returnData);
                        //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
                        //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                        callback(returnData);
                    }, 200);
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    Ewin.alert("查询失败");
                }

            });
        },
         //绑定数据
         columns: [
                {
                    data: "id",//字段名
                    orderable : false
                },
                {
                    data: "firstname",//姓
                    orderable : false
                },
                 {
                     data: "lastname",//名
                     orderable : false
                 },
                 {
                     data: "phone",//电话
                     orderable : false
                 },
                 {
                     data: "email",//邮箱
                     orderable : false
                },
                 {
                     data: "subject",//标题
                     orderable : false
                 },
                 {
                     data: "message",//内容
                     orderable : false,
                     width:"30%"
                 },
                 {
                     data: "status",//
                     orderable : false,
                     render: function(data,type,row,meta){
                         if(data == 1) {
                             return '<span class="badge badge-pill badge-success">已处理</span>';
                         }
                         return '<span class="badge badge-pill badge-warning">未处理</span>';;
                     }
                 },
                 {
                     data: "createTime",//创建时间
                     orderable : false
                 }
         ],
        "columnDefs" : [ {
            // 定义操作列,######以下是重点########
            "targets" : 9,//操作按钮目标列
            "data" : null,
            "width":"15%",
            "render" : function(data,type, row) {
                var id = '"' + row.id
                    + '"';
                var html = "<button class='btn btn-handle btn-primary' style='margin: 5px;'>处理<i class='icon-pencil'></i> </button>"
                html += "<button class='btn btn-delete btn-danger' style='margin: 5px;'>删除<i class='icon-remove'></i> </button>"
                return html;
            }
        } ]

        })
    );
    //绑定事件 --　编辑按钮
    $dataTable.on("click",".btn-handle",function () {
       var item =_table.row($(this).closest('tr')).data();
       console.log("点击的行数据:"+item);
        messageManage.handleItem(item);
    });
    //绑定事件 --　删除按钮
    $dataTable.on("click",".btn-delete",function () {
        var item =_table.row($(this).closest('tr')).data();
        console.log("点击的行数据:"+item);
        Ewin.confirm({ message: "确认要删除选择的数据吗？" }).on(function () {
            messageManage.deleteItem(item);
        });

    });
    //绑定事件 --　查询按钮
    $("#search").click(function () {
        _table.ajax.reload();
    });
    //绑定事件 --　清除按钮
    $("#clear").click(function () {
        $("#subject").val("")
    });


});