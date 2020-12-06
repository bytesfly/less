package com.github.itwild.less.base.db;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 单线程批量插入数据
 */
@Slf4j
public class BatchInsertExample {

    public static void main(String[] args) {
        batchInsert();
    }

    /**
     * create database `demo` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
     * use `demo`;
     * <p>
     * CREATE TABLE `tb_book` (
     * `book_id` int(11) NOT NULL,
     * `book_name` varchar(64) NOT NULL,
     * `author` varchar(32) NOT NULL,
     * `date` datetime NOT NULL,
     * PRIMARY KEY (`book_id`),
     * UNIQUE KEY `uk_book_name` (`book_name`) USING BTREE
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
     */
    public static void batchInsert() {
        String url = "jdbc:mysql://localhost:3306/demo?characterEncoding=utf8&useSSL=false&allowMultiQueries=true&rewriteBatchedStatements=true";
        String user = "";
        String password = "";

        String sql = "INSERT INTO tb_book (book_id, book_name, author, date) VALUES (?, ?, ?, ?)";

        int batch = 1000;

        long start = System.currentTimeMillis();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (int i = 1; i <= 100000; i++) {
                pstmt.setInt(1, i);
                pstmt.setString(2, "book" + i);
                pstmt.setString(3, "金庸");
                pstmt.setDate(4, new Date(i));

                pstmt.addBatch();

                if (i % batch == 0) {
                    pstmt.executeBatch();
                }
            }

            pstmt.executeBatch();
        } catch (Exception e) {
            log.error("batch insert error", e);
        }

        long end = System.currentTimeMillis();

        System.out.println("耗时：" + (end - start) / 1000 + "秒");
    }

}
