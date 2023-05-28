// PRODUCTOS
let productos = [];

fetch("js/productos.json")
    .then((respuesta) => respuesta.json())
    .then((datos) => {
        productos = datos;
        mostrarProductos(productos);
    });

const contenedorProductos = document.querySelector("#contenedor-productos");
const botonesCategoria = document.querySelectorAll(".boton-categoria");
const tituloPrincipal = document.querySelector("#titulo-principal");
let botonesAgregar = document.querySelectorAll(".producto-agregar");
const numeritoCarrito = document.querySelector("#numerito");

// Funcion que muestra los productos en el HTML
function mostrarProductos(productosElegidos) {

    contenedorProductos.innerHTML = ""; // Limpio el HTML

    productosElegidos.forEach((producto) => { // Recorro el array de productos y por cada producto creo un div
        let div = document.createElement("div"); 
        div.classList.add("producto"); // Agrego la clase producto al div
        div.innerHTML = ` 
            <img class="producto-imagen" src="${producto.imagen}" alt="${producto.titulo}">
            <div class="producto-detalles">
                <h3 class="producto-titulo"> ${producto.titulo} </h3>
                <p class="producto-precio"> $ ${producto.precio} </p>
                <button class="producto-agregar" id="${producto.id}"> Agregar al Carrito </button>
            </div>
        `;
        contenedorProductos.appendChild(div);
    });
    actualizarBotonesAgregar();
   
}


botonesCategoria.forEach((boton) => { 
    boton.addEventListener("click", (evento) => { // Agrego un evento click a cada boton

        botonesCategoria.forEach( boton =>  boton.classList.remove("active")  ); // Remuevo la clase boton-activo de cada boton
        evento.target.classList.add("active"); // Agrego la clase boton-activo al boton clickeado

        if(evento.currentTarget.id !== "todos") { // Si el id del boton clickeado es distinto a "todos", filtro los productos
            
            const productoCategoria = productos.find((producto) => producto.categoria.id === evento.currentTarget.id); // Busco el producto que coincida con el id del boton clickeado
            tituloPrincipal.innerText = productoCategoria.categoria.nombre; // Cambio el titulo principal por el nombre de la categoria

            const productosEscogidos = productos.filter((producto) => producto.categoria.id === evento.currentTarget.id);  
            mostrarProductos(productosEscogidos);
        } else { // Si el id del boton clickeado es igual a "todos", muestro todos los productos
            tituloPrincipal.innerText = "Todos los Productos";
            mostrarProductos(productos);
        }
    });
});

function actualizarBotonesAgregar () {
    botonesAgregar = document.querySelectorAll(".producto-agregar");
    botonesAgregar.forEach((boton) => {
        boton.addEventListener("click", agregarAlCarrito);
    });
}

let productosEnCarrito = [];
const productosEnCarritoLS = JSON.parse(localStorage.getItem("Productos-en-Carrito"));

if (productosEnCarritoLS) {
    productosEnCarrito = productosEnCarritoLS;
    actualizarNumerito();
} else {
    productosEnCarrito = [];
}

function agregarAlCarrito (evento) {

    Toastify({
        text: "Producto Agregado ",
        duration: 3000,
        close: true,
        gravity: "top", // `top` or `bottom`
        position: "right", // `left`, `center` or `right`
        stopOnFocus: true, // Prevents dismissing of toast on hover
        style: {
          background: "linear-gradient(to right, #44A29C, #78c6c9)",
          borderRadius: "2rem",
          fontSide: ".75rem",
        },
        offset: {
            x: "1.5rem", 
            y: "1.5rem" 
          },
        onClick: function(){} // Callback after click
      }).showToast();

    const idBoton = evento.currentTarget.id;
    const productoElegido = productos.find(producto => producto.id === idBoton);

    if ( productosEnCarrito.some( producto => producto.id === idBoton) ) {
        const index = productosEnCarrito.findIndex( producto => producto.id === idBoton );
        productosEnCarrito[index].cantidad++;
    } else {
        productoElegido.cantidad = 1;
        productosEnCarrito.push(productoElegido);
    }

    actualizarNumerito();

    localStorage.setItem("Productos-en-Carrito", JSON.stringify(productosEnCarrito));
}

function actualizarNumerito () {
    let Nuevonumerito = productosEnCarrito.reduce( (acc, producto) => acc + producto.cantidad , 0);
    numerito.innerText = Nuevonumerito;
    console.log(numerito);
}