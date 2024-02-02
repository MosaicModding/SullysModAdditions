package com.mosaic_modding.sullysmod_additions.core.integration;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

public class CompatHandler {
    public static final String FDID = "farmersdelight";
    public static final boolean FDLOADED = isLoaded(FDID);
    public static final String QUARKID = "quark";
    public static final boolean QUARLOADED = isLoaded(QUARKID);
    public static final String VSCID = "v_slab_compat";
    public static final boolean VSCLOADED = isLoaded(VSCID);
    public static final String COPPERATIVE = "copperative";
    public static final boolean COPPERATIVE_LOADED = isLoaded(COPPERATIVE);
    public static boolean isLoaded(String id) {
        return ModList.get().isLoaded(id);
    }

    public static void init() {
        if (loadCompat(FDLOADED)) FDCompat.init();
        if (loadCompat(QUARLOADED && !VSCLOADED)) VerticalSlabsCompat.init();
        if (loadCompat(COPPERATIVE_LOADED)) CopperativeCompat.init();
    }

    private static boolean loadCompat(boolean additionalFlags) {
        return additionalFlags || !FMLLoader.isProduction();
    }

}
