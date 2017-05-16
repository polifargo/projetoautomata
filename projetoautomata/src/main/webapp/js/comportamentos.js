function filtrar(){
    var b = window.event.target;
    
    if(b.classList[0] == "abasItem"){
        var aba = b.classList[1];
        
        var telas = document.querySelector("div.telas");
        
        for(var i = 0; i < telas.children.length; i++){
            console.log(telas.children[i].classList[1]);
            console.log(aba);
            
            if(telas.children[i].classList[1] == aba){
                telas.children[i].style.display = "block";
            }else{
                telas.children[i].style.display = "none";
            }
        }
    }
}

window.addEventListener("click", filtrar);