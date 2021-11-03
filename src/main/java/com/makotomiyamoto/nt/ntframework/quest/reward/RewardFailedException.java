package com.makotomiyamoto.nt.ntframework.quest.reward;

public class RewardFailedException extends Exception {
    public enum Reason {
        INVENTORY_FULL
    }
    private Reason reason;

    public RewardFailedException() {
        super();
    }

    public RewardFailedException(String message, Reason reason) {
        super(message);
        this.reason = reason;
    }

    public RewardFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RewardFailedException(Throwable cause) {
        super(cause);
    }

    protected RewardFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Reason getReason() {
        return reason;
    }

}
