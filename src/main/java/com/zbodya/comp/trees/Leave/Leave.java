package com.zbodya.comp.trees.Leave;

import lombok.Data;

@Data
abstract public class Leave
{
    private String leave;
    public Leave(String leave)
    {
        this.leave = leave;
    }
    abstract public void getType();
}
