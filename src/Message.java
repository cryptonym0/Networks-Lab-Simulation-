public class Message {
    //initiate variables
    private long msg;
    private long pktSize;
    private long numOfPackets;
    long total              = 0;

    //create message
    public Message (long msg, long pktSize){
        this.msg                = msg;
        this.pktSize            = pktSize;

        sendMsg();
        showDelay();
    }

    private void sendMsg(){
        numOfPackets            = msg / pktSize;
        int i                   = 0;

        Router r1               = new Router(100, 200, 300, pktSize);
        Router r2               = new Router(300, 300, 1000, pktSize);
        Router r3               = new Router(500, 100, 430, pktSize);

        Link l1                 = new Link(500,300);
        Link l2                 = new Link(600,200);
        Link l3                 = new Link(2300,150);
        Link l4                 = new Link(40,300);
        
        long totalDelay         = 0;
       
        while(i != numOfPackets){
            long totalRouter    = r1.getDelay() + r2.getDelay() + r3.getDelay();
            long totalLink      = l1.getDelay() + l2.getDelay() + l3.getDelay() + l4.getDelay(); 
            
            System.out.println("Packet: "+(i+1) + ": Leaving S");
            totalDelay += l1.getDelay();
            System.out.println("Packet: "+(i+1) + ": Link   1 Delay: " + totalDelay);
            
            totalDelay += r1.getDelay();
            System.out.println("Packet: "+(i+1) + ": Router 1 Delay: " + totalDelay);
            totalDelay += l2.getDelay();
            System.out.println("Packet: "+(i+1) + ": Link   2 Delay: " + totalDelay);
            totalDelay += r2.getDelay();
            System.out.println("Packet: "+(i+1) + ": Router 2 Delay: " + totalDelay);
            totalDelay += l3.getDelay();
            System.out.println("Packet: "+(i+1) + ": Link   3 Delay: " + totalDelay);
            totalDelay += r3.getDelay();
            System.out.println("Packet: "+(i+1) + ": Router 3 Delay: " + totalDelay);
            totalDelay += l4.getDelay();
            System.out.println("Packet: "+(i+1) + ": Link   4 Delay: " + totalDelay);
            System.out.println("Packet: "+(i+1) + ": Arriving at D");
            System.out.println("Packet: "+(i+1) + ": Total Delay: "+(totalRouter +totalLink) + "\n");
            total += (totalRouter +totalLink);
            ++i;
        }
    }

    public void showDelay(){
        System.out.println("Total Message Delay: \n" +
                             total + " ms\n" +
                            (total/1000)+" s\n" +
                            (total/60000)+" m\n");            
    }
}
