let mm = {}

mm.func = function(){

	$("#btnFind").click(function() {
		let param = $("#frm_mm").serialize();
		$.post("select.mm", param, function(data, state) {
			$("#main").html(data);
		});
	})

	$("#btnInsert").click(function() {
		let param = $("#frm_mm").serialize();
		$.post("insert.mm", param, function(data, state) {
			$("#main").html(data);
		});
	})
	
	$("#btnRegister").click(function() {
		let param = $("#frm_mm").serialize();
		$.post("insertR.mm", param, function(data, state) {
			$("#main").html(data);
		});
	})
	
	//수정폼
	$("#btnModify").click(function() {
		let param = $("#frm_mm").serialize();
		$.post("modify.mm", param, function(data, state) {
			$("#main").html(data);
		});
	})
	
	//수정내용저장
	$("#btnUpdate").click(function() {
		let param = $("#frm_mm").serialize();
		$.post("modifyR.mm", param, function(data, state) {
			$("#main").html(data);
		});
	})
	
	$("#btnDelete").click(function() {
		let param = $("#frm_mm").serialize();
		$.post("deleteR.mm", param, function(data, state) {
			$("#main").html(data);
		});
	})
	
	mm.go = function(nowPage){
		frm_mm.nowPage.value = nowPage;
		let param = $("#frm_mm").serialize();
		console.log(param);
		$.post("select.mm", param, function(data, state) {
			$("#main").html(data);
		});
	}
	
	  $("#btnLogin").click(function(){
		  let param = $("#frm_mm").serialize();
		    $.post("login.brd", param, function (data, state) {
		      $("#main").html(data);
		    });
	  })
}


mm.init = function(){
	//mm안에 있는 init라는 함수
	
	$("#main").load("select.mm");
	// view resolve에 담겨있는 값
	// ./board/select.jsp를 실행한 결과가 main에 로드됨
}

mm.view = function(serial){
	frm_mm.serial.value = serial;
	let param = $("#frm_mm").serialize();
	console.log(param);
	$.post("view.mm", param, function(data, state) {
		$("#main").html(data);
	});
}

//mm.func();