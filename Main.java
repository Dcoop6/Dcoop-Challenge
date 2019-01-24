
class Main 
{
  
  public static void main(String[] args) 
  {
    boolean isValid = false;
    Firewall fw1 = new Firewall("someFile.csv");
    isValid = fw1.accept_packet("INBOUND", "udp", "5563-22515", "223.222.113.132");
    System.out.printf("1 = %b \n", isValid);
    
    Firewall fw2 = new Firewall("someFile.csv");
    isValid = fw2.accept_packet("INBOUND", "udp", "556322515", "223.554.113.55332");
    System.out.printf("2 = %b \n", isValid);
    
    Firewall fw3 = new Firewall("someFile.csv");
    isValid = fw3.accept_packet("INBOUND", "TCP", "5563-22515", "223.554.113.55332");
    System.out.printf("3 = %b \n", isValid);

    Firewall fw4 = new Firewall("someFile.csv");
    isValid = fw4.accept_packet("INBOUND", "udp", "5563", "223.54.113.10-118.92.168.2");
    System.out.printf("4 = %b \n", isValid);

    Firewall fw5 = new Firewall("someFile.csv");
    isValid = fw5.accept_packet("outbound", "udp", "5563-22515", "0");
    System.out.printf("5 = %b \n", isValid);

    Firewall fw6 = new Firewall("someFile.csv");
    isValid = fw6.accept_packet("outbound", "udp", "5563-22515-4552", "223.554.113.55332");
    System.out.printf("6 = %b \n", isValid);

  }
}
