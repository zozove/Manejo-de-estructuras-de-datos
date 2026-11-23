package Proyecto_EDAI_1B_Grupo_1;

import java.util.Scanner;

public class ProyectoEDAI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControladorMenu controlador = new ControladorMenu();
        controlador.iniciar(scanner);
        scanner.close();
    }
}

class ControladorMenu {

    private boolean activo;
    private ArregloUnidimensional arregloSimple;
    private PilaTAD pila;
    private ColaTAD colaSimple;
    private ColaTAD colaCircular;
    private BicolaTAD bicola;
    private ModuloRecursion recursion;
    private ListaSimple listaSimple;

    public ControladorMenu() {
        this.activo = true;
        this.arregloSimple = new ArregloUnidimensional(5);
        this.pila = new PilaTAD(6);
        this.colaSimple = new ColaTAD(5, false);
        this.colaCircular = new ColaTAD(5, true);
        this.bicola = new BicolaTAD(5);
        this.recursion = new ModuloRecursion();
        this.listaSimple = new ListaSimple();
    }

    public boolean isActivo() {
        return this.activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    private void imprimirEncabezadoInicial() {
        System.out.println("================= PROYECTO EDAI 1B - GRUPO 1 =================");
        System.out.println("Integrantes:");
        System.out.println("  Zoe Cartuche       | Martin Correa | Dilan Leon");
        System.out.println("  Alexis Liquinchana | Inti Males    | Dominique Vallejo");
        System.out.println("==============================================================");
    }

    public void iniciar(Scanner scanner) {
        imprimirEncabezadoInicial();

        int opcion = 0;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Arreglos unidimensionales");
            System.out.println("2. Pilas");
            System.out.println("3. Colas simples y colas circulares");
            System.out.println("4. Bicolas o dobles colas");
            System.out.println("5. Recursion y simulacion mediante pilas");
            System.out.println("6. Listas simplemente enlazadas");
            System.out.println("7. Salir");

            opcion = leerEnteroRango(scanner, "Seleccione opcion (1-7): ", 1, 7);

            if (opcion == 1) {
                menuArreglo(scanner);
            } else {
                if (opcion == 2) {
                    menuPila(scanner);
                } else {
                    if (opcion == 3) {
                        menuCola(scanner);
                    } else {
                        if (opcion == 4) {
                            menuBicola(scanner);
                        } else {
                            if (opcion == 5) {
                                menuRecursion(scanner);
                            } else {
                                if (opcion == 6) {
                                    menuLista(scanner);
                                } else {
                                    if (opcion == 7) {
                                        setActivo(false);
                                        System.out.println("Salida controlada del programa.");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } while (isActivo());
    }

    private void menuArreglo(Scanner scanner) {
        int op = 0;
        do {
            System.out.println("\n--- Menu Arreglos Unidimensionales ---");
            System.out.println("1. Crear arreglo");
            System.out.println("2. Recorrer y mostrar elementos");
            System.out.println("3. Insertar en posicion");
            System.out.println("4. Eliminar en posicion");
            System.out.println("5. Buscar valor");
            System.out.println("6. Volver");
            op = leerEnteroRango(scanner, "Opcion (1-6): ", 1, 6);

            if (op == 1) {
                int cap = leerEnteroRango(scanner, "Capacidad (1-20): ", 1, 20);
                int cant = leerEnteroRango(scanner, "Cantidad inicial (0-" + cap + "): ", 0, cap);
                int[] arregloValores = new int[cant];
                for (int i = 0; i < cant; i++) {
                    arregloValores[i] = leerEntero(scanner, "Valor P[" + i + "]= ");
                }
                arregloSimple.inicializar(cap, arregloValores, cant);
            } else {
                if (op == 2) {
                    arregloSimple.recorrerYMostrar();
                } else {
                    if (op == 3) {
                        int val = leerEntero(scanner, "Valor a insertar: ");
                        int pos = leerEntero(scanner, "Posicion: ");
                        arregloSimple.insertar(val, pos);
                    } else {
                        if (op == 4) {
                            int pos = leerEntero(scanner, "Posicion a eliminar: ");
                            arregloSimple.eliminar(pos);
                        } else {
                            if (op == 5) {
                                int val = leerEntero(scanner, "Valor a buscar: ");
                                arregloSimple.buscar(val);
                            }
                        }
                    }
                }
            }
        } while (op != 6);
    }

    private void menuPila(Scanner scanner) {
        int op = 0;
        do {
            System.out.println("\n--- Menu TAD Pila ---");
            System.out.println("1. Inicializar pila");
            System.out.println("2. Apilar (push)");
            System.out.println("3. Desapilar (pop)");
            System.out.println("4. Consultar cima (peek)");
            System.out.println("5. Comprobar vacia / llena");
            System.out.println("6. Mostrar contenido (LIFO)");
            System.out.println("7. Convertir expresion infija a postfija");
            System.out.println("8. Evaluar expresion postfija");
            System.out.println("9. Volver");
            op = leerEnteroRango(scanner, "Opcion (1-9): ", 1, 9);

            if (op == 1) {
                int cap = leerEnteroRango(scanner, "Capacidad (1-20): ", 1, 20);
                pila.inicializar(cap);
            } else {
                if (op == 2) {
                    int val = leerEntero(scanner, "Valor a apilar: ");
                    pila.push(val);
                } else {
                    if (op == 3) {
                        pila.pop();
                    } else {
                        if (op == 4) {
                            pila.peek();
                        } else {
                            if (op == 5) {
                                pila.comprobarEstados();
                            } else {
                                if (op == 6) {
                                    pila.mostrarLIFO();
                                } else {
                                    if (op == 7) {
                                        System.out.print("Ingrese expresion infija (ej. (3+4)*2): ");
                                        String exprInfija = scanner.nextLine();
                                        pila.infijaAPostfija(exprInfija);
                                    } else {
                                        if (op == 8) {
                                            System.out.print("Ingrese expresion postfija (ej. 34+2*): ");
                                            String exprPostfija = scanner.nextLine();
                                            pila.evaluarPostfija(exprPostfija);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } while (op != 9);
    }

    private void menuCola(Scanner scanner) {
        int tipo = 0;
        do {
            System.out.println("\n--- Menu TAD Cola (Variante) ---");
            System.out.println("1. Cola simple");
            System.out.println("2. Cola circular");
            System.out.println("3. Volver");
            tipo = leerEnteroRango(scanner, "Opcion (1-3): ", 1, 3);

            if (tipo == 1 || tipo == 2) {
                boolean circular = (tipo == 2);
                ColaTAD actualCola;
                if (circular) {
                    actualCola = colaCircular;
                } else {
                    actualCola = colaSimple;
                }
                int op = 0;
                do {
                    String nombreTipo;
                    if (circular) {
                        nombreTipo = "Circular";
                    } else {
                        nombreTipo = "Simple";
                    }
                    System.out.println("\n--- Operaciones Cola (" + nombreTipo + ") ---");
                    System.out.println("1. Inicializar cola");
                    System.out.println("2. Insertar (enqueue)");
                    System.out.println("3. Retirar (dequeue)");
                    System.out.println("4. Consultar frente");
                    System.out.println("5. Comprobar vacia / llena");
                    System.out.println("6. Mostrar orden FIFO");
                    System.out.println("7. Volver");
                    op = leerEnteroRango(scanner, "Opcion (1-7): ", 1, 7);

                    if (op == 1) {
                        int cap = leerEnteroRango(scanner, "Capacidad (1-20): ", 1, 20);
                        actualCola.inicializar(cap, circular);
                    } else {
                        if (op == 2) {
                            int val = leerEntero(scanner, "Valor a insertar: ");
                            actualCola.enqueue(val);
                        } else {
                            if (op == 3) {
                                actualCola.dequeue();
                            } else {
                                if (op == 4) {
                                    actualCola.consultarFrente();
                                } else {
                                    if (op == 5) {
                                        actualCola.comprobarEstados();
                                    } else {
                                        if (op == 6) {
                                            actualCola.mostrarFIFO();
                                        }
                                    }
                                }
                            }
                        }
                    }
                } while (op != 7);
            }
        } while (tipo != 3);
    }

    private void menuBicola(Scanner scanner) {
        int op = 0;
        do {
            System.out.println("\n--- Menu TAD Bicola ---");
            System.out.println("1. Inicializar bicola");
            System.out.println("2. Insertar por el frente");
            System.out.println("3. Insertar por el final");
            System.out.println("4. Eliminar por el frente");
            System.out.println("5. Eliminar por el final");
            System.out.println("6. Consultar extremos y mostrar");
            System.out.println("7. Volver");
            op = leerEnteroRango(scanner, "Opcion (1-7): ", 1, 7);

            if (op == 1) {
                int cap = leerEnteroRango(scanner, "Capacidad (1-20): ", 1, 20);
                bicola.inicializar(cap);
            } else {
                if (op == 2) {
                    int val = leerEntero(scanner, "Valor frente: ");
                    bicola.insertarFrente(val);
                } else {
                    if (op == 3) {
                        int val = leerEntero(scanner, "Valor final: ");
                        bicola.insertarFinal(val);
                    } else {
                        if (op == 4) {
                            bicola.eliminarFrente();
                        } else {
                            if (op == 5) {
                                bicola.eliminarFinal();
                            } else {
                                if (op == 6) {
                                    bicola.consultarYMostrar();
                                }
                            }
                        }
                    }
                }
            }
        } while (op != 7);
    }

    private void menuRecursion(Scanner scanner) {
        int op = 0;
        do {
            System.out.println("\n--- Menu Recursion y Simulacion con Pila ---");
            System.out.println("1. Factorial recursivo");
            System.out.println("2. Potencia recursiva");
            System.out.println("3. Simular factorial usando Pila");
            System.out.println("4. Volver");
            op = leerEnteroRango(scanner, "Opcion (1-4): ", 1, 4);

            if (op == 1) {
                int n = leerEnteroRango(scanner, "Ingrese n (0-12): ", 0, 12);
                recursion.factorialRecursivo(n);
            } else {
                if (op == 2) {
                    int b = leerEnteroRango(scanner, "Base (-10 a 10): ", -10, 10);
                    int e = leerEnteroRango(scanner, "Exponente (0-8): ", 0, 8);
                    recursion.potenciaRecursiva(b, e);
                } else {
                    if (op == 3) {
                        int n = leerEnteroRango(scanner, "Ingrese n para simular con Pila (0-8): ", 0, 8);
                        recursion.simularFactorialConPila(n);
                    }
                }
            }
        } while (op != 4);
    }

    private void menuLista(Scanner scanner) {
        int op = 0;
        do {
            System.out.println("\n--- Menu Lista Simplemente Enlazada ---");
            System.out.println("1. Inicializar lista vacia");
            System.out.println("2. Insertar al inicio");
            System.out.println("3. Insertar al final");
            System.out.println("4. Insertar en posicion");
            System.out.println("5. Recorrer y mostrar");
            System.out.println("6. Buscar valor");
            System.out.println("7. Eliminar por valor");
            System.out.println("8. Eliminar por posicion");
            System.out.println("9. Informar vacia y cantidad");
            System.out.println("10. Volver");
            op = leerEnteroRango(scanner, "Opcion (1-10): ", 1, 10);

            if (op == 1) {
                listaSimple.inicializarVacia();
            } else {
                if (op == 2) {
                    int val = leerEntero(scanner, "Valor al inicio: ");
                    listaSimple.insertarInicio(val);
                } else {
                    if (op == 3) {
                        int val = leerEntero(scanner, "Valor al final: ");
                        listaSimple.insertarFinal(val);
                    } else {
                        if (op == 4) {
                            int val = leerEntero(scanner, "Valor: ");
                            int pos = leerEntero(scanner, "Posicion: ");
                            listaSimple.insertarEnPosicion(val, pos);
                        } else {
                            if (op == 5) {
                                listaSimple.recorrerYMostrar();
                            } else {
                                if (op == 6) {
                                    int val = leerEntero(scanner, "Valor a buscar: ");
                                    listaSimple.buscarValor(val);
                                } else {
                                    if (op == 7) {
                                        int val = leerEntero(scanner, "Valor a eliminar: ");
                                        listaSimple.eliminarPorValor(val);
                                    } else {
                                        if (op == 8) {
                                            int pos = leerEntero(scanner, "Posicion a eliminar: ");
                                            listaSimple.eliminarPorPosicion(pos);
                                        } else {
                                            if (op == 9) {
                                                listaSimple.informarEstadoYCantidad();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } while (op != 10);
    }

    public static int leerEnteroRango(Scanner scanner, String msg, int min, int max) {
        int val = 0;
        boolean ok = false;
        do {
            System.out.print(msg);
            if (scanner.hasNextInt()) {
                val = scanner.nextInt();
                scanner.nextLine();
                if (val >= min && val <= max) {
                    ok = true;
                } else {
                    System.out.println("Error: valor fuera de rango [" + min + ".." + max + "].");
                }
            } else {
                String invalido = scanner.next();
                System.out.println("Error: '" + invalido + "' no es un entero valido.");
            }
        } while (!ok);
        return val;
    }

    public static int leerEntero(Scanner scanner, String msg) {
        int val = 0;
        boolean ok = false;
        do {
            System.out.print(msg);
            if (scanner.hasNextInt()) {
                val = scanner.nextInt();
                scanner.nextLine();
                ok = true;
            } else {
                String invalido = scanner.next();
                System.out.println("Error: '" + invalido + "' no es un entero valido.");
            }
        } while (!ok);
        return val;
    }
}

// ============================================================================
// CASO 1: ARREGLOS UNIDIMENSIONALES
// ============================================================================
class ArregloUnidimensional {

    private int[] arregloElementos;
    private boolean[] arregloOcupado;
    private int capacidad;
    private int cantidad;

    public ArregloUnidimensional(int cap) {
        if (cap < 1) {
            cap = 1;
        }
        this.capacidad = cap;
        this.arregloElementos = new int[cap];
        this.arregloOcupado = new boolean[cap];
        this.cantidad = 0;
    }

    public int[] getArregloElementos() {
        return this.arregloElementos;
    }

    public void setArregloElementos(int[] arregloElementos) {
        this.arregloElementos = arregloElementos;
    }

    public boolean[] getArregloOcupado() {
        return this.arregloOcupado;
    }

    public void setArregloOcupado(boolean[] arregloOcupado) {
        this.arregloOcupado = arregloOcupado;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    private void imprimirEstadoArreglo(String etiqueta) {
        System.out.println("  " + etiqueta + " (cap=" + getCapacidad() + ", cant=" + getCantidad() + "):");
        for (int i = 0; i < getCapacidad(); i++) {
            if (getArregloOcupado()[i]) {
                System.out.println("    P[" + i + "]= " + getArregloElementos()[i] + " [OCUPADO]");
            } else {
                System.out.println("    P[" + i + "]= - [LIBRE]");
            }
        }
    }

    public void inicializar(int nuevaCap, int[] arregloValores, int cantIni) {
        System.out.println("\n1. Estado inicial:");
        imprimirEstadoArreglo("Antes");

        System.out.println("2. Ejecucion paso a paso:");
        setCapacidad(nuevaCap);
        setArregloElementos(new int[nuevaCap]);
        setArregloOcupado(new boolean[nuevaCap]);
        setCantidad(0);

        int i = 0;
        for (i = 0; i < cantIni && i < nuevaCap; i++) {
            getArregloElementos()[i] = arregloValores[i];
            getArregloOcupado()[i] = true;
            setCantidad(getCantidad() + 1);
            System.out.println("  Paso " + (i + 1) + ": P[" + i + "]= " + arregloValores[i]);
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  i= " + i + ", nuevaCap= " + nuevaCap + ", cantIni= " + cantIni + ", cantidad= " + getCantidad());

        System.out.println("4. Estado final:");
        imprimirEstadoArreglo("Despues");
    }

    public void recorrerYMostrar() {
        System.out.println("\n1. Estado inicial:");
        imprimirEstadoArreglo("Actual");

        System.out.println("2. Ejecucion paso a paso:");
        if (getCantidad() == 0) {
            System.out.println("  Arreglo vacio. Todas las posiciones estan disponibles.");
        }
        int i = 0;
        for (i = 0; i < getCapacidad(); i++) {
            if (getArregloOcupado()[i]) {
                System.out.println("  P[" + i + "]= " + getArregloElementos()[i] + " [OCUPADO]");
            } else {
                System.out.println("  P[" + i + "]= - [DISPONIBLE]");
            }
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  i= " + i + ", capacidad= " + getCapacidad() + ", cantidad= " + getCantidad());

        System.out.println("4. Estado final:");
        imprimirEstadoArreglo("Final");
    }

    public void insertar(int valor, int pos) {
        System.out.println("\n1. Estado inicial:");
        imprimirEstadoArreglo("Antes de insertar " + valor + " en P[" + pos + "]");

        System.out.println("2. Ejecucion paso a paso:");
        int i = 0;
        int desplazados = 0;
        if (getCantidad() >= getCapacidad()) {
            System.out.println("  Error: arreglo lleno.");
        } else {
            if (pos < 0 || pos > getCantidad()) {
                System.out.println("  Error: posicion invalida P[" + pos + "].");
            } else {
                for (i = getCantidad() - 1; i >= pos; i--) {
                    getArregloElementos()[i + 1] = getArregloElementos()[i];
                    getArregloOcupado()[i + 1] = true;
                    desplazados++;
                    System.out.println("  Desplaza de P[" + i + "] a P[" + (i + 1) + "]= " + getArregloElementos()[i + 1]);
                }
                getArregloElementos()[pos] = valor;
                getArregloOcupado()[pos] = true;
                setCantidad(getCantidad() + 1);
                System.out.println("  Inserta P[" + pos + "]= " + valor);
            }
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  valor= " + valor + ", pos= " + pos + ", i= " + i + ", desplazados= " + desplazados + ", cantidad= " + getCantidad());

        System.out.println("4. Estado final:");
        imprimirEstadoArreglo("Despues de insertar");
    }

    public void eliminar(int pos) {
        System.out.println("\n1. Estado inicial:");
        imprimirEstadoArreglo("Antes de eliminar P[" + pos + "]");

        System.out.println("2. Ejecucion paso a paso:");
        int eliminado = 0;
        int i = pos;
        int movidos = 0;
        if (getCantidad() == 0) {
            System.out.println("  Error: arreglo vacio.");
        } else {
            if (pos < 0 || pos >= getCantidad()) {
                System.out.println("  Error: posicion invalida P[" + pos + "].");
            } else {
                eliminado = getArregloElementos()[pos];
                System.out.println("  Elimina P[" + pos + "]= " + eliminado);
                for (i = pos; i < getCantidad() - 1; i++) {
                    getArregloElementos()[i] = getArregloElementos()[i + 1];
                    getArregloOcupado()[i] = true;
                    movidos++;
                    System.out.println("  Reorganiza: P[" + i + "]= " + getArregloElementos()[i] + " (desde P[" + (i + 1) + "])");
                }
                int ultimo = getCantidad() - 1;
                getArregloElementos()[ultimo] = 0;
                getArregloOcupado()[ultimo] = false;
                setCantidad(getCantidad() - 1);
            }
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  pos= " + pos + ", eliminado= " + eliminado + ", i= " + i + ", movidos= " + movidos + ", cantidad= " + getCantidad());

        System.out.println("4. Estado final:");
        imprimirEstadoArreglo("Despues de eliminar");
    }

    public void buscar(int objetivo) {
        System.out.println("\n1. Estado inicial:");
        imprimirEstadoArreglo("Buscando " + objetivo);

        System.out.println("2. Ejecucion paso a paso:");
        int i = 0;
        int hallados = 0;
        String posiciones = "";
        if (getCantidad() == 0) {
            System.out.println("  Arreglo vacio. Valor no encontrado.");
        } else {
            for (i = 0; i < getCantidad(); i++) {
                if (getArregloElementos()[i] == objetivo) {
                    hallados++;
                    if (posiciones.length() > 0) {
                        posiciones = posiciones + ", ";
                    }
                    posiciones = posiciones + "P[" + i + "]";
                    System.out.println("  Coincidencia en P[" + i + "]= " + getArregloElementos()[i]);
                } else {
                    System.out.println("  P[" + i + "]= " + getArregloElementos()[i] + " (no coincide)");
                }
            }
            if (hallados > 0) {
                System.out.println("  Valor " + objetivo + " encontrado en: " + posiciones);
            } else {
                System.out.println("  Valor " + objetivo + " no encontrado.");
            }
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  objetivo= " + objetivo + ", i= " + i + ", hallados= " + hallados + ", posiciones= " + posiciones);

        System.out.println("4. Estado final:");
        imprimirEstadoArreglo("Final");
    }
}

// ============================================================================
// CASO 2: TAD PILA (LIFO) + EXPRESIONES POSTFIJAS
// ============================================================================
class PilaTAD {

    private int[] arregloDatos;
    private int cima;
    private int capacidad;

    public PilaTAD(int cap) {
        if (cap < 1) {
            cap = 1;
        }
        this.capacidad = cap;
        this.arregloDatos = new int[cap];
        this.cima = -1;
    }

    public int[] getArregloDatos() {
        return this.arregloDatos;
    }

    public void setArregloDatos(int[] arregloDatos) {
        this.arregloDatos = arregloDatos;
    }

    public int getCima() {
        return this.cima;
    }

    public void setCima(int cima) {
        this.cima = cima;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean estaVacia() {
        return getCima() == -1;
    }

    public boolean estaLlena() {
        return getCima() == getCapacidad() - 1;
    }

    private void imprimirPila(String etiqueta) {
        System.out.println("  " + etiqueta + " (cima= P[" + getCima() + "], cap= " + getCapacidad() + "):");
        if (estaVacia()) {
            System.out.println("    (vacia)");
        } else {
            for (int i = getCima(); i >= 0; i--) {
                System.out.println("    P[" + i + "]= " + getArregloDatos()[i]);
            }
        }
    }

    public void inicializar(int cap) {
        System.out.println("\n1. Estado inicial:");
        imprimirPila("Antes");

        System.out.println("2. Ejecucion paso a paso:");
        setCapacidad(cap);
        setArregloDatos(new int[cap]);
        setCima(-1);
        System.out.println("  Pila reiniciada con capacidad " + cap + " y cima= P[-1].");

        System.out.println("3. Variables auxiliares:");
        System.out.println("  cap= " + cap + ", cima= " + getCima());

        System.out.println("4. Estado final:");
        imprimirPila("Despues");
    }

    public void push(int valor) {
        System.out.println("\n1. Estado inicial:");
        imprimirPila("Antes de push(" + valor + ")");

        System.out.println("2. Ejecucion paso a paso:");
        if (estaLlena()) {
            System.out.println("  Error: desbordamiento, pila llena.");
        } else {
            int nuevaCima = getCima() + 1;
            setCima(nuevaCima);
            getArregloDatos()[nuevaCima] = valor;
            System.out.println("  Apila P[" + nuevaCima + "]= " + valor);
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  valor= " + valor + ", cima= " + getCima());

        System.out.println("4. Estado final:");
        imprimirPila("Despues de push");
    }

    public void pop() {
        System.out.println("\n1. Estado inicial:");
        imprimirPila("Antes de pop");

        System.out.println("2. Ejecucion paso a paso:");
        int sacado = 0;
        if (estaVacia()) {
            System.out.println("  Error: subdesbordamiento, pila vacia.");
        } else {
            sacado = getArregloDatos()[getCima()];
            getArregloDatos()[getCima()] = 0;
            setCima(getCima() - 1);
            System.out.println("  Desapila " + sacado + "; nueva cima= P[" + getCima() + "]");
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  sacado= " + sacado + ", cima= " + getCima());

        System.out.println("4. Estado final:");
        imprimirPila("Despues de pop");
    }

    public void peek() {
        System.out.println("\n1. Estado inicial:");
        imprimirPila("Consulta peek");

        System.out.println("2. Ejecucion paso a paso:");
        int tope = 0;
        if (estaVacia()) {
            System.out.println("  Pila vacia: no hay cima.");
        } else {
            tope = getArregloDatos()[getCima()];
            System.out.println("  Cima actual P[" + getCima() + "]= " + tope);
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  cima= " + getCima() + ", tope= " + tope);

        System.out.println("4. Estado final:");
        imprimirPila("Final");
    }

    public void comprobarEstados() {
        System.out.println("\n1. Estado inicial:");
        imprimirPila("Estado actual");

        System.out.println("2. Ejecucion paso a paso:");
        boolean v = estaVacia();
        boolean l = estaLlena();
        System.out.println("  estaVacia= " + v + ", estaLlena= " + l);

        System.out.println("3. Variables auxiliares:");
        System.out.println("  cima= " + getCima() + ", capacidad= " + getCapacidad() + ", vacia= " + v + ", llena= " + l);

        System.out.println("4. Estado final:");
        imprimirPila("Final");
    }

    public void mostrarLIFO() {
        System.out.println("\n1. Estado inicial:");
        imprimirPila("Inicio LIFO");

        System.out.println("2. Ejecucion paso a paso:");
        int i = getCima();
        int orden = 1;
        if (estaVacia()) {
            System.out.println("  Pila vacia.");
        } else {
            for (i = getCima(); i >= 0; i--) {
                System.out.println("  Orden LIFO #" + orden + " -> P[" + i + "]= " + getArregloDatos()[i]);
                orden++;
            }
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  i= " + i + ", orden= " + orden + ", cima= " + getCima());

        System.out.println("4. Estado final:");
        imprimirPila("Final LIFO");
    }

    private int precedencia(char op) {
        if (op == '^') {
            return 3;
        } else {
            if (op == '*' || op == '/') {
                return 2;
            } else {
                if (op == '+' || op == '-') {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    private boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private boolean esOperando(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public void infijaAPostfija(String infija) {
        System.out.println("\n1. Estado inicial:");
        System.out.println("  Expresion infija: \"" + infija + "\"");
        System.out.println("  Pila de operadores vacia (tope= P[-1])");

        System.out.println("2. Ejecucion paso a paso:");
        int n = infija.length();
        if (n == 0) {
            System.out.println("  Error: expresion vacia.");
            System.out.println("3. Variables auxiliares:");
            System.out.println("  n= 0, tope= P[-1], postfija= \"\"");
            System.out.println("4. Estado final:");
            System.out.println("  Expresion postfija: \"\"");
            return;
        }

        char[] arregloPilaOp = new char[n];
        int tope = -1;
        String postfija = "";
        boolean error = false;
        int i = 0;

        for (i = 0; i < n && !error; i++) {
            char c = infija.charAt(i);
            if (c != ' ') {
                if (esOperando(c)) {
                    postfija = postfija + c;
                    System.out.println("  Lee '" + c + "' (operando) -> agrega a salida: \"" + postfija + "\"");
                } else {
                    if (c == '(') {
                        tope++;
                        arregloPilaOp[tope] = c;
                        System.out.println("  Lee '(' -> apila en P[" + tope + "]= '('");
                    } else {
                        if (c == ')') {
                            while (tope >= 0 && arregloPilaOp[tope] != '(') {
                                char sacado = arregloPilaOp[tope];
                                tope--;
                                postfija = postfija + sacado;
                                System.out.println("  Desapila '" + sacado + "' hasta '(' -> salida: \"" + postfija + "\"");
                            }
                            if (tope < 0) {
                                System.out.println("  Error: parentesis de cierre sin apertura.");
                                error = true;
                            } else {
                                tope--;
                                System.out.println("  Descarta '(' de la pila (tope= P[" + tope + "])");
                            }
                        } else {
                            if (esOperador(c)) {
                                while (tope >= 0 && esOperador(arregloPilaOp[tope]) && precedencia(arregloPilaOp[tope]) >= precedencia(c)) {
                                    char sacado = arregloPilaOp[tope];
                                    tope--;
                                    postfija = postfija + sacado;
                                    System.out.println("  Mayor/igual precedencia: desapila '" + sacado + "' -> salida: \"" + postfija + "\"");
                                }
                                tope++;
                                arregloPilaOp[tope] = c;
                                System.out.println("  Apila operador P[" + tope + "]= '" + c + "'");
                            } else {
                                System.out.println("  Error: caracter invalido '" + c + "'.");
                                error = true;
                            }
                        }
                    }
                }
            }
        }

        while (tope >= 0 && !error) {
            char sacado = arregloPilaOp[tope];
            tope--;
            if (sacado == '(') {
                System.out.println("  Error: parentesis '(' sin cerrar.");
                error = true;
            } else {
                postfija = postfija + sacado;
                System.out.println("  Vacia pila: desapila '" + sacado + "' -> salida: \"" + postfija + "\"");
            }
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  i= " + i + ", tope= P[" + tope + "], error= " + error + ", postfija= \"" + postfija + "\"");

        System.out.println("4. Estado final:");
        if (error) {
            System.out.println("  Conversion abortada por error de sintaxis.");
        } else {
            System.out.println("  Expresion postfija resultante: " + postfija);
        }
    }

    public void evaluarPostfija(String postfija) {
        System.out.println("\n1. Estado inicial:");
        System.out.println("  Expresion postfija: \"" + postfija + "\"");
        System.out.println("  Pila de operandos vacia (tope= P[-1])");

        System.out.println("2. Ejecucion paso a paso:");
        int n = postfija.length();
        if (n == 0) {
            System.out.println("  Error: expresion vacia.");
            System.out.println("3. Variables auxiliares:");
            System.out.println("  n= 0, tope= P[-1], resultado= 0");
            System.out.println("4. Estado final:");
            System.out.println("  Evaluacion sin resultado.");
            return;
        }

        long[] arregloPilaVal = new long[n];
        int tope = -1;
        boolean error = false;
        int i = 0;

        for (i = 0; i < n && !error; i++) {
            char c = postfija.charAt(i);
            if (c != ' ') {
                if (c >= '0' && c <= '9') {
                    long num = c - '0';
                    tope++;
                    arregloPilaVal[tope] = num;
                    System.out.println("  Lee digito '" + c + "' -> apila P[" + tope + "]= " + num);
                } else {
                    if (esOperador(c)) {
                        if (tope < 1) {
                            System.out.println("  Error: faltan operandos para el operador '" + c + "'.");
                            error = true;
                        } else {
                            long b = arregloPilaVal[tope];
                            tope--;
                            long a = arregloPilaVal[tope];
                            tope--;
                            long resOp = 0L;

                            if (c == '+') {
                                resOp = a + b;
                            } else {
                                if (c == '-') {
                                    resOp = a - b;
                                } else {
                                    if (c == '*') {
                                        resOp = a * b;
                                    } else {
                                        if (c == '/') {
                                            if (b == 0) {
                                                System.out.println("  Error: division por cero.");
                                                error = true;
                                            } else {
                                                resOp = a / b;
                                            }
                                        } else {
                                            if (c == '^') {
                                                resOp = 1L;
                                                for (int p = 0; p < b; p++) {
                                                    resOp = resOp * a;
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            if (!error) {
                                tope++;
                                arregloPilaVal[tope] = resOp;
                                System.out.println("  Aplica '" + c + "': " + a + " " + c + " " + b + " = " + resOp + " -> apila P[" + tope + "]= " + resOp);
                            }
                        }
                    } else {
                        System.out.println("  Error: simbolo no valido '" + c + "' (use digitos 0-9 y operadores + - * / ^).");
                        error = true;
                    }
                }
            }
        }

        long resultadoFinal = 0L;
        if (!error) {
            if (tope != 0) {
                System.out.println("  Error: expresion mal formada (sobran operandos en la pila).");
                error = true;
            } else {
                resultadoFinal = arregloPilaVal[tope];
            }
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  i= " + i + ", tope= P[" + tope + "], error= " + error + ", resultadoFinal= " + resultadoFinal);

        System.out.println("4. Estado final:");
        if (error) {
            System.out.println("  Evaluacion abortada por error en la expresion.");
        } else {
            System.out.println("  Resultado de la evaluacion postfija = " + resultadoFinal);
        }
    }
}

// ============================================================================
// CASO 3: TAD COLA SIMPLE Y COLA CIRCULAR (FIFO)
// ============================================================================
class ColaTAD {

    private int[] arregloDatos;
    private int frente;
    private int finalIdx;
    private int tamano;
    private int capacidad;
    private boolean circular;

    public ColaTAD(int cap, boolean esCircular) {
        if (cap < 1) {
            cap = 1;
        }
        this.capacidad = cap;
        this.arregloDatos = new int[cap];
        this.frente = 0;
        this.finalIdx = -1;
        this.tamano = 0;
        this.circular = esCircular;
    }

    public int[] getArregloDatos() {
        return this.arregloDatos;
    }

    public void setArregloDatos(int[] arregloDatos) {
        this.arregloDatos = arregloDatos;
    }

    public int getFrente() {
        return this.frente;
    }

    public void setFrente(int frente) {
        this.frente = frente;
    }

    public int getFinalIdx() {
        return this.finalIdx;
    }

    public void setFinalIdx(int finalIdx) {
        this.finalIdx = finalIdx;
    }

    public int getTamano() {
        return this.tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isCircular() {
        return this.circular;
    }

    public void setCircular(boolean circular) {
        this.circular = circular;
    }

    public boolean estaVacia() {
        return getTamano() == 0;
    }

    public boolean estaLlena() {
        if (isCircular()) {
            return getTamano() == getCapacidad();
        } else {
            return getFinalIdx() == getCapacidad() - 1;
        }
    }

    private void imprimirCola(String etiqueta) {
        System.out.println("  " + etiqueta + " (frente= P[" + getFrente() + "], final= P[" + getFinalIdx() + "], tam= " + getTamano() + "/" + getCapacidad() + "):");
        if (estaVacia()) {
            System.out.println("    (vacia)");
        } else {
            int idx = getFrente();
            for (int k = 0; k < getTamano(); k++) {
                System.out.println("    P[" + idx + "]= " + getArregloDatos()[idx]);
                if (isCircular()) {
                    idx = (idx + 1) % getCapacidad();
                } else {
                    idx++;
                }
            }
        }
    }

    public void inicializar(int cap, boolean esCircular) {
        System.out.println("\n1. Estado inicial:");
        imprimirCola("Antes");

        System.out.println("2. Ejecucion paso a paso:");
        setCapacidad(cap);
        setCircular(esCircular);
        setArregloDatos(new int[cap]);
        setFrente(0);
        setFinalIdx(-1);
        setTamano(0);
        System.out.println("  Cola inicializada (circular= " + esCircular + ", cap= " + cap + ").");

        System.out.println("3. Variables auxiliares:");
        System.out.println("  frente= P[" + getFrente() + "], finalIdx= P[" + getFinalIdx() + "], tamano= " + getTamano());

        System.out.println("4. Estado final:");
        imprimirCola("Despues");
    }

    public void enqueue(int valor) {
        System.out.println("\n1. Estado inicial:");
        imprimirCola("Antes de enqueue(" + valor + ")");

        System.out.println("2. Ejecucion paso a paso:");
        if (estaLlena()) {
            System.out.println("  Error: desbordamiento, cola llena.");
        } else {
            if (isCircular()) {
                int sig = (getFinalIdx() + 1) % getCapacidad();
                setFinalIdx(sig);
                getArregloDatos()[sig] = valor;
                setTamano(getTamano() + 1);
                System.out.println("  Circular: finalIdx= P[" + sig + "], inserta " + valor);
            } else {
                int sig = getFinalIdx() + 1;
                setFinalIdx(sig);
                getArregloDatos()[sig] = valor;
                setTamano(getTamano() + 1);
                System.out.println("  Simple: finalIdx= P[" + sig + "], inserta " + valor);
            }
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  valor= " + valor + ", frente= P[" + getFrente() + "], finalIdx= P[" + getFinalIdx() + "], tamano= " + getTamano());

        System.out.println("4. Estado final:");
        imprimirCola("Despues de enqueue");
    }

    public void dequeue() {
        System.out.println("\n1. Estado inicial:");
        imprimirCola("Antes de dequeue");

        System.out.println("2. Ejecucion paso a paso:");
        int ret = 0;
        if (estaVacia()) {
            System.out.println("  Error: subdesbordamiento, cola vacia.");
        } else {
            ret = getArregloDatos()[getFrente()];
            getArregloDatos()[getFrente()] = 0;
            setTamano(getTamano() - 1);
            System.out.println("  Retira " + ret + " de P[" + getFrente() + "]");
            if (isCircular()) {
                if (getTamano() == 0) {
                    setFrente(0);
                    setFinalIdx(-1);
                } else {
                    setFrente((getFrente() + 1) % getCapacidad());
                }
            } else {
                setFrente(getFrente() + 1);
            }
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  ret= " + ret + ", frente= P[" + getFrente() + "], finalIdx= P[" + getFinalIdx() + "], tamano= " + getTamano());

        System.out.println("4. Estado final:");
        imprimirCola("Despues de dequeue");
    }

    public void consultarFrente() {
        System.out.println("\n1. Estado inicial:");
        imprimirCola("Consulta frente");

        System.out.println("2. Ejecucion paso a paso:");
        int val = 0;
        if (estaVacia()) {
            System.out.println("  Cola vacia.");
        } else {
            val = getArregloDatos()[getFrente()];
            System.out.println("  Frente en P[" + getFrente() + "]= " + val);
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  frente= P[" + getFrente() + "], val= " + val + ", tamano= " + getTamano());

        System.out.println("4. Estado final:");
        imprimirCola("Final");
    }

    public void comprobarEstados() {
        System.out.println("\n1. Estado inicial:");
        imprimirCola("Comprobacion");

        System.out.println("2. Ejecucion paso a paso:");
        boolean v = estaVacia();
        boolean l = estaLlena();
        System.out.println("  estaVacia= " + v + ", estaLlena= " + l);

        System.out.println("3. Variables auxiliares:");
        System.out.println("  frente= P[" + getFrente() + "], finalIdx= P[" + getFinalIdx() + "], tamano= " + getTamano());

        System.out.println("4. Estado final:");
        imprimirCola("Final");
    }

    public void mostrarFIFO() {
        System.out.println("\n1. Estado inicial:");
        imprimirCola("Inicio FIFO");

        System.out.println("2. Ejecucion paso a paso:");
        int idx = getFrente();
        int k = 0;
        if (estaVacia()) {
            System.out.println("  Cola vacia.");
        } else {
            for (k = 0; k < getTamano(); k++) {
                System.out.println("  FIFO #" + (k + 1) + " -> P[" + idx + "]= " + getArregloDatos()[idx]);
                if (isCircular()) {
                    idx = (idx + 1) % getCapacidad();
                } else {
                    idx++;
                }
            }
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  k= " + k + ", idx= P[" + idx + "], frente= P[" + getFrente() + "], finalIdx= P[" + getFinalIdx() + "]");

        System.out.println("4. Estado final:");
        imprimirCola("Final FIFO");
    }
}

// ============================================================================
// CASO 4: TAD BICOLA (DEQUE)
// ============================================================================
class BicolaTAD {

    private int[] arregloDatos;
    private int frente;
    private int finalIdx;
    private int tamano;
    private int capacidad;

    public BicolaTAD(int cap) {
        if (cap < 1) {
            cap = 1;
        }
        this.capacidad = cap;
        this.arregloDatos = new int[cap];
        this.frente = 0;
        this.finalIdx = -1;
        this.tamano = 0;
    }

    public int[] getArregloDatos() {
        return this.arregloDatos;
    }

    public void setArregloDatos(int[] arregloDatos) {
        this.arregloDatos = arregloDatos;
    }

    public int getFrente() {
        return this.frente;
    }

    public void setFrente(int frente) {
        this.frente = frente;
    }

    public int getFinalIdx() {
        return this.finalIdx;
    }

    public void setFinalIdx(int finalIdx) {
        this.finalIdx = finalIdx;
    }

    public int getTamano() {
        return this.tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean estaVacia() {
        return getTamano() == 0;
    }

    public boolean estaLlena() {
        return getTamano() == getCapacidad();
    }

    private String estadoActual() {
        if (estaVacia()) {
            return "VACIA";
        } else {
            if (estaLlena()) {
                return "LLENA";
            } else {
                return "CON_ELEMENTOS";
            }
        }
    }

    private void imprimirBicola(String etiqueta) {
        System.out.println("  " + etiqueta + " [" + estadoActual() + "] (frente= P[" + getFrente() + "], final= P[" + getFinalIdx() + "], tam= " + getTamano() + "/" + getCapacidad() + "):");
        if (estaVacia()) {
            System.out.println("    (vacia)");
        } else {
            int idx = getFrente();
            for (int k = 0; k < getTamano(); k++) {
                System.out.println("    P[" + idx + "]= " + getArregloDatos()[idx]);
                idx = (idx + 1) % getCapacidad();
            }
        }
    }

    public void inicializar(int cap) {
        System.out.println("\n1. Estado inicial:");
        imprimirBicola("Antes");

        System.out.println("2. Ejecucion paso a paso:");
        setCapacidad(cap);
        setArregloDatos(new int[cap]);
        setFrente(0);
        setFinalIdx(-1);
        setTamano(0);
        System.out.println("  Bicola inicializada con capacidad " + cap + ".");

        System.out.println("3. Variables auxiliares:");
        System.out.println("  frente= P[" + getFrente() + "], finalIdx= P[" + getFinalIdx() + "], tamano= " + getTamano());

        System.out.println("4. Estado final:");
        imprimirBicola("Despues");
    }

    public void insertarFrente(int valor) {
        System.out.println("\n1. Estado inicial:");
        imprimirBicola("Antes insertar frente " + valor);

        System.out.println("2. Ejecucion paso a paso:");
        if (estaLlena()) {
            System.out.println("  Error: bicola llena.");
        } else {
            if (estaVacia()) {
                setFrente(0);
                setFinalIdx(0);
                getArregloDatos()[0] = valor;
                setTamano(1);
                System.out.println("  Insertado P[0]= " + valor + " por el frente.");
            } else {
                int nuevoF = (getFrente() - 1 + getCapacidad()) % getCapacidad();
                setFrente(nuevoF);
                getArregloDatos()[nuevoF] = valor;
                setTamano(getTamano() + 1);
                System.out.println("  Insertado P[" + nuevoF + "]= " + valor + " por el frente.");
            }
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  valor= " + valor + ", frente= P[" + getFrente() + "], finalIdx= P[" + getFinalIdx() + "], tamano= " + getTamano());

        System.out.println("4. Estado final:");
        imprimirBicola("Despues insertar frente");
    }

    public void insertarFinal(int valor) {
        System.out.println("\n1. Estado inicial:");
        imprimirBicola("Antes insertar final " + valor);

        System.out.println("2. Ejecucion paso a paso:");
        if (estaLlena()) {
            System.out.println("  Error: bicola llena.");
        } else {
            if (estaVacia()) {
                setFrente(0);
                setFinalIdx(0);
                getArregloDatos()[0] = valor;
                setTamano(1);
                System.out.println("  Insertado P[0]= " + valor + " por el final.");
            } else {
                int nuevoFin = (getFinalIdx() + 1) % getCapacidad();
                setFinalIdx(nuevoFin);
                getArregloDatos()[nuevoFin] = valor;
                setTamano(getTamano() + 1);
                System.out.println("  Insertado P[" + nuevoFin + "]= " + valor + " por el final.");
            }
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  valor= " + valor + ", frente= P[" + getFrente() + "], finalIdx= P[" + getFinalIdx() + "], tamano= " + getTamano());

        System.out.println("4. Estado final:");
        imprimirBicola("Despues insertar final");
    }

    public void eliminarFrente() {
        System.out.println("\n1. Estado inicial:");
        imprimirBicola("Antes eliminar frente");

        System.out.println("2. Ejecucion paso a paso:");
        int elim = 0;
        if (estaVacia()) {
            System.out.println("  Error: bicola vacia.");
        } else {
            elim = getArregloDatos()[getFrente()];
            getArregloDatos()[getFrente()] = 0;
            if (getTamano() == 1) {
                setFrente(0);
                setFinalIdx(-1);
                setTamano(0);
            } else {
                setFrente((getFrente() + 1) % getCapacidad());
                setTamano(getTamano() - 1);
            }
            System.out.println("  Eliminado " + elim + " del frente.");
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  elim= " + elim + ", frente= P[" + getFrente() + "], finalIdx= P[" + getFinalIdx() + "], tamano= " + getTamano());

        System.out.println("4. Estado final:");
        imprimirBicola("Despues eliminar frente");
    }

    public void eliminarFinal() {
        System.out.println("\n1. Estado inicial:");
        imprimirBicola("Antes eliminar final");

        System.out.println("2. Ejecucion paso a paso:");
        int elim = 0;
        if (estaVacia()) {
            System.out.println("  Error: bicola vacia.");
        } else {
            elim = getArregloDatos()[getFinalIdx()];
            getArregloDatos()[getFinalIdx()] = 0;
            if (getTamano() == 1) {
                setFrente(0);
                setFinalIdx(-1);
                setTamano(0);
            } else {
                setFinalIdx((getFinalIdx() - 1 + getCapacidad()) % getCapacidad());
                setTamano(getTamano() - 1);
            }
            System.out.println("  Eliminado " + elim + " del final.");
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  elim= " + elim + ", frente= P[" + getFrente() + "], finalIdx= P[" + getFinalIdx() + "], tamano= " + getTamano());

        System.out.println("4. Estado final:");
        imprimirBicola("Despues eliminar final");
    }

    public void consultarYMostrar() {
        System.out.println("\n1. Estado inicial:");
        imprimirBicola("Consulta bicola");

        System.out.println("2. Ejecucion paso a paso:");
        int vf = 0;
        int vr = 0;
        if (estaVacia()) {
            System.out.println("  Bicola vacia.");
        } else {
            vf = getArregloDatos()[getFrente()];
            vr = getArregloDatos()[getFinalIdx()];
            System.out.println("  Frente P[" + getFrente() + "]= " + vf + ", Final P[" + getFinalIdx() + "]= " + vr);
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  vf= " + vf + ", vr= " + vr + ", tamano= " + getTamano() + ", estado= " + estadoActual());

        System.out.println("4. Estado final:");
        imprimirBicola("Final");
    }
}

// ============================================================================
// CASO 5: RECURSION Y SIMULACION CON PILA
// ============================================================================
class ModuloRecursion {

    private long factRec(int n) {
        if (n <= 1) {
            return 1L;
        } else {
            return n * factRec(n - 1);
        }
    }

    private long potRec(int b, int e) {
        if (e == 0) {
            return 1L;
        } else {
            return b * potRec(b, e - 1);
        }
    }

    public void factorialRecursivo(int n) {
        System.out.println("\n1. Estado inicial:");
        System.out.println("  factorial(" + n + ") | Caso base: n<=1 -> 1 | Caso recursivo: n * factorial(n-1)");

        System.out.println("2. Ejecucion paso a paso:");
        for (int k = n; k >= 1; k--) {
            if (k <= 1) {
                System.out.println("  Caso base: factorial(1) = 1");
            } else {
                System.out.println("  Caso recursivo: factorial(" + k + ") = " + k + " * factorial(" + (k - 1) + ")");
            }
        }
        long res = factRec(n);

        System.out.println("3. Variables auxiliares:");
        System.out.println("  n= " + n + ", res= " + res);

        System.out.println("4. Estado final:");
        System.out.println("  Resultado: " + n + "! = " + res);
    }

    public void potenciaRecursiva(int b, int e) {
        System.out.println("\n1. Estado inicial:");
        System.out.println("  potencia(" + b + ", " + e + ") | Caso base: e==0 -> 1 | Caso recursivo: b * potencia(b, e-1)");

        System.out.println("2. Ejecucion paso a paso:");
        for (int i = e; i >= 0; i--) {
            if (i == 0) {
                System.out.println("  Caso base: potencia(" + b + ", 0) = 1");
            } else {
                System.out.println("  Caso recursivo: potencia(" + b + ", " + i + ") = " + b + " * potencia(" + b + ", " + (i - 1) + ")");
            }
        }
        long res = potRec(b, e);

        System.out.println("3. Variables auxiliares:");
        System.out.println("  b= " + b + ", e= " + e + ", res= " + res);

        System.out.println("4. Estado final:");
        System.out.println("  Resultado: " + b + "^" + e + " = " + res);
    }

    public void simularFactorialConPila(int n) {
        System.out.println("\n1. Estado inicial:");
        System.out.println("  Simulacion factorial(" + n + ") con pila explicita vacia (tope= P[-1]).");

        System.out.println("2. Ejecucion paso a paso:");
        int[] arregloPila = new int[n + 2];
        int tope = -1;

        for (int actual = n; actual >= 1; actual--) {
            tope++;
            arregloPila[tope] = actual;
            System.out.println("  Apila P[" + tope + "]= " + actual);
        }
        System.out.println("  Caso base retorna 1.");

        long acum = 1L;
        while (tope >= 0) {
            int val = arregloPila[tope];
            System.out.println("  Desapila P[" + tope + "]= " + val);
            tope--;
            acum = acum * val;
            System.out.println("    acum= " + acum + " (tope= P[" + tope + "])");
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  n= " + n + ", tope= P[" + tope + "], acum= " + acum);

        System.out.println("4. Estado final:");
        System.out.println("  Resultado simulado: " + acum);
    }
}

// ============================================================================
// CASO 6: LISTA SIMPLEMENTE ENLAZADA
// ============================================================================
class NodoLista {

    private int dato;
    private NodoLista siguiente;

    public NodoLista(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public int getDato() {
        return this.dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoLista getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }
}

class ListaSimple {

    private NodoLista cabeza;
    private int tamano;

    public ListaSimple() {
        this.cabeza = null;
        this.tamano = 0;
    }

    public NodoLista getCabeza() {
        return this.cabeza;
    }

    public void setCabeza(NodoLista cabeza) {
        this.cabeza = cabeza;
    }

    public int getTamano() {
        return this.tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public boolean estaVacia() {
        return getCabeza() == null;
    }

    private void imprimirLista(String etiqueta) {
        System.out.println("  " + etiqueta + " (tam= " + getTamano() + ", vacia= " + estaVacia() + "):");
        NodoLista aux = getCabeza();
        int pos = 0;
        if (aux == null) {
            System.out.println("    (vacia -> null)");
        } else {
            while (aux != null) {
                System.out.println("    P[" + pos + "]= " + aux.getDato());
                aux = aux.getSiguiente();
                pos++;
            }
            System.out.println("    Fin -> null");
        }
    }

    public void inicializarVacia() {
        System.out.println("\n1. Estado inicial:");
        imprimirLista("Antes");

        System.out.println("2. Ejecucion paso a paso:");
        setCabeza(null);
        setTamano(0);
        System.out.println("  cabeza= null, tamano= 0.");

        System.out.println("3. Variables auxiliares:");
        System.out.println("  tamano= " + getTamano() + ", vacia= " + estaVacia());

        System.out.println("4. Estado final:");
        imprimirLista("Despues");
    }

    public void insertarInicio(int valor) {
        System.out.println("\n1. Estado inicial:");
        imprimirLista("Antes insertar inicio " + valor);

        System.out.println("2. Ejecucion paso a paso:");
        NodoLista nuevo = new NodoLista(valor);
        nuevo.setSiguiente(getCabeza());
        setCabeza(nuevo);
        setTamano(getTamano() + 1);
        System.out.println("  Nuevo nodo P[0]= " + valor + " enlazado a cabeza.");

        System.out.println("3. Variables auxiliares:");
        System.out.println("  valor= " + valor + ", tamano= " + getTamano());

        System.out.println("4. Estado final:");
        imprimirLista("Despues insertar inicio");
    }

    public void insertarFinal(int valor) {
        System.out.println("\n1. Estado inicial:");
        imprimirLista("Antes insertar final " + valor);

        System.out.println("2. Ejecucion paso a paso:");
        NodoLista nuevo = new NodoLista(valor);
        NodoLista actual = getCabeza();
        int pasos = 0;

        if (estaVacia()) {
            setCabeza(nuevo);
            System.out.println("  Lista vacia: cabeza apuntara a P[0]= " + valor + ".");
        } else {
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
                pasos++;
            }
            actual.setSiguiente(nuevo);
            System.out.println("  Avanza " + pasos + " pasos y enlaza P[" + (pasos + 1) + "]= " + valor + " al final.");
        }
        setTamano(getTamano() + 1);

        System.out.println("3. Variables auxiliares:");
        System.out.println("  pasos= " + pasos + ", tamano= " + getTamano());

        System.out.println("4. Estado final:");
        imprimirLista("Despues insertar final");
    }

    public void insertarEnPosicion(int valor, int pos) {
        System.out.println("\n1. Estado inicial:");
        imprimirLista("Antes insertar " + valor + " en P[" + pos + "]");

        System.out.println("2. Ejecucion paso a paso:");
        int idx = 0;
        NodoLista actual = getCabeza();
        NodoLista anterior = null;

        if (pos < 0 || pos > getTamano()) {
            System.out.println("  Error: posicion invalida P[" + pos + "].");
        } else {
            if (pos == 0) {
                NodoLista nuevo = new NodoLista(valor);
                nuevo.setSiguiente(getCabeza());
                setCabeza(nuevo);
                setTamano(getTamano() + 1);
                System.out.println("  Inserta P[0]= " + valor + ".");
            } else {
                for (idx = 0; idx < pos && actual != null; idx++) {
                    anterior = actual;
                    actual = actual.getSiguiente();
                }
                NodoLista nuevo = new NodoLista(valor);
                nuevo.setSiguiente(actual);
                if (anterior != null) {
                    anterior.setSiguiente(nuevo);
                }
                setTamano(getTamano() + 1);
                System.out.println("  Inserta P[" + pos + "]= " + valor + ".");
            }
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  pos= " + pos + ", idx= " + idx + ", tamano= " + getTamano());

        System.out.println("4. Estado final:");
        imprimirLista("Despues insertar posicion");
    }

    public void recorrerYMostrar() {
        System.out.println("\n1. Estado inicial:");
        imprimirLista("Recorrido");

        System.out.println("2. Ejecucion paso a paso:");
        NodoLista actual = getCabeza();
        int pos = 0;
        if (actual == null) {
            System.out.println("  Lista vacia.");
        } else {
            while (actual != null) {
                System.out.println("  P[" + pos + "]= " + actual.getDato());
                actual = actual.getSiguiente();
                pos++;
            }
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  pos= " + pos + ", tamano= " + getTamano());

        System.out.println("4. Estado final:");
        imprimirLista("Final");
    }

    public void buscarValor(int objetivo) {
        System.out.println("\n1. Estado inicial:");
        imprimirLista("Buscar " + objetivo);

        System.out.println("2. Ejecucion paso a paso:");
        NodoLista actual = getCabeza();
        int pos = 0;
        boolean encontrado = false;
        int posHallada = -1;

        while (actual != null) {
            if (actual.getDato() == objetivo) {
                System.out.println("  Encontrado " + objetivo + " en P[" + pos + "]");
                if (!encontrado) {
                    encontrado = true;
                    posHallada = pos;
                }
            } else {
                System.out.println("  P[" + pos + "]= " + actual.getDato() + " (no coincide)");
            }
            actual = actual.getSiguiente();
            pos++;
        }
        if (!encontrado) {
            System.out.println("  Valor " + objetivo + " no encontrado.");
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  objetivo= " + objetivo + ", encontrado= " + encontrado + ", posHallada= P[" + posHallada + "]");

        System.out.println("4. Estado final:");
        imprimirLista("Final");
    }

    public void eliminarPorValor(int objetivo) {
        System.out.println("\n1. Estado inicial:");
        imprimirLista("Antes eliminar valor " + objetivo);

        System.out.println("2. Ejecucion paso a paso:");
        NodoLista actual = getCabeza();
        NodoLista anterior = null;
        boolean eliminado = false;
        int pos = 0;

        if (estaVacia()) {
            System.out.println("  Error: lista vacia.");
        } else {
            while (actual != null && !eliminado) {
                if (actual.getDato() == objetivo) {
                    if (anterior == null) {
                        setCabeza(actual.getSiguiente());
                    } else {
                        anterior.setSiguiente(actual.getSiguiente());
                    }
                    actual.setSiguiente(null);
                    setTamano(getTamano() - 1);
                    eliminado = true;
                    System.out.println("  Eliminado valor " + objetivo + " en P[" + pos + "]");
                } else {
                    anterior = actual;
                    actual = actual.getSiguiente();
                    pos++;
                }
            }
            if (!eliminado) {
                System.out.println("  Valor " + objetivo + " no encontrado.");
            }
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  objetivo= " + objetivo + ", eliminado= " + eliminado + ", pos= P[" + pos + "], tamano= " + getTamano());

        System.out.println("4. Estado final:");
        imprimirLista("Despues eliminar valor");
    }

    public void eliminarPorPosicion(int pos) {
        System.out.println("\n1. Estado inicial:");
        imprimirLista("Antes eliminar P[" + pos + "]");

        System.out.println("2. Ejecucion paso a paso:");
        NodoLista actual = getCabeza();
        NodoLista anterior = null;
        int idx = 0;
        int datoElim = 0;

        if (estaVacia()) {
            System.out.println("  Error: lista vacia.");
        } else {
            if (pos < 0 || pos >= getTamano()) {
                System.out.println("  Error: posicion invalida P[" + pos + "].");
            } else {
                for (idx = 0; idx < pos && actual != null; idx++) {
                    anterior = actual;
                    actual = actual.getSiguiente();
                }
                if (actual != null) {
                    datoElim = actual.getDato();
                    if (anterior == null) {
                        setCabeza(actual.getSiguiente());
                    } else {
                        anterior.setSiguiente(actual.getSiguiente());
                    }
                    actual.setSiguiente(null);
                    setTamano(getTamano() - 1);
                    System.out.println("  Eliminado nodo en P[" + pos + "]= " + datoElim);
                }
            }
        }

        System.out.println("3. Variables auxiliares:");
        System.out.println("  pos= P[" + pos + "], idx= P[" + idx + "], datoElim= " + datoElim + ", tamano= " + getTamano());

        System.out.println("4. Estado final:");
        imprimirLista("Despues eliminar posicion");
    }

    public void informarEstadoYCantidad() {
        System.out.println("\n1. Estado inicial:");
        imprimirLista("Estado");

        System.out.println("2. Ejecucion paso a paso:");
        System.out.println("  Esta vacia: " + estaVacia() + " | Cantidad: " + getTamano());

        System.out.println("3. Variables auxiliares:");
        System.out.println("  tamano= " + getTamano() + ", vacia= " + estaVacia());

        System.out.println("4. Estado final:");
        imprimirLista("Final");
    }
}