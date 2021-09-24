package com.zbodya.comp.trees.Branch;

import com.zbodya.comp.trees.Leaf.SimpleLeaf;


public class DeciduousBranch extends Branch<SimpleLeaf>
{
    public DeciduousBranch(String branch) {
        super(branch);
    }

    @Override
    public void addLeaf(SimpleLeaf leaf)
    {
        this.leaves.add((leaf));
    }
}
