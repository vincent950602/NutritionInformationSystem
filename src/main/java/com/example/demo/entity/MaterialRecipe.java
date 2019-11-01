package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "t_material_recipe")
public class MaterialRecipe {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="menu_type")
    private String menuType;

    @Column(name="menu_code")
    private String menuCode;

    @Column(name="menu_name")
    private String menuName;

    @Column(name="menu_price")
    private String menuPrice;

    @Column(name="material_code")
    private String materialCode;

    @Column(name="material_name")
    private String materialName;

    @Column(name="material_weight")
    private String materialWeight;

    @Column(name="main_or_vice")
    private String mainOrVice;

    @Column(name="create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
