/**
 * 
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

import data.Cine;
import data.Musica;
import data.Productos;
import data.Videojuegos;
import mensajes.Mensajes;
import store.Ficheros;

/**
 * Clase que gestiona los productos disponibles en la tienda. Permite cargar
 * productos, mostrarlos, y realizar compras.
 * 
 * @author 
 * @version 1.0
 */
public class GestionProductos {

	private TreeMap<Integer, Productos> catalogo = new TreeMap<>();
	private List<Productos> productosSeleccionados = new ArrayList<>();

	/**
	 * Carga productos en el catálogo.
	 * 
	 * @param catalogo Catálogo de productos a cargar.
	 */
	public void cargarProductos(TreeMap<Integer, Productos> catalogo) {

		Productos disco1 = new Musica("Feelings", 18.53, 6, true, "Pop", generarCodigoBarras(), "Lauv");
		Productos disco2 = new Musica("Enchanted", 21.2, 20, true, "Pop", generarCodigoBarras(), "Taylor Swift");
		Productos cine1 = new Cine("Willy Wonka", 30.2, 5, true, "Fantasía", generarCodigoBarras(), "Tim Burton");
		Productos juego1 = new Videojuegos("Mario Bros", 35.11, 0, false, "Plataformas", generarCodigoBarras(),
				"Nintendo");

		catalogo.put(disco1.getCodigoBarras(), disco1);
		catalogo.put(disco2.getCodigoBarras(), disco2);
		catalogo.put(cine1.getCodigoBarras(), cine1);
		catalogo.put(juego1.getCodigoBarras(), juego1);

		this.catalogo = catalogo;
	}

	/**
	 * Muestra la lista de productos disponibles
	 * 
	 */
	public void mostrarProductos() {
		int contador = 1;
		for (Map.Entry<Integer, Productos> entry : catalogo.entrySet()) {
			Productos producto = entry.getValue();
			System.out.println("PRODUCTO " + contador + "\nCódigo de barras: " + entry.getKey() + "\nNombre: "
					+ producto.getNombre() + "\nPrecio unitario: " + producto.getPrecioUnit() + " euros"
					+ "\nCantidad en stock: " + producto.getCantStock() + "\nGenero: " + producto.getGenero());

			if (producto instanceof Musica) {
				Musica musica = (Musica) producto;
				System.out.println("Autor: " + musica.getAutor());
			} else if (producto instanceof Cine) {
				Cine cine = (Cine) producto;
				System.out.println("Director: " + cine.getDirector());
			} else if (producto instanceof Videojuegos) {
				Videojuegos videojuego = (Videojuegos) producto;
				System.out.println("Plataforma: " + videojuego.getPlataforma());
			}
			System.out.println();
			contador = contador + 1;
		}
	}

	/**
	 * Obtiene el catálogo de productos.
	 * 
	 * @return Catálogo de productos.
	 */
	public TreeMap<Integer, Productos> getCatalogo() {
		return catalogo;
	}

	/**
	 * Devuelve un numero random.
	 * 
	 * @return Número random de 6 cifras
	 */
	public int generarCodigoBarras() {
		Random random = new Random();
		return 100000 + random.nextInt(900000);
	}

}
