<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="../js/jquery.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
	<meta charset="UTF-8">
	<title>Add Room Page</title>
</head>
<style>
</style>
<body>
    <div id="app">
		<div>
			<label for="uId">아이디:</label>
			<input type="text" id="uId" v-model="uId">
		</div>
		<div>
			<label for="uPw">pw:</label>
			<input type="text" id="uPw" v-model="uPw">
		</div>
		<div>
			<label for="uName">이름:</label>
			<input type="text" id="uName" v-model="uName">
		</div>
		<div>
			<label for="uPhone">폰:</label>
			<input type="text" id="uPhone" v-model="uPhone">
		</div>
		<div>
			<label for="uEmail">이메일:</label>
			<input type="text" id="uEmail" v-model="uEmail">
		</div>
		<div>
			<label for="uBirth">생일:</label>
			<input type="text" id="uBirth" v-model="uBirth">
		</div>
        <div><button @click="userJoin">추가</button></div>
    </div>
</body>
</html>
<script type="text/javascript">
        var app = new Vue({
            el: '#app',
            data: {
                uId: '',
				uPw : '',
				uName : '',
				uPhone : '',
				uEmail : '',
				uBirth : '0000-00-00'
            },
            methods: {
                userJoin: function() {
					var self = this;
	             	var nparmap = {
                    	uId: self.uId,
                    	uPw: self.uPw,
						uName : self.uName,
						uPhone : self.uPhone,
						uEmail : self.uEmail,
						uBirth : self.uBirth
                	};
	            	 $.ajax({
	                 	url:"userJoin.dox",
	                 	dataType:"json",    
	                 	type : "POST", 
	                 	data : nparmap,
	                 	success : function(data) { 
		                      window.close();
		                      window.opener.location.reload();
		                 }
	             	}); 
                }
            }
        });
    </script>