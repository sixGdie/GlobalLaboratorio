
public class ProductoManufacturado {

	private int codigo;
	private String denominacion;
	private int tiempoFabricacion;
	private String[][] insumos;
	private double margenGanancia;
	
	public ProductoManufacturado() {
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public int getTiempoFabricacion() {
		return tiempoFabricacion;
	}

	public void setTiempoFabricacion(int tiempoFabricacion) {
		this.tiempoFabricacion = tiempoFabricacion;
	}

	public String[][] getInsumos() {
		return insumos;
	}

	public void setInsumos(String[][] insumos) {
		this.insumos = insumos;
	}

	public double getMargenGanancia() {
		return margenGanancia;
	}

	public void setMargenGanancia(double margenGanancia) {
		this.margenGanancia = margenGanancia;
	}
	
	public void inicializarArreglo(int filas) {
		
		this.insumos = new String[filas][4];
		
	}
	
	public void cargarInsumos(int fila, String codigo, String denominacion, double cantidad, double precioCosto) {
		
		this.insumos[fila][0] = codigo;
		this.insumos[fila][1] = denominacion;
		this.insumos[fila][2] = Double.toString(cantidad);
		this.insumos[fila][3] = Double.toString(precioCosto);
		
	}
	
	public double costoTotalProducto() {
		
		double costoTotal = 0;
		
		for (int i = 0; i < insumos.length; i++) {

			costoTotal += Double.parseDouble(insumos[i][3]);
			
		}
		
		return costoTotal;
	}
	
	public double precioVentaProducto() {
		
		double precioVenta = costoTotalProducto() + (costoTotalProducto() * this.margenGanancia / 100);
		
		return precioVenta;
	}
	
}
