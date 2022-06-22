package com.mac;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TestEntityFactory implements EntityFactory {
    // 不需要实现任何方法

    // 不加注解的话，其实跟普通的创建没啥区别。
    // 加注解，通过调用名字创建实体
    //如果两种实体代码一样，可以加逗号跟上
    // 看方法名是灰色的
    @Spawns("rect,square")
    public Entity newRect(SpawnData data ){
        return FXGL.entityBuilder(data)
                .type(MyType.REALTYPE)
                // 注意int转double
                .view(new Rectangle(data.<Integer>get("w"),data.<Integer>get("h"), data.get("color")))
                .build();
    }
}
