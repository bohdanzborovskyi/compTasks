package com.zbodya.comp.trees.Leaf;


public class SimpleLeaf extends Leaf
{
    public SimpleLeaf(String leafName) {
        super(leafName);
    }

    @Override
    public void getType() {
        System.out.println("This is simple leaf");
    }
}
