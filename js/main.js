// PRODUCTOS
const productos = [
    // Abrigos
    {
        id: "abrigo-01",
        titulo: "Abrigo 01",
        imagen: "./img/abrigos/01.jpg",
        categoria: {
            nombre: "Celulares",
            id: "celulares"
        },
        precio: 1000
    },
    {
        id: "abrigo-02",
        titulo: "Abrigo 02",
        imagen: "./img/abrigos/02.jpg",
        categoria: {
            nombre: "Celulares",
            id: "celulares"
        },
        precio: 1000
    },
    {
        id: "abrigo-03",
        titulo: "Abrigo 03",
        imagen: "./img/abrigos/03.jpg",
        categoria: {
            nombre: "Celulares",
            id: "celulares"
        },
        precio: 1000
    },
    {
        id: "abrigo-04",
        titulo: "Abrigo 04",
        imagen: "./img/abrigos/04.jpg",
        categoria: {
            nombre: "Celulares",
            id: "celulares"
        },
        precio: 1000
    },
    {
        id: "abrigo-05",
        titulo: "Abrigo 05",
        imagen: "./img/abrigos/05.jpg",
        categoria: {
            nombre: "Celulares",
            id: "celulares"
        },
        precio: 1000
    },
    // Camisetas
    {
        id: "camiseta-01",
        titulo: "Camiseta 01",
        imagen: "./img/camisetas/01.jpg",
        categoria: {
            nombre: "Asesorios",
            id: "asesorios"
        },
        precio: 1000
    },
    {
        id: "camiseta-02",
        titulo: "Camiseta 02",
        imagen: "./img/camisetas/02.jpg",
        categoria: {
            nombre: "Asesorios",
            id: "asesorios"
        },
        precio: 1000
    },
    {
        id: "camiseta-03",
        titulo: "Camiseta 03",
        imagen: "./img/camisetas/03.jpg",
        categoria: {
            nombre: "Asesorios",
            id: "asesorios"
        },
        precio: 1000
    },
    {
        id: "camiseta-04",
        titulo: "Camiseta 04",
        imagen: "./img/camisetas/04.jpg",
        categoria: {
            nombre: "Asesorios",
            id: "asesorios"
        },
        precio: 1000
    },
    {
        id: "camiseta-05",
        titulo: "Camiseta 05",
        imagen: "./img/camisetas/05.jpg",
        categoria: {
            nombre: "Asesorios",
            id: "asesorios"
        },
        precio: 1000
    },
    {
        id: "camiseta-06",
        titulo: "Camiseta 06",
        imagen: "./img/camisetas/06.jpg",
        categoria: {
            nombre: "Asesorios",
            id: "asesorios"
        },
        precio: 1000
    },
    {
        id: "camiseta-07",
        titulo: "Camiseta 07",
        imagen: "./img/camisetas/07.jpg",
        categoria: {
            nombre: "Asesorios",
            id: "asesorios"
        },
        precio: 1000
    },
    {
        id: "camiseta-08",
        titulo: "Camiseta 08",
        imagen: "./img/camisetas/08.jpg",
        categoria: {
            nombre: "Asesorios",
            id: "asesorios"
        },
        precio: 1000
    },
    // Pantalones
    {
        id: "pantalon-01",
        titulo: "Pantalón 01",
        imagen: "./img/pantalones/01.jpg",
        categoria: {
            nombre: "Hardware",
            id: "hardware"
        },
        precio: 1000
    },
    {
        id: "pantalon-02",
        titulo: "Pantalón 02",
        imagen: "./img/pantalones/02.jpg",
        categoria: {
            nombre: "Hardware",
            id: "hardware"
        },
        precio: 1000
    },
    {
        id: "pantalon-03",
        titulo: "Pantalón 03",
        imagen: "./img/pantalones/03.jpg",
        categoria: {
            nombre: "Hardware",
            id: "hardware"
        },
        precio: 1000
    },
    {
        id: "pantalon-04",
        titulo: "Pantalón 04",
        imagen: "./img/pantalones/04.jpg",
        categoria: {
            nombre: "Hardware",
            id: "hardware"
        },
        precio: 1000
    },
    {
        id: "pantalon-05",
        titulo: "Pantalón 05",
        imagen: "./img/pantalones/05.jpg",
        categoria: {
            nombre: "Hardware",
            id: "hardware"
        },
        precio: 1000
    }
];

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

mostrarProductos(productos);

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

const productosEnCarrito = [];

function agregarAlCarrito (evento) {

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