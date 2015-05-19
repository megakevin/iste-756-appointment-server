/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

/**
 *
 * @author Kevin
 */
public class OperationResultModel {
    private boolean success;
    private String message;
    private int errorCode;

    public OperationResultModel() {
    }
    
    public OperationResultModel(boolean success) {
        this.success = success;
    }
    
    public OperationResultModel(boolean success, String message, int errorCode) {
        setSuccess(success);
        setMessage(message);
        setErrorCode(errorCode);
    }

    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
