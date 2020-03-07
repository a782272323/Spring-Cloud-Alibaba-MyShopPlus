package learn.lhb.myshop.plus.provider.service;

import learn.lhb.myshop.plus.provider.api.EchoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author 梁鸿斌
 * @date 2020/3/3.
 * @time 21:51
 */
@Service(version = "1.0.0")
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String string) {
        return "hello dubbo" + string;
    }
}
