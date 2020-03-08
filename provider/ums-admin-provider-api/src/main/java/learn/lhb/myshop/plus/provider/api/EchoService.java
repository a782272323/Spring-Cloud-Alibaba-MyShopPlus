package learn.lhb.myshop.plus.provider.api;

/**
 * @author 梁鸿斌
 * @date 2020/3/3.
 * @time 00:39
 */
public interface EchoService {

    /**
     * 测试服务之间的通信
     * @param string
     * @return
     */
    public String echo(String string);
}
