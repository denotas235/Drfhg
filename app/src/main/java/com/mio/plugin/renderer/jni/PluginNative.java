package com.mio.plugin.renderer.jni;

public class PluginNative {
    static {
        try {
            System.loadLibrary("maliplugin");
        } catch (UnsatisfiedLinkError ignored) {}
    }

    public static native String getGLExtensions();
    public static native float getGPUTemperature();
    public static native float getGPUFrequency();
    public static native float getVRAMUsage();
}
