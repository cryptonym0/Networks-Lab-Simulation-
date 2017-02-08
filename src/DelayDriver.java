public class DelayDriver {
    public static  void main(String[] args){
      for(int i=0; i<=10; i++){
        long message = (i*100) * 1000 * 1000;
        long packetSize = 10 * 1000 * 1000;
        System.out.println("Message Size:" + message);    
        Message msg = new Message(message, packetSize);
      }
    }
}