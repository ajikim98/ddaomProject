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
        <label for="addFri">친구 추가:</label>
        <input type="text" id="addFri" v-model="yourFriend">
        <button @click="searchFriend">조회</button>
		<div v-if="!textHidden">
			<div v-if="info && info.userId">
				<div>{{ info.userId }}</div> 
				<button @click="addFriend">추가</button>
			</div>
			<div v-else>
				<div>존재하지 않는 유저입니다.</div>
			</div>
		</div>
		<div v-else>
			<div></div>
		</div>
		<div>
		</div>
    </div>
</body>
</html>
<script type="text/javascript">
        var app = new Vue({
            el: '#app',
            data: {
                yourFriend: '',
				info : {},
				sessionId : '${sessionId}',
				textHidden : true
            },
            methods: {
				searchFriend: function() {
					var self = this;
	             	var nparmap = {
                    	yourFriend: self.yourFriend
                	};
	            	 $.ajax({
	                 	url:"searchFriend.dox",
	                 	dataType:"json",    
	                 	type : "POST", 
	                 	data : nparmap,
	                 	success : function(data) { 
							self.textHidden = false;
							self.info = data.info;
							console.log(self.info);

		                 }
	             	}); 
                },

                addFriend: function() {
					var self = this;
	             	var nparmap = {
                    	yourFriend: self.yourFriend,
						sessionId: self.sessionId
                	};
	            	 $.ajax({
	                 	url:"addFriend.dox",
	                 	dataType:"json",    
	                 	type : "POST", 
	                 	data : nparmap,
	                 	success : function(data) { 
		                      window.close();
		                      window.opener.location.reload();
		                 }
	             	}); 
                },


            }
        });
    </script>