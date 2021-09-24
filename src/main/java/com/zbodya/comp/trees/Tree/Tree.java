package com.zbodya.comp.trees.Tree;

import com.zbodya.comp.trees.Branch.Branch;
import com.zbodya.comp.trees.Trunk.Trunk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
abstract class Tree <B extends Branch>
{
    protected List<B> branches;
    private String treeName;
    private Trunk trunk;
    abstract public void addBranch(B branch);
    abstract public void grow();
    abstract public void cutDown();
    abstract public void dryUp();

    public Tree(String treeName) {
        this.treeName = treeName;
        this.branches = new ArrayList<>();
    }

}
