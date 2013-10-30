import java.io.*;
import java.util.Scanner;

class LeerNotas {
	public static void main(String[] arg) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		Scanner sc = new Scanner(System.in);
		int i=1, total=1, np=0 ;
		double vNota=0, suma=0, media=0;
		String nota;
		
		System.out.println("Introduce la ruta del archivo (Ej: C:/) ");
		String ruta = sc.nextLine();
		System.out.println("Introduce el nombre del archivo a leer (acabado en .txt): ");
		String nombreArchivo = sc.nextLine();
		
		try {
			archivo = new File(ruta+nombreArchivo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null){
				nota=linea.substring((linea.length()-3), linea.length());
				if(nota.contains("NP")){
					System.out.println(linea);
					System.out.println(" -> No presentado nº "+np);
					np++;
				}
				else
				{
					System.out.println(linea);
					vNota=Double.parseDouble(nota);
					suma=suma+vNota;
					System.out.println(" -> Nota: "+vNota+", Nota Ac.: "+suma);
				}
				total++;
			}
			System.out.println("Total presentados: "+total);
			media=suma/total;
			System.out.println("Nota media: "+media);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
