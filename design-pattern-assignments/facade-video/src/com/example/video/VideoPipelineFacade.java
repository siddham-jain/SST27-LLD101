package com.example.video;

import java.nio.file.Path;
import java.util.Objects;

public class VideoPipelineFacade {
    private final Decoder decoder;
    private final FilterEngine filterEngine;
    private final Encoder encoder;
    private final SharpenAdapter sharpenAdapter;

    public VideoPipelineFacade() {
        this.decoder = new Decoder();
        this.filterEngine = new FilterEngine();
        this.encoder = new Encoder();
        this.sharpenAdapter = new SharpenAdapter(new LegacySharpen());
    }

    public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {
        Objects.requireNonNull(src, "src");
        Objects.requireNonNull(out, "out");

        Frame[] frames = decoder.decode(src);

        if (gray) {
            frames = filterEngine.grayscale(frames);
        }

        if (scale != null && scale > 0) {
            frames = filterEngine.scale(frames, scale);
        }

        if (sharpenStrength != null && sharpenStrength > 0) {
            frames = sharpenAdapter.sharpen(frames, sharpenStrength);
        }

        return encoder.encode(frames, out);
    }
}
