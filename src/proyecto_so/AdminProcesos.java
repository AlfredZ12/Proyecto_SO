/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_so;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author el_fr
 */
public class AdminProcesos {

    private List<Proceso> procesos;
    private List<Memoria> memoria;
    private int iteraciones;
    private int iteracionesDel;

    public AdminProcesos() {
        this.iniciarListas();
    }

    private void iniciarListas() {
        procesos = new ArrayList<>();
        memoria = new ArrayList<>();
        procesos.add(new Proceso(1, 30, 2890, "En Espera"));
        procesos.add(new Proceso(2, 54, 7340, "En Espera"));
        procesos.add(new Proceso(3, 30, 2890, "En Espera"));
        procesos.add(new Proceso(4, 34, 4200, "En Espera"));
        procesos.add(new Proceso(5, 25, 7200, "En Espera"));
        procesos.add(new Proceso(6, 33, 2500, "En Espera"));
        procesos.add(new Proceso(7, 9, 8900, "En Espera"));
        procesos.add(new Proceso(8, 26, 5000, "En Espera"));
        procesos.add(new Proceso(9, 10, 2550, "En Espera"));
        procesos.add(new Proceso(10, 56, 1120, "En Espera"));
        procesos.add(new Proceso(11, 17, 4270, "En Espera"));
        procesos.add(new Proceso(12, 19, 6540, "En Espera"));
        procesos.add(new Proceso(13, 54, 3500, "En Espera"));
        procesos.add(new Proceso(14, 8, 9400, "En Espera"));
        procesos.add(new Proceso(15, 12, 6300, "En Espera"));
        procesos.add(new Proceso(16, 28, 5900, "En Espera"));
        procesos.add(new Proceso(17, 21, 150, "En Espera"));
        procesos.add(new Proceso(18, 15, 330, "En Espera"));
        procesos.add(new Proceso(19, 24, 670, "En Espera"));
        procesos.add(new Proceso(20, 35, 5950, "En Espera"));
        procesos.add(new Proceso(21, 11, 2380, "En Espera"));
        procesos.add(new Proceso(22, 6, 7540, "En Espera"));
        procesos.add(new Proceso(23, 7, 6800, "En Espera"));
        procesos.add(new Proceso(24, 11, 2121, "En Espera"));
        procesos.add(new Proceso(25, 26, 4290, "En Espera"));

        //Fragmentos de la memoria
        memoria.add(new Memoria(1, 3800));
        memoria.add(new Memoria(2, 2700));
        memoria.add(new Memoria(3, 3700));
        memoria.add(new Memoria(4, 9400));
        memoria.add(new Memoria(6, 900));
        memoria.add(new Memoria(5, 700));
        memoria.add(new Memoria(7, 6500));
        memoria.add(new Memoria(8, 2400));
        memoria.add(new Memoria(9, 4600));
        memoria.add(new Memoria(10, 7200));
        memoria.add(new Memoria(11, 8100));

    }

    public void run() throws InterruptedException {
        this.iteraciones = 0;
        this.iteracionesDel = 0;
        int maxMemoria = this.memoria.size();
        while (!isTerminado()) {

            if (isFull()) {
                this.eliminarProceso();
            } else if (!isFull() && !isTerminado()) {
                this.eliminarProceso();
            }

            this.agregarProceso();
            System.out.println("Se han elminado: " + iteracionesDel);
            System.out.println("Se han agregado: " + iteraciones);

            // procesos.forEach(System.out::println);
            memoria.forEach(System.out::println);

            Thread.sleep(500);

        }

    }

    public boolean isFull() {
        int cantidadProcesos = 0;

        for (Memoria memoria1 : memoria) {
            if (memoria1.getProceso() != null) {
                cantidadProcesos++;
            }

        }

        if (cantidadProcesos == memoria.size()) {
            return true;
        }

        return false;
    }

    public boolean isTerminado() {
        int cantidadProcesos = 0;

        for (Proceso proceso : procesos) {
            if (proceso.getEstado().equalsIgnoreCase("Terminado")) {
                cantidadProcesos++;
            }

        }

        if (cantidadProcesos == procesos.size()) {
            return true;
        }

        return false;
    }

    public void agregarProceso() {
        for (Proceso proceso : procesos) {
            //Se busca si el proceso no se esta ejecutando para agregarlo
            if (proceso.getEstado().equalsIgnoreCase("En espera")) {
                //Si el proceso no se esta ejecutando itera la memoria 
                for (Memoria memoria : memoria) {
                    if (memoria.getProceso() == null) {
                        //si el proceso es menor o igual ala memoria se agrega
                        if (proceso.getTamanio() <= memoria.getTamanio()) {
                            proceso.setEstado("Ejecutando");
                            proceso.setEntrada(iteraciones);
                            memoria.setProceso(proceso);
                            memoria.setFragmentacion(memoria.getTamanio() - proceso.getTamanio());
                            memoria.setTiempo(proceso.getTiempo());
                            this.iteraciones++;
                            System.out.println("Agregado: " + memoria.getBloque() + " " + memoria.getProceso());
                            break;
                        }
                    }

                }
            }
        }
    }

    public void eliminarProceso() {
        for (Memoria memoria1 : memoria) {
            if (memoria1.getProceso() != null) {
                if (memoria1.getProceso().getEntrada() == iteracionesDel) {
                    if (memoria1.getProceso().getEstado().equalsIgnoreCase("Ejecutando")) {
                        memoria1.getProceso().setEstado("Terminado");
                        System.out.println("Salio: " + memoria1);
                        memoria1.setProceso(null);
                        this.iteracionesDel++;
                        break;
                    }
                }

            }
        }
    }

}
