package com.wenbao.bean;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author wenbao
 * @data 2022/2/21
 * @Tip
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Api(value = "用户信息")
public class User {

    //id 自增
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "用户唯一标识")
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "邮箱")
    private String email;

    //逻辑删除
    @TableLogic
    @ApiModelProperty(value = "逻辑删除值")
    private Integer deleted;

    //乐观锁
    @Version
    @ApiModelProperty(value = "乐观锁")
    private Integer version;

    //自动填充处理
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "修改时间")
    private Date modifiedTime;
}
