package Controller;

import java.util.HashMap;


public class Inventario {
    private HashMap<String, Producto> productos;
    
    public Inventario(){
        productos = new HashMap<>();
    }
    
    public void agregarProducto(Producto producto){
        productos.put(producto.getCodigo(), producto);
        System.out.println("--> Producto agregado correctamente: " + producto.getNombre());
    }    
    
    public Producto buscarProductoPorCodigo(String codigo) {
        Producto producto = productos.get(codigo);
        if (producto == null) {
            System.out.println("Producto no encontrado.");
        }
        return producto;
    }

    public void eliminarProducto(String codigo) {
        if (productos.remove(codigo) != null) {
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void actualizarProducto(Producto productoActualizado) {
        if (productos.containsKey(productoActualizado.getCodigo())) {
            productos.put(productoActualizado.getCodigo(), productoActualizado);
            System.out.println("Producto actualizado correctamente.");
        } else {
            System.out.println("Producto no encontrado. No se pudo actualizar.");
        }
    }
    

    public void listarProductos() {
        for (Producto producto : productos.values()) {
            System.out.println(producto);
        }
    }
    

    public void buscarProductoPorNombreODescripcion(String terminoBusqueda) {
        String terminoBusquedaMinusculas = terminoBusqueda.toLowerCase();
        long count = productos.values().stream()
                .filter(producto -> producto.getNombre().toLowerCase().contains(terminoBusquedaMinusculas) ||
                        producto.getDescripcion().toLowerCase().contains(terminoBusquedaMinusculas))
                .peek(System.out::println) 
                .count();
        if (count == 0) {
            System.out.println("No se encontraron productos.");
        }
    }
   
}
