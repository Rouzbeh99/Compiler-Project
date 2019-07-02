package Nodes.ExpressionNodes;

import Nodes.ClassNode;

public class ForLoop extends BlockContent {
    private ExpressionNode loopCond;
    private Block loopBody;

    public ForLoop(ExpressionNode loopCond, Block loopBody) {
        this.loopCond = loopCond;
        this.loopBody = loopBody;
    }

    @Override
    public ClassNode compile(){
        // code to check condition and run body code
        System.out.println("in loop operation");
        System.out.println("go to loop cond");
        loopCond.compile();
        System.out.println("go to loop body");
        loopBody.compile();
        System.out.println("loop operation finished");

        return null;
    }
}
