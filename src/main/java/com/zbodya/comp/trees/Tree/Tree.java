package com.zbodya.comp.trees.Tree;

import com.zbodya.comp.trees.Branch.Branch;
import com.zbodya.comp.trees.Trunk.Trunk;
import lombok.Data;

import java.util.List;

@Data
abstract class Tree <B extends Branch>
{
    private String tree;
    private Trunk trunk;
    abstract public void addBranch(B branch);
    abstract public void grow();
    abstract public void cutDown();
    abstract public void dryUp();

    public Tree(String tree) {
        this.tree = tree;
    }

}
