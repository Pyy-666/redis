package cn.messcat.redis.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApplyCost implements Serializable{
    private int id;
    private Integer cost;
    private String name;
}
