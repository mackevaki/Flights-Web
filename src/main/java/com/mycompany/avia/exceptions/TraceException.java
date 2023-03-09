package com.mycompany.avia.exceptions;

public class TraceException extends Exception {
    private ExceptionInfo exceptionInfo = new ExceptionInfo();

    public TraceException() {
    }

    public TraceException(String message) {
        super(message);
    }

    public TraceException(String message, Throwable cause) {
        super(message, cause);
    }

    public TraceException(Throwable cause) {
        super(cause);
    }

    public TraceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ExceptionInfo getExceptionInfo() {
        exceptionInfo.setTrace(getStringFromTrace(getStackTrace()));
        return exceptionInfo;
    }

    private String getStringFromTrace(StackTraceElement[] stackTrace) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (StackTraceElement stackTraceElement :
                stackTrace) {
            sb.append(stackTraceElement.toString()).append("\n");
        }
        return sb.toString();
    }
}
