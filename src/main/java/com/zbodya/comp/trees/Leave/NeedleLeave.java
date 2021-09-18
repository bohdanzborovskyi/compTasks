package com.zbodya.comp.trees.Leave;


public class NeedleLeave extends Leave
{
    public NeedleLeave(String leave) {
        super(leave);
    }

    @Override
    public void getType() {
        System.out.println("This is needle leave");
    }
}
