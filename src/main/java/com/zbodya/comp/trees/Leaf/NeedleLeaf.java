package com.zbodya.comp.trees.Leaf;


public class NeedleLeaf extends Leaf
{
    public NeedleLeaf(String leafName) {
        super(leafName);
    }

    @Override
    public void getType() {
        System.out.println("This is needle leaf");
    }
}
