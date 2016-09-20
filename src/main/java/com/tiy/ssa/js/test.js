function View(id) {
	this.id = id;
	
	function show(className){
		className = '';
	}
	
	function hide(className){
		className = 'hidden';
	}
	
	function click(){
		
	}
	
	function refreshInitialize(){
		
	}
}


function ListView(id){
	View.call(this, id);
	
	ListView.prototype.click = function(){
		
	}
}







function extend(sup, sub) {
	sub.prototype = Object.create(sup.prototype);
	sub.prototype.constructor = sup;
	return sub;
}











function A(w){
	this.w = w;
}

function B(w) {
	A.call(this, w)
}

extend(A, B);


var list = new View('c-list');

