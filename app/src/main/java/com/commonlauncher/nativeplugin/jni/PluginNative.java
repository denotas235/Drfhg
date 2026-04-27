package com.commonlauncher.nativeplugin.jni;

public class PluginNative {
    static {
        try {
            System.loadLibrary("maliplugin");
        } catch (UnsatisfiedLinkError e) {
            android.util.Log.e("MaliBridge", "Erro ao carregar libmaliplugin: " + e.getMessage());
        }
    }

    public static native String getGLExtensions();
    public static native float getGPUTemperature();
    public static native float getGPUFrequency();
    public static native float getVRAMUsage();
}
