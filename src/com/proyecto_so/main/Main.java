/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto_so.main;

import com.proyecto_so.controllers.Controller;
import com.proyecto_so.controllers.ProcessController;
import com.proyecto_so.handles.ProcessHandle;
import com.proyecto_so.views.ProcessView;
import java.util.List;

/**
 *
 * @author el_fr
 */
public class Main {
    
    public static void main(String[] args) throws InterruptedException{
    new ProcessController(new ProcessView());
          
           
    }
    
}
