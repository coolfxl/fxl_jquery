window.addEventListener("load",function(){
	function $(id){
		return document.getElementById(id);
	}
	var fm = document.forms[0];
	var user = fm.elements["user"];
	var pwd = fm.elements["password"];
	user.focus();

	user.addEventListener("keyup",tabForWard,false);
	pwd.addEventListener("keyup",tabForWard,false);

	function tabForWard(evt) {
		var e = evt || window.event;
		//判断当前的长度是否和我们输入的长度是否一致
		if (this.value.length == this.maxLength) {
			//遍历所有控件
			for (var i = 0; i < fm.elements.length; i ++) {
				if (fm.elements[i] == this) {
					fm.elements[i + 1].focus();
					return;
				}
			}
		}
	}

	var pt = $("pt");
	var alist = pt.getElementsByTagName("a");

	var uls = $("uls");
	var lis = uls.getElementsByTagName("li");
	
	for (var i = 0; i<alist.length ; i++ ){
		alist[i].index = i;
		alist[i].addEventListener("click",function(){
			show(this.index);
		},false);
	}

	function show(a){
		for (var i = 0; i<lis.length ; i++ ){
			lis[i].className = "";
			lis[a].className = "curr"; //通过下标添加效果
		}
	};
},false);
