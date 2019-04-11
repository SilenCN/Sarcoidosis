package cn.silen_dev.sarcoidosis.model;

public class FailureResult extends RequestResult {
    public FailureResult(){
        this(null);
    }
    public FailureResult(Object result){
        setResult(result);
        setCode(200);
    }
}
