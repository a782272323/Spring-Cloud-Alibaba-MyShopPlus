package learn.lhb.myshop.plus.business.controller;


import learn.lhb.myshop.plus.provider.api.EchoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 梁鸿斌
 * @date 2020/3/6.
 * @time 21:25
 */
@RestController
@RequestMapping(value = "echo")
public class EchoController {

    @Reference(version = "1.0.0")
    private EchoService echoService;

    @GetMapping("{string}")
    public String echo(@PathVariable String string) {
        return echoService.echo(string);
    }
}
