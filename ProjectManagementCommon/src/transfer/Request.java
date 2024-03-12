/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.Serializable;
import operation.Operation;

/**
 *
 * @author HP
 */
public class Request implements Serializable{
    
    private final Operation operation;
    private final Object argument;

    public Request(Object argument,Operation operation) {
        this.operation = operation;
        this.argument = argument;
    }

    public Operation getOperation() {
        return operation;
    }

    public Object getArgument() {
        return argument;
    }

    
    
    
}
