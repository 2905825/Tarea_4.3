import java.util.Arrays;
	import java.util.List;

	public class EjercicioArrays {

	  //Este es el método principal, el método main, el cual va a abarcar el resto de código en su interior.
	  public static void main(String[] args) {
		  
	        int numAlumnos = 40;
	        Integer[] control = generarNotasAleatorias(numAlumnos);
	        int[] listaClase = generarListaClase(numAlumnos);
	        
	        int minNota = Encontrar_MinNota(control);
	        int maxNota = Encontrar_MaxNota(control);
	        
	        List<Integer> notas = Arrays.asList(control);
	        int indMinNota = notas.indexOf(minNota) + 1;
	        int indMaxNota = notas.indexOf(maxNota) + 1;

	        MostrarEstadisticas(minNota, maxNota, indMinNota, indMaxNota, listaClase, notas);
	        
	        Integer[] practicas = generarNotasAleatorias(numAlumnos);
	        float[] calificaciones = calcularNotasFinales(control, practicas);
	        
	        MostrarPracticasYNotas(practicas, calificaciones);
	        
	        float[] estadistica = MostrarEstadisticas(calificaciones);
	        MostrarEstadisticas(estadistica);
	        
	        int[] aprobados = new int[numAlumnos];
	        int[] suspensos = new int[numAlumnos];
	        int countAprobados = 0;
	        int  countSuspensos = 0;

	        for (int i = 0; i < numAlumnos; i++) {
	            if (calificaciones[i] < 5) {
	                aprobados[countAprobados++] = i + 1; 
	            } else {
	                suspensos[countSuspensos++] = i + 1; 
	            }
	        }

	        MostrarAprobadosYSuspensos(aprobados, countAprobados, suspensos, countSuspensos);
	        
	        double[] calif = new double[40];
	        for (int j = 0; j < 31; j++) {
	            calif[j] = (int) (Math.random() * 11);
	        }
	        actualizarNotas(calif, 3, 6);
	    }

	  	//Este método te genera notas aleatorias de los alumnos de la clase.
	    private static Integer[] generarNotasAleatorias(int numAlumnos) {
	        Integer[] grades = new Integer[numAlumnos];
	        for (int i = 0; i < numAlumnos; i++) {
	            grades[i] = (int) (Math.random() * 11);
	        }
	        return grades;
	    }

	    //Este método te genera la lista de la clase.
	    private static int[] generarListaClase(int numAlumnos) {
	        int[] listaClase = new int[numAlumnos];
	        for (int i = 0; i < numAlumnos; i++) {
	            listaClase[i] = i + 1;
	        }
	        
	        return listaClase;
	    }

	    //Este método te muestra la nota mínima.
	    private static int Encontrar_MinNota(Integer[] control) {
	        return Arrays.stream(control).min(Integer::compare).orElse(0);
	    }

	    //Este método te muestra la nota máxima.
	    private static int Encontrar_MaxNota(Integer[] control) {
	        return Arrays.stream(control).max(Integer::compare).orElse(0);
	    }

	    //Este método te muestra las estadísticas de las notas de los alumnos de la clase.
	    private static void MostrarEstadisticas(int minNota, int maxNota, int indMinNota, int indMaxNota, int[] listaClase, List<Integer> notas) {
	        System.out.println("Mínimo es: " + minNota);
	        System.out.println("Máximo es: " + maxNota);
	        System.out.println("Índice del mínimo es: " + indMinNota);
	        System.out.println("Índice del máximo es: " + indMaxNota);
	        System.out.println("Lista de clase: " + Arrays.toString(listaClase));
	        System.out.println("Array de Notas: " + notas);
	    }

	    //Este método te calcula las notas finales de los alumnos.
	    private static float[] calcularNotasFinales(Integer[] control, Integer[] practicas) {
	        float[] calificaciones = new float[control.length];
	        for (int i = 0; i < control.length; i++) {
	            calificaciones[i] = (control[i] + practicas[i]) / 2.0f;
	        }
	        return calificaciones;
	    }

	    //Este método te muestra las prácticas y las notas de los alumnos de la clase.
	    private static void MostrarPracticasYNotas(Integer[] practicas, float[] calificaciones) {
	        System.out.println("Prácticas: " + Arrays.toString(practicas));
	        System.out.println("Calificaciones: " + Arrays.toString(calificaciones));
	    }

	    //Este método te muestra las estadísticas de las notas.
	    private static float[] MostrarEstadisticas(float[] estadistica) {
	    	
	        for (int i = 0; i < estadistica.length; i++) {
	            double sol = Math.round(estadistica[i] * 10000.0) / 100.0;
	            System.out.println("Estadística nota tramo <= " + (i + 1) + " = " + sol + "%");
	        }
	        
			return estadistica;
	    }
	    
	    //Este método te muestra todos los aprobados y suspensos de la clase.
	    private static void MostrarAprobadosYSuspensos(int[] aprobados, int countAprobados, int[] suspensos, int countSuspensos) {
	        System.out.println("Relación de aprobados por n° de lista: " + Arrays.toString(Arrays.copyOf(aprobados, countAprobados)));
	        System.out.println("Relación de suspensos por n° de lista: " + Arrays.toString(Arrays.copyOf(suspensos, countSuspensos)));
	    }

	    //Este método te actualiza la nota antigua y nueva del alumno.
	    private static void actualizarNotas(double[] calif, int index, double NuevaNota) {
	        System.out.println("Nota antigua alumno n°" + (index + 1) + ": " + calif[index]);
	        calif[index] = NuevaNota;
	        System.out.println("Nota nueva alumno n°" + (index + 1) + ": " + calif[index]);
	    }
	    
	    //Fin del programa.
	}

