$(document).ready(function(){
	$("#passwd").click(function(){
		ckPW();
		ckRePW();
	});
});

function ckPW(){
	var inputPW = $("#passwd").val();

/*
	if(inputPW.length >= 6){
		if($('input:checkbox[id="passwdCKB"]').is(":checked") == false)
			$('input:checkbox[id="passwdCKB"]').attr("checked", true);
	}else{
		if($('input:checkbox[id="passwdCKB"]').is(":checked") == true)
			$('input:checkbox[id="passwdCKB"]').attr("checked", false);
	}
*/
}

function ckRePW(){
	var inputPW = $("#rePasswd").val();
	
	console.log(inputPW.length);
}