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
@TableName("tb_hero")
public class Hero {

    @TableId("hero_id")
    protected Long heroId;

    @TableField(value = "hero_name", keepGlobalFormat = true)
    protected String heroName;

    @TableField(value = "skill", keepGlobalFormat = true)
    protected String skill;

    @TableField(value = "book_id", keepGlobalFormat = true)
    protected Long bookId;
}
