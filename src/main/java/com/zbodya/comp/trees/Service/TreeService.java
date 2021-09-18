package com.zbodya.comp.trees.Service;

import com.zbodya.comp.trees.Branch.DeciduousBranch;
import com.zbodya.comp.trees.Branch.NeedleBranch;
import com.zbodya.comp.trees.Leave.NeedleLeave;
import com.zbodya.comp.trees.Leave.SimpleLeave;
import com.zbodya.comp.trees.Tree.DeciduousTree;
import com.zbodya.comp.trees.Tree.NeedleTree;
import com.zbodya.comp.trees.Trunk.Trunk;
import org.springframework.stereotype.Service;

@Service
public class TreeService
{
    public static void loadTreeData()
    {
        // Create trunks
        Trunk needleTrunk = new Trunk("Needle trunk");
        Trunk deciduousTrunk = new Trunk("Deciduous trunk");
        // Create trees
        DeciduousTree deciduousTree = new DeciduousTree("Deciduous tree");
        NeedleTree needleTree = new NeedleTree("Deciduous tree");
        // Setting trunks to trees
        deciduousTree.setTrunk(deciduousTrunk);
        needleTree.setTrunk(needleTrunk);
        // Creating branches with leaves and adding them to trees
        for(int i=0; i<25; i++)
        {
            DeciduousBranch decidousBranch = new DeciduousBranch("Deciduous branch" + i);
            for(int j=0; j<20; j++)
            {
                SimpleLeave simpleLeave = new SimpleLeave("Simple leave" + j);
                decidousBranch.addLeave(simpleLeave);
            }
            NeedleBranch neddleBranch = new NeedleBranch("Needle branch" + i);
            for(int j=0; j<20; j++)
            {
                NeedleLeave needleLeave = new NeedleLeave("Needle leave" + j);
                neddleBranch.addLeave(needleLeave);
            }
            needleTree.addBranch(neddleBranch);
            deciduousTree.addBranch(decidousBranch);
        }

        // Info about loading trees
//        System.out.println(needleTree.getBranches());
//        for(int i=0; i<25; i++)
//        {
//            needleTree.getBranches().forEach(needleBranch -> needleBranch.getLeaves().forEach(NeedleLeave::getType));
//            deciduousTree.getBranches().forEach(deciduousBranch -> deciduousBranch.getLeaves().forEach(SimpleLeave::getType));
//        }
    }
}
