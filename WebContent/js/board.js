let brd = {};

brd.func = function () {
  $("#btnFind").click(function () {
	$("#frm_brd").removeAttr('encType');
    let param = $("#frm_brd").serialize();
    $.post("select.brd", param, function (data, state) {
      $("#main").html(data);
    });
  });

  $("#btnInsert").click(function () {
    let param = $("#frm_brd").serialize();
    $.post("insert.brd", param, function (data, state) {
      $("#main").html(data);
    });
  });

  $("#btnRegister").click(function () {
	  alert($("#summernote").val());
	  
	  let fd = new FormData($('#frm_brd')[0]);
	  
	  $.ajax({
		 url : "insertR.brd",
		 type : "post",
		 data : fd,
		 contentType : false,
		 processData : false,
		 error : function(xhr, status, error){
			 console.log(error);
		 },
		 success : function(data, xhr, status){
			 $("#main").html(data);
		 }
	  })
	  
	/*
    let param = $("#frm_brd").serialize();
    $.post("insertR.brd", param, function (data, state) {
      $("#main").html(data);
    });
    => enctype하면 여기 다 null!!!!
    */
  });

  //수정폼
  $("#btnModify").click(function () {
    let param = $("#frm_brd").serialize();
    $.post("modify.brd", param, function (data, state) {
      $("#main").html(data);
    });
  });

  //수정내용저장
  $("#btnUpdate").click(function () {
    let param = $("#frm_brd").serialize();
    $.post("modifyR.brd", param, function (data, state) {
      $("#main").html(data);
    });
  });

  $("#btnDelete").click(function () {
    
	  let pwd = prompt("삭제하려면 암호를 입력하셍세요");
	  if(pwd==null || pwd=='') return;
	  frm_brd.pwd.value = pwd;
	  
	  let param = $("#frm_brd").serialize();
    $.post("deleteR.brd", param, function (data, state) {
      $("#main").html(data);
    });
  });

  $("#btnRepl").click(function () {
    // 답변 폼
    let param = $("#frm_brd").serialize();
    $.post("repl.brd", param, function (data, state) {
      $("#main").html(data);
    });
  });

  $("#btnReplR").click(function () {
    // 답변 저장
    let param = $("#frm_brd").serialize();
    $.post("replR.brd", param, function (data, state) {
      $("#main").html(data);
    });
  });

  brd.go = function (nowPage) {
    frm_brd.nowPage.value = nowPage;
    let param = $("#frm_brd").serialize();
    console.log(param);
    $.post("select.brd", param, function (data, state) {
      $("#main").html(data);
    });
  };
  
  $('#summernote').summernote({
	    placeholder: '내용을 입력하세요.',
	    tabsize: 2,
	    height: 400
	  });
};

brd.init = function () {
  //brd안에 있는 init라는 함수

  $("#main").load("select.brd");
  // view resolve에 담겨있는 값
  // ./board/select.jsp를 실행한 결과가 main에 로드됨
};

brd.view = function (serial) {
  frm_brd.serial.value = serial;
  let param = $("#frm_brd").serialize();
  console.log(param);
  $.post("view.brd", param, function (data, state) {
    $("#main").html(data);
  });
};

//brd.func();
