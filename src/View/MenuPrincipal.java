package View;

import Controller.Inventario;
import Controller.Producto;
import java.util.Scanner;

public class MenuPrincipal {
    
    static Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int opcionUsuario;
        
        Inventario inventario = new Inventario();

        Producto producto1 = new Producto("1","Shampoo","Producto de aseo del cabello",5400, 5);
        inventario.agregarProducto(producto1);
        Producto producto2 = new Producto("2","Leche","Leche semi-descremada",990, 15);
        inventario.agregarProducto(producto2);
        Producto producto3 = new Producto("3","Cafe","Cafe de 90gr",1800, 7);
        inventario.agregarProducto(producto3);
        Producto producto4 = new Producto("4","Jabon","Jabon en barra",850, 20);
        inventario.agregarProducto(producto4);
        
        
        do{
            System.out.println("""
                               |========================================|
                               |            GESTION INVENTARIO          |
                               |========================================|
                               
                                    [1] AGREGAR PRODUCTO
                                    [2] MODIFICAR PRODUCTO
                                    [3] ELIMINAR PRODUCTO
                                    [4] BUSCAR PRODUCTO
                                    [5] LISTAR INVENTARIO
                                    [6] SALIR
                               
                               |========================================|                               
                               """);
            System.out.print("Ingrese su opcion: ");
            opcionUsuario = teclado.nextInt();
            
            switch(opcionUsuario){
                case 1 -> {
                    System.out.println("Ingrese el codigo: ");
                    String codigo = teclado.next();
                    Producto productoEncontrado = inventario.buscarProductoPorCodigo(codigo);
                            if (productoEncontrado != null) {
                                System.out.println("El codigo ya existe, elige otro. \nProducto: " + productoEncontrado);
                                break;
                            } 
                    System.out.println("Ingrese el nombre: ");
                    String nombre = teclado.next(); teclado.nextLine();
                    System.out.println("Ingrese la descripcion: ");
                    String descripcion = teclado.nextLine();
                    System.out.println("Ingrese el precio: ");
                    String precio1 = teclado.next();
                    double precio = Double.parseDouble(precio1);
                    System.out.println("Ingrese la cantidad de Stock: ");
                    String cantidad = teclado.next();
                    int cantidadEnStock = Integer.parseInt(cantidad);
                    inventario.agregarProducto(new Producto(codigo,nombre,descripcion,precio,cantidadEnStock));
                }
                case 2 -> {
                    System.out.println("Ingrese el codigo: ");
                    String codigo = teclado.next(); 
                    System.out.println("Ingrese el nombre: ");
                    String nombre = teclado.next(); teclado.nextLine();
                    System.out.println("Ingrese la descripcion: ");
                    String descripcion = teclado.nextLine();
                    System.out.println("Ingrese el precio: ");
                    String precio1 = teclado.next();
                    double precio = Double.parseDouble(precio1);
                    System.out.println("Ingrese la cantidad de Stock: ");
                    String cantidad = teclado.next();
                    int cantidadEnStock = Integer.parseInt(cantidad);
                    inventario.actualizarProducto(new Producto(codigo,nombre,descripcion,precio,cantidadEnStock));
                }
                case 3 -> {
                    System.out.print("Ingrese codigo: ");
                    String codigo = teclado.next(); 
                    inventario.eliminarProducto(codigo);       
                    
                }
                case 4 -> {
                    System.out.println("""
                                       [BUSCAR PRODUCTO]
                                           [1] POR CODIGO
                                           [2] POR NOMBRE O DESCRIPCION                                      
                                       """);
                    System.out.print("Ingrese su opcion: ");
                    int opcionUsuario4 = teclado.nextInt();
                    switch(opcionUsuario4){
                        case 1 -> {
                            System.out.print("Ingrese codigo: ");
                            String codigo = teclado.next(); 
                            Producto productoEncontrado = inventario.buscarProductoPorCodigo(codigo);
                            if (productoEncontrado != null) {
                                System.out.println(productoEncontrado);
                            } 
                        }
                        case 2 -> {
                            System.out.print("Ingrese nombre o descripcion: ");
                            String nombreODesc = teclado.next();                          
                            inventario.buscarProductoPorNombreODescripcion(nombreODesc);
                        }
                        default -> System.out.println("Ingrese una opcion valida...");
                    }
                }
                case 5 -> {
                    System.out.println("\n[   INVENTARIO ACTUAL   ]");
                    inventario.listarProductos();
                    System.out.println("");
                }
                case 6 -> {
                    System.out.println("Saliendo...");
                }
                default -> System.out.println("Ingrese una opcion valida...");
                    
                    
            }
            
        }while(opcionUsuario !=6);
        
        
    }
}
