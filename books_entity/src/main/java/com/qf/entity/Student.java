package com.qf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @Author chenzhongjun
 * @Date 2019/11/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = false)
@TableName("t_student")
public class Student implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private Integer sex;

    private String phone;

    @TableField(exist = false)
    private List<Books> booksList;
}
