package com.example.video;

import java.util.Objects;

public class SharpenAdapter {
    private final LegacySharpen legacySharpen;

    public SharpenAdapter(LegacySharpen legacySharpen) {
        this.legacySharpen = Objects.requireNonNull(legacySharpen, "legacySharpen");
    }

    public Frame[] sharpen(Frame[] frames, int strength) {
        Objects.requireNonNull(frames, "frames");
        if (strength <= 0) return frames;

        String framesHandle = "FRAMES:" + frames.length;
        String resultHandle = legacySharpen.applySharpen(framesHandle, strength);
        
        return frames;
    }
}
