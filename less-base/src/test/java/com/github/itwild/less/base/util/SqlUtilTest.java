package com.github.itwild.less.base.util;

import cn.hutool.db.sql.SqlUtil;
import org.junit.jupiter.api.Test;

public class SqlUtilTest {

    /**
     * 格式化sql
     */
    @Test
    public void t1() {
        String sql = "select a.*, b.field from a left join b on a.b_id = b.id where status > 100";

        String formatSql = SqlUtil.formatSql(sql);
        System.out.println(formatSql);
    }
}
