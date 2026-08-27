package com.gameengine.config;


public final class EngineConfig {

    private final String title;

    private final int internalWidth;
    private final int internalHeight;

    private final int scale;

    private final int targetTps;
    private final int targetFps;

    private final boolean resizable;
    private final boolean debug;
    private final boolean syncToolkit;

    private EngineConfig(Builder builder) {
        this.title = builder.title;
        this.internalWidth = builder.internalWidth;
        this.internalHeight = builder.internalHeight;
        this.scale = builder.scale;
        this.targetTps = builder.targetTps;
        this.targetFps = builder.targetFps;
        this.resizable = builder.resizable;
        this.debug = builder.debug;
        this.syncToolkit = builder.syncToolkit;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTitle() {
        return title;
    }

    public int getInternalWidth() {
        return internalWidth;
    }

    public int getInternalHeight() {
        return internalHeight;
    }

    public int getScale() {
        return scale;
    }

    public int getWindowWidth() {
        return internalWidth * scale;
    }

    public int getWindowHeight() {
        return internalHeight * scale;
    }

    public int getTargetTps() {
        return targetTps;
    }

    public int getTargetFps() {
        return targetFps;
    }

    public boolean isResizable() {
        return resizable;
    }

    public boolean isDebug() {
        return debug;
    }

    public boolean isSyncToolkit() {
        return syncToolkit;
    }

    public static final class Builder {

        private String title = "Java Game";

        private int internalWidth = 320;
        private int internalHeight = 180;

        private int scale = 4;

        private int targetTps = 60;
        private int targetFps = 60;

        private boolean resizable = false;
        private boolean debug = false;
        private boolean syncToolkit = true;

        private Builder() {
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder resolution(int width, int height) {
            this.internalWidth = width;
            this.internalHeight = height;
            return this;
        }

        public Builder scale(int scale) {
            this.scale = scale;
            return this;
        }

        public Builder targetTps(int targetTps) {
            this.targetTps = targetTps;
            return this;
        }

        public Builder targetFps(int targetFps) {
            this.targetFps = targetFps;
            return this;
        }

        public Builder resizable(boolean resizable) {
            this.resizable = resizable;
            return this;
        }

        public Builder debug(boolean debug) {
            this.debug = debug;
            return this;
        }

        public Builder syncToolkit(boolean syncToolkit) {
            this.syncToolkit = syncToolkit;
            return this;
        }

        public EngineConfig build() {
            validate();

            return new EngineConfig(this);
        }

        private void validate() {

            if (title == null || title.isBlank()) {
                throw new IllegalArgumentException(
                        "Window title cannot be null or blank."
                );
            }

            if (internalWidth <= 0 || internalHeight <= 0) {
                throw new IllegalArgumentException(
                        "Internal resolution must be greater than zero."
                );
            }

            if (scale <= 0) {
                throw new IllegalArgumentException(
                        "Scale must be greater than zero."
                );
            }

            if (targetTps <= 0) {
                throw new IllegalArgumentException(
                        "Target TPS must be greater than zero."
                );
            }

            if (targetFps < 0) {
                throw new IllegalArgumentException(
                        "Target FPS cannot be negative."
                );
            }
        }
    }
}