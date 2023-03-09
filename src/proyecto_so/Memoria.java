/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_so;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Memoria {
    private int bloque;
    private Integer tamanio;
    private Proceso proceso;
    private Integer tiempo;
    private Integer fragmentacion;
   
    public Memoria() {
        
    }

    public Memoria(int bloque, Integer tamanio) {
        this.bloque = bloque;
        this.tamanio = tamanio;
    }
    
    

    public int getBloque() {
        return bloque;
    }

    public void setBloque(int bloque) {
        this.bloque = bloque;
    }

    public Integer getTamanio() {
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public Integer getFragmentacion() {
        return fragmentacion;
    }

    public void setFragmentacion(Integer fragmentacion) {
        this.fragmentacion = fragmentacion;
    }

    @Override
    public String toString() {
        if(this.getProceso()!=null){
                    return "Memoria{" + "bloque=" + bloque + ", tamanio=" + tamanio + ", proceso=" + proceso + ", tiempo=" + tiempo + ", fragmentacion=" + fragmentacion + '}';

        }else{
                    return "Memoria{" + "bloque=" + bloque + ", tamanio=" + tamanio + ", proceso: N "  + ", tiempo=" + tiempo + ", fragmentacion=" + fragmentacion + '}';

        }
    }
  
         
}
