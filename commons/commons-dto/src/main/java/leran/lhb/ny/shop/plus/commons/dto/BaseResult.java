package leran.lhb.ny.shop.plus.commons.dto;

import com.sun.org.slf4j.internal.LoggerFactory;
import leran.lhb.ny.shop.plus.commons.utils.TimeUtils;

import java.util.HashMap;

/**
 * 通用数据传输对象
 * 返回结果集封装
 *
 * @author 梁鸿斌
 * @date 2020/3/6.
 * @time 23:58
 */
public class BaseResult extends HashMap<String,Object> {

    private static final int STATUS_OK = 200;
    private static final int STATUS_ERROR = 500;
    private static final String MESSAGE_OK = "请求成功！";
    private static final String MESSAGE_ERROR = "请求失败!";
    private static final String STATUS = "code";
    private static final String MESSAGE = "message";
    private static final String TIMESTAMP = "timestamp";

    /**
     * HTTP 状态码
     */
    private int status;
    /**
     * 信息
     */
    private String message;
    /**
     * 封装实体类的map对象名（记得用双引号包裹）
     */
    private String key;
    /**
     * 封装实体类的map对象
     */
    private Object data;

    /**
     * 返回 HTTP 和 消息
     * @param status
     * @param message
     * @return
     */
    private static BaseResult createResult(int status, String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.put(STATUS, status);
        baseResult.put(MESSAGE, message);
        baseResult.put(TIMESTAMP, TimeUtils.getCurrentDateTime());
        return baseResult;
    }

    /**
     * 返回 HTTP状态码 和 消息 和 结果集
     *
     * @param status 状态码
     * @param message 消息
     * @param key   结果集的属性名（加双引号）
     * @param data 结果集对象
     * @return0
     */
    private static BaseResult createResult(String key,Object data,int status,String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.put(STATUS,status);
        baseResult.put(key, data);
        baseResult.put(MESSAGE,message);
        baseResult.put(TIMESTAMP, TimeUtils.getCurrentDateTime());
        return baseResult;
    }

    /**
     * 链式编程，返回 HTTP状态码和消息还有 结果集
     *
     * @param key 返回给前端的json的对象名
     * @param data 返回给前端的json的实体类或者别的数据
     * @param status 状态码
     * @param message 消息
     * @return
     */
    public BaseResult put(String key, Object data, int status, String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.put(STATUS, status);
        baseResult.put(MESSAGE, message);
        baseResult.put(key, data);
        baseResult.put(TIMESTAMP, TimeUtils.getCurrentDateTime());
        return baseResult;
    }

    /**
     * 返回默认的请求成功描述
     *
     * @return
     */
    public static BaseResult ok() {
        return BaseResult.createResult(STATUS_OK, MESSAGE_OK);
    }

    /**
     * 返回成功的自定义的HTTP状态码和默认的消息
     *
     * @param status
     * @return
     */
    public static BaseResult ok(int status) {
        return BaseResult.createResult(status, MESSAGE_OK);
    }

    /**
     * 返回成功的默认的HTTP状态码和自定义的消息
     *
     * @param message
     * @return
     */
    public static BaseResult ok(String message) {
        return BaseResult.createResult(STATUS_OK, message);
    }

    /**
     * 返回成功的自定义HTTP状态和消息
     *
     * @param status
     * @param message
     * @return
     */
    public static BaseResult ok(int status, String message) {
        return BaseResult.createResult(status, message);
    }

    /**
     * 返回默认的失败的 HTTP状态码 和 消息
     *
     * @return
     */
    public static BaseResult error() {
        return BaseResult.createResult(STATUS_ERROR, MESSAGE_ERROR);
    }

    /**
     * 返回自定义的HTTP状态码 和 默认的消息
     *
     * @param status
     * @return
     */
    public static BaseResult error(int status) {
        return BaseResult.createResult(status, MESSAGE_ERROR);
    }

    /**
     * 返回默认的HTTP状态码 和 默认的消息
     *
     * @param message
     * @return
     */
    public static BaseResult error(String message) {
        return BaseResult.createResult(STATUS_OK, message);
    }

    /**
     * 返回自定义的 HTTP状态码和消息
     *
     * @param status
     * @param message
     * @return
     */
    public static BaseResult error(int status, String message) {
        return BaseResult.createResult(status, message);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
