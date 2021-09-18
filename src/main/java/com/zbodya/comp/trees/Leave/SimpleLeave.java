package com.zbodya.comp.trees.Leave;


public class SimpleLeave extends Leave
{
    public SimpleLeave(String leave) {
        super(leave);
    }

    @Override
    public void getType() {
        System.out.println("This is simple leave");
    }
}
