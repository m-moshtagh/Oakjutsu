package com.dogigiri.core.blocks;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BlocksDemo extends SuperClass {
    static {
        Logger.getLogger(BlocksDemo.class.getName()).log(Level.INFO, "static block");
    }
    {
        Logger.getLogger(BlocksDemo.class.getName()).log(Level.INFO, "initializer block");
    }

    BlocksDemo() {
        Logger.getLogger(BlocksDemo.class.getName()).log(Level.INFO, "constructor block");
    }

    public static void main(String[] args) {
        BlocksDemo blocksDemo = new BlocksDemo();
    }

}
