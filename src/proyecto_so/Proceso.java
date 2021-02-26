/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_so;

import java.util.Objects;

/**
 *
 * @author Admin
 */
public class Proceso {
    private int numero_tarea,tiempo;
    private Integer tamanio;
    private String estado;
    private int entrada;

    public Proceso() {
    }

    public Proceso(int numero_tarea, int tiempo, Integer tamanio, String estado) {
        this.numero_tarea = numero_tarea;
        this.tiempo = tiempo;
        this.tamanio = tamanio;
        this.estado = estado;
    }

    public int getEntrada() {
        return entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public int getNumero_tarea() {
        return numero_tarea;
    }

    public void setNumero_tarea(int numero_tarea) {
        this.numero_tarea = numero_tarea;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public Integer getTamanio() {
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.numero_tarea;
        hash = 83 * hash + this.tiempo;
        hash = 83 * hash + Objects.hashCode(this.tamanio);
        hash = 83 * hash + Objects.hashCode(this.estado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proceso other = (Proceso) obj;
        if (this.numero_tarea != other.numero_tarea) {
            return false;
        }
        if (this.tiempo != other.tiempo) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.tamanio, other.tamanio)) {
            return false;
        }
        return true;
    }
    
   
    
    
    

    @Override
    public String toString() {
        return "Proceso: [" + "numero:" + numero_tarea + " Tiempo:" + tiempo + " Tamanio:" + tamanio + " Estado: " + estado + ']';
    }
    
    
    
    
    
 
            
    
}


