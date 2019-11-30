package com.qf.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author chenzhongjun
 * @Date 2019/11/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = false)
@TableName("t_book")
public class Books {

    private Integer id;

    private String name;

    private Integer storage;

    @TableField("type_id")
    private Integer typeId;
}
