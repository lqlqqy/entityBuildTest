package com.mac;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.core.collection.PropertyMap;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import javafx.scene.paint.Color;

import java.io.Serializable;

import static com.almasb.fxgl.dsl.FXGL.*;

public class TestEntityApp extends GameApplication {

    @Override
    protected void initSettings(GameSettings gameSettings) {

        /*gameSettings.setWidth(700);
        gameSettings.setWidth(500);
        gameSettings.setTitle("坦克大战");
        gameSettings.setVersion("1.0");*/
    }

    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new TestEntityFactory());

        /*
        FXGL.getGameWorld().spawn("rect",new SpawnData(100,100));

        //简写1
        FXGL.spawn("rect",new SpawnData(50,40));
        //简写2 静态导入 FXGL
        spawn("rect",new SpawnData(70,90));


        //这个方法只创建实体，不会自动创建到游戏世界中
        Entity en = getGameWorld().create("rect",new SpawnData(170,190));
        getGameWorld().addEntity(en);

        //测试第二个实体
        spawn("square",new SpawnData(0,0));
*/

        // SpawnData功能其实强大
        Entity entity = spawn("square",
                new SpawnData(30,90)
                .put("w",60)
                .put("h",70)
                .put("color", Color.YELLOW)
        );

        // spawn返回值是entity，怎么通过他获取参数呢？
        Color c = entity.getObject("color");
        System.out.println(c);
        int w = entity.getInt("w");
        System.out.println(w);

        PropertyMap pm = entity.getProperties();
        // 注意这里的type其实是没啥 用的
        // 一般跟entityname同名
        pm.keys().forEach(item ->{
            System.out.println("item : " + item + " - " + pm.getValue(item).toString());
        });

        //注意比较前面做坦克demo时传进去的type枚举  这个不会放在PropertyMap中
        Serializable s = entity.getType();
        System.out.println(s);


        for (int i = 0; i < 3; i++) {

        }


    }

    public static void main(String[] args) {
        launch(args);

    }
}
