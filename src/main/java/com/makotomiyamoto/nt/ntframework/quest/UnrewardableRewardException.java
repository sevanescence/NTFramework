package com.makotomiyamoto.nt.ntframework.quest;

public class UnrewardableRewardException extends Exception {
    public UnrewardableRewardException() {
        super();
    }

    public UnrewardableRewardException(String message) {
        super(message);
    }

    public UnrewardableRewardException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnrewardableRewardException(Throwable cause) {
        super(cause);
    }

    protected UnrewardableRewardException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
