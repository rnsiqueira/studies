package ilearn.thread;

public class WithThreadingProblem {

    int nextId;

    public int takeNextId() {
        return ++nextId;
    }
}
