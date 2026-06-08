package org.week03_visibility_publication;

public final class ImmutableRequestConfig {

    private final String serviceName;
    private final int timeoutMillis;
    private final boolean fallbackEnabled;

    public ImmutableRequestConfig(String serviceName,int timeoutMillis,boolean fallbackEnabled) {
        this.serviceName = serviceName;
        this.timeoutMillis = timeoutMillis;
        this.fallbackEnabled = fallbackEnabled;
    }

    public String getServiceName() {
        return serviceName;
    }

    public int getTimeoutMillis() {
        return timeoutMillis;
    }

    public boolean isFallbackEnabled() {
        return fallbackEnabled;
    }
}

