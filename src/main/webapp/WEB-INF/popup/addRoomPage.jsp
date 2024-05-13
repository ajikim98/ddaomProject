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
        <label for="roomTitle">방 제목:</label>
        <input type="text" id="roomTitle" v-model="newRoomTitle">
        <button @click="addRoom">추가</button>
    </div>
</body>
</html>
<script type="text/javascript">
        var addRoomApp = new Vue({
            el: '#addRoomApp',
            data: {
                newRoomTitle: '', // 새로운 방의 제목
				sessionId : '${sessionId}'
            },
            methods: {
                addRoom: function() {
					var self = this;
	             	var nparmap = {
                    	newRoomTitle: self.newRoomTitle,
						sessionId: self.sessionId
                	};
	            	 $.ajax({
	                 	url:"addRoom.dox",
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