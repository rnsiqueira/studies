package java21;

public class ExpressionTest {

    static int eval(Expr e){
        return switch(e){
            case IntExpr(int val) ->  val;
            case NegExpr(Expr val) -> -eval(val);
            case AddExpr(Expr left,Expr right) -> eval(left) + eval(right);
            case MultExpr(Expr left,Expr right) -> eval(left) * eval(right);
        };
    }
    public static void main(String[] args) {
        //int ans = eval(new IntExpr(10));
        int ans = eval(new AddExpr(new IntExpr(4),new MultExpr(new IntExpr(3),new IntExpr(2))));
        System.out.println(ans);

    }
}
