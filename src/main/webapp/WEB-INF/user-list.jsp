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
	        // fnGetList : function(){
	        //     var self = this;
	        //     var nparmap = {};
	        //     $.ajax({
	        //         url:"list.dox",
	        //         dataType:"json",    
	        //         type : "POST", 
	        //         data : nparmap,
	        //         success : function(data) { 
	        //             console.log(data);
	        //             self.list = data.list;
	        //         }
	        //     }); 
	        // },
			fnConnectWebSocket: function() {
			    const webSocket = new WebSocket('ws://localhost:8081/test1');
			
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
			}
	    },//methods - end
	    created: function () {
	        var self = this;
	        self.fnGetList();
	        self.fnConnectWebSocket(); // WebSocket 연결
	    }
	});

</script>