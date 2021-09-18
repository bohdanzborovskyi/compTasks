package com.zbodya.comp.trees.Branch;

import com.zbodya.comp.trees.Leave.Leave;
import lombok.Data;

import java.util.List;

@Data
abstract public class Branch <L extends Leave>
{
    private String branch;
    public Branch(String branch)
    {
        this.branch = branch;
    }
    abstract public void addLeave(L leave);

}
