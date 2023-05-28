const productosEnCarrito = JSON.parse(localStorage.getItem("Productos-en-Carrito"));

const contenedorCarritoVacio = document.querySelector(".carrito-vacio");
const contenedorCarritoComprado= document.querySelector(".carrito-comprado");
const contenedorCarritoAcciones = document.querySelector(".carrito-acciones");
const contenedorCarritoProductos = document.querySelector(".carrito-productos");
let botonesEliminar = document.querySelectorAll(".carrito-producto-borrar");
const botonVaciarCarrito = document.querySelector(".carrito-acciones-vaciar");
const contenedorTotal = document.querySelector("#total");
const botonComprar = document.querySelector(".carrito-acciones-comprar");

function cargarProductosCarrito () {

if (productosEnCarrito && productosEnCarrito.length > 0) {
    contenedorCarritoVacio.classList.add("disabled");
    contenedorCarritoProductos.classList.remove("disabled");
    contenedorCarritoAcciones.classList.remove("disabled");
    contenedorCarritoComprado.classList.add("disabled");

    contenedorCarritoProductos.innerHTML = ""; // Limpio el contenedor de productos

    productosEnCarrito.forEach((producto) => {
        const div = document.createElement("div");
        div.classList.add("carrito-producto"); // Agrego la clase carrito-producto al div y lo agrego al contenedor de productos
        div.innerHTML = ` 
            <img class="carrito-producto-imagen" src="${producto.imagen}" alt="${producto.titulo}">
            <div class="carrito-producto-titulo">
                <small> Titulo </small>
                <h3> ${producto.titulo} </h3>
            </div>
            <div class="carrito-producto-cantidad">
                <small> Cantidad </small>
                
                <p> ${producto.cantidad} </p>
            </div>
            <div class="carrito-producto-precio">
                <small> Precio </small>
                <h3> $ ${producto.precio}</h3>
            </div>
            <div class="carrito-producto-total">
                <small> SubTotal </small>
                <h3> $ ${producto.precio * producto.cantidad} </h3>
            </div>
            <div >
                <button class="carrito-producto-borrar" id = "${producto.id}"> <i class="bi bi-trash-fill"> </i> </button>
            </div>
        `;
        contenedorCarritoProductos.appendChild(div);
        });

} else {
    contenedorCarritoVacio.classList.remove("disabled");
    contenedorCarritoProductos.classList.add("disabled");
    contenedorCarritoAcciones.classList.add("disabled");
    contenedorCarritoComprado.classList.add("disabled");
}

actualizarBotonesEliminar();
calcularTotal();

}

cargarProductosCarrito();

function actualizarBotonesEliminar () {
    botonesEliminar = document.querySelectorAll(".carrito-producto-borrar");
    botonesEliminar.forEach((boton) => {
        boton.addEventListener("click", eliminarDelCarrito);
    });
}

function eliminarDelCarrito (evento) {

    Toastify({
        text: "Producto Eliminado",
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

    let idBoton = evento.currentTarget.id;
    const indiceEliminado = productosEnCarrito.findIndex(producto => producto.id === idBoton);

    productosEnCarrito.splice(indiceEliminado, 1);
    cargarProductosCarrito();

    localStorage.setItem("Productos-en-Carrito", JSON.stringify(productosEnCarrito));

}

botonVaciarCarrito.addEventListener("click", vaciarCarrito);

function vaciarCarrito () {

    Swal.fire({
        title: '<strong> ¿Estas Seguro? </strong>',
        icon: 'info',
        html: 'Se eliminaran todos los productos del carrito',
        showCloseButton: true,
        showCancelButton: true,
        confirmButtonText:
          '<i class="fa fa-thumbs-up"></i> Si!',
        cancelButtonText:
          '<i class="fa fa-thumbs-down"></i> No'
      }) .then((result) => {
        if (result.isConfirmed) {
            productosEnCarrito.length = 0;
            localStorage.setItem("Productos-en-Carrito", JSON.stringify(productosEnCarrito));
            cargarProductosCarrito();
        } 
    })
}

function calcularTotal () {
    const totalCalculado = productosEnCarrito.reduce((acumulador, producto) => acumulador + (producto.precio * producto.cantidad), 0);
    contenedorTotal.innerText = `$ ${totalCalculado}`;
}

botonComprar.addEventListener("click", comprarCarrito);

function comprarCarrito () {
    productosEnCarrito.length = 0;
    localStorage.setItem("Productos-en-Carrito", JSON.stringify(productosEnCarrito));
    contenedorCarritoVacio.classList.add("disabled");
    contenedorCarritoProductos.classList.add("disabled");
    contenedorCarritoAcciones.classList.add("disabled");
    contenedorCarritoComprado.classList.remove("disabled");
}