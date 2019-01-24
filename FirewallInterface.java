interface FirewallInterface
{
    public boolean accept_packet(String direction,String protocol,
                                        String port,String ip);
}