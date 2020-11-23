'use strict'

app.filter('replaceWith', function (){
	return function (input,from,to){
		return String(input).replace(new RegExp(from,'g'),to);
	};
});