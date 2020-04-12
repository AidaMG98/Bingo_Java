/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bingo;

import java.util.Random;

/**
 *
 * @author aida
 */
public class Carton {

    // Creamos los atributos de la clase
    int[][] matrizNumeros;

    // Añadimos el construcor
    public Carton() {
        this.matrizNumeros = new int[3][9];
    }
    
    //  Para eliminar los numeros del cartón hemos creado un método para que sea 
    // mas sencillo de ver.
    private void eliminarNumero() {
        //  Lo primero hemos creado son tres atributos para contar el numero de
        // espacios que tiene cada fila. 
        int fila0 = 0;
        int fila1 = 0;
        int fila2 = 0;
        //  También hemos creado un valor que sera el que nos servira para crear 
        // un valor rando.
        int valor; 
        Random alt = new Random();
        
        //  Como ya sabemos la fila no puede tener mas que 4 espacios en blanco y 
        // una columna tiene que tener como mínimo una posición ocupado y como 
        // máximo 2.
        
        //  Para hacer este método hemos tenido esos dos factores como prioridad 
        // por ello hemos creado dos bucles para recorrer y como primera condicion
        // hemos indicado que en las columnas no pueden ser su posición 0 
        // (refiriendonos al espacio en blanco)
        for (int[] matrizNumero : this.matrizNumeros) {
            for (int j = 0; j < matrizNumero.length; j++) {
                while (this.matrizNumeros[0][j] != 0 && this.matrizNumeros[1][j] != 0 && this.matrizNumeros[2][j] != 0) {
                    //  Dentro del bucle lo que hemos hecho es que el atributo 
                    // "valor" saque un valor aleatorio.
                    valor = alt.nextInt(3);
                    //  Ese valor se meterá en un switch y si el contador es menor 
                    // a 3 entrará y esa posición se pondrá a "0" (se quedará 
                    // como un espacio en blanco)
                    switch (valor) {
                        case 0:
                            if (fila0 < 3) {
                                this.matrizNumeros[0][j] = 0;
                                fila0++;
                            }
                            break;
                        case 1:
                            if (fila1 < 3) {
                                this.matrizNumeros[1][j] = 0;
                                fila1++;
                            }
                            break;
                        case 2:
                            if (fila2 < 3) {
                                this.matrizNumeros[2][j] = 0;
                                fila2++;
                            }
                            break;
                    }
                }
            }
        }
        //  Una vez termine este bucle se iniciará otros 2 en el que se ejecutará 
        // un bulce en el que cuando los valores de las tres filas sean 3
        for (int[] matrizNumero : this.matrizNumeros) {
            for (int j = 0; j < matrizNumero.length; j++) {
                do {       
                    valor = alt.nextInt(3);
                    //  Volveremos a generá un valor aleatorio en el que se meterá
                    // en otro switch.
                    switch (valor) {
                        //  Dentro de cada opción vamos a tener que cumplir una
                        // condición. Si la fila es menor a 4 y la posición en
                        // la que estamos actualmente es distinta de 0 y si alguna 
                        // de las fila es dinstinta a 0 entraremos la posición se 
                        // pondrá a 0 y se le sumará uno más a la fila
                        case 0:   
                            if (fila0 < 4 && this.matrizNumeros[0][j] != 0 && (this.matrizNumeros[1][j] != 0 || this.matrizNumeros[2][j] != 0)) {
                                this.matrizNumeros[0][j] = 0;
                                fila0++;
                            }
                            break;
                        case 1:
                            if (fila1 < 4 && this.matrizNumeros[1][j] != 0 && (this.matrizNumeros[0][j] != 0 || this.matrizNumeros[2][j] != 0)) {
                                this.matrizNumeros[1][j] = 0;
                                fila1++;
                            }
                            break;
                        case 2:
                            if (fila2 < 4 && this.matrizNumeros[2][j] != 0 && (this.matrizNumeros[1][j] != 0 || this.matrizNumeros[0][j] != 0)) {
                                this.matrizNumeros[2][j] = 0;
                                fila2++;
                            }
                            break;
                    }

                } while (fila0 == 3 && fila1== 3 && fila2== 3);
            }
        }
    }


    // Añadimos el método generarCarton en el se va a crear el cartón
    public void generarCarton() {
        Random alt = new Random();

        //  Vamos a generar dos bucles, uno dentro del otro ya que se trata de una matriz,
        // las matrices son dos arrays que contiene otro array en cada uno de sus 
        // elementos. Por ello necesitamos dos bucles para poder ir metiendo valores.
        for (int[] matrizNumero : this.matrizNumeros) {
            for (int j = 0; j < matrizNumero.length; j++) {
                // Hemos creado un atributo para que genere numero aleatorio.
                int numero;
                //  Hemos creado un switch para que cuando "j" tome un valor en la posición 
                // que le toque en ese momento se genera un número aletorio en el rango indicado
                // asi la primera columna será tomará valores menores a 10, la segunda valores
                // mayores a 9 menores a 20... Hasta que llegue a la ultima columna que tendrá 
                // valores mayores a 79 y menores hasta el 90 incluido.
                switch (j) {
                //  En cada opcion dentro hay un bucle para que vaya comparando las filas, si 
                // la fila 0, o cualquier otra fila, tiene el mismo valor genera otro numero.
                // Dentro también le indicamos que la posición "x" va a tener el número aleatorio
                // que hemos generado en el bucle y tambien tiene un break para que se salga.
                    case 0:
                        do {
                            numero = alt.nextInt(9) + 1; // Genera números entre 1 hasta 9
                        } while (numero == this.matrizNumeros[0][j] || numero == this.matrizNumeros[1][j] || numero == this.matrizNumeros[2][j]);
                        matrizNumero[j] = numero;
                        break;
                    case 1:
                        do {
                            numero = alt.nextInt(9) + 11; // Genera núermos desde el 10 al 19
                        } while (numero == this.matrizNumeros[0][j] || numero == this.matrizNumeros[1][j] || numero == this.matrizNumeros[2][j]);
                        matrizNumero[j] = numero;
                        break;
                    case 2:
                        do {
                            numero = alt.nextInt(9) + 21;
                        } while (numero == this.matrizNumeros[0][j] || numero == this.matrizNumeros[1][j] || numero == this.matrizNumeros[2][j]);
                        matrizNumero[j] = numero;
                        break;
                    case 3:
                        do {
                            numero = alt.nextInt(9) + 31;
                        } while (numero == this.matrizNumeros[0][j] || numero == this.matrizNumeros[1][j] || numero == this.matrizNumeros[2][j]);
                        matrizNumero[j] = numero;
                        break;
                    case 4:
                        do {
                            numero = alt.nextInt(9) + 41;
                        } while (numero == this.matrizNumeros[0][j] || numero == this.matrizNumeros[1][j] || numero == this.matrizNumeros[2][j]);
                        matrizNumero[j] = numero;
                        break;
                    case 5:
                        do {
                            numero = alt.nextInt(9) + 51;
                        } while (numero == this.matrizNumeros[0][j] || numero == this.matrizNumeros[1][j] || numero == this.matrizNumeros[2][j]);
                        matrizNumero[j] = numero;
                        break;
                    case 6:
                        do {
                            numero = alt.nextInt(9) + 61;
                        } while (numero == this.matrizNumeros[0][j] || numero == this.matrizNumeros[1][j] || numero == this.matrizNumeros[2][j]);
                        matrizNumero[j] = numero;
                        break;
                    case 7:
                        do {
                            numero = alt.nextInt(9) + 71;
                        } while (numero == this.matrizNumeros[0][j] || numero == this.matrizNumeros[1][j] || numero == this.matrizNumeros[2][j]);
                        matrizNumero[j] = numero;
                        break;
                    case 8:
                        do {
                            numero = alt.nextInt(9) + 82;
                        } while (numero == this.matrizNumeros[0][j] || numero == this.matrizNumeros[1][j] || numero == this.matrizNumeros[2][j]);
                        matrizNumero[j] = numero;
                        break;
                }
            }
        }
        
        //  Despúes vamos a hacer otros dos bucles para que vaya comparando los números 
        // y los vaya ordnenado entre las filas. (Para ello e usado el método burbuja 
        // explicado en clase.)
        for (int i = 0; i< this.matrizNumeros.length - 1; i++) {
            for (int j = 0; j < this.matrizNumeros[i].length; j++) {
                int valor;
                //  Esta condición compara la fila "x" con la fila "x+1" si es mayor 
                // la fila "x" entra dentro y en el atributo creado antes guarda el
                // valor de la fila "x+1", despúes la fila "x+1" se queda con el valor 
                // de la fila "x" y por ultimo se le asigna el valor del atributo a la fila"x".
                if (this.matrizNumeros[i + 1][j] < this.matrizNumeros[i][j]) {
                    valor = this.matrizNumeros[i + 1][j];
                    this.matrizNumeros[i + 1][j] = this.matrizNumeros[i][j];
                    this.matrizNumeros[i][j] = valor;
                }

            }
        }
        this.eliminarNumero();

    }

    //  Este método lo hemos creado para poder ver el cartón con un ESTILO ÚNICO 
    public void mostrarCarton() {
        //  Dentro tenemos dos for para que vaya creado la estructura
        System.out.println("\033[34m" + "-------------------------------CARTÓN-------------------------------");
        for (int[] matrizNumero : matrizNumeros) {
            for (int j = 0; j < matrizNumero.length; j++) {
                //  Dentro de los dos for tenemos un switch para que si sale 0 
                // (que es el valor con el que asociamos los espacios) no se 
                // muestre nada, si sale 99 (que es el valor que hemos asocuado 
                // cuando el numero es tachado) salga una "X" en color rojo y si
                // no sale ninguna de esos 2 casos que muestre el número como un String
                switch (matrizNumero[j]) {
                    case 0:
                        System.out.print("\033[34m" + " | " + " " + " | ");
                        break;
                    case 99:
                        System.out.print("\033[34m" + " | " + "\033[31m" + "X" + "\033[34m" +" | ");
                        break;
                    default:
                        System.out.print("\033[34m" + " | " + String.valueOf(matrizNumero[j]) + " | ");
                        break;
                }
            }
            System.out.println("");
            System.out.println("\033[34m" + "--------------------------------------------------------------------");
        }

    }

    //  Luego tenemos el método tachar casilla al que se le pasa un número
    public void tacharCasilla(int numero) { 
        //  Lo primero mostrará un mensaje con el número que ha salido
        System.out.println("EL NÚMERO QUE HA SALIDO ES EL: " + numero);
        //  Después crearemos dos for para que vaya comprobando si ese número 
        // esta en nuestro cartón
        for (int[] matrizNumero : this.matrizNumeros) {
            for (int j = 0; j < matrizNumero.length; j++) {
                //  Si está en nuestro cartón se pondrá a 99 pero nosotros lo 
                // veremos como una "X"
                if (matrizNumero[j] == numero) {
                    matrizNumero[j] = 99;
                }
            }
        }

    }

    //  Este metodo hace dos bucles para ir mirando fila por fila si alguno de
    // los numeros ha sido tachado, si así es se le añade un valor a su contador
    // y cuando llegue a 5 mostrará un mensaje indicando en que fila es la linea 
    public void comprobarLinea() {
 
        for (int i = 0; i < this.matrizNumeros.length; i++) {
            int contarFila1 = 0;
            int contarFila2 = 0;
            int contarFila3 = 0;
        
            for (int j = 0; j < this.matrizNumeros[i].length; j++) {
                
                if (this.matrizNumeros[0][j] == 99) {
                    contarFila1++;
                    if (contarFila1 == 5 || this.matrizNumeros[1][j] == 99 || this.matrizNumeros[2][j] == 99) {
                        System.out.println("LINEA....!!!");
                        return;
                    }
                } 
            }
        }
    }
    
    //  En este método comprobaremos que todos los números del cartón que han sido
    // tachados, si es así nos mostrará un mensaje diciendo que tiene bingo.
    public boolean comprobarBingo() {
        int contador = 0;
        for (int i = 0; i < this.matrizNumeros.length; i++) {
            for (int j = 0; j < this.matrizNumeros[i].length; j++) {
                
                if (this.matrizNumeros[i][j] == 99) {
                    contador++;
                }
                if (contador == 15) {
                    System.out.println("BINGO....!!!");
                    return true;
                }
            }
        }
        return false;
    }

}
