$(function () {
    $("#jqGrid").jqGrid({
        url: '../sys/realnamemgr/list',
        datatype: "json",
        colModel: [			
			{ label: '用户ID', name: 'userid', index: "user_id", width: 45, key: true },
			{ label: '用户名', name: 'login', width: 75 },
			{ label: '姓名', name: 'name', width: 75 },
			{ label: '身份证号', name: 'paperworkcode', width: 90 },
			{ label: '状态', name: 'state', width: 80, formatter: function(value, options, row){
				return value === 02 ?
					'<span class="label label-danger">审核未通过</span>' :
					'<span class="label label-success">审核通过</span>';
			}},
			{ label: '审核时间', name: 'verifycompletetime', index: "create_time", width: 80}
        ],
		// mtype: 'POST',
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			name: null,
			start: null,
			end: null
		},
		showList: true,
		title:null,
		roleList:{},
		user:{
			status:1,
			roleIdList:[]
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.roleList = {};
			vm.user = {status:1,roleIdList:[]};

			//获取角色信息
			this.getRoleList();
		},
		update: function () {
			var userId = getSelectedRow();
			if(userId == null){
				return ;
			}

			vm.showList = false;
            vm.title = "修改";

			vm.getUser(userId);
			//获取角色信息
			this.getRoleList();
		},
		del: function () {
			var userIds = getSelectedRows();
			if(userIds == null){
				return ;
			}

			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../sys/user/delete",
				    data: JSON.stringify(userIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
                                vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		saveOrUpdate: function (event) {
			var url = vm.user.userId == null ? "../sys/user/save" : "../sys/user/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.user),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		getUser: function(userId){
			$.get("../sys/user/info/"+userId, function(r){
				vm.user = r.user;
			});
		},
		getRoleList: function(){
			$.get("../sys/role/select", function(r){
				vm.roleList = r.list;
			});
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'name': vm.q.name,'start':vm.q.start},
                page:1,
            }).trigger("reloadGrid");
		}
	}
});

//layui时间控件
layui.use('laydate', function() {
	var laydate = layui.laydate;

	var start = {
		min: '2015-01-01 23:59:59'
		, max: '2099-06-16 23:59:59'
		, istoday: false
		, choose: function (datas) {
			end.min = datas; //开始日选好后，重置结束日的最小日期
			end.start = datas //将结束日的初始值设定为开始日
		}
	};

	var end = {
		min: laydate.now()
		, max: '2099-06-16 23:59:59'
		, istoday: false
		, choose: function (datas) {
			start.max = datas; //结束日选好后，重置开始日的最大日期
		}
	};

	document.getElementById('LAY_demorange_s').onclick = function () {
		start.elem = this;
		laydate(start);
	}
	document.getElementById('LAY_demorange_e').onclick = function () {
		end.elem = this
		laydate(end);
	}
});