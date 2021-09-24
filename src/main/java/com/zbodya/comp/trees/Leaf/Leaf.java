package com.zbodya.comp.trees.Leaf;

import lombok.Data;

@Data
abstract public class Leaf
{
    protected String leafName;
    public Leaf(String leafName)
    {
        this.leafName = leafName;
    }
    abstract public void getType();
}
