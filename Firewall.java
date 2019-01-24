
public class Firewall implements FirewallInterface
{
    private String fileName;
    
    //Constructor
    public Firewall(String fileName)
    {
        this.fileName = fileName;
    }
    
    public boolean accept_packet(String direction,String protocol,String port,String ip)
    {
        if(!valid_direction(direction))
            return false;
        if(!valid_protocol(protocol))
            return false;
        if(!valid_port(port))
            return false;
        if(!valid_ip(ip))
            return false;    

        return true;
    }
    
    private boolean valid_direction(String direction)
    {
        final String VALID_DIRECTION_1 = "inbound";
        final String VALID_DIRECTION_2 = "outbound";

        if (direction.compareToIgnoreCase(VALID_DIRECTION_1)== 0)
            return true;
        if (direction.compareToIgnoreCase(VALID_DIRECTION_2) == 0)
            return true;

        return false;        
    }
    
    private boolean valid_protocol(String protocol)
    {
        final String VALID_PROTOCOL_1 = "udp";
        final String VALID_PROTOCOL_2 = "tcp";

        if (protocol.compareTo(VALID_PROTOCOL_1)== 0)
            return true;
        if (protocol.compareTo(VALID_PROTOCOL_2) == 0)
            return true;
        
        return false;
    }
    
    private boolean valid_port(String port)
    {
        final int MAX_QUANTITY = 2;
        final int MIN_QUANTITY = 1;
        final double MAX =  65535;
        final double MIN = 1 ;
        double temp = 0 ;

        String port_pile[] = port.split("-");
        
        if (port_pile.length > MAX_QUANTITY || port_pile.length < MIN_QUANTITY )
            return false;
        
        for(int i = 0 ; i < port_pile.length ; i++)
        {
            temp = Double.parseDouble(port_pile[i]);

            if (temp < MIN || temp >  MAX ) 
                return false;
        }
        return true; 
    }
    
    private boolean valid_ip(String ip)
    {
        final int MAX_QUANTITY = 2;
        final int MIN_QUANTITY = 1;
        final int OCTET_COUNT = 4;
        final int MIN = 0;
        final int MAX = 255;
        String tempS;
        int temp = 0 ;

        String ip_pile[] = ip.split("-");
        
        if (ip_pile.length > MAX_QUANTITY || ip_pile.length < MIN_QUANTITY)
            return false;

        for(int i = 0 ; i < ip_pile.length; i++)
        {
            tempS = ip_pile[i];
            String ip_addy[] = tempS.split("\\.");                      
            
            if(ip_addy.length != OCTET_COUNT)
                return false;
           
            for(int j = 0 ; j < ip_addy.length ; j++)
            {
                temp = Integer.parseInt(ip_addy[j]);
              
                if (temp < MIN || temp > MAX)
                    return false;
            }    
        }
            return true; 
    }
}