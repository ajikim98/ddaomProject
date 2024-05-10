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
    <div id="addRoomApp">
		<div>
			<label for="uId">아이디:</label>
			<input type="text" id="uId" v-model="uId">
		</div>
		<div>
			<label for="uPw">pw:</label>
			<input type="text" id="uPw" v-model="uPw">
		</div>
        <div>
            <button @click="userLogin">로그인</button>
            <button @click="userJoin">회원가입</button>
        </div>
    </div>
</body>
</html>
<script type="text/javascript">
        var addRoomApp = new Vue({
            el: '#addRoomApp',
            data: {
                uId: '',
				uPw : ''
            },
            methods: {
                userLogin: function() {
					var self = this;
	             	var nparmap = {
                    	uId: self.uId,
                    	uPw: self.uPw
                	};
	            	 $.ajax({
	                 	url:"userLogin.dox",
	                 	dataType:"json",    
	                 	type : "POST", 
	                 	data : nparmap,
	                 	success : function(data) { 
		                    //   window.close();
		                    //   window.opener.location.reload();

		                 }
	             	}); 
                },
                userJoin: function() {
					window.open('popup/join.jsp','width=600,height=400,resizable=yes');
                }
            }
        });
    </script>