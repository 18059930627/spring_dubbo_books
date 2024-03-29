package com.qf.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("t_book")
public class Books extends BaseEntity {
    private String name;
    private Integer storage;
    @TableField("type_id")
    private  Integer typeId;

    @TableField(exist = false)
    private BooksType booksType;
}
