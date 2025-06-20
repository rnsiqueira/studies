package java21;

public sealed interface Expr permits AddExpr,NegExpr,MultExpr,IntExpr {
}
