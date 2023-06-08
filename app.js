const templateCard = document.getElementById('template-card').content
const templateFooter = document.getElementById('template-footer').content
const templateCarrito = document.getElementById('template-carrito').content

const items = document.getElementById('items')
const cards = document.getElementById('cards')
const footer = document.getElementById('footer')

const fragment = document.createDocumentFragment()
let carrito = {}

document.addEventListener('DOMContentLoaded', ()=>{
    fetchData()
    if (localStorage.getItem('carrito')){
        carrito = JSON.parse(localStorage.getItem('carrito'))
        pintarCarrito()
    }
})
cards.addEventListener('click', e =>{
addCarrito(e)})

items.addEventListener('click', e =>{
    btnAction(e)})

const fetchData = async ()=>{
    const res = await fetch('api.json')
    const data = await res.json()
    pintarCards(data)
    

}
const pintarCards = data =>{
    data.forEach(producto => {
    templateCard.querySelector('h5').textContent = producto.title
    templateCard.querySelector('p').textContent = producto.precio
    templateCard.querySelector('h6').textContent = producto.hola
    templateCard.querySelector('img').setAttribute('src', producto.thumbnailUrl)
    templateCard.querySelector('button').dataset.id = producto.id


     const clone = templateCard.cloneNode(true)  
     fragment.appendChild(clone) 
    });
    cards.appendChild(fragment)
}
const addCarrito = e =>{
    if(e.target.classList.contains('btn-success')){  //cambio dark a success
setCarrito(e.target.parentElement)
    }
    e.stopPropagation()
}
const setCarrito = objeto =>{
const producto = {
    id: objeto.querySelector('button').dataset.id,
    title: objeto.querySelector('h5').textContent,
    precio: objeto.querySelector('p').textContent,
    cantidad:1



}

if (carrito.hasOwnProperty(producto.id)){
    producto.cantidad = carrito[producto.id].cantidad +1
}
carrito[producto.id] = {... producto}
pintarCarrito()

}

const pintarCarrito = ()=>{
    console.log(carrito);
    items.innerHTML= ''
Object.values(carrito).forEach(item  =>{
templateCarrito.querySelector('th').textContent=item.id
templateCarrito.querySelectorAll('td')[0].textContent=item.title
templateCarrito.querySelectorAll('td')[1].textContent=item.cantidad
templateCarrito.querySelector('.btn-info').dataset.id=item.id
templateCarrito.querySelector('.btn-danger').dataset.id=item.id
templateCarrito.querySelector('span').textContent=item.cantidad * item.precio

console.log(item.title);
// cart1(item.cantidad);

//console.log(item.cantidad);

const clone = templateCarrito.cloneNode(true)
fragment.appendChild(clone)
})
items.appendChild(fragment)
pintarFooter()

localStorage.setItem('carrito', JSON.stringify(carrito))

}


 
const pintarFooter = ()=>{
    footer.innerHTML = ''
    if ( Object.keys(carrito).length === 0) {
        footer.innerHTML = `
        <th scope="row" colspan="5">Carrito vacío - comience a comprar!</th>
        `
        return
    }
    const nCantidad = Object.values(carrito).reduce((acc,{cantidad}) => acc +cantidad  ,0 )
    const nPrecio = Object.values(carrito).reduce((acc,{cantidad,precio}) => acc + cantidad * precio ,0)
    
    templateFooter.querySelectorAll('td')[0].textContent = nCantidad
    templateFooter.querySelector('span').textContent = nPrecio
    // cart1(nCantidad)
    const clone = templateFooter.cloneNode(true)
    footer.appendChild(clone)
    footer.append(fragment)

    const btnVaciar = document.getElementById('vaciar-carrito')
    btnVaciar.addEventListener('click', () => {
        carrito = {}
        pintarCarrito()
        

    })
}

const btnAction = e =>{
if (e.target.classList.contains('btn-info')){
    carrito[e.target.dataset.id]

    const producto = carrito[e.target.dataset.id]
    producto.cantidad ++
    carrito[e.target.dataset.id] = {... producto}
    pintarCarrito()
}
if (e.target.classList.contains('btn-danger')){
    const producto = carrito[e.target.dataset.id]
    producto.cantidad --
   
    if(producto.cantidad === 0){
        delete  carrito[e.target.dataset.id]
    }
    pintarCarrito()

}
e.stopPropagation()
}
// function cart1(cantidad ) {
  
 
//    console.log(cantidad);
// var cartElement = document.getElementById('cart');
// if (carrito = {}){
// cartElement.innerText = 0
// }else{
// cartElement.innerText = cantidad
// }var cartElement = document.getElementById('cart');


// }
