/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.resourcemanagers;

import com.puttysoftware.images.BufferedImageIcon;

public class StatImageCache {
    // Fields
    private static CacheEntry[] cache;
    private static int CACHE_INCREMENT = 20;
    private static int CACHE_SIZE = 0;

    // Methods
    static BufferedImageIcon getCachedImage(final String name) {
        if (!StatImageCache.isInCache(name)) {
            final BufferedImageIcon bii = StatImageManager
                    .getUncachedImage(name);
            final BufferedImageIcon fixed = ImageTransformer
                    .getTransformedImage(bii);
            StatImageCache.addToCache(name, fixed);
        }
        for (final CacheEntry element : StatImageCache.cache) {
            if (name.equals(element.getName())) {
                return element.getImage();
            }
        }
        return null;
    }

    private static void expandCache() {
        final CacheEntry[] tempCache = new CacheEntry[StatImageCache.cache.length
                + StatImageCache.CACHE_INCREMENT];
        for (int x = 0; x < StatImageCache.CACHE_SIZE; x++) {
            tempCache[x] = StatImageCache.cache[x];
        }
        StatImageCache.cache = tempCache;
    }

    static void addToCache(final String name, final BufferedImageIcon bii) {
        if (StatImageCache.cache == null) {
            StatImageCache.cache = new CacheEntry[StatImageCache.CACHE_INCREMENT];
        }
        if (StatImageCache.CACHE_SIZE == StatImageCache.cache.length) {
            StatImageCache.expandCache();
        }
        StatImageCache.cache[StatImageCache.CACHE_SIZE] = new CacheEntry(bii,
                name);
        StatImageCache.CACHE_SIZE++;
    }

    static boolean isInCache(final String name) {
        if (StatImageCache.cache == null) {
            StatImageCache.cache = new CacheEntry[StatImageCache.CACHE_INCREMENT];
        }
        for (int x = 0; x < StatImageCache.CACHE_SIZE; x++) {
            if (name.equals(StatImageCache.cache[x].getName())) {
                return true;
            }
        }
        return false;
    }
}