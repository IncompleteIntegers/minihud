package fi.dy.masa.minihud.network;


import fi.dy.masa.malilib.network.handler.ClientPlayHandler;
import fi.dy.masa.malilib.network.payload.channel.ServuxStructuresPayload;
import fi.dy.masa.minihud.network.handlers.ServuxStructuresPlayListener;

public class PacketUtils
{
    static ServuxStructuresPlayListener<ServuxStructuresPayload> minihud_servuxStructuresListener = ServuxStructuresPlayListener.INSTANCE;
    private static boolean payloadsRegistered = false;

    public static void registerPayloads()
    {
        if (payloadsRegistered)
            return;

        // Register Client Payload Listeners
        ClientPlayHandler.getInstance().registerClientPlayHandler(minihud_servuxStructuresListener);

        payloadsRegistered = true;
    }

    public static void unregisterPayloads()
    {
        ClientPlayHandler.getInstance().unregisterClientPlayHandler(minihud_servuxStructuresListener);

        payloadsRegistered = false;
    }
}