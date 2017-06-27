window.addEventListener("load",function(){
	function $(id){
		return document.getElementById(id);
	};
	var index = 0;
	var  timer = null;
	var prev = $("prev");
	var next = $("next");
	var  boxDom = $("box");

	var uls = document.getElementsByTagName("ul");	
	var imgs = uls[1].getElementsByTagName("li");
	var btns = uls[2].getElementsByTagName("li");

	// 遍历获取索引
	for (var i = 0; i<btns.length; i++ ){
		btns[i].index = i;
		btns[i].onmouseover = function(){
			show(this.index); 
		}
	}
	// 淡入淡出
	function show(a){
		for (var i = 0; i<btns.length; i++ ){
			btns[i].className="";   
			btns[a].className="none"; 
			imgs[i].style.opacity = "0";
			imgs[i].style.transition = "all 0.6s ease";
			imgs[i].style.transform = "scale(0)";
			imgs[a].style.transform = "scale(1)";
			imgs[a].style.opacity = "1";
		}
	}
	// 下一页
	next.onmousedown = function(){
		index++;
		if (index == imgs.length){
			index = 0;     
			show(index);
		}else{
			show(index);
		}
	};
	// 上一页
	prev.onmousedown = function(){
		index--;
		if (index<0){   
			index = imgs.length-1;   
			show(index);
		}else{
			show(index);
		}
	};
	// 自动播放
	function autoPlay(){
		timer = setInterval(function(){
			index++;
			console.log(index);
			if (index > imgs.length-1) {
				index = 0;
				show(index);
			}else{
				show(index);
			};
		},3000);
	};
	autoPlay();
	// 鼠标悬浮
	boxDom.onmouseover = function(){
		clearInterval(timer);
	}
	// 鼠标离开
	boxDom.onmouseout = function(){
		autoPlay();
	}
},false);