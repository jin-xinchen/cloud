public class SnowflakeIdWorker {
    /** workerId (0-31) **/
    private long workerId;
    /** datacenterId (0-31) **/
    private long datacenterId;
    /** Millisecond Id (0-4095) **/
    private long sequence;
    /** last Timestamp上次生成ID的时间戳 **/
    private long lastTimestamp = -1L;
    /**
     * starting timestamp
     */
    private final static long twepoch = 1625457600000L;
    //1625457600000L; //2021-07-05 12:00:00
    //https://tool.lu/timestamp/
    /** bits of workerId **/
    private final long workerIdBits = 5L;
    /** bits of datacenterId **/
    private final long datacenterIdBits = 5L;
    // /watch?v=aps_3FGQfSs&list=PLmOn9nNkQxJGVG1ktTV4SedFWuyef_Pi0&index=150
    /** the maximum of the worker's identify = 31 **/
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    /** the maximum of the data center's identify = 31 **/
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    /** bits of sequence **/
    private final long sequenceBits = 12L;
    /** shift 12 bits to the left **/
    private final long workerIdShift = sequenceBits;
    /** shift 17=12+5 bits to the left  **/
    private final long datacenterIdShift = sequenceBits+workerIdBits;
    /** shift 22=12+5+5 bits to the left **/
    private final long timestampLeftShift = sequenceBits+workerIdBits+datacenterIdShift;
    /** Mask code 4095 (0b111111111111=0xfff=4095) **/
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    /**
     *
     * @param workerId 0-31
     * @param datacenterId 0-31
     */
    public SnowflakeIdWorker(long workerId, long datacenterId){
        if(workerId>maxWorkerId || workerId<0){
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0",maxWorkerId));
        }
        if(datacenterId > maxDatacenterId || datacenterId<0){
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0",maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }
    public synchronized long nextId(){
        long timestamp = timeGen();
        if(timestamp<lastTimestamp){
            throw new RuntimeException(
                    String.format("Clock moved backwards. Refusing to generate id for %d milliseconds",lastTimestamp-timestamp)
            );
        }
        if(lastTimestamp == timestamp){
            sequence = (sequence +1) & sequenceMask;
            if(sequence == 0){
                timestamp = tilNextMillis(lastTimestamp);
            }
        }
        lastTimestamp = timestamp;
        return ((timestamp-twepoch) << timestampLeftShift)
               | (datacenterId << datacenterIdShift)
                | (workerId << workerIdShift)
                | sequence;
    }

    /**
     *
     * @param lastTimestamp
     * @return current timestamp
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while(timestamp<=lastTimestamp){
            timestamp = timeGen();
        }
        return timestamp;
    }
    private long timeGen(){
        return System.currentTimeMillis();
    }
    public static void main(String[] args) {
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1,1);
        for(int i=0;i<10;i++){
            long id = idWorker.nextId();
            System.out.println(id+"\t"+String.valueOf(id).length());
        }
    }
}
