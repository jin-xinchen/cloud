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
     * 起始的时间戳
     */
    private final static long twepoch = 1625457600000L;
    //1625457600000L; //2021-07-05 12:00:00
    //https://tool.lu/timestamp/
    /** bits of workerId **/
    private final long workerIdBits = 5L;
    /** bits of datacenterId **/
    private final long datacenterIdBits = 5L;
    // /watch?v=aps_3FGQfSs&list=PLmOn9nNkQxJGVG1ktTV4SedFWuyef_Pi0&index=150

}
