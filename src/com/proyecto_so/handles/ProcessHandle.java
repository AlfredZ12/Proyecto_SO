/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto_so.handles;

import com.proyecto_so.bussines.Memory;
import com.proyecto_so.bussines.Process;
import com.proyecto_so.bussines.StateProcess;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author el_fr
 */
public class ProcessHandle implements Runnable {

    private List<Process> processList;
    private List<Memory> memoryList;
    private int iterations;
    private int iterationsDel;

    public ProcessHandle() {
        this.initLists();
    }

    private void initLists() {
        processList = new ArrayList<>();
        memoryList = new ArrayList<>();
        processList.add(new Process(1, 30, 2890, StateProcess.WAITING));
        processList.add(new Process(2, 54, 7340, StateProcess.WAITING));
        processList.add(new Process(3, 30, 2890, StateProcess.WAITING));
        processList.add(new Process(4, 34, 4200, StateProcess.WAITING));
        processList.add(new Process(5, 25, 7200, StateProcess.WAITING));
        processList.add(new Process(6, 33, 2500, StateProcess.WAITING));
        processList.add(new Process(7, 9, 8900, StateProcess.WAITING));
        processList.add(new Process(8, 26, 5000, StateProcess.WAITING));
        processList.add(new Process(9, 10, 2550, StateProcess.WAITING));
        processList.add(new Process(10, 56, 1120, StateProcess.WAITING));
        processList.add(new Process(11, 17, 4270, StateProcess.WAITING));
        processList.add(new Process(12, 19, 6540, StateProcess.WAITING));
        processList.add(new Process(13, 54, 3500, StateProcess.WAITING));
        processList.add(new Process(14, 8, 9400, StateProcess.WAITING));
        processList.add(new Process(15, 12, 6300, StateProcess.WAITING));
        processList.add(new Process(16, 28, 5900, StateProcess.WAITING));
        processList.add(new Process(17, 21, 150, StateProcess.WAITING));
        processList.add(new Process(18, 15, 330, StateProcess.WAITING));
        processList.add(new Process(19, 24, 670, StateProcess.WAITING));
        processList.add(new Process(20, 35, 5950, StateProcess.WAITING));
        processList.add(new Process(21, 11, 2380, StateProcess.WAITING));
        processList.add(new Process(22, 6, 7540, StateProcess.WAITING));
        processList.add(new Process(23, 7, 6800, StateProcess.WAITING));
        processList.add(new Process(24, 11, 2121, StateProcess.WAITING));
        processList.add(new Process(25, 26, 4290, StateProcess.WAITING));

        //Fragmentos de la memoryList
        memoryList.add(new Memory(1, 3800));
        memoryList.add(new Memory(2, 2700));
        memoryList.add(new Memory(3, 3700));
        memoryList.add(new Memory(4, 9400));
        memoryList.add(new Memory(6, 900));
        memoryList.add(new Memory(5, 700));
        memoryList.add(new Memory(7, 6500));
        memoryList.add(new Memory(8, 2400));
        memoryList.add(new Memory(9, 4600));
        memoryList.add(new Memory(10, 7200));
        memoryList.add(new Memory(11, 8100));

    }

    @Override
    public void run() {
        this.iterations = 0;
        this.iterationsDel = 0;
       
        try {
            while (!isFinish()) {

                if (isFull()) {
                    this.removeProcess();
                } else if (!isFull() && !isFinish()) {
                    this.removeProcess();
                }

                this.addProcess();
                System.out.println("deleted Process: " + iterationsDel);
                System.out.println("Added Prcoess: " + iterations);

                // processList.forEach(System.out::println);
                memoryList.forEach(System.out::println);

                Thread.sleep(500);

            }

        } catch (InterruptedException ex) {
            Logger.getLogger(ProcessHandle.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean isFull() {
        int processInMemory = 0;

        for (Memory memory : memoryList) {
            if (memory.getProcess()!= null) {
                processInMemory++;
            }

        }

        if (processInMemory == memoryList.size()) {
            return true;
        }

        return false;
    }

    public boolean isFinish() {
        int processFinish = 0;

        for (Process process : processList) {
            if (process.getState()==StateProcess.FINISHED) {
                processFinish++;
            }

        }

        if (processFinish == processList.size()) {
            return true;
        }

        return false;
    }

    public void addProcess() {
        for (Process process : processList) {
            //Se busca si el process no se esta ejecutando para agregarlo
            if (process.getState()==StateProcess.WAITING) {
                //Si el process no se esta ejecutando itera la memoryList 
                for (Memory memory : memoryList) {
                    if (memory.getProcess()== null) {
                        //si el process es menor o igual ala memoryList se agrega
                        if (process.getSize() <= memory.getSize()) {
                            process.setState(StateProcess.RUNNING);
                            process.setNumIn(iterations);
                            memory.setProcess(process);
                            memory.setFragmentation(memory.getSize()- process.getSize());
                            memory.setTime(process.getTime());
                            this.iterations++;
                            System.out.println("Process get in: " + memory.getBlock()+ " " + memory.getBlock());
                            break;
                        }
                    }

                }
            }
        }
    }

    public void removeProcess() {
        for (Memory memory : memoryList) {
            if (memory.getProcess()!= null) {
                if (memory.getProcess().getNumIn() == iterationsDel) {
                    if (memory.getProcess().getState()==StateProcess.RUNNING) {
                        memory.getProcess().setState(StateProcess.FINISHED);
                        System.out.println("Process left: " + memory);
                        memory.setProcess(null);
                        this.iterationsDel++;
                        break;
                    }
                }

            }
        }
    }

}
