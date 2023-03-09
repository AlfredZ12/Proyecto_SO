/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto_so.controllers;

import com.proyecto_so.bussines.Memory;
import com.proyecto_so.bussines.Process;

import com.proyecto_so.handles.ProcessHandle;
import com.proyecto_so.views.ProcessView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author el_fr
 */
public class ProcessController implements Controller {

    private ProcessHandle processHandle;
    private ProcessView frame;

    public ProcessController(ProcessView frame) {

        this.processHandle = new ProcessHandle();
        this.frame = frame;
        this.frame.setVisible(true);
        this.addEvent();
    }

    @Override
    public void init() {
       
            
            this.processHandle.addObserver(this);
            new Thread(this.processHandle).start();
      
    }

    @Override
    public void update() {

        this.list();

    }

    public void list() {
        this.customList(this.processHandle.getMemoryList());
        this.customList(this.processHandle.getProcessList());

    }

    public void customList(List<?> lista) {
        if (lista.isEmpty()) {
            return;
        }
        String clazzName = lista.get(0).getClass().getSimpleName();

        if (clazzName.equals("Memory")) {

            JTable table = new JTable(buildMemoryTable(lista));

            this.frame.getScrollMemory().setViewportView(table);
        }

        if (clazzName.equals("Process")) {

            JTable table = new JTable(buildProcessTable(lista));
            this.frame.getScrollProcess().setViewportView(table);
        }

    }

    public DefaultTableModel buildProcessTable(List<?> list) {
        DefaultTableModel model = new DefaultTableModel();
        String[] titles = {"NumProcess", "time", "Size", "State"};
        model.setColumnIdentifiers(titles);

        for (Object obj : list) {
            if (obj instanceof Process) {
                Process process = (Process) obj;

                Object[] row = {
                    process.getNumProcess(),
                    process.getTime(),
                    process.getSize(),
                    process.getState()};
                model.addRow(row);

            }

        }
        return model;
    }

    public DefaultTableModel buildMemoryTable(List<?> list) {
        DefaultTableModel model = new DefaultTableModel();
        String[] titles = {"Block", "Fragmentation", "Time", "Size", "Process", "ProcessState", "ProcessSize"};
        model.setColumnIdentifiers(titles);

        for (Object obj : list) {
            if (obj instanceof Memory) {
                Memory memory = (Memory) obj;
                obj = (Memory) obj;
                if (memory.getProcess() != null) {
                    Object[] row = {
                        memory.getBlock(),
                        memory.getFragmentation(),
                        memory.getTime(),
                        memory.getSize(),
                        memory.getProcess().getNumProcess(),
                        memory.getProcess().getState(),
                        memory.getProcess().getSize()
                    };
                    model.addRow(row);
                } else {
                    Object[] row = {
                        memory.getBlock(),
                        memory.getFragmentation(),
                        memory.getTime(),
                        memory.getSize(),
                        "--",
                        "--",
                        "--"};
                    model.addRow(row);
                }
            }

        }
        return model;
    }

    private void addEvent() {
        this.frame.getjButton1().addActionListener((ActionEvent e) -> {
            init();
        });
    }

}
