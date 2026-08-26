package main.java.com.gameengine.config;

public class EngineConfig {
    private final String title;
    
    private final int internalWidth;
    private final int internalHeight;

    private final int scale;
    private final int targetTps;

    public EngineConfig(
        String title,
        int internalWidth,
        int internalHeight,
        int scale,
        int targetTps
    ){
        checkArguments(internalWidth, internalHeight, scale, targetTps);
        this.title = title;
        this.internalWidth = internalWidth;
        this.internalHeight = internalHeight;
        this.scale = scale;
        this.targetTps = targetTps;
    }

    public void checkArguments(int internalWidth, int internalHeight, int scale, int targetTps){
        if(internalWidth <= 0 || internalHeight <= 0){
            throw new IllegalArgumentException(
                "Internal resolution must be greather than zero"
            );
        }

        if(scale <= 0){
            throw new IllegalArgumentException(
                "Scale must be greather than zero"
            );
        }

        if(targetTps <= 0){
            throw new IllegalArgumentException(
                "Target TPS must be greater than zero"
            );
        }
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

    public int getTargetTps() {
        return targetTps;
    }

    public int getWindowWidth() {
        return internalWidth * scale;
    }

    public int getWindowHeight() {
        return internalHeight * scale;
    }

}
