package org.apache.beam.sdk.io.cdap;

import io.cdap.cdap.api.plugin.PluginConfig;

/**
 * Class containing general info about a plugin.
 */
public class PluginInfo {
    public Class pluginClass;
    public Class formatClass;
    public Class formatProviderClass;

    public PluginConfig pluginConfig;
}
