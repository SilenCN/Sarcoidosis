package cn.silen_dev.sarcoidosis.model;

public class SuccessResult extends RequestResult {
    public SuccessResult(){
        this(null);
    }
    public SuccessResult(Object object){
        setCode(100);
        setResult(object);
    }
}
