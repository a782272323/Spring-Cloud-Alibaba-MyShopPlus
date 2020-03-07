package learn.lhb.myshop.plus.provider.mapper;

import learn.lhb.myshop.plus.provider.domain.UmsAdmin;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 梁鸿斌
 * @date 2020/3/3.
 * @time 21:58
 */
@Repository
@MapperScan
public interface UmsAdminMapper {

    /**
     * 查询表全部信息
     * @return
     */
    List<UmsAdmin> selectAll();

    /**
     * 新增系统用户
     * @param umsAdmin
     * @return
     */
    int insert(UmsAdmin umsAdmin);

    /**
     * 获取用户名
     * @param username
     * @return
     */
    String getUsername(String username);

    /**
     * 获取单个系统用户对象
     * @param umsAdmin
     * @return
     */
    UmsAdmin getUmsAdminByOne(UmsAdmin umsAdmin);
}
