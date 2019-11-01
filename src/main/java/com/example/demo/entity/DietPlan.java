package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_diet_plan")
public class DietPlan {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "diet_time")
    private String dietTime;

    @Column(name = "diet_zhw")
    private String dietZhw;

    @Column(name = "cost")
    private String cost;

    @Column(name = "number_people")
    private String numberPeople;


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
