/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto_so.bussines;

import java.util.Objects;

/**
 *
 * @author Admin
 */
public class Process {

    private int numProcess, time;
    private Integer size;
    private StateProcess state;
    private int numIn;

    public Process() {
    }

    public Process(int numProcess, int time, Integer size, StateProcess state) {
        this.numProcess = numProcess;
        this.time = time;
        this.size = size;
        this.state = state;
    }

    public int getNumIn() {
        return numIn;
    }

    public void setNumIn(int numIn) {
        this.numIn = numIn;
    }

    public int getNumProcess() {
        return numProcess;
    }

    public void setNumProcess(int numProcess) {
        this.numProcess = numProcess;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public StateProcess getState() {
        return state;
    }

    public void setState(StateProcess state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.numProcess;
        hash = 83 * hash + this.time;
        hash = 83 * hash + Objects.hashCode(this.size);
        hash = 83 * hash + Objects.hashCode(this.state);
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
        final Process other = (Process) obj;
        if (this.numProcess != other.numProcess) {
            return false;
        }
        if (this.time != other.time) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.size, other.size)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Process{" + "numProcess=" + numProcess + ", time=" + time + ", size=" + size + ", state=" + state + ", numIn=" + numIn + '}';
    }

}
