package com.mycompany.avia.exceptions;

import jakarta.xml.ws.WebFault;

@WebFault
public class ArgumentException extends TraceException {
    public ArgumentException(String message) {
        super(message);
    }
    
    @Override
    public ExceptionInfo getExceptionInfo() {
        return super.getExceptionInfo(); 
    }
}
