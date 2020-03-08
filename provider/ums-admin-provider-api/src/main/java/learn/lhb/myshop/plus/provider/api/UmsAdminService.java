package learn.lhb.myshop.plus.provider.api;

import learn.lhb.myshop.plus.provider.domain.UmsAdmin;

/**
 * @author 梁鸿斌
 * @date 2020/3/6.
 * @time 22:04
 */
public interface UmsAdminService {

    /**
     * 新增用户
     * @param umsAdmin
     * @return
     */
    int insert(UmsAdmin umsAdmin);

    /**
     * 获取用户
     * @param username 用户名
     * @return
     */
    UmsAdmin getUmsAdminByUsername(String username);

    /**
     * 获取用户
     * @param umsAdmin
     * @return
     */
    UmsAdmin getUmsAdminByOne(UmsAdmin umsAdmin);
}
