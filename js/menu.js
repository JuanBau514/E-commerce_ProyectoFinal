const abrirMenu = document.querySelector('#openButton');
const cerrarMenu = document.querySelector('#openClose');
const aside = document.querySelector("aside");

abrirMenu.addEventListener('click', () => {
    aside.classList.add("aside-visible");
});

cerrarMenu.addEventListener('click', () => {
    aside.classList.remove("aside-visible");
});

botonesCategoria.forEach(boton => boton.addEventListener("click", (evento) => {
    aside.classList.remove("aside-visible");
}));