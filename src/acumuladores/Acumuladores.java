package acumuladores;

public class Acumuladores {

	/**
	 * Dada una matriz de enteros y un número, verifica si existe alguna fila 
	 * donde todos sus elementos sean múltiplos del número recibido por 
	 * parámetro.
	 * 
	 * Si la matriz está vacía o si el número no es positivo, devuelve falso.
	 * 
	 * @param mat
	 * @param num
	 * @return
	 */
	public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) { 
		if(mat.length==0 || num<1) {
			return false;
		}
		boolean ret=false;
		for(int fila=0; fila<mat.length; fila++) {
			ret|= todosElemMultiplos(mat[fila],num);
		}
		return ret;
	}
	private boolean todosElemMultiplos(int[] arr,int num) {
		boolean ret=true;
		for(int elem=0; elem<arr.length; elem++) {
			ret&= arr[elem]%num==0;
		}
		return ret;
	}
	
	/**
	 * Dado 2 matrices se verifica si hay intersección entre las filas de cada
	 * matriz, fila a fila.
	 * 
	 * Si las matrices tienen distinta cantidad de filas o si alguna matriz 
	 * está vacía, devuelve falso.
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public boolean hayInterseccionPorFila(int[][] mat1, int[][]mat2) { 
		if(mat1.length==0 || mat2.length==0 || mat1.length!=mat2.length) {
			return false;
		}
		boolean ret=true;
		for(int fila=0; fila<mat1.length; fila++) {
			ret&= interseccion(mat1[fila], mat2[fila]);
		}
		return ret;
	}
	private boolean interseccion(int[] arr1, int[] arr2) {
		boolean ret=false;
		for(int elem=0; elem<arr1.length; elem++) {
			for(int elem2=0; elem2<arr2.length; elem2++) {
				ret|= arr1[elem]==arr2[elem2];
			}
		}
		return ret;
	}
	
	/**
	 * Dada una matriz y el índice de una columna, se verifica si existe alguna
	 * fila cuya suma de todos sus elementos sea mayor estricto que la suma de
	 * todos los elementos de la columna indicada por parámetro.
	 * 
	 * Si el índice de la columna es inválido o la matriz está vacía, devuelve 
	 * falso.
	 * 
	 * @param mat
	 * @param nColum
	 * @return
	 */
	public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) { 
		if(mat.length==0 || nColum>=mat[0].length || nColum<0) {
			return false;
		}
		boolean ret=false;
		int sumaCol= sumaColumna(mat,nColum);
		for(int fila=0; fila<mat.length; fila++) {
			ret|= sumaFila(mat[fila]) > sumaCol;
		}
		return ret;
	}
	private int sumaColumna(int[][] mat,int nColum) {
		int suma=0;
		for(int fila=0; fila<mat.length; fila++) {
			suma+=mat[fila][nColum];
		}
		return suma;
	}
	private int sumaFila(int[] arr) {
		int suma=0;
		for(int elem=0; elem<arr.length; elem++) {
			suma+=arr[elem];
		}
		return suma;
	}
	
	/**
	 * Dadas 2 matrices, se verifica si hay intersección entre las columnas de
	 * cada matriz, columna a columna.
	 * 
	 * Si las matrices tienen distinta cantidad de columnas o alguna matriz 
	 * está vacía, devuelve falso. 
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public boolean hayInterseccionPorColumna(int[][] mat1, int[][]mat2) { 
		if(mat1.length==0 || mat2.length==0 || mat1[0].length!=mat2[0].length ) {
			return false;
		}
		boolean ret=true;
		for(int columna=0; columna<mat1[0].length; columna++) {
			ret&= interseccionColum(mat1,mat2,columna);
		}
		return ret;
	}
	private boolean interseccionColum(int[][] mat1, int[][] mat2, int columna) {
		boolean ret=false;
		for(int i=0; i<mat1.length; i++) {
			for(int j=0; j<mat2.length; j++) {
				ret|=mat1[i][columna]==mat2[j][columna];
			}
		}
		return ret;
	}
}
