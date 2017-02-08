public class Router {
    //Decalre variabes
    private long queueDelay;
    private long processingDelay;
    private long bandwidth;
    private long packetSize;

    public Router(long queueDelay, long processingDelay, long bandwidth, long packetSize){
        this.queueDelay         = queueDelay;
        this.processingDelay    = processingDelay;
        this.bandwidth          = bandwidth;
        this.packetSize         = packetSize;
    }

    public long getDelay(){
        return (queueDelay + processingDelay) + (packetSize/bandwidth);
    }
}