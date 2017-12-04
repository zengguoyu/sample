$(function() {
	
	
	
	
var vm=	new Vue({
		el : '#app',
		data : {
			active : 2,
			formData :{
				orgName:null,
				adminUserName:null,
				adminLoginName:null,
				adminPhoneNumber:null,
				adminPassword:null,
				adminRePassword:null,
				adminSex:1
			},
			rules : {
				orgName : [ {
					required : true,
					message : '请输入企业名称！',
				}, {
					min : 3,
					max : 100,
					message : '长度在 3 到100 个字符',
				} ],

				adminUserName:[{ 
					required : true,
					message : '请输入管理员姓名！',
				}, {
					min : 3,
					max : 100,
					message : '长度在 3 到100 个字符',
				}],
				adminLoginName:[{ 
					required : true,
					message : '请输入管理员登录名！',
				}, {
					min : 3,
					max : 100,
					message : '长度在 3 到100 个字符',
				}],
				adminPhoneNumber:[{ 
					required : true,
					message : '请输入手机号！',
				}, {
					 pattern: /^1[34578]\d{9}$/, message: '请输入有效的手机号'
				}],
				adminPassword:[{ 
					required : true,
					message : '请输入管理员登录名！',
				}, {
					min : 3,
					max : 20,
					message : '请输入密码，长度3到20个字符',
				}],
				adminRePassword:[{ 
					required : true,
					message : '请确认密码！',
				},{
					
					validator:function(rule, value, callback){
						if (value === '') {
			                callback(new Error('请再次输入密码'))
			            } else if (value !==vm.formData.adminPassword) {
			                callback(new Error('两次输入密码不一致!'))
			            } else {
			                callback()
			            }
					}
				}],
			}

		},
		computed :{
			organizationNext : function() { 
				return !this.formData || !this.formData.orgName || this.formData.orgName.length<3|| this.formData.orgName.length>100;
			},
			adminNext:function(){
				return !this.formData || !this.formData.adminUserName || this.formData.adminUserName.length<2|| this.formData.adminUserName.length>100

				 || !this.formData.adminUserName || this.formData.adminUserName.length<3|| this.formData.adminUserName.length>100
				 || !this.formData.adminLoginName || this.formData.adminLoginName.length<3|| this.formData.adminLoginName.length>100
				 || !this.formData.adminPassword || this.formData.adminPassword.length<3|| this.formData.adminPassword.length>100

				 || !this.formData.adminRePassword || this.formData.adminRePassword.length<3|| this.formData.adminRePassword.length>100
				 
				 || !this.formData.adminPassword===this.formData.adminRePassword

				
			},
			sexString:function(){
				return this.formData && this.formData.adminSex==1 ?"男":"女";
			}
		},

		methods : {
			next : function(step) {

				if (step + this.active > 2) {
					this.active = 2;
				} else if (step + this.active < 0) {
					this.acitve = 0;
				} else {
					this.active += step;
				}
			}
		}
	});
});
