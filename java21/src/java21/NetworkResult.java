package java21;

sealed  interface NetworkResult<V> permits Success,Failure,Interrupted,Timeout{

    enum State {
        SUCCESS, FAILED, TIMEOUT, INTERRUPTED;
    }
}



record Success<V>(String response) implements NetworkResult<V>{}
record Failure<V>(Throwable cause) implements NetworkResult<V>{}
record Interrupted<V>(InterruptedException ie) implements NetworkResult<V> { }
record Timeout<V>(String reason) implements NetworkResult<V> { }



