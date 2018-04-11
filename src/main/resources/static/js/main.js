        

window.onload = function (){
	var sec = document.getElementById("second");
    var i = 5;
    var timer = setInterval(function(){
      i--;
      sec.innerHTML = i;
      if(i==0){
        window.location.href = "http://www.boe.com";
      }
    },1000);

}

  
function goBack(){ 
	 window.location.href = "http://www.boe.com";
}