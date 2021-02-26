/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_so;

import java.awt.Event;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


/**
 *
 * @author Admin
 */
public class Proyecto_SO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        Scanner comando = new Scanner(System.in);
        String escribir;
        List<Proceso> Procesos = new ArrayList<>();
       
        
       
        List<Memoria> Memoria = new ArrayList<>();
        
       
        //Procesos
        Procesos.add(new Proceso(1, 30, 2890, "En Espera"));
        Procesos.add(new Proceso(2, 54, 7340, "En Espera"));
        Procesos.add(new Proceso(3, 30, 2890, "En Espera"));
        Procesos.add(new Proceso(4, 34, 4200, "En Espera"));
        Procesos.add(new Proceso(5, 25, 7200, "En Espera"));
        Procesos.add(new Proceso(6, 33, 2500, "En Espera"));
        Procesos.add(new Proceso(7, 9, 8900, "En Espera"));
        Procesos.add(new Proceso(8, 26, 5000, "En Espera"));
        Procesos.add(new Proceso(9, 10, 2550, "En Espera"));
        Procesos.add(new Proceso(10, 56, 1120, "En Espera"));
        Procesos.add(new Proceso(11, 17, 4270, "En Espera"));
        Procesos.add(new Proceso(12, 19, 6540, "En Espera"));
        Procesos.add(new Proceso(13, 54, 3500, "En Espera"));
        Procesos.add(new Proceso(14, 8, 9400, "En Espera"));
        Procesos.add(new Proceso(15, 12, 6300, "En Espera"));
        Procesos.add(new Proceso(16, 28, 5900, "En Espera"));
        Procesos.add(new Proceso(17, 21, 150, "En Espera"));
        Procesos.add(new Proceso(18, 15, 330, "En Espera"));
        Procesos.add(new Proceso(19, 24, 670, "En Espera"));
        Procesos.add(new Proceso(20, 35, 5950, "En Espera"));
        Procesos.add(new Proceso(21, 11, 2380, "En Espera"));
        Procesos.add(new Proceso(22, 6, 7540, "En Espera"));
        Procesos.add(new Proceso(23, 7, 6800, "En Espera"));
        Procesos.add(new Proceso(24, 11, 2121, "En Espera"));
        Procesos.add(new Proceso(25, 26, 4290, "En Espera"));

        //Fragmentos de la Memoria
        Memoria.add(new Memoria(1, 3800));
        Memoria.add(new Memoria(2, 2700));
        Memoria.add(new Memoria(3, 3700));
        Memoria.add(new Memoria(4, 9400));
        Memoria.add(new Memoria(6, 900));
        Memoria.add(new Memoria(5,700));
        Memoria.add(new Memoria(7, 6500));
        Memoria.add(new Memoria(8, 2400));
        Memoria.add(new Memoria(9, 4600));
        Memoria.add(new Memoria(10, 7200));
        Memoria.add(new Memoria(11, 8100));
        
        
        
        System.out.println("Tamaño de lista: " + Procesos.size());
        int aux = 0;
        int aux2 = 0;
        
        while (true) {
            
            System.out.println("Presiona S/N para continuar o terminar");
          //  System.out.println("vuelta: " + (aux + 1));
            escribir = comando.next();
            
            while (escribir.equalsIgnoreCase("S")) {

                Agregar(Procesos, Memoria);

                aux++;
                if (aux >= Memoria.size()) {
                    if (Quitar(Memoria, aux2)) {
                        aux2++;
                    } else{
                        aux2=0;
                    }
                  
                }

                for (Proceso proceso : Procesos) {
                    System.out.println(proceso);
                }

                break;
            }
            
            
            
            
            if (escribir.equalsIgnoreCase("N")) {
                return;
            }

        }

    }
    
    
    public static boolean Agregar(List<Proceso> procesos, List<Memoria> Particionesmemoria) {

        for (Proceso proceso : procesos) {
            //Se busca si el proceso no se esta ejecutando para agregarlo
            if (proceso.getEstado().equalsIgnoreCase("En espera")) {
                //Si el proceso no se esta ejecutando itera la memoria 
                for (Memoria memoria : Particionesmemoria) {
                    if (memoria.getProceso() == null ) {
                        //si el proceso es menor o igual ala memoria se agrega
                        if (proceso.getTamanio() <= memoria.getTamanio()) {
                            proceso.setEstado("Ejecutando");
                            memoria.setProceso(proceso);
                            memoria.setFragmentacion(memoria.getTamanio() - proceso.getTamanio());
                            memoria.setTiempo(proceso.getTiempo());
                            System.out.println("Agregado: " + memoria);
                            return true;
                        } else {
                            
                            break;
                        }
                    }

                }
            } 
        }

        return false;
    }
    
   
    public static boolean Quitar (List<Memoria> memoria,int i){
       
            if(memoria.get(i).getProceso()!=null){
                 if(memoria.get(i).getProceso().getEstado().equalsIgnoreCase("Ejecutando")){
                     memoria.get(i).getProceso().setEstado("Terminado");
                     System.out.println("Salio: " + memoria.get(i));
                     memoria.get(i).setProceso(null);
                     
                     return true;   
                 }
            }
        
        
        return false;
    }


       
}
