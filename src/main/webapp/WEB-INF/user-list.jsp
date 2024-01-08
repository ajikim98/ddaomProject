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
</style>
<body>
	<div id="app">
	
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
	            const webSocket = new WebSocket('ws://localhost:8081/your-websocket-endpoint');
	
	            webSocket.onopen = function(event) {
	                console.log('WebSocket 연결 성공');
	                webSocket.send('Hello, Server!'); // 연결 성공 후 메시지 전송
	            };
	
	            webSocket.onmessage = function(event) {
	                console.log('서버로부터 메시지 수신:', event.data);
	            };
	        }
	    },   
	    created: function () {
	        var self = this;
	        self.fnGetList();
	        self.fnConnectWebSocket(); // WebSocket 연결
	    }
	});

</script>