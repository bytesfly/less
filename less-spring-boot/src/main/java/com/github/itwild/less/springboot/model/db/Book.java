package com.github.itwild.less.springboot.model.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@TableName("tb_book")
public class Book {

    @TableId("book_id")
    protected Long bookId;

    @TableField(value = "book_name", keepGlobalFormat = true)
    protected String bookName;

    @TableField(value = "author", keepGlobalFormat = true)
    protected String author;
}
