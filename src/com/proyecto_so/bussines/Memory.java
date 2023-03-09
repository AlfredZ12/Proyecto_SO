/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto_so.bussines;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Memory {

    private int block;
    private Integer size;
    private Process process;
    private Integer time;
    private Integer fragmentation;

    public Memory() {

    }

    public Memory(int block, Integer size) {
        this.block = block;
        this.size = size;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getFragmentation() {
        return fragmentation;
    }

    public void setFragmentation(Integer fragmentation) {
        this.fragmentation = fragmentation;
    }

    @Override
    public String toString() {
        if (getProcess() != null) {
            return "Memory{" + "block=" + block + ", size=" + size + ", process=" + process + ", time=" + time + ", fragmentation=" + fragmentation + '}';

        } else {
            return "Memory{" + "block=" + block + ", size=" + size + ", process: ---" + ", time=" + time + ", fragmentation=" + fragmentation + '}';

        }
    }

}
