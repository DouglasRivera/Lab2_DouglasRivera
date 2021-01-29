/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_douglasrivera;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author famii
 */
public class Lab2_DouglasRivera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner Leer = new Scanner(System.in);
        Leer.useDelimiter("\\n");
        ArrayList<Restaurantes> restaurantes = new ArrayList();
        int Opcion = 0;
        boolean Login = false;
        while (Opcion != 6) {
            System.out.println("•••   RESTAURANTES  •••");
            System.out.println("•1. Agregar Restaurante");
            System.out.println("•2. Actualizar Restaurante");
            System.out.println("•3. Eliminar Restaurante");
            System.out.println("•4. Listar Restaurante");
            System.out.println("•5. Log in para los reportes");
            System.out.println("•6. Salir del programa");
            System.out.print("Ingrese la opcion deseada: ");
            Opcion = Leer.nextInt();
            switch (Opcion) {
                case 1: 
                    System.out.println("Ingrese el nombre del Restaurante: ");
                    String Nombre = Leer.next();
                    System.out.println("Ingrese la ubicacion del Restaurante: ");
                    String Ubicacion = Leer.next();
                    System.out.println("Ingrese la cantidad de empleados: ");
                    int Cantidad_Empleados = Leer.nextInt();
                    System.out.println("Hay parqueo 1)[si] 0)[no]: ");
                    boolean Parqueo = Leer.nextInt() == 0 ? false : true;
                    int NumeroParqueos = 0;
                    if(Parqueo){
                        System.out.println("Numero maximo de vehiculos que soporta: ");
                        NumeroParqueos = Leer.nextInt();
                    }
                    System.out.println("Hay Area de Juegos 1)[si] 0)[no]: ");
                    boolean Area_Juegos = Leer.nextInt() == 0 ? false : true;
                    System.out.println("Ingrese la cantidad de mesas : ");
                    int Cantidad_Mesas = Leer.nextInt();
                    System.out.println("Ingrese la cantidad de cajeros: ");
                    int Cantidad_Cajeros = Leer.nextInt();
                    System.out.println("Ingrese el estado del Restaurante: \n1. Remodelacion\n2. Demolicion\n3. Funcional: ");
                    int EstadoRestaurante = Leer.nextInt();
                    
                    String Nombre_Gerente="";
                    String Especialidad_Restaurante="";
                    switch (EstadoRestaurante) {
                        case 1:
                            System.out.println("El estado del Restaurante es que esta en Remodelacion");
                            break;
                        case 2:
                            System.out.println("El estado del Restaurante esta en Demolicion");
                            break;
                        default:
                            System.out.println("El estado del Restaurante esta en perfectas condiciones");
                            System.out.println("Ingrese el nombre del gerente : ");
                            Nombre_Gerente = Leer.next();
                            System.out.println("Ingrese la especialidad del Restaurante: ");
                            Especialidad_Restaurante = Leer.next();
                            break;
                    }                    
                    restaurantes.add(new Restaurantes(Nombre, Ubicacion, Cantidad_Empleados, Parqueo, Area_Juegos, Cantidad_Mesas, Cantidad_Cajeros, Nombre_Gerente, Especialidad_Restaurante, EstadoRestaurante,NumeroParqueos,(NumeroParqueos>=30 && Area_Juegos)));
                    System.out.println("Se agrego el Restaurante con exito");
                    break;
                case 2:
                    boolean existeRestaurante = false;
                    String buscar = "";
                    System.out.println("Ingrese el nombre del Restaurante a actualizar:");
                    buscar = Leer.next();
                    for (int i = 0; i < restaurantes.size(); i++) {
                        if (restaurantes.get(i).Nombre.equals(buscar)) {
                            System.out.println("Ingrese el nombre del Restaurante: ");
                            String Nombree = Leer.next();
                            System.out.println("Ingrese la ubicacion del Restaurante: ");
                            String Ubicacionn = Leer.next();
                            System.out.println("Ingrese la cantidad de empleados: ");
                            int CantidadEmpleados = Leer.nextInt();
                            System.out.println("Hay parqueo 1)[si] 0)[no]: ");
                            boolean Parqueoo = Leer.nextInt() == 0 ? false : true;
                            System.out.println("Hay Area de Juegos 1-[si] 0)[no]: ");
                            boolean AreaJuego = Leer.nextInt() == 0 ? false : true;
                            System.out.println("Ingrese la cantidad de mesas : ");
                            int CantidadMesas = Leer.nextInt();
                            System.out.println("Ingrese la cantidad de cajeros: ");
                            int CantidadCajeros = Leer.nextInt();
                            System.out.println("Ingrese el nombre del gerente : ");
                            String NombreGerente = Leer.next();
                            System.out.println("Ingrese la especialidad del Restaurante: ");
                            String EspecialidadRestaurante = Leer.next();
                            restaurantes.get(i).Nombre = Nombree;
                            restaurantes.get(i).Ubicacion = Ubicacionn;
                            restaurantes.get(i).Cantidad_Empleados = CantidadEmpleados;
                            restaurantes.get(i).Parqueo = Parqueoo;
                            restaurantes.get(i).Area_Juegos = AreaJuego;
                            restaurantes.get(i).Cantidad_Mesas = CantidadMesas;
                            restaurantes.get(i).Cantidad_Cajeros = CantidadCajeros;
                            restaurantes.get(i).Nombre_Gerente = NombreGerente;
                            restaurantes.get(i).Especialidad_Restaurante = EspecialidadRestaurante;
                            existeRestaurante = true;
                            System.out.println("El Restaurante se actualizo");
                        }
                    }
                    if (existeRestaurante == false) {
                        System.out.println("El Restaurante buscado no existe");
                    }
                    break;
                case 3:
                    int posicionEliminar = -1;
                    posicionEliminar = -1;
                    System.out.println("Ingrese el nombre dek Restaurante a eliminar:");
                    buscar = Leer.next();
                    for (int i = 0; i < restaurantes.size(); i++) {
                        if (restaurantes.get(i).Nombre.equals(buscar)) {
                            posicionEliminar = i;
                        }
                    }
                    if (posicionEliminar >= 0) {
                        restaurantes.remove(posicionEliminar);
                        System.out.println("El Restaurante se elimino");
                    } else {
                        System.out.println("El Restaurante buscado no existe");
                    }
                    break;

                case 4:
                    System.out.println("Lista de Restaurantes");
                    for (int i = 0; i < restaurantes.size(); i++) {
                        System.out.println("Nombre del Retsaurante: " + restaurantes.get(i).Nombre);
                        System.out.println("Ubicacion del restaurante: " + restaurantes.get(i).Ubicacion);
                        System.out.println("Cantidad de Empleados: " + restaurantes.get(i).Cantidad_Empleados);
                        System.out.println("Tiene parqueo? : " + restaurantes.get(i).Parqueo);
                        System.out.println("Tiene Area de Juegos? : " + restaurantes.get(i).Area_Juegos);
                        System.out.println("Cantidad de mesas: " + restaurantes.get(i).Cantidad_Mesas);
                        System.out.println("Cantidad de Cajeros: " + restaurantes.get(i).Cantidad_Cajeros);
                        System.out.println("Nombre del gerente: " + restaurantes.get(i).Especialidad_Restaurante);
                        System.out.println("Estado de la casa: " + restaurantes.get(i).Estado_Restaurante);
                    }
                    break;
                case 5:
                    System.out.println(">>>>>>>Inicio de sesión<<<<<<<<");
                    while (Login != true) {
                        System.out.println("Ingrese el nombre de Usuario: ");
                        String User = Leer.next();
                        System.out.println("Ingrese la contraseña del usuario: ");
                        String Password = Leer.next();

                        if (User.equalsIgnoreCase("David") && Password.equals("99")) {
                            System.out.println("Usted ha iniciado sesión correctamente");
                            Login = true;
                        } else {
                            System.out.println("Nombre de usuario o contraseña incorrectos");
                        }
                    }
                    int OpcionReportes = 0;
                    System.out.println("•1. Reporte 1 ");
                    System.out.println("•2. Reporte 2");
                    System.out.println("•3. Reporte 3");
                    System.out.println("•4. Reporte 4");
                    System.out.println("•5. Salir del programa");
                    System.out.print("Ingrese la opcion deseada: ");
                    OpcionReportes = Leer.nextInt();
                    switch (OpcionReportes) {
                        case 1:
                            
                            break;
                        case 2:
                            
                            break;
                        case 3:
                            
                            break;
                        case 4:
                            
                            break;
                    }

                    break;
                case 6:
                    System.out.println("Saliendo........");
            }
        }     
    }
    public static boolean ValidarUbicacion(ArrayList<Restaurantes> restaurantes, String Ubicacion){
        for (int i = 0; i < restaurantes.size(); i++) {
          if(restaurantes.get(i).Ubicacion.equals(Ubicacion)){
              return false;
          }
        }
        return true;
    }
    public static boolean ValidarGerente(ArrayList<Restaurantes> restaurantes, String Gerente){
        int Apariciones=0;
        for (int i = 0; i < restaurantes.size(); i++) {
            if(restaurantes.get(i).Nombre_Gerente.equals(Gerente)){
                Apariciones ++;
            }
         }
        if(Apariciones>2){
            return false;
        }
        return true;
    }

    public static class Restaurantes {

        String Nombre;
        String Ubicacion;
        int Cantidad_Empleados;
        boolean Parqueo;
        boolean Area_Juegos;
        int Cantidad_Mesas;
        int Cantidad_Cajeros;
        String Nombre_Gerente;
        String Especialidad_Restaurante;
        int Estado_Restaurante;
        int NumeroParqueos;
        boolean EsPremiun;

        public Restaurantes() {
        }

        public Restaurantes(String Nombre, String Ubicacion, int Cantidad_Empleados, boolean Parqueo, boolean Area_Juegos, int Cantidad_Mesas, int Cantidad_Cajeros, String Nombre_Gerente, String Especialidad_Restaurante, int Estado_Restaurante, int NumeroParqueos,boolean EsPremiun) {
            this.Nombre = Nombre;
            this.Ubicacion = Ubicacion;
            this.Cantidad_Empleados = Cantidad_Empleados;
            this.Parqueo = Parqueo;
            this.Area_Juegos = Area_Juegos;
            this.Cantidad_Mesas = Cantidad_Mesas;
            this.Cantidad_Cajeros = Cantidad_Cajeros;
            this.Nombre_Gerente = Nombre_Gerente;
            this.Especialidad_Restaurante = Especialidad_Restaurante;
            this.Estado_Restaurante = Estado_Restaurante;
            this.NumeroParqueos = NumeroParqueos;
            this.EsPremiun = EsPremiun;
        }

        public boolean isEsPremiun() {
            return EsPremiun;
        }

        public void setEsPremiun(boolean EsPremiun) {
            this.EsPremiun = EsPremiun;
        }

        public int getNumeroParqueos() {
            return NumeroParqueos;
        }

        public void setNumeroParqueos(int NumeroParqueos) {
            this.NumeroParqueos = NumeroParqueos;
        }

        public String getNombre() {
            return Nombre;
        }

        public void setNombre(String Nombre) {
            this.Nombre = Nombre;
        }

        public String getUbicacion() {
            return Ubicacion;
        }

        public void setUbicacion(String Ubicacion) {
            this.Ubicacion = Ubicacion;
        }

        public int getCantidad_Empleados() {
            return Cantidad_Empleados;
        }

        public void setCantidad_Empleados(int Cantidad_Empleados) {
            this.Cantidad_Empleados = Cantidad_Empleados;
        }

        public boolean getParqueo() {
            return Parqueo;
        }

        public void setParqueo(boolean Parqueo) {
            this.Parqueo = Parqueo;
        }

        public boolean getArea_Juegos() {
            return Area_Juegos;
        }

        public void setArea_Juegos(boolean Area_Juegos) {
            this.Area_Juegos = Area_Juegos;
        }

        public int getCantidad_Mesas() {
            return Cantidad_Mesas;
        }

        public void setCantidad_Mesas(int Cantidad_Mesas) {
            this.Cantidad_Mesas = Cantidad_Mesas;
        }

        public int getCantidad_Cajeros() {
            return Cantidad_Cajeros;
        }

        public void setCantidad_Cajeros(int Cantidad_Cajeros) {
            this.Cantidad_Cajeros = Cantidad_Cajeros;
        }

        public String getNombre_Gerente() {
            return Nombre_Gerente;
        }

        public void setNombre_Gerente(String Nombre_Gerente) {
            this.Nombre_Gerente = Nombre_Gerente;
        }

        public String getEspecialidad_Restaurante() {
            return Especialidad_Restaurante;
        }

        public void setEspecialidad_Restaurante(String Especialidad_Restaurante) {
            this.Especialidad_Restaurante = Especialidad_Restaurante;
        }

        public int getEstado_Restaurante() {
            return Estado_Restaurante;
        }

        public void setEstado_Restaurante(int Estado_Restaurante) {
            this.Estado_Restaurante = Estado_Restaurante;
        }

    }
}
