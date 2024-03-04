    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="../js/jquery.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
	<meta charset="UTF-8">
	<title>View Room Page</title>
</head>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }
</style>
<body>
	<div id="app">
		<div>
			 <table>
            <thead>
                <tr>
                    <th>채팅번호</th>
                    <th>아이디</th>
                    <th>채팅메시지</th>
                    <th>보낸시간</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="chat in list" :key="chat.chatNo">
				  	<td>{{ chat.chatNo }}</td>
					<td>{{ chat.userId }}</td>
					<td>{{ chat.chatMessage }}</td>
					<td>{{ chat.chatDate }}</td>
                </tr>
            </tbody>
        </table>
			
			<input type="text" v-model="chatMessageAdd">
	        <button @click="addChat">보내기</button>
		</div>
	</div>
	

</body>
</html>
<script type="text/javascript">
        var addRoomApp = new Vue({
            el: '#app',
            data: {
            	 list : [],
                 crNo: null,
                 chatMessageAdd : '',
            },
            created: function() {
            	var self = this;
            	var urlParams = new URLSearchParams(window.location.search);
	            self.crNo = urlParams.get('crNo');
	        	self.fnGetList();
	            
	            // crNo가 성공적으로 할당되었는지 확인
	            console.log('crNo:', self.crNo);
	        },//created - end
            methods: {
            	fnGetList : function(){
		             var self = this;
		             var nparmap = {
		             		crNo: self.crNo
		             	};
		             $.ajax({
		                 url:"chatList.dox",
		                 dataType:"json",    
		                 type : "POST", 
		                 data : nparmap,
		                 success : function(data) { 
		                     console.log(data);
		                     self.list = data.list;
		                 }
		             }); 
	         	},
	         	addChat : function(){
		             var self = this;
		             var nparmap = {
		             	crNo: self.crNo,
		             	chatMessage : self.chatMessageAdd
		             	};
		             $.ajax({
		                 url:"addchat.dox",
		                 dataType:"json",
		                 type : "POST", 
		                 data : nparmap,
		                 success : function(data) { 
		                     console.log('success');
		                     self.chatMessageAdd = '';
		                     window.location.reload();
		                 }
		             }); 
	         	},
               
            }//methods - end
          
        });
    </script>