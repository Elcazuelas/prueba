/agregar clase flotante para seleccionar el elemento de la lista/

let list = document.querySelectorAll(".navegadorL li")

function activeLink(){
    list.forEach(item =>{
        item.classList.remove("hovered")
    })
    this.classList.add("hovered");
}

list.forEach(item => item.addEventListener("mouseover", activeLink));

//esconder Menu
let toggleicon = document.querySelector(".toggleicon");
let navegadorL = document.querySelector(".navegadorL");
let cuerpo = document.querySelector(".cuerpo");

toggleicon.onclick = function(){
    navegadorL.classList.toggle("active");
    cuerpo.classList.toggle("active");

}