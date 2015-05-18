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

    public OperationResultModel() {
    }
    
    public OperationResultModel(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
}
