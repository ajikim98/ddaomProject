<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="../js/jquery.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
	<meta charset="UTF-8">
	<title>첫번째 페이지</title>
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
		<table>
            <thead>
                <tr>
                    <th>고객 아이디</th>
                    <th>고객 이름</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="user in list" :key="user.userUId">
                    <td><a href="#" @click="openCR()">{{ user.userId }}</a></td>
                    <td>{{ user.userName }}</td>
                </tr>
            </tbody>
		</table>
	</div>
</body>
</html>
<script type="text/javascript">
	var app = new Vue({ 
	    el: '#app',
	    data: {
	        list : []
	    },
	    methods: {
	         fnGetList : function(){
	             var self = this;
	             var nparmap = {};
	             $.ajax({
	                 url:"list.dox",
	                 dataType:"json",    
	                 type : "POST", 
	                 data : nparmap,
	                 success : function(data) { 
	                     console.log(data);
	                     self.list = data.list;
	                 }
	             }); 
	         },
			fnConnectWebSocket: function() {
				const webSocket = new WebSocket('ws://localhost:8082/test1');
			
				webSocket.onopen = function(event) {
					console.log('WebSocket 연결 성공');
					// JSON 형식의 메시지 생성
					const message = {
						test: 'helloworld'
					};
					// 메시지를 JSON 문자열로 변환하여 전송
					webSocket.send(JSON.stringify(message));
				};
			
			    webSocket.onmessage = function(event) {
			        console.log('서버로부터 메시지 수신:', event.data);
			    };
			},
	         openCR : function(){
	         	window.location.href = 'chatRoomList.do';
	         }
	    },//methods - end
	    created: function () {
	        var self = this;
	        self.fnGetList();
	        self.fnConnectWebSocket(); // WebSocket 연결
	    }
	});

</script>