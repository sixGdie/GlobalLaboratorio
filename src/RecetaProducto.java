import java.util.ArrayList;
import java.util.Scanner;

public class RecetaProducto {

	private static final String[][] listaInsumos = { { "1000", "Harina", "Kg", "50" }, { "1001", "Huevos", "Un", "3" },
			{ "1002", "Tomate en Salsa", "Lt", "45" }, { "1003", "Queso Muzzarella", "Kg", "550" },
			{ "1004", "Queso Provolone", "Kg", "620" }, { "1005", "Queso Roquefort", "Kg", "650" },
			{ "1006", "Jamon Cocido", "Kg", "400" }, { "1007", "Salame", "Kg", "450" },
			{ "1008", "Lata Pimiento Morron", "Un", "130" }, { "1009", "Aceite", "Lt", "60" },
			{ "1010", "Carne Molida", "Kg", "180" }, { "1011", "Cebollas", "Kg", "60" },
			{ "1012", "Sal", "Kg", "75" } };

	public static void main(String[] args) {

		ArrayList<ProductoManufacturado> productos = new ArrayList<ProductoManufacturado>();

		while (true) {
			
			ProductoManufacturado producto = new ProductoManufacturado();
			System.out.println("====================================");
			System.out.println("DATOS PRODUCTO");
			System.out.println("====================================");
			System.out.println("Ingrese código del producto:");
			int codigo = leerCodigo();
			producto.setCodigo(codigo);
			System.out.println("Ingrese nombre del producto:");
			String denominacion = leerDenominacion();
			producto.setDenominacion(denominacion);
			System.out.println("Ingrese el tiempo de fabricación:");
			int tiempoFabricacion = leerTiempoFabricacion();
			System.out.println("Ingrese el márgen de ganancia:");
			double margenGanancia = leerMargenGanancia();
			producto.setMargenGanancia(margenGanancia);
			System.out.println("====================================");
			System.out.println("DATOS INSUMOS");
			System.out.println("====================================");
			System.out.println("Ingrese la cantidad de insumos a cargar:");
			int cantidadInsumos = leerCantidadFilas();
			producto.inicializarArreglo(cantidadInsumos);
			int contador = 0;
			while (contador < cantidadInsumos) {

				System.out.println("=============================");
				String[] insumoIngresado = buscarInsumo();
				System.out.println("Insumo encontrado: " + insumoIngresado[1]);
				System.out.println("Ingrese la cantidad del insumo:");
				int cantidadInsumo = leerCantidadInsumo();
				double precioCosto = cantidadInsumo * Double.parseDouble(listaInsumos[contador][3]);
				producto.cargarInsumos(contador, insumoIngresado[0], insumoIngresado[1], cantidadInsumo, precioCosto);
				
				++contador;

			}
			productos.add(producto);
			
			System.out.println("¿ Desea agregar más productos ? SI/NO");
			String salir = new Scanner(System.in).nextLine();
			if (!salirCarga(salir)) {
				
				System.out.println("[INFO]: Ha salido del programa.");
				break;
				
			}
			
		}
		mostrarProductos(productos);

	}

	static int leerCantidadFilas() {

		int cantidad = new Scanner(System.in).nextInt();

		if (cantidad <= 0 || cantidad >= 14) {

			System.out.println("[ERROR]: La cantidad de insumos debe ser entre 1 (uno) y 13 (trece) incluídos, inténtelo nuevamente.");
			leerCantidadFilas();

		}

		return cantidad;
	}

	static String[] buscarInsumo() {
		
		System.out.println("Ingrese código del insumo a cargar:");
		String codigo = new Scanner(System.in).nextLine();
		boolean encontrado = false;
		String insumo[] = new String[3];
		
		for (int i = 0; i < listaInsumos.length; i++) {
			
			if (listaInsumos[i][0].equals(codigo)) {
				
				insumo[0] = listaInsumos[i][0];
				insumo[1] = listaInsumos[i][1];
				insumo[2] = listaInsumos[i][2];
				encontrado = true;
				break;
				
			}
			
		}
		if (!encontrado) {
			
			System.out.println("[ERROR]: El código ingresado no fue encontrado, inténtelo nuevamente.");
			buscarInsumo();
			
		}
		
		return insumo;	
	}

	static int leerCodigo() {

		int codigo = new Scanner(System.in).nextInt();

		if (codigo <= 0) {

			System.out.println("[ERROR]: El código debe ser mayor a cero, inténtelo nuevamente.");
			leerCodigo();

		}

		return codigo;
	}

	static String leerDenominacion() {

		String denominacion = new Scanner(System.in).nextLine();

		if (denominacion.isEmpty()) {

			System.out.println("[ERROR]: La denominación no puede estar vacía, inténtelo nuevamente.");
			leerDenominacion();

		}

		return denominacion;
	}

	static int leerTiempoFabricacion() {

		int tiempoFabricacion = new Scanner(System.in).nextInt();

		if (tiempoFabricacion <= 0) {

			System.out.println("[ERROR]: El tiempo de fabricación debe ser mayor a cero, inténtelo nuevamente.");
			leerTiempoFabricacion();

		}

		return tiempoFabricacion;
	}

	static double leerMargenGanancia() {

		double margenGanancia = new Scanner(System.in).nextDouble();

		if (margenGanancia <= 0) {

			System.out.println("[ERROR]: El márgen de ganancia debe ser mayor a cero, inténtelo nuevamente.");
			leerMargenGanancia();

		}

		return margenGanancia;
	}
	
	static int leerCantidadInsumo() {
		
		int cantidad = new Scanner(System.in).nextInt();
		
		if (cantidad <= 0) {
			
			System.out.println("[ERROR]: La cantidad del insumo debe ser mayor a cero, inténtelo nuevamente.");
			leerCantidadInsumo();
			
		}
		
		return cantidad;
	}
	
	static boolean salirCarga(String salir) {
		
		if (salir.equalsIgnoreCase("NO")) {
			
			return false;
			
		} else if (salir.equalsIgnoreCase("SI")) {
			
			return true;
			
		} else {
			
			System.out.println("[ERROR]: Opción no válida, inténtelo nuevamente.");
			salir = new Scanner(System.in).nextLine();
			
		}
		
		return true;
	}
	
	static void mostrarProductos(ArrayList<ProductoManufacturado> listaProductos) {
		
		
		for (ProductoManufacturado p : listaProductos) {
			
			System.out.println("Código Producto: " + p.getCodigo());
			System.out.println("Producto: " + p.getDenominacion());
			System.out.println("Tiempo Elaboración: " + p.getTiempoFabricacion());
			System.out.println("Insumos:");
			System.out.println();
			System.out.println(completarConEspacios("Código") + "\t" + completarConEspacios("Insumo") + "\t" + completarConEspacios("Cantidad/Unidad Medida") + "\t" + completarConEspacios("Precio Costo Calculado"));
			
			for (int i = 0; i < p.getInsumos().length; i++) {
				
				System.out.println(completarConEspacios(p.getInsumos()[i][0]) + "\t" + completarConEspacios(p.getInsumos()[i][1]) + "\t" + completarConEspacios(p.getInsumos()[i][2] + listaInsumos[i][2]) + "\t" + completarConEspacios(p.getInsumos()[i][3]));
				
			}
			System.out.println();
			System.out.println(completarConEspacios("Costo Total Producto:") + "\t\t\t\t\t\t\t" + completarConEspacios(Double.toString(p.costoTotalProducto())));
			System.out.println(completarConEspacios("Margen de Ganancia:") + "\t\t\t\t\t\t\t" + completarConEspacios(Double.toString(p.getMargenGanancia()) + " %"));
			System.out.println(completarConEspacios("Precio de Venta Final") + "\t\t\t\t\t\t\t" + completarConEspacios(Double.toString(p.precioVentaProducto())));
			
		}

		
		
	}

	static String completarConEspacios(String cadena) {
		
		int cantidadEspacios = 20 - cadena.length();
		for (int i = 0; i < cantidadEspacios; i++) {
			cadena += " ";
		}
		return cadena;
	}

}
